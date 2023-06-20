package com.faculdade.t1projarc.interfacesAdaptadoras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RotaDTO {
    private String rota;
    private String data;
    private String horario;
    private String aeronave;
}
