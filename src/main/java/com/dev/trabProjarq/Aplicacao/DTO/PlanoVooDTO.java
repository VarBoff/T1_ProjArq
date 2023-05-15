package com.dev.trabProjarq.Aplicacao.DTO;

import java.time.LocalDate;

public class PlanoVooDTO {
    public int rotaId;

    public LocalDate data;

    public float horarioPartida;

    public float velCruzeiro;

    public int altitude;

    public PlanoVooDTO(int rotaId, LocalDate data, float horarioPartida, float velCruzeiro, int altitude) {
        this.rotaId = rotaId;
        this.data = data;
        this.horarioPartida = horarioPartida;
        this.velCruzeiro = velCruzeiro;
        this.altitude = altitude;
    }
}