package com.GerenciadorCondominio.GerenciadorCondominio.dto;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Locatario;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Proprietario;

import java.time.LocalDate;

public record LocatarioDto(String nome, Integer numApart, String cpf, String telefone, LocalDate dataInicioContrato, LocalDate dataFimContrato) {

    public LocatarioDto(Locatario locatario){
        this(
                locatario.getNome(),
                locatario.getNumApart(),
                locatario.getCpf(),
                locatario.getTelefone(),
                locatario.getDataInicioContrato(),
                locatario.getDataFimContrato()
        );
    }



}
