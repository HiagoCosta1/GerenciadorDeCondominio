package com.GerenciadorCondominio.GerenciadorCondominio.service;


import com.GerenciadorCondominio.GerenciadorCondominio.dto.LocatarioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Locatario;
import com.GerenciadorCondominio.GerenciadorCondominio.repository.LocatarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocatarioService {

    private LocatarioRepository locatarioRepository;

    public LocatarioService(LocatarioRepository locatarioRepository){
        this.locatarioRepository = locatarioRepository;
    }

    public List<LocatarioDto> getAll(){
        return locatarioRepository.findAll().stream().map(locatario -> new LocatarioDto(locatario)).collect(Collectors.toUnmodifiableList());
    }

    public Optional<LocatarioDto> findById(long id){
        return locatarioRepository.findById(id).map(LocatarioDto::new);

    }

    public LocatarioDto save (LocatarioDto dto){
        Locatario locatario = new Locatario();
        BeanUtils.copyProperties(dto, locatario);

        Locatario salvo = locatarioRepository.save((locatario));

        return new LocatarioDto(salvo);
    }

    public void delete(Long id){
        Locatario locatario = locatarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Locatario não encontrado"));

        locatarioRepository.delete(locatario);
    }

    public LocatarioDto update(Long id, LocatarioDto dto){
        Locatario locatarioExistente = locatarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Locatario não encontrado"));

        BeanUtils.copyProperties(dto,locatarioExistente, "id");
        Locatario atualizado = locatarioRepository.save(locatarioExistente);

        return new LocatarioDto(atualizado);
    }












}
