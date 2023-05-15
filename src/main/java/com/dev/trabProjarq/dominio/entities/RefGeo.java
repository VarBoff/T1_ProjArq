package com.dev.trabProjarq.dominio.entities;

import javax.persistence.*;

@Entity
@Table(name = "ref_geo")
public class RefGeo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nome;
    public float latitude;
    public float longitude;

    public RefGeo(){
        
    }

}
