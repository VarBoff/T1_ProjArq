package com.dev.trabProjarq.InterfacesAdaptadoras;

import com.dev.trabProjarq.Aplicacao.*;
import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.Aplicacao.DTO.RelatorioDTO;
import com.dev.trabProjarq.Aplicacao.DTO.RotaDTO;
import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trafegoMenu")
public class TrafegoAereoMenu {
    private ConsultarRotas consultarRotas;
    private ConsultarSlots consultarSlots;
    private GerarRelatorio gerarRelatorio;

    private VerificarPlanoVoo verificarPlanoVoo;

    private AutorizarPlanoDeVoo autorizarPlanoDeVoo;

    private CancelaPlanoDeVoo cancelaPlanoDeVoo;

    @Autowired
    public TrafegoAereoMenu(ConsultarRotas consultarRotas, ConsultarSlots consultarSlots,
            VerificarPlanoVoo verificarPlanoVoo, AutorizarPlanoDeVoo autorizarPlanoDeVoo,
            CancelaPlanoDeVoo cancelaPlanoDeVoo, GerarRelatorio gerarRelatorio) {
        this.gerarRelatorio = gerarRelatorio;
        this.consultarRotas = consultarRotas;
        this.consultarSlots = consultarSlots;
        this.verificarPlanoVoo = verificarPlanoVoo;
        this.autorizarPlanoDeVoo = autorizarPlanoDeVoo;
        this.cancelaPlanoDeVoo = cancelaPlanoDeVoo;
    }

    @GetMapping("/rotas")
    @CrossOrigin(origins = "*")
    public List<RotaDTO> consultaRotasDestinos(@RequestParam("destino") String destino,
            @RequestParam("origem") String origem) {
        return this.consultarRotas.buscaRotasDestino(destino, origem);
    }

    @GetMapping("/altitudes-livres/{aeroviaId}")
    @CrossOrigin(origins = "*")
    public List<Integer> consultaAltitudesLivres(@PathVariable int aeroviaId, @RequestParam("data") String data,
            @RequestParam("horario") float horario, @RequestParam("velocidade") float velCruzeiro) {
        LocalDate dataObj = LocalDate.parse(data);
        return this.consultarSlots.consultaAltitudesLivres(aeroviaId, dataObj, horario, velCruzeiro);
    }

    @PostMapping("/verifica-plano-voo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Aerovia>> verificaPlanoDeVoo(@RequestBody PlanoVooDTO planoVoo) {
        List<Aerovia> lista = this.verificarPlanoVoo.verificaPlanoDeVoo(planoVoo);

        if (!lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lista);
        }
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PostMapping("/libera-plano")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PlanoDeVoo> liberarPlano(@RequestBody PlanoVooDTO planoVoo) {
        PlanoDeVoo plano = this.autorizarPlanoDeVoo.autorizaPlanoDeVoo(planoVoo);
        if (plano != null) {
            return ResponseEntity.status(HttpStatus.OK).body(plano);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/cancela-plano/{planoId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PlanoDeVoo> cancelaPlano(@PathVariable int planoId) {
        PlanoDeVoo plano = this.cancelaPlanoDeVoo.cancelaPlano(planoId);

        if (plano == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(plano);
        }
        return ResponseEntity.status(HttpStatus.OK).body(plano);
    }

    @GetMapping("/relatorio/{aeroviaId}")
    @CrossOrigin(origins = "*")
    public RelatorioDTO geraRelatorio(@PathVariable int aeroviaId, @RequestParam("data") String data){
        LocalDate dataObj = LocalDate.parse(data);
        return this.gerarRelatorio.geraRelatorio(aeroviaId, dataObj);
    }
}
