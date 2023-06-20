package com.faculdade.t1projarc.dominio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rota {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    @ManyToOne
    @JoinColumn(name = "origem_id")
    private Aeroporto origem;
    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Aeroporto destino;
    private int tamanho; //distância
}
