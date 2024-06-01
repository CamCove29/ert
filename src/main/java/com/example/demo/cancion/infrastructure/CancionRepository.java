package com.example.demo.cancion.infrastructure;

import com.example.demo.cancion.domain.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    void deleteById(Integer id);
}
