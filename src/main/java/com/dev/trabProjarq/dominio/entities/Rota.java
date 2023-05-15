package com.dev.trabProjarq.dominio.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "rota")
public class Rota {

    @ManyToMany
    @JoinTable(name = " rota_aerovia ",
    joinColumns =  @JoinColumn(name = " id_rota "),
    inverseJoinColumns = @JoinColumn(name = " id_aerovia "))
    public List<Aerovia> aerovias;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    public String nome;

    @ManyToOne
    @JoinColumn(name = "ref_geo_origin_id")
    public RefGeo origem;

    @ManyToOne
    @JoinColumn(name = "ref_geo_destiny_id")
    public RefGeo destino;

    public Rota(){
        
    }
    
}
