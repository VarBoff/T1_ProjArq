package com.faculdade.t1projarc.dominio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aeroporto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
}
