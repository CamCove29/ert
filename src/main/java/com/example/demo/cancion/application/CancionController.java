package com.example.demo.cancion.application;

import com.example.demo.artista.domain.Artista;
import com.example.demo.artista.infrastructure.ArtistaRepository;
import com.example.demo.cancion.domain.Cancion;
import com.example.demo.cancion.domain.CancionService;
import com.example.demo.cancion.dto.CancionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/cancion")
@RequiredArgsConstructor
public class CancionController {
    private final CancionService cancionService;
    private final ArtistaRepository artistaRepository;

    @GetMapping
    public ResponseEntity<List<Cancion>> getCanciones() {
        return ResponseEntity.ok(cancionService.getCanciones());
    }

    @PostMapping
    public ResponseEntity<String> createCancion(@RequestBody CancionDto cancionCreateDto) {
        cancionService.createCancion(cancionCreateDto);
        return ResponseEntity.ok("Cancion created.");
    }

    @PutMapping
    public ResponseEntity<String> updateCancion(@RequestBody CancionDto cancionUpdateDto) {
        cancionService.updateCancion(cancionUpdateDto);
        return ResponseEntity.ok("Cancion updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCancion(@PathVariable Long id) {
        cancionService.deleteCancion(id);
        return ResponseEntity.ok("Cancion deleted.");
    }

    @PostMapping("/artistas")
    public ResponseEntity<Void> createArtirsta(@RequestBody Artista artista) {
        artistaRepository.save(artista);
        return ResponseEntity.ok().build();
    }
}

