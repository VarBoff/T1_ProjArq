package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import com.dev.trabProjarq.dominio.services.ServicoDePlanos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificarPlanoVoo {

    private ServicoDePlanos servicoDePlanos;

    @Autowired
    public VerificarPlanoVoo(ServicoDePlanos servicoDePlanos){
        this.servicoDePlanos = servicoDePlanos;
    }

    public List<Aerovia> verificaPlanoDeVoo(PlanoVooDTO propostaPlanoDeVoo){
        return this.servicoDePlanos.verificarPlanoDeVoo(propostaPlanoDeVoo);
    }
}
