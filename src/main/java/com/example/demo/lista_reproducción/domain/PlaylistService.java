package com.example.demo.lista_reproducción.domain;


import com.example.demo.lista_reproducción.infrastructure.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylistById(int id) {
        return playlistRepository.findById(id).orElseThrow();
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(int id, Playlist playlist) {
        Playlist existingPlaylist = getPlaylistById(id);
        existingPlaylist.setNombre(playlist.getNombre());
        existingPlaylist.setFechaDeCreacion(playlist.getFechaDeCreacion());
        existingPlaylist.setUser(playlist.getUser());
        existingPlaylist.setCanciones(playlist.getCanciones());
        return playlistRepository.save(existingPlaylist);
    }

    public void deletePlaylist(int id) {
        playlistRepository.deleteById(id);
    }
}
