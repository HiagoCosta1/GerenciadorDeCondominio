package com.GerenciadorCondominio.GerenciadorCondominio.service;

import com.GerenciadorCondominio.GerenciadorCondominio.dto.CondominioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Condominio;
import com.GerenciadorCondominio.GerenciadorCondominio.repository.CondominioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CondominioService {

    private final CondominioRepository condominioRepository;

    public CondominioService (CondominioRepository condominioRepository){
        this.condominioRepository = condominioRepository;
    }

    public List<CondominioDto> getAll() {
        return condominioRepository.findAll()
                .stream()
                .map(condominio -> new CondominioDto(condominio))
                .collect(Collectors.toList()); //
    }

    public Optional<CondominioDto> findById(Long id) {
        return condominioRepository.findById(id)
                .map(CondominioDto::new);
    }

    public CondominioDto save(CondominioDto dto) {
        Condominio condominio = new Condominio();
        BeanUtils.copyProperties(dto, condominio);

        Condominio salvo = condominioRepository.save(condominio);

        return new CondominioDto(salvo);
    }

    public void delete(Long id) {
        Condominio condominio = condominioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Condomínio não encontrado"));

        condominioRepository.delete(condominio);
    }

    public CondominioDto update(Long id, CondominioDto dto) {
        Condominio condominioExistente = condominioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Condomínio não encontrado"));

        BeanUtils.copyProperties(dto, condominioExistente, "id");
        Condominio atualizado = condominioRepository.save(condominioExistente);

        return new CondominioDto(atualizado);
    }



}
