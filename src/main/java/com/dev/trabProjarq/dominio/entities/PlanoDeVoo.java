package com.dev.trabProjarq.dominio.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plano_voo")
public class PlanoDeVoo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public float horarioPartida;
    public LocalDate data;
    public float altitude;
    public float velCruzeiro;

    @ManyToOne
    @JoinColumn( name = "id_rota")
    public Rota rota;

    public PlanoDeVoo() {

    }

    public PlanoDeVoo(float horarioPartida, LocalDate data, int altitude, float velCruzeiro, Rota rota) {
        this.horarioPartida = horarioPartida;
        this.data = data;
        this.altitude = altitude;
        this.velCruzeiro = velCruzeiro;
        this.rota = rota;
    }
}
