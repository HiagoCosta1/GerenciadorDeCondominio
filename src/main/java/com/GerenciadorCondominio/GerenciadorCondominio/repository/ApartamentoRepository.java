package com.GerenciadorCondominio.GerenciadorCondominio.repository;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentoRepository  extends JpaRepository<Apartamento, Long> {


}
