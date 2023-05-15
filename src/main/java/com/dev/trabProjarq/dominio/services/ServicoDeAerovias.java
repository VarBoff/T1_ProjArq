package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.PorcentagemOcupacaoDTO;
import com.dev.trabProjarq.Aplicacao.DTO.RelatorioDTO;
import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoDeAerovias {
    private IAeroviaRep aeroviaRep;
    private IOcupacaoAeroviaRep ocupacaoRep;

    @Autowired
    public ServicoDeAerovias(IAeroviaRep aeroviaRep, IOcupacaoAeroviaRep ocupacaoRep) {
        this.aeroviaRep = aeroviaRep;
        this.ocupacaoRep = ocupacaoRep;
    }

    public List<Integer> consultaSlotsLivres(int aeroviaId, LocalDate data, float horario, float velCruzeiro){
        Aerovia aerovia = aeroviaRep.findAerovia(aeroviaId).get();

        List<Integer> slotsTodos = new ArrayList<>(Arrays.asList(25000, 26000, 27000, 28000, 29000, 30000, 31000, 32000, 33000, 34000));
        List<Float> slotsHorarios = new ArrayList<>();

        float tempoVoo = aerovia.distancia / velCruzeiro;

        tempoVoo = tempoVoo + horario;
        
        slotsHorarios.add((float) Math.floor(horario));

        while(tempoVoo > horario){
            slotsHorarios.add((float) Math.floor(horario));
            tempoVoo--;
        } 
        
        slotsHorarios.add((float) Math.ceil(horario));

        List<OcupacaoAerovia> ocupadas = this.ocupacaoRep.findOcupadasSlots(aeroviaId, data, slotsHorarios);

        List<Integer> altitudesOcupadas = ocupadas.stream().map( ocupaAerovia -> ocupaAerovia.slot_altitude).collect(Collectors.toList());

        return slotsTodos.stream().filter(slotsLivres -> !altitudesOcupadas.contains(slotsLivres)).collect(Collectors.toList());
    }

    public RelatorioDTO consultaPorcentagemOcupacao(int aeroviaId, LocalDate data){
        List<OcupacaoAerovia> ocupacaoAerovias = this.ocupacaoRep.findAllOcupacaoAeroviasByData(aeroviaId, data);
        
        List<PorcentagemOcupacaoDTO> listaOcupacao = new ArrayList<>();

        List<Integer> slotsTodos = new ArrayList<>(Arrays.asList(25000, 26000, 27000, 28000, 29000, 30000, 31000, 32000, 33000, 34000));
        
        for(Integer slotAltitude: slotsTodos){
            List<OcupacaoAerovia> ocupadasPorSlot = ocupacaoAerovias.stream().filter(ocupacaoAerovia -> ocupacaoAerovia.slot_altitude == slotAltitude).collect(Collectors.toList());
            float porcentagem = Float.parseFloat(String.format("%.2f", ((ocupadasPorSlot.size() * 100) / 24.0)));
            listaOcupacao.add(new PorcentagemOcupacaoDTO( slotAltitude, porcentagem));
            ocupadasPorSlot.clear();
        }

        return new RelatorioDTO(listaOcupacao);
    }
}
