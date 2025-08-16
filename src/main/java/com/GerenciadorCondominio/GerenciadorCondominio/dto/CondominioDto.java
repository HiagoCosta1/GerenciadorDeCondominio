package com.GerenciadorCondominio.GerenciadorCondominio.dto;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Condominio;

public record CondominioDto(Long id, String nome, String endereco, int qtdApartamentos) {

    public CondominioDto(Condominio condominio) {
        this(
                condominio.getId(),
                condominio.getNome(),
                condominio.getEndereco(),
                condominio.getQtdApartamentos()
        );
    }
}
