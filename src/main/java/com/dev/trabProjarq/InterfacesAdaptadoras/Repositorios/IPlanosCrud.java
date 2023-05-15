package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlanosCrud extends JpaRepository<PlanoDeVoo, Integer> {


}
