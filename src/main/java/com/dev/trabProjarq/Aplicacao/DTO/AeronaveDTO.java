package com.dev.trabProjarq.Aplicacao.DTO;

import com.dev.trabProjarq.Aplicacao.TiposAeronave;

public class AeronaveDTO {

    public int id;
    public String prefixo;
    public TiposAeronave tipo;
    public float velCruzeiro;
    public double autonomia;

    public AeronaveDTO(String prefixo, TiposAeronave tipo, float velCruzeiro, double autonomia) {
        this.prefixo = prefixo;
        this.tipo = tipo;
        this.velCruzeiro = velCruzeiro;
        this.autonomia = autonomia;
    }
}
