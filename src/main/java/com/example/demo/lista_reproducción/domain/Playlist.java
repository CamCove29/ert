package com.example.demo.lista_reproducción.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Playlist {
    @Id
    private int idPlaylist;
    private String nombre;
    private Date fechaDeCreacion;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "playlist")
    private List<Cancion> canciones;


}