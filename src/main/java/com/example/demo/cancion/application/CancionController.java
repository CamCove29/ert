package com.example.demo.cancion.application;

import com.example.demo.cancion.domain.CancionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cancion")
@RequiredArgsConstructor
public class CancionController {
    private final CancionService cancionService;

    @GetMapping
    public ResponseEntity<List<Cancion>> getCanciones() {
        return ResponseEntity.ok(cancionService.getCanciones());
    }

    @PostMapping
    public ResponseEntity<String> createCancion(@RequestBody CancionCreateDto cancionCreateDto) {
        cancionService.createCancion(cancionCreateDto);
        return ResponseEntity.ok("Cancion created.");
}
