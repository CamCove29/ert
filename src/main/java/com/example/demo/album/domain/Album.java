package com.example.demo.album.domain;

import com.example.demo.cancion.domain.Cancion;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    String nombre;

    LocalDate fechaDeLanzamiento;

    @OneToMany(mappedBy = "album")
    List<Cancion> canciones;
}
