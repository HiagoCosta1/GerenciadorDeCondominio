package com.GerenciadorCondominio.GerenciadorCondominio.service;


import com.GerenciadorCondominio.GerenciadorCondominio.dto.ProprietarioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Condominio;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Proprietario;
import com.GerenciadorCondominio.GerenciadorCondominio.repository.ProprietarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProprietarioService {


    private ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    public List<ProprietarioDto> getAll(){
        return proprietarioRepository.findAll().stream().map(proprietario -> new ProprietarioDto(proprietario)).collect(Collectors.toUnmodifiableList());

    }

    public Optional<ProprietarioDto> findById(long id){
        return proprietarioRepository.findById(id).map(ProprietarioDto::new);
    }

    public ProprietarioDto save(ProprietarioDto dto){
        Proprietario proprietario = new Proprietario();
        BeanUtils.copyProperties(dto, proprietario);

        Proprietario salvo = proprietarioRepository.save(proprietario);

        return new ProprietarioDto(salvo);
    }

    public void delete (Long id){
        Proprietario proprietario = proprietarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Proprietario nâo encontrado"));

        proprietarioRepository.delete(proprietario);
    }

    public ProprietarioDto update(Long id, ProprietarioDto dto){
        Proprietario proprietarioExistente = proprietarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Proprietario não encontrado"));

        BeanUtils.copyProperties(dto,proprietarioExistente, "id");
        Proprietario atualizado = proprietarioRepository.save(proprietarioExistente);
        return new ProprietarioDto(atualizado);
    }


}
