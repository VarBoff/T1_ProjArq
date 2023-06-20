package com.faculdade.t1projarc.aplicacao;

import com.faculdade.t1projarc.dominio.entity.PlanoDeVoo;
import com.faculdade.t1projarc.dominio.service.ServicoPlanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AprovaPlanoDeVoo{

    private ServicoPlanos servicoPlanos;

    @Autowired
    public AprovaPlanoDeVoo(ServicoPlanos servicoPlanos) {
        this.servicoPlanos = servicoPlanos;
    }

    public String aprovaPlanoDeVoo(String nomeAeronave, String nomeRota, String data,
                                   String horario, Integer altitude, List<Integer> slotsHorario){
      try{
          Long id= servicoPlanos.aprovaPlanoDeVoo(nomeAeronave,nomeRota,data,horario,altitude,slotsHorario);
          return "liberadoo: " +  id;
      }catch (Exception e){
          return "negado";
      }
    }
}
