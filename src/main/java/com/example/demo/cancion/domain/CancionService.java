package com.example.demo.cancion.domain;

import com.example.demo.album.infrastructure.AlbumRepository;
import com.example.demo.cancion.infrastructure.CancionRepository;
import com.example.demo.lista_reproducción.infrastructure.PlaylistRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

public class CancionService {

    private final CancionRepository cancionRepository;

    private ArtistaRepository artistaRepository;

    private AlbumRepository albumRepository;

    private UserRepository userRepository;

    private PlaylistRepository playlistRepository;

    private final ModelMapper modelMapper;



}