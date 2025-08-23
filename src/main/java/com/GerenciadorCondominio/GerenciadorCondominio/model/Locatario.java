package com.GerenciadorCondominio.GerenciadorCondominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@Entity
public class Locatario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer numApart;
    private String cpf;
    private String telefone;
    private LocalDate dataInicioContrato;
    private LocalDate dataFimContrato;

    public Locatario(){

    }

    public Locatario(Long id, String nome, Integer numApart, String cpf, String telefone, LocalDate dataInicioContrato, LocalDate dataFimContrato) {
        this.id = id;
        this.nome = nome;
        this.numApart = numApart;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataInicioContrato = dataInicioContrato;
        this.dataFimContrato = dataFimContrato;
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

    public Integer getNumApart() {
        return numApart;
    }

    public void setNumApart(Integer numApart) {
        this.numApart = numApart;
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

    public LocalDate getDataInicioContrato() {
        return dataInicioContrato;
    }

    public void setDataInicioContrato(LocalDate dataInicioContrato) {
        this.dataInicioContrato = dataInicioContrato;
    }

    public LocalDate getDataFimContrato() {
        return dataFimContrato;
    }

    public void setDataFimContrato(LocalDate dataFimContrato) {
        this.dataFimContrato = dataFimContrato;
    }
}
