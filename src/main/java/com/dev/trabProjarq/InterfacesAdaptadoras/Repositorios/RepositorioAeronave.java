package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.Aplicacao.DTO.AeronaveDTO;
import com.dev.trabProjarq.dominio.entities.Aeronave;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositorioAeronave {
    private IAeronaveCrud aeronaveCrud;

    @Autowired
    public RepositorioAeronave(IAeronaveCrud aeronaveCrud) {
        this.aeronaveCrud = aeronaveCrud;
    }

    @Override
    public Aeronave findAeronaveById(AeronaveDTO aeronaveDTO) {
        return this.aeronaveCrud.findById(aeronaveDTO.id).get();
    }
}
