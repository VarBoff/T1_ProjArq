package com.faculdade.t1projarc.dominio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
public class Aeronave {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Pattern(regexp = "^(PP|PR|PS|PT|PU)(?!Q)(?!.*W)(?!SOS)(?!XXX)(?!PAN)(?!TTT)(?!VFR)(?!IFR)(?!VMC)(?!IMC)[A-Z0-9]{3}$")
    private String prefixo;
    private String tipo; //Aqui preciso descrever PP, CP, CC
    private int velocidade;
    private int autonomia;

}
