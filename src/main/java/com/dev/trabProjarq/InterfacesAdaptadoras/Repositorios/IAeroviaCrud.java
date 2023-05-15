package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.Aerovia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAeroviaCrud extends JpaRepository<Aerovia, Integer> {


}
