package com.GerenciadorCondominio.GerenciadorCondominio.dto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Locatario;
import java.time.LocalDate;

public record LocatarioDto(
        Long id,
        String nome,
        Long apartamentoId,
        String cpf,
        String telefone,
        LocalDate dataInicioContrato,
        LocalDate dataFimContrato
) {
    public LocatarioDto(Locatario locatario){
        this(
                locatario.getId(),
                locatario.getNome(),
                locatario.getApartamento() != null ? locatario.getApartamento().getId() : null,
                locatario.getCpf(),
                locatario.getTelefone(),
                locatario.getDataInicioContrato(),
                locatario.getDataFimContrato()
        );
    }
}

