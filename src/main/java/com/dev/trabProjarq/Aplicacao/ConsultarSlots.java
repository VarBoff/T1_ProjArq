package com.dev.trabProjarq.Aplicacao;

import com.dev.trabProjarq.dominio.services.ServicoDeAerovias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsultarSlots {
    private ServicoDeAerovias servicoDeAerovias;

    @Autowired
    public ConsultarSlots(ServicoDeAerovias servicoDeAerovias) {
        this.servicoDeAerovias = servicoDeAerovias;
    }

    public List<Integer> consultaAltitudesLivres(int aeroviaId, LocalDate data, Float horario, float velCruzeiro){
        return this.servicoDeAerovias.consultaSlotsLivres(aeroviaId, data, horario, velCruzeiro);
    }
}
