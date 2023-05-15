package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.Rota;
import com.dev.trabProjarq.dominio.services.IRotasRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositorioRotas implements IRotasRep{
    private IRotasCrud rotasCrud;

    @Autowired
    public RepositorioRotas(IRotasCrud rotasCrud){
        this.rotasCrud = rotasCrud;
    }

    @Override
    public Rota findById(int rotaId) {
        return this.rotasCrud.findById(rotaId).get();
    }

    @Override
    public List<Rota> findRotas(){
        return this.rotasCrud.findAll();
    }

}
