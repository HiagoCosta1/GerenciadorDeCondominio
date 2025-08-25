package com.GerenciadorCondominio.GerenciadorCondominio.repository;

import com.GerenciadorCondominio.GerenciadorCondominio.model.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {
}
