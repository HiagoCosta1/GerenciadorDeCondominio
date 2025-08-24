package com.GerenciadorCondominio.GerenciadorCondominio.dto;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Apartamento;

public record ApartamentoDto(Integer numero, Integer andar, Boolean ocupado) {

    public ApartamentoDto(Apartamento apartamento){
        this(
                apartamento.getNumero(),
                apartamento.getAndar(),
                apartamento.getOcupado()
        );
    }

}
