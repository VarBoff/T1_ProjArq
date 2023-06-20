package com.faculdade.t1projarc.dominio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanoDeVoo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;
    private int altitude;
    private List<Integer> slotsTempo;

}
