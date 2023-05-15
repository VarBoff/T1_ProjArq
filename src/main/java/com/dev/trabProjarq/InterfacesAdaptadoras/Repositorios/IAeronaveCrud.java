package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAeronaveCrud extends JpaRepository<Aeronave, Integer> {
}
