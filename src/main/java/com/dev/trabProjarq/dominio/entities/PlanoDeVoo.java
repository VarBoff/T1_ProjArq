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

    public float altitude;

    public float slot_horario;

    public LocalDate data;

    @ManyToOne
    @JoinColumn( name = "id Aeronave" )
    public Aeronave aeronave;

    @ManyToOne
    @JoinColumn( name = "id_rota")
    public Rota rota;

    public PlanoDeVoo() {

    }

    public PlanoDeVoo(float slot_horario, LocalDate data, int altitude,Aeronave aeronave, Rota rota) {
        this.slot_horario = slot_horario;
        this.data = data;
        this.altitude = altitude;
        this.aeronave = aeronave;
        this.rota = rota;
    }
}
