package br.com.maestro.backend.controller;

import br.com.maestro.backend.dto.UsuarioRequestDTO;
import br.com.maestro.backend.dto.UsuarioResponseDTO;
import br.com.maestro.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO inserir(@RequestBody UsuarioRequestDTO usuario) {
        return service.inserir(usuario);
    }
}
