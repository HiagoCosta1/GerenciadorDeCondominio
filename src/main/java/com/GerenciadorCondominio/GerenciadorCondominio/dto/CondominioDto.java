package com.GerenciadorCondominio.GerenciadorCondominio.dto;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Condominio;

import java.util.List;
import java.util.stream.Collectors;

public record CondominioDto(Long id, String nome, String endereco, int qtdApartamentos, List<ApartamentoDto> apartamentos) {

    public CondominioDto(Condominio condominio) {
        this(
                condominio.getId(),
                condominio.getNome(),
                condominio.getEndereco(),
                condominio.getQtdApartamentos(),
                condominio.getApartamentos().stream()
                        .map(ApartamentoDto::new)
                        .collect(Collectors.toList())
        );
    }
}
