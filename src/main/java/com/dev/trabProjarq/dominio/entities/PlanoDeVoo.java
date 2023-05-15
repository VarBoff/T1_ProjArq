package com.dev.trabProjarq.dominio.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plano_voo")
public class PlanoDeVoo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public float altitude;

    public List<Integer> slot_horario;
    public LocalDate data;
    public float horarioPartida;

    @ManyToOne
    @JoinColumn( name = "id Aeronave" )
    public Aeronave aeronave;

    @ManyToOne
    @JoinColumn( name = "id_rota")
    public Rota rota;

    public PlanoDeVoo() {

    }

    public PlanoDeVoo(List<Integer> slot_horario, LocalDate data, float horarioPartida, int altitude, Aeronave aeronave, Rota rota) {
        this.slot_horario = slot_horario;
        this.data = data;
        this.horarioPartida = horarioPartida;
        this.altitude = altitude;
        this.aeronave = aeronave;
        this.rota = rota;
    }
}
