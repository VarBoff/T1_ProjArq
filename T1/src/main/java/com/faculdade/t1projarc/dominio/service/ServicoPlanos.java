package com.faculdade.t1projarc.dominio.service;

import com.faculdade.t1projarc.interfacesAdaptadoras.repository.IRepositoryAeronaves;
import com.faculdade.t1projarc.interfacesAdaptadoras.repository.IRepositoryOcupacao;
import com.faculdade.t1projarc.interfacesAdaptadoras.repository.IRepositoryPlanos;
import com.faculdade.t1projarc.dominio.entity.Aeronave;
import com.faculdade.t1projarc.dominio.entity.Ocupacao;
import com.faculdade.t1projarc.dominio.entity.PlanoDeVoo;
import com.faculdade.t1projarc.dominio.entity.Rota;
import com.faculdade.t1projarc.interfacesAdaptadoras.dto.StatusPlanoDeVooDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoPlanos {

    private IRepositoryPlanosCRUD repositoryPlanosDeVoo;
    private IRepositoryOcupacaoCRUD repositoryOcupacao;
    private IRepositoryAeronavesCRUD repositoryAeronave;
    private ServicoRota servicoRota;


    @Autowired
    public ServicoPlanos(IRepositoryPlanosCRUD repositoryPlanosDeVoo, IRepositoryOcupacaoCRUD repositoryOcupacao,
                         IRepositoryAeronavesCRUD repositoryAeronave, ServicoRota servicoRota) {
        this.repositoryPlanosDeVoo = repositoryPlanosDeVoo;
        this.repositoryOcupacao = repositoryOcupacao;
        this.repositoryAeronave = repositoryAeronave;
        this.servicoRota = servicoRota;
    }




    public void cancelaPlanoVoo(Long idPlanoVoo) {
        Optional<PlanoDeVoo> planoVooOptional = repositoryPlanosDeVoo.findById(idPlanoVoo);


        if (planoVooOptional.isPresent()) {

            PlanoDeVoo planoVoo = planoVooOptional.get();

            //Marca o voo como cancelado e libera a ocupação do referido plano de voo
            servicoRota.libera(planoVoo.getRota().getId(),planoVoo.getData(),
                    planoVoo.getAltitude(),planoVoo.getSlotsTempo());

        } else {
            //Se não encontra o plano de voo, joga exceção
            throw new IllegalArgumentException();
        }
    }

    public Long aprovaPlanoDeVoo(String nomeAeronave, String nomeRota, String data,
                                 String horario, Integer altitude, List<Integer> slotsHorario){

        PlanoDeVoo propostaDePlanoDeVoo = getPlanoDeVoo(nomeAeronave,nomeRota,data,horario,altitude,slotsHorario);

        if(avaliaPlanoDeVoo(propostaDePlanoDeVoo)){
            for (Integer slot: propostaDePlanoDeVoo.getSlotsTempo()) {
                servicoRota.ocupa(propostaDePlanoDeVoo.getRota().getId(),
                        propostaDePlanoDeVoo.getData(),propostaDePlanoDeVoo.getAltitude(),
                        slot);
            }
            return repositoryPlanosDeVoo.save(propostaDePlanoDeVoo).getId();
        }else{
            throw new IllegalArgumentException();
        }

    }

    public boolean avaliaPlanoDeVoo(PlanoDeVoo planoDeVoo) {

        if (!verificarSlotLivre(planoDeVoo)) {
            return false;
        }

        if (!verificarAutonomia(planoDeVoo)) {
            return false;
        }

        if (!verificaSePodeVoar(planoDeVoo)) {
            return false;
        }

        return true;
    }
    public StatusPlanoDeVooDTO avaliaPlanoDeVoo(String nomeAeronave, String nomeRota, String data,
                                                String horario, Integer altitude, List<Integer> slotsHorario) {

        PlanoDeVoo propostaDePlanoDeVoo = getPlanoDeVoo(nomeAeronave,nomeRota,data,horario,altitude,slotsHorario);

        if (!verificarSlotLivre(propostaDePlanoDeVoo)) {
            return new StatusPlanoDeVooDTO("Problema", "Não possui espaço livre");
        }

        if (!verificarAutonomia(propostaDePlanoDeVoo)) {
            return new StatusPlanoDeVooDTO("Problema", "Não possui Autonomia");
        }

        if (!verificaSePodeVoar(propostaDePlanoDeVoo)) {
            return new StatusPlanoDeVooDTO("Problema", "Não Pode voar com este aviao nesta altitude ou hora");
        }


        return new StatusPlanoDeVooDTO("Aprovado","");
    }

    private boolean verificarSlotLivre(PlanoDeVoo planoDeVoo) {
        int slotAltitude = planoDeVoo.getAltitude();
        List<Integer> slotsTempo = planoDeVoo.getSlotsTempo();

        for (Integer slotTempo : slotsTempo) {
            Optional<Ocupacao> ocupacao = repositoryOcupacao.findByDataAndSlotAltitudeAndSlotHorario(planoDeVoo.getData(), slotAltitude, slotTempo);
            if (ocupacao.isPresent()){
                return false; // Slot ocupado, não está livre
            }
        }

        return true; // Todos os slots estão livres
    }

    private boolean verificarAutonomia(PlanoDeVoo planoDeVoo) {
        Aeronave aeronave = planoDeVoo.getAeronave();
        Rota rota = planoDeVoo.getRota();

        int distancia = rota.getTamanho();
        int autonomia = aeronave.getAutonomia();

        return distancia <= autonomia;
    }

    private boolean verificaSePodeVoar(PlanoDeVoo planoDeVoo){
        Aeronave aeronave = planoDeVoo.getAeronave();
        if(aeronave.getTipo()=="PP"){
            if(planoDeVoo.getAltitude()>=25000 && planoDeVoo.getAltitude()<=27000){
                return true;
            }else{
                return false;
            }
        }else if(aeronave.getTipo()=="CP"){
            if(planoDeVoo.getAltitude()>=28000){
                return true;
            }else{
                return false;
            }
        }else if(aeronave.getTipo()=="CC"){
            for (Integer slot:
                 planoDeVoo.getSlotsTempo()) {
                if(slot>=6){
                    return false;
                }
            }
            return true;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public PlanoDeVoo getPlanoDeVoo(String nomeAeronave, String nomeRota, String data,
                                    String horario, Integer altitude, List<Integer> slotsHorario){
        String dataHoraString = data + " " + horario;

        System.out.println(nomeAeronave + nomeRota + data + horario + altitude + slotsHorario);
        // Defina o formato esperado para a data e o horário combinados
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            // Converte a string de data e horário combinados para Date
            Date dataHora = formato.parse(dataHoraString);
            Optional<Aeronave> aeronave = repositoryAeronave.getByPrefixo(nomeAeronave);
            Optional<Rota> rota = servicoRota.getRotaByNome(nomeRota);

            //System.out.println(rota.get().getNome());
           // System.out.println(aeronave.get().getPrefixo());


            if(aeronave.isEmpty() || rota.isEmpty()){
                throw new IllegalArgumentException();
            }else{
                return PlanoDeVoo.builder()
                        .aeronave(aeronave.get())
                        .altitude(altitude)
                        .data(dataHora)
                        .rota(rota.get()).build();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
