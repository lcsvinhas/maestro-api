package br.com.maestro.backend.controller;

import br.com.maestro.backend.dto.BandaDTO;
import br.com.maestro.backend.service.BandaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bandas")
public class BandaController {
    @Autowired
    private BandaService service;

    @GetMapping
    public ResponseEntity<List<BandaDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<BandaDTO> salvar(@Valid @RequestBody BandaDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BandaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody BandaDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@Valid @PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
