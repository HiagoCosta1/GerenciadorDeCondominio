package com.GerenciadorCondominio.GerenciadorCondominio.controller;


import com.GerenciadorCondominio.GerenciadorCondominio.dto.CondominioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.dto.ProprietarioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Proprietario;
import com.GerenciadorCondominio.GerenciadorCondominio.service.ProprietarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProprietarioDto> getById(@PathVariable("id") long id){
        Optional<ProprietarioDto> dto = proprietarioService.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<ProprietarioDto> save (@RequestBody ProprietarioDto dto){
        ProprietarioDto salvo = proprietarioService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try{
            proprietarioService.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProprietarioDto> update(@PathVariable("id") Long id, @RequestBody ProprietarioDto dto){
        try{
            ProprietarioDto atualizado = proprietarioService.update(id, dto);
            return ResponseEntity.ok(atualizado);
        }
        catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}


