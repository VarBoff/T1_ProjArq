package com.dev.trabProjarq.dominio.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "aerovia")
public class Aerovia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nome;
    public float distancia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "ref_geo_destiny_id")
    public RefGeo destino;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "ref_geo_origin_id")
    public RefGeo origem;

    public Aerovia(){

    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RefGeo getDestino() {
        return destino;
    }

    public void setDestino(RefGeo destino) {
        this.destino = destino;
    }

    public RefGeo getOrigem() {
        return origem;
    }

    public void setOrigem(RefGeo origem) {
        this.origem = origem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

}
