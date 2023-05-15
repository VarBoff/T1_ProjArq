package com.dev.trabProjarq.dominio.services;

import com.dev.trabProjarq.dominio.entities.Rota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoDeRotas {
    private IRotasRep rotasRep;

    @Autowired
    public ServicoDeRotas(IRotasRep rotasRep) {
        this.rotasRep = rotasRep;
    }

    public List<Rota> consultaRotas(String origem, String destino) {
        return rotasRep.findRotas().stream()
                .filter(rota -> rota.destino.nome.toLowerCase().equals(destino.toLowerCase())
                        && rota.origem.nome.toLowerCase().equals(origem.toLowerCase()))
                .collect(Collectors.toList());
    }
}
