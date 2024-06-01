package com.example.demo.cancion.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
@Builder
@Getter
public class CancionDto {

    @NotBlank
    private String titulo;

    @NotBlank
    private Integer artistaId;

    @NotBlank
    private Integer albumId;

    @NonNull
    private int duracion;

    @NotBlank
    private Integer userId;

    @NotBlank
    private Integer playlistId;


}
