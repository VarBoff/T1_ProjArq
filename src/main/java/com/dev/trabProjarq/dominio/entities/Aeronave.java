package com.dev.trabProjarq.dominio.entities;

import com.dev.trabProjarq.Aplicacao.TiposAeronave;

import javax.persistence.*;

@Entity
@Table(name = "aeronave")
public class Aeronave {

    @Id
    public int id;

    public String prefixo;

    public TiposAeronave tipo;

    public float velCruzeiro;

    public double autonomia;

    public Aeronave(){

    }
}
