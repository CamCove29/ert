package com.example.demo.lista_reproducción.infrastructure;

import com.example.demo.lista_reproducción.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}
