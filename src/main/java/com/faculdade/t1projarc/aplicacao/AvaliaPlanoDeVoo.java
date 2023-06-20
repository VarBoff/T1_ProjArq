package com.faculdade.t1projarc.aplicacao;

import com.faculdade.t1projarc.dominio.service.ServicoPlanos;
import com.faculdade.t1projarc.interfacesAdaptadoras.dto.StatusPlanoDeVooDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvaliaPlanoDeVoo {

    private ServicoPlanos servicoPlanos;

    @Autowired

    public AvaliaPlanoDeVoo(ServicoPlanos servicoPlanos) {
        this.servicoPlanos = servicoPlanos;
    }

    public StatusPlanoDeVooDTO avaliacaoPlanoDeVoo(String aeronaveNome, String rotaNome, String data, String horario,
                                                   Integer altitude, List<Integer> slotsHorario){

        System.out.println(aeronaveNome+ rotaNome+ data+horario+altitude+slotsHorario);
        return servicoPlanos.avaliaPlanoDeVoo(aeronaveNome, rotaNome, data, horario, altitude, slotsHorario);
    }
}
