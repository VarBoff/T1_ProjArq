package com.faculdade.t1projarc.dominio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class Ocupacao {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;
    private int slotAltitude;
    private int slotHorario;

    public Ocupacao(Long id, Date data, Rota rota, int slotAltitude, int slotHorario) {
        this.id = id;
        this.data = data;
        this.rota = rota;
        this.slotAltitude = slotAltitude;
        this.slotHorario = slotHorario;
    }

    public Ocupacao() {

    }
}
