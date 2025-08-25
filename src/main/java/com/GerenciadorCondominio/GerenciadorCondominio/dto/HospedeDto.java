package com.GerenciadorCondominio.GerenciadorCondominio.dto;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Hospede;

public record HospedeDto(Long id, String nome, String cpf, String telefone, Long apartamentoId, String autorizadoPor) {

    public HospedeDto(Hospede hospede){
        this(
                hospede.getId(),
                hospede.getNome(),
                hospede.getCpf(),
                hospede.getTelefone(),
                hospede.getApartamento() != null ? hospede.getApartamento().getId() : null,
                hospede.getAutorizadoPor()
        );
    }
}

