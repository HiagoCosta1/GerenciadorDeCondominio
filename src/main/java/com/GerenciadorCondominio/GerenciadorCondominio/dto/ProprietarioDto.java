package com.GerenciadorCondominio.GerenciadorCondominio.dto;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Apartamento;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Proprietario;

import java.util.List;
import java.util.stream.Collectors;

public record ProprietarioDto(Long id, String nome, List<Long> apartamentosIds, String cpf, String telefone) {
    public ProprietarioDto(Proprietario proprietario) {
        this(
                proprietario.getId(),
                proprietario.getNome(),
                extrairIds(proprietario),
                proprietario.getCpf(),
                proprietario.getTelefone()
        );
    }

    private static List<Long> extrairIds(Proprietario proprietario) {
        return proprietario.getApartamentos().stream()
                .map(ap -> ap.getId())
                .collect(Collectors.toList());
    }
}




