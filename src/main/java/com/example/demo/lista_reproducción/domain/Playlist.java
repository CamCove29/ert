package com.example.demo.lista_reproducción.domain;

import com.example.demo.cancion.domain.Cancion;
import com.example.demo.user.domain.User;
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
    private int idUser;
    private String nombre;
    private Date fechaDeCreacion;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @OneToMany(mappedBy = "playlist")
    private List<Cancion> canciones;


}