package com.faculdade.t1projarc.aplicacao;

import com.faculdade.t1projarc.dominio.service.ServicoRota;
import com.faculdade.t1projarc.interfacesAdaptadoras.dto.SlotDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ListaSlotsLivres {
    private ServicoRota servicoRota;

    @Autowired
    public ListaSlotsLivres(ServicoRota servicoRota) {
        this.servicoRota = servicoRota;
    }

    public List<SlotDTO> listaSlotsLivres(String nomeRota, String data, String horario) {

        String dataHoraString = data + " " + horario;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            // Converte a string de data e horário combinados para Date
            Date dataHora = formato.parse(dataHoraString);
            return servicoRota.slotsLivres(nomeRota, dataHora);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
