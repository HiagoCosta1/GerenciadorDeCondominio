package com.GerenciadorCondominio.GerenciadorCondominio.repository;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository  extends JpaRepository<Hospede, Long> {
}
