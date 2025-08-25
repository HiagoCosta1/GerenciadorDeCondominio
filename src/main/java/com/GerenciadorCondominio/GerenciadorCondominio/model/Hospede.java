package com.GerenciadorCondominio.GerenciadorCondominio.model;


import jakarta.persistence.*;

@Entity
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Integer numApart;
    private String autorizadoPor;

    @ManyToOne
    private Apartamento apartamento;

    public Hospede(){

    }

    public Hospede(Long id, String nome, String cpf, String telefone, Integer numApart, String autorizadoPor) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.numApart = numApart;
        this.autorizadoPor = autorizadoPor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getNumApart() {
        return numApart;
    }

    public void setNumApart(Integer numApart) {
        this.numApart = numApart;
    }

    public String getAutorizadoPor() {
        return autorizadoPor;
    }

    public void setAutorizadoPor(String autorizadoPor) {
        this.autorizadoPor = autorizadoPor;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }
}
