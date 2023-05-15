package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;

import java.util.List;

public interface IPlanosRep {
    List<PlanoDeVoo> findPlanos();

    PlanoDeVoo salvaPlano(PlanoDeVoo planoDeVoo);

    PlanoDeVoo findPlanoById(int planoId);

    void removePlano(PlanoDeVoo plano);
}

