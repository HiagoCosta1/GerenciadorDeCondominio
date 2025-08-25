package com.GerenciadorCondominio.GerenciadorCondominio.service;


import com.GerenciadorCondominio.GerenciadorCondominio.dto.ApartamentoDto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Apartamento;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Condominio;
import com.GerenciadorCondominio.GerenciadorCondominio.repository.ApartamentoRepository;
import com.GerenciadorCondominio.GerenciadorCondominio.repository.CondominioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    public ApartamentoService(ApartamentoRepository apartamentoRepository, CondominioRepository condominioRepository){
        this.condominioRepository = condominioRepository;
        this.apartamentoRepository = apartamentoRepository;
    }

    public List<ApartamentoDto> getAll(){
        return apartamentoRepository.findAll().stream().map(apartamento -> new ApartamentoDto(apartamento)).collect(Collectors.toUnmodifiableList());
    }

    public Optional<ApartamentoDto> findById(long id){
        return apartamentoRepository.findById(id).map(ApartamentoDto::new);
    }

    public ApartamentoDto save(ApartamentoDto apartamentoDto){
        Apartamento apartamento = new Apartamento();
        BeanUtils.copyProperties(apartamentoDto, apartamento);
        Condominio condominio = condominioRepository.findById(apartamentoDto.condominioId())
                .orElseThrow(() -> new RuntimeException("Condomínio não encontrado"));
        apartamento.setCondominio(condominio);


        Apartamento salvo = apartamentoRepository.save(apartamento);
        return new ApartamentoDto(salvo);
    }

    public void delete(long id){

        Apartamento apartamento = apartamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Apartamento não encontrado"));
        apartamentoRepository.delete(apartamento);
    }

    public ApartamentoDto update(long id, ApartamentoDto dto){

        Apartamento apartamentoatualizado = apartamentoRepository.findById(id).orElseThrow(()-> new RuntimeException("Apartamento não encontrado"));
        BeanUtils.copyProperties(dto,apartamentoatualizado);
        Apartamento salvo = apartamentoRepository.save(apartamentoatualizado);
        return new ApartamentoDto(salvo);
    }





}
