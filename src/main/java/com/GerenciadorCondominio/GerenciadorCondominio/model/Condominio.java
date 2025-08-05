package com.GerenciadorCondominio.GerenciadorCondominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class  Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;
    private Integer qtdBlocos;
    private Integer qtdApartamentos;


    public Condominio(){

    }

    public Condominio(Integer qtdApartamentos, Integer qtdBlocos, String cnpj, String endereco, String nome, Long id) {
        this.qtdApartamentos = qtdApartamentos;
        this.qtdBlocos = qtdBlocos;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.nome = nome;
        this.id = id;


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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getQtdBlocos() {
        return qtdBlocos;
    }

    public void setQtdBlocos(Integer qtdBlocos) {
        this.qtdBlocos = qtdBlocos;
    }

    public Integer getQtdApartamentos() {
        return qtdApartamentos;
    }

    public void setQtdApartamentos(Integer qtdApartamentos) {
        this.qtdApartamentos = qtdApartamentos;
    }

    }



