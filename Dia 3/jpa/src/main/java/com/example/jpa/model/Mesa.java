package com.example.jpa.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
    public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroMesa;
    private Boolean ocupada;

    public Mesa() {

    }

    public Mesa(int numeroMesa, Boolean ocupada) {
        this.numeroMesa = numeroMesa;
        this.ocupada = ocupada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }
}
