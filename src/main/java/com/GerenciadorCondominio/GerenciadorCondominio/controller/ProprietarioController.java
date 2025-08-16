package com.GerenciadorCondominio.GerenciadorCondominio.controller;


import com.GerenciadorCondominio.GerenciadorCondominio.dto.CondominioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.dto.ProprietarioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.service.ProprietarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioService proprietarioService;

    @GetMapping()
    public ResponseEntity<List<ProprietarioDto>> getAll(){
        List<ProprietarioDto> listProprietarios = proprietarioService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProprietarios);
    }


    @PostMapping
    public ResponseEntity<ProprietarioDto> save (@RequestBody ProprietarioDto dto){
        ProprietarioDto salvo = proprietarioService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}


