package com.dev.trabProjarq.Aplicacao.DTO;

import java.util.List;

public class RelatorioDTO {
    
    public List<PorcentagemOcupacaoDTO> listaOcupacao;
    
    public RelatorioDTO(List<PorcentagemOcupacaoDTO> listaOcupacao){
        this.listaOcupacao = listaOcupacao;
    }

}
