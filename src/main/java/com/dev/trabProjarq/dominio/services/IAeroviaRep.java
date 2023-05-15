package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.Aerovia;

import java.util.Optional;

public interface IAeroviaRep {
    Optional<Aerovia> findAerovia(int aeroviaId);
}
