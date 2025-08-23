package com.GerenciadorCondominio.GerenciadorCondominio.controller;


import com.GerenciadorCondominio.GerenciadorCondominio.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locatarios")
public class LocatatioController {

    @Autowired
    private LocatarioService locatarioService;


}
