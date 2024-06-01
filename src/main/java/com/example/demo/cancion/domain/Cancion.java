package com.example.demo.cancion.domain;

import com.example.demo.album.domain.Album;
import com.example.demo.artista.domain.Artista;
import com.example.demo.lista_reproducción.domain.Playlist;
import com.example.demo.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
//@AllArgsConstructor
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long idSong;

    @NonNull
    private String titulo;

    @ManyToOne
    @NonNull
    private Artista artista;

    @ManyToOne
    @NonNull
    private Album album;

    @NonNull
    private int duracion;

    @ManyToOne
    @NonNull
    private User user;

    @ManyToOne
    @NonNull
    private Playlist playlist;


}
