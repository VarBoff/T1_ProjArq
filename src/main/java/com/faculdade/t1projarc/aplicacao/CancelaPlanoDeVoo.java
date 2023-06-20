package com.faculdade.t1projarc.aplicacao;

import com.faculdade.t1projarc.dominio.service.ServicoPlanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CancelaPlanoDeVoo {

    private ServicoPlanos servicoPlanos;

    @Autowired
    public CancelaPlanoDeVoo(ServicoPlanos servicoPlanos) {
        this.servicoPlanos = servicoPlanos;
    }

    public String cancelaPlanoDeVoo(Long id){
        try{
            servicoPlanos.cancelaPlanoVoo(id);
            return "ok";
        }catch(IllegalArgumentException e){
            return "Não encontrado";
        }
    }
}
