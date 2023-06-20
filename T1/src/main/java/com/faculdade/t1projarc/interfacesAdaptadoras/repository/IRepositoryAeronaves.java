package com.faculdade.t1projarc.interfacesAdaptadoras.repository;

import com.faculdade.t1projarc.dominio.entity.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositoryAeronaves extends JpaRepository<Aeronave,Long> {
    Optional<Aeronave> getByPrefixo(String nomeAeronave);
}
