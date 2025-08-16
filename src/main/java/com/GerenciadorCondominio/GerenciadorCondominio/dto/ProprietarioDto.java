package com.GerenciadorCondominio.GerenciadorCondominio.dto;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Proprietario;

public record ProprietarioDto(String nome, Integer numApart, String cpf, String telefone) {
    public ProprietarioDto(Proprietario proprietario) {
        this(
                proprietario.getNome(),
                proprietario.getNumApart(),
                proprietario.getCpf(),
                proprietario.getTelefone()
        );
    }
}

