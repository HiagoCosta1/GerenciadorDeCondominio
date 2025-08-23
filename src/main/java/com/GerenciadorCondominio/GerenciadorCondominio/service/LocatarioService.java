package com.GerenciadorCondominio.GerenciadorCondominio.service;


import com.GerenciadorCondominio.GerenciadorCondominio.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocatarioService {

    private LocatarioRepository locatarioRepository;

    public LocatarioService(LocatarioRepository locatarioRepository){
        this.locatarioRepository = locatarioRepository;
    }








}
