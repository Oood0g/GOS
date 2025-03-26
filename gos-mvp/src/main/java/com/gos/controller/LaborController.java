package com.gos.controller;

import com.gos.model.Labor;
import com.gos.service.LaborService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labor")
@RequiredArgsConstructor //Anotação do lombok
public class LaborController {

    private final LaborService service; //Campo final

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Labor>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Labor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // Criar
    @PostMapping
    public ResponseEntity<Labor> create(@RequestBody Labor labor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(labor));
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Labor> update(@PathVariable Long id, @RequestBody Labor labor) {
        labor.setId(id);
        return ResponseEntity.ok(service.update(id, labor));
    }

    // Excluir
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}