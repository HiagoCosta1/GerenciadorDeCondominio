package com.GerenciadorCondominio.GerenciadorCondominio.controller;
import com.GerenciadorCondominio.GerenciadorCondominio.dto.HospedeDto;
import com.GerenciadorCondominio.GerenciadorCondominio.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {


    @Autowired
    private HospedeService hospedeService;

    @GetMapping
    public ResponseEntity<List<HospedeDto>> getAll() {
        List<HospedeDto> listHospedes = hospedeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(listHospedes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<HospedeDto> getById(@PathVariable("id") long id) {
        Optional<HospedeDto> dto = hospedeService.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<HospedeDto> save(@RequestBody HospedeDto hospedeDto) {
        HospedeDto salvo = hospedeService.save(hospedeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        try {
            hospedeService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospedeDto> update(@PathVariable("id") long id, @RequestBody HospedeDto dto) {
        try {
            HospedeDto atualizado = hospedeService.update(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}