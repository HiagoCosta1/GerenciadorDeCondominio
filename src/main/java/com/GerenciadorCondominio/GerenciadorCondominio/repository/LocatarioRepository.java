package com.GerenciadorCondominio.GerenciadorCondominio.repository;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
}
