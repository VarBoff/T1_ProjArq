package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.Aplicacao.DTO.AeronaveDTO;
import com.dev.trabProjarq.dominio.entities.Aeronave;

import java.util.Optional;

public interface IAeronaveRep {
    Aeronave findAeronave(AeronaveDTO aeronaveDTO);
}
