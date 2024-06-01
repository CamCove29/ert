package com.example.demo.cancion.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CancionDto {

    @NotBlank
    private String titulo;

    @NotBlank
    private String artista;

    @NotBlank
    private String album;

    @NonNull
    private int duracion;

    @NotBlank
    private String user;

    @NotBlank
    private String playlist;


}
