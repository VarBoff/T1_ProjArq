package com.faculdade.t1projarc.interfacesAdaptadoras.repository;

import com.faculdade.t1projarc.dominio.entity.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositoryRotas extends JpaRepository<Rota,Long> {
    Optional<Rota> findByNome(String nomeRota);

}
