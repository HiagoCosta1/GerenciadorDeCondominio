package com.GerenciadorCondominio.GerenciadorCondominio.dto;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Hospede;

public record HospedeDto(String nome, String cpf, String telefone, Integer numApart, String autorizadoPor) {

    public HospedeDto(Hospede hospede){
        this(
                hospede.getNome(),
                hospede.getCpf(),
                hospede.getTelefone(),
                hospede.getNumApart(),
                hospede.getAutorizadoPor()
        );
    }

}
