package com.faculdade.t1projarc.interfacesAdaptadoras;

import com.faculdade.t1projarc.aplicacao.*;
import com.faculdade.t1projarc.dominio.entity.Rota;
import com.faculdade.t1projarc.interfacesAdaptadoras.dto.PlanoDeVooDTO;
import com.faculdade.t1projarc.interfacesAdaptadoras.dto.RotaDTO;
import com.faculdade.t1projarc.interfacesAdaptadoras.dto.SlotDTO;
import com.faculdade.t1projarc.interfacesAdaptadoras.dto.StatusPlanoDeVooDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/scta", produces = "application/json")
public class ControllerAPI {

    private ListaRotas listaRotas;
    private ListaSlotsLivres listaSlotsLivres;

    private CancelaPlanoDeVoo cancelaPlanoDeVoo;

    private AvaliaPlanoDeVoo avaliaPlanoDeVoo;

    private AprovaPlanoDeVoo aprovaPlanoDeVoo;

    @Autowired
    public ControllerAPI(ListaRotas listaRotas, ListaSlotsLivres listaSlotsLivres,
                         CancelaPlanoDeVoo cancelaPlanoDeVoo, AvaliaPlanoDeVoo avaliaPlanoDeVoo,
                         AprovaPlanoDeVoo aprovaPlanoDeVoo) {
        this.listaRotas = listaRotas;
        this.listaSlotsLivres = listaSlotsLivres;
        this.cancelaPlanoDeVoo = cancelaPlanoDeVoo;
        this.avaliaPlanoDeVoo = avaliaPlanoDeVoo;
        this.aprovaPlanoDeVoo = aprovaPlanoDeVoo;
    }


    @GetMapping("rotas/{origem}/{destino}")
    public List<Rota> listaRotasClient(@PathVariable("origem") String origem, @PathVariable("destino") String destino) {
        return listaRotas.listaRotas(origem,destino);
    }

    @PostMapping(value = "/slotslivres",produces = "application/json" )
    @ResponseBody
    public List<SlotDTO> listaSlotsLivresClient(@RequestBody RotaDTO requisicaoDTO) {

        String rota = requisicaoDTO.getRota();
        String data = requisicaoDTO.getData();
        String horario = requisicaoDTO.getHorario();

        return listaSlotsLivres.listaSlotsLivres(rota,data,horario);
    }
    @PostMapping(value = "/avaliaPlanoDeVoo", produces = "application/json" )
    @ResponseBody
    public StatusPlanoDeVooDTO avaliaPlanoDeVooClient(@RequestBody PlanoDeVooDTO planoDeVooDTO){

        String nomeAeronave = planoDeVooDTO.getNomeAeronave();
        String nomeRota = planoDeVooDTO.getNomeRota();
        String data = planoDeVooDTO.getData();
        String horario = planoDeVooDTO.getHorario();
        Integer altitude = planoDeVooDTO.getAltitude();
        List<Integer> slotsHorario = planoDeVooDTO.getSlotsHorario();

        return avaliaPlanoDeVoo.avaliacaoPlanoDeVoo(nomeAeronave,nomeRota,data,horario,altitude,slotsHorario);
    }
    @PostMapping("/aprovaPlanoDeVoo")
    public String aprovaPlanoDeVooClient(@RequestBody PlanoDeVooDTO planoDeVooDTO){
        String nomeAeronave = planoDeVooDTO.getNomeAeronave();
        String nomeRota = planoDeVooDTO.getNomeRota();
        String data = planoDeVooDTO.getData();
        String horario = planoDeVooDTO.getHorario();
        Integer altitude = planoDeVooDTO.getAltitude();
        List<Integer> slotsHorario = planoDeVooDTO.getSlotsHorario();

        return aprovaPlanoDeVoo.aprovaPlanoDeVoo(nomeAeronave,nomeRota,data,horario,altitude,slotsHorario);
    }

    @PostMapping("slotslivres/cancela/{idPlanoDeVoo}")
    public String cancelaPlanoDeVooClient(@PathVariable("idPlanoDeVoo") Long idPlanoDeVoo){

        return cancelaPlanoDeVoo.cancelaPlanoDeVoo(idPlanoDeVoo);
    }


}
