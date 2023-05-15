package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;

import java.time.LocalDate;
import java.util.List;

public interface IOcupacaoAeroviaRep {
    List<OcupacaoAerovia> findOcupadasSlots(int aeroviaId, LocalDate data, List<Float> slotsHorarios);
    List<OcupacaoAerovia> findAllOcupacaoAeroviasByData(int aeroviaId, LocalDate data);

    OcupacaoAerovia ocupa(OcupacaoAerovia ocupacaoAerovia);

    void removeOcupacao(OcupacaoAerovia ocupacaoAerovia);
}
