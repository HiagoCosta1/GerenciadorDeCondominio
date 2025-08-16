package com.GerenciadorCondominio.GerenciadorCondominio.repository;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
}
