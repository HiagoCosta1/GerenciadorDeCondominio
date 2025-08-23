package com.GerenciadorCondominio.GerenciadorCondominio.controller;


import com.GerenciadorCondominio.GerenciadorCondominio.dto.LocatarioDto;
import com.GerenciadorCondominio.GerenciadorCondominio.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locatarios")
public class LocatatioController {

    @Autowired
    private LocatarioService locatarioService;


    @GetMapping
    public ResponseEntity<List<LocatarioDto>> getAll(){
        List<LocatarioDto> listLocatatios = locatarioService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(listLocatatios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocatarioDto> getById(@PathVariable ("id") long id){
        Optional<LocatarioDto> dto = locatarioService.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LocatarioDto> save(@RequestBody LocatarioDto dto){
        LocatarioDto salvo = locatarioService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") long id){
        try{
            locatarioService.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocatarioDto> update(@PathVariable("id") long id, @RequestBody  LocatarioDto dto){
        try{
            LocatarioDto atualizado = locatarioService.update(id, dto);
            return ResponseEntity.ok(atualizado);
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }


}
