package com.dev.trabProjarq.dominio.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@AllArgsConstructor
@Table(name = "ocupacao_aerovia")
public class OcupacaoAerovia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    public LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_aerovia")
	public Aerovia aerovia;

	public int slot_altitude;

	public int slot_horario;
	
    public OcupacaoAerovia() {
        
    }

    public OcupacaoAerovia(LocalDate data, Aerovia aerovia, int slot_altitude, int slot_horario) {
        this.data = data;
        this.aerovia = aerovia;
        this.slot_altitude = slot_altitude;
        this.slot_horario = slot_horario;
    }
}