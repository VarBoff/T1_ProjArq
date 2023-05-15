package com.dev.trabProjarq.dominio.entities;

import javax.persistence.*;

@Entity
@Table(name = "aeronave")
public class Aeronave {

    @Id
    public String prefixo;

    public String tipo;

    public float velCruzeiro;

    public double autonomia;

    public Aeronave(){

    }
}
