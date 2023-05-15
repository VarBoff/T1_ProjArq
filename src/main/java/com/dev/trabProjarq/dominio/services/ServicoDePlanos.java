package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServicoDePlanos {
    private IPlanosRep planosRep;
    private IRotasRep rotasRep;
    private IOcupacaoAeroviaRep ocupacaoRep;
    private IAeronaveRep aeronaveRep;

    @Autowired
    public ServicoDePlanos(IPlanosRep planosRep, IRotasRep rotasRep, IOcupacaoAeroviaRep ocupacaoRep, IAeronaveRep aeronaveRep) {
        this.planosRep = planosRep;
        this.rotasRep = rotasRep;
        this.ocupacaoRep = ocupacaoRep;
        this.aeronaveRep = aeronaveRep;
    }

    public List<Aerovia> verificarPlanoDeVoo(PlanoVooDTO propostaPlano) {
        Rota rotaEscolhida = this.rotasRep.findById(propostaPlano.rotaId);

        List<Aerovia> trechosComProblemas = new ArrayList<>();

        for (Aerovia aerovia: rotaEscolhida.aerovias) {

            float tempoVoo = aerovia.distancia / propostaPlano.aeronave.velCruzeiro;

            tempoVoo = tempoVoo + propostaPlano.horarioPartida;
            
            propostaPlano.slot_horario.add((int)Math.ceil(propostaPlano.horarioPartida));

            while(tempoVoo > propostaPlano.horarioPartida){
                propostaPlano.slot_horario.add((int)Math.floor(propostaPlano.horarioPartida));
                tempoVoo--;
            }

            List<OcupacaoAerovia> ocupadas = this.ocupacaoRep.findOcupadasSlots(
                aerovia.id, 
                propostaPlano.data, 
                propostaPlano.slot_horario
            );
            for(OcupacaoAerovia ocupacao: ocupadas) {
                if (ocupacao.slot_altitude == propostaPlano.altitude) {
                    trechosComProblemas.add(aerovia);
                }
            }
        }

        return trechosComProblemas;
    }

    public PlanoDeVoo cancelarPlanoDeVoo(int id) {
        PlanoDeVoo plano = this.planosRep.findPlanoById(id);
        if(plano != null){
            Rota rota = plano.rota;
            List<Aerovia> aerovias = rota.aerovias;

            for(Aerovia aerovia: aerovias) {

                float tempoVoo = aerovia.distancia / plano.aeronave.velCruzeiro;

                for (int i = 0; i < tempoVoo; i++) {
                    plano.slot_horario.add((int) Math.floor(1));
                }
                List<OcupacaoAerovia> slotsOcupados = this.ocupacaoRep.findOcupadasSlots(aerovia.id, plano.data, plano.slot_horario).stream()
                        .filter(o -> o.slot_altitude == plano.altitude)
                        .collect(Collectors.toList());

                for (OcupacaoAerovia slot : slotsOcupados) {
                    this.ocupacaoRep.removeOcupacao(slot);
                }
            }
            this.planosRep.removePlano(plano);
        }

        return plano;
    }

    public PlanoDeVoo autorizarPlanoDeVoo(PlanoVooDTO planoVoo) {
        if(this.verificarPlanoDeVoo(planoVoo).isEmpty()){
            Rota rota = this.rotasRep.findById(planoVoo.rotaId);
            Aeronave aeronave = this.aeronaveRep.findAeronave(planoVoo.aeronave);
            PlanoDeVoo planoDeVoo = new PlanoDeVoo(planoVoo.slot_horario, planoVoo.data, planoVoo.horarioPartida, planoVoo.altitude, aeronave, rota);
            for(Aerovia aerovia: rota.aerovias) {

                float tempoVoo = aerovia.distancia / planoDeVoo.aeronave.velCruzeiro;

                for(int i=0; i<tempoVoo; i++){
                    planoVoo.slot_horario.add((int) Math.floor(1));
                }

                for(int slot: planoVoo.slot_horario){
                    LocalDate date = planoVoo.data;
                    if(slot > 24){
                        slot = slot - 24;
                        date = date.plusDays(1);
                    }
                    OcupacaoAerovia ocupacaoAerovia = new OcupacaoAerovia(date, aerovia, (int)planoVoo.altitude, planoVoo.slot_horario);
                    this.ocupacaoRep.ocupa(ocupacaoAerovia);
                }
            }
            return this.planosRep.salvaPlano(planoDeVoo);
        }
        return null;
    }
}
