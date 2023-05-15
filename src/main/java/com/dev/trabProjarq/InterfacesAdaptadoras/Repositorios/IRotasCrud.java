package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRotasCrud extends JpaRepository<Rota, Integer> {


}
