package com.faculdade.t1projarc.aplicacao;

import com.faculdade.t1projarc.dominio.entity.Rota;
import com.faculdade.t1projarc.dominio.service.ServicoRota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaRotas {
    private ServicoRota servicoRota;
    @Autowired
    public ListaRotas(ServicoRota servicoRota) {
        this.servicoRota = servicoRota;
    }

    public List<Rota> listaRotas(String prefixoAeroportoOrigem, String prefixoAeroportoDestino){
        return servicoRota.listaRotasEncontradas(prefixoAeroportoOrigem,prefixoAeroportoDestino);
    }
}
