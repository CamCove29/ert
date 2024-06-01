package com.example.demo.cancion.domain;

import com.example.demo.album.infrastructure.AlbumRepository;
import com.example.demo.artista.infrastructure.ArtistaRepository;
import com.example.demo.lista_reproducción.infrastructure.PlaylistRepository;

import com.example.demo.cancion.dto.CancionDto;
import com.example.demo.cancion.infrastructure.CancionRepository;

import com.example.demo.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CancionService {

    private final CancionRepository cancionRepository;

    private final ArtistaRepository artistaRepository;

    private final AlbumRepository albumRepository;

    private final UserRepository userRepository;

    private final PlaylistRepository playlistRepository;

    private final ModelMapper modelMapper;

    @Async
    public void createCancion(CancionDto cancionDto) {
        var artista = artistaRepository.getReferenceById(cancionDto.getArtistaId());
        var album = albumRepository.getReferenceById(cancionDto.getAlbumId());
        var user = userRepository.getReferenceById(cancionDto.getUserId());
        var playlist = playlistRepository.getReferenceById(cancionDto.getPlaylistId());
        var cancion = modelMapper.map(cancionDto, Cancion.class);

        cancion.setArtista(artista);
        cancion.setAlbum(album);
        cancion.setUser(user);
        cancion.setPlaylist(playlist);

        cancionRepository.save(cancion);

        System.out.println("Cancion created: " + cancionDto.getTitulo());
    }

    public void updateCancion(CancionDto cancionDto) {
        var artista = artistaRepository.getReferenceById(cancionDto.getArtistaId());
        var album = albumRepository.getReferenceById(cancionDto.getAlbumId());
        var user = userRepository.getReferenceById(cancionDto.getUserId());
        var playlist = playlistRepository.getReferenceById(cancionDto.getPlaylistId());
        var cancion = modelMapper.map(cancionDto, Cancion.class);

        cancion.setArtista(artista);
        cancion.setAlbum(album);
        cancion.setUser(user);
        cancion.setPlaylist(playlist);

        cancionRepository.save(cancion);

        System.out.println("Cancion updated: " + cancionDto.getTitulo());
    }

    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
        System.out.println("Cancion deleted.");
    }

    public List<Cancion> getCanciones() {
        return cancionRepository.findAll();
    }
}
