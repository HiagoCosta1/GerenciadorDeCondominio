package com.GerenciadorCondominio.GerenciadorCondominio.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Apartamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Integer andar;
    private Boolean ocupado;

    @ManyToOne
    private Condominio condominio;

    @ManyToOne
    private Proprietario proprietario;

    @OneToOne
    private Locatario locatario;

    @OneToMany(mappedBy = "apartamento")
    private List<Hospede> hospedes;


    public Apartamento(){

    }

    public Apartamento(Long id, Integer numero, Integer andar, Boolean ocupado) {
        this.id = id;
        this.numero = numero;
        this.andar = andar;
        this.ocupado = ocupado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }
}
