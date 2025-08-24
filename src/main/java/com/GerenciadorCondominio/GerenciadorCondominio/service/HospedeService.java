package com.GerenciadorCondominio.GerenciadorCondominio.service;


import com.GerenciadorCondominio.GerenciadorCondominio.dto.HospedeDto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Hospede;
import com.GerenciadorCondominio.GerenciadorCondominio.repository.HospedeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospedeService {

    private HospedeRepository hospedeRepository;

    public HospedeService(HospedeRepository hospedeRepository){
        this.hospedeRepository = hospedeRepository;
    }

    public List<HospedeDto> getAll(){
        return hospedeRepository.findAll().stream().map(hospede -> new HospedeDto(hospede)).collect(Collectors.toUnmodifiableList());
    }

    public Optional<HospedeDto> findById(Long id){
        return hospedeRepository.findById(id).map(HospedeDto::new);
    }

    public HospedeDto save(HospedeDto hospedeDto){
        Hospede hospede = new Hospede();
        BeanUtils.copyProperties(hospedeDto,hospede);

        Hospede salvo = hospedeRepository.save(hospede);
        return new HospedeDto(salvo);

    }

    public void delete(long id){

        Hospede hospede = hospedeRepository.findById(id).orElseThrow(()-> new RuntimeException("Hospede não encontrado"));
        hospedeRepository.delete(hospede);
    }

    public HospedeDto update(long id, HospedeDto dto){
        Hospede hospedeatualizado = hospedeRepository.findById(id).orElseThrow(()-> new RuntimeException("Hospede não encontrado"));

        BeanUtils.copyProperties(dto,hospedeatualizado,"id");
        Hospede salvo = hospedeRepository.save(hospedeatualizado);

        return new HospedeDto(salvo);

    }


}
