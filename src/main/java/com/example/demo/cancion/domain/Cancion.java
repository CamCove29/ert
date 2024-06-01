package com.example.demo.cancion.domain;

import com.example.demo.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long idSong;

    @NonNull
    private String titulo;

    @OneToMany
    @NonNull
    private Artista artista;

    @ManyToOne
    @NonNull
    private Album album;

    @NonNull
    private int duracion;

    @OneToMany
    @NonNull
    private User user;

    @OneToMany
    @NonNull
    private Playlist playlist;


}
