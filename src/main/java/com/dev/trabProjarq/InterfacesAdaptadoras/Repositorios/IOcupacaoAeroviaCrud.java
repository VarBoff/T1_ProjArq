package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOcupacaoAeroviaCrud extends JpaRepository<OcupacaoAerovia, Integer> {


}
