package com.faculdade.t1projarc.interfacesAdaptadoras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlanoDeVooDTO {

    private String nomeAeronave;
    private String nomeRota;
    private String data;
    private String horario;
    private Integer altitude;
    private List<Integer> slotsHorario;
}
