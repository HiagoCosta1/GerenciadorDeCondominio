package com.GerenciadorCondominio.GerenciadorCondominio.controller;


import com.GerenciadorCondominio.GerenciadorCondominio.dto.CondominioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.model.Condominio;
import com.GerenciadorCondominio.GerenciadorCondominio.repository.CondominioRepository;
import com.GerenciadorCondominio.GerenciadorCondominio.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;

    @GetMapping
    public ResponseEntity<List<CondominioDto>> getAll() {
        List<CondominioDto> listCondominios = condominioService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(listCondominios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<CondominioDto> dto = condominioService.findById(id);
        return dto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CondominioDto> save(@RequestBody CondominioDto dto) {
        CondominioDto salvo = condominioService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            condominioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondominioDto> update(@PathVariable("id") Long id, @RequestBody CondominioDto dto) {
        try {
            CondominioDto atualizado = condominioService.update(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }





}
