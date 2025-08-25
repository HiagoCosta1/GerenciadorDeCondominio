package com.GerenciadorCondominio.GerenciadorCondominio.dto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Apartamento;
public record ApartamentoDto(
        Long id,
        Integer numero,
        Integer andar,
        Boolean ocupado,
        Long condominioId,
        Long proprietarioId,
        Long locatarioId
) {
    public ApartamentoDto(Apartamento apartamento) {
        this(
                apartamento.getId(),
                apartamento.getNumero(),
                apartamento.getAndar(),
                apartamento.getOcupado(),
                apartamento.getCondominio() != null ? apartamento.getCondominio().getId() : null,
                apartamento.getProprietario() != null ? apartamento.getProprietario().getId() : null,
                apartamento.getLocatario() != null ? apartamento.getLocatario().getId() : null
        );
    }
}
