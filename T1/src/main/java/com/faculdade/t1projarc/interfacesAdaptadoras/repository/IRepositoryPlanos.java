package com.faculdade.t1projarc.interfacesAdaptadoras.repository;

import com.faculdade.t1projarc.dominio.entity.PlanoDeVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositoryPlanos extends JpaRepository<PlanoDeVoo,Long> {

    Optional<PlanoDeVoo> findById(Long id);
}
