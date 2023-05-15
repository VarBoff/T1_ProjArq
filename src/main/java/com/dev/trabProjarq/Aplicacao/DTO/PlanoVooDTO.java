package com.dev.trabProjarq.Aplicacao.DTO;

import java.time.LocalDate;
import java.util.List;

public class PlanoVooDTO {
    public int rotaId;

    public List<Integer> slot_horario;
    public LocalDate data;
    public float horarioPartida;

    public AeronaveDTO aeronave;

    public int altitude;

    public PlanoVooDTO(int rotaId, List<Integer> slot_horaio, LocalDate data, float horarioPartida, AeronaveDTO aeronave, int altitude) {
        this.rotaId = rotaId;
        this.slot_horario = slot_horaio;
        this.data = data;
        this.horarioPartida = horarioPartida;
        this.aeronave = aeronave;
        this.altitude = altitude;
    }
}