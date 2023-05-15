package com.dev.trabProjarq.Aplicacao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.trabProjarq.Aplicacao.DTO.RelatorioDTO;
import com.dev.trabProjarq.dominio.services.ServicoDeAerovias;

@Component
public class GerarRelatorio {
    private ServicoDeAerovias servicoDeAerovias;

    @Autowired
    public GerarRelatorio(ServicoDeAerovias servicoDeAerovias) {
        this.servicoDeAerovias = servicoDeAerovias;
    }

    public RelatorioDTO geraRelatorio(int aeroviaId, LocalDate data){
        return this.servicoDeAerovias.consultaPorcentagemOcupacao(aeroviaId, data);
    }
}
