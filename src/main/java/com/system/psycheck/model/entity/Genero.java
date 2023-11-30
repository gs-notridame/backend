package com.system.psycheck.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "GENERO")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GENERO")
    @SequenceGenerator(name = "SQ_GENERO", sequenceName = "SQ_GENERO", allocationSize = 1, initialValue = 1)
    @Column(name = "COD_GENERO")
    private Long codGenero;

    private String genero;

    public Genero() {
    }

    public Genero(Long codGenero, String genero) {
        this.codGenero = codGenero;
        this.genero = genero;
    }

    public Long getCodGenero() {
        return codGenero;
    }

    public Genero setCodGenero(Long codGenero) {
        this.codGenero = codGenero;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public Genero setGenero(String genero) {
        this.genero = genero;
        return this;
    }
}

