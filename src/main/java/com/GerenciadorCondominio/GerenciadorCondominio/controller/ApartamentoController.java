package com.GerenciadorCondominio.GerenciadorCondominio.controller;
import com.GerenciadorCondominio.GerenciadorCondominio.dto.ApartamentoDto;
import com.GerenciadorCondominio.GerenciadorCondominio.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;


    @GetMapping
    public ResponseEntity<List<ApartamentoDto>> getAll(){
        List<ApartamentoDto> listApartamento = apartamentoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(listApartamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartamentoDto> getById(@PathVariable("id") long id){
        Optional<ApartamentoDto> dto = apartamentoService.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<ApartamentoDto> save (@RequestBody ApartamentoDto apartamentoDto){
        ApartamentoDto salvo = apartamentoService.save(apartamentoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
       try{
           apartamentoService.delete(id);
           return ResponseEntity.noContent().build();
       }
       catch(RuntimeException e){
           return ResponseEntity.notFound().build();
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApartamentoDto> update(@PathVariable("id")long id, @RequestBody ApartamentoDto dto) {
        try {
            ApartamentoDto atualizado = apartamentoService.update(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
