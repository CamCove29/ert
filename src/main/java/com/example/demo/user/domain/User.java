package com.example.demo.user.domain;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String nombre;
    private String email;
    private Date fechaDeRegistro;

    @OneToMany(mappedBy = "user")
    private List<PlayList> listasDeReproduccion;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public List<PlayList> getListasDeReproduccion() {
        return listasDeReproduccion;
    }


    public void setListasDeReproduccion(List<PlayList> listasDeReproduccion) {
        this.listasDeReproduccion = listasDeReproduccion;
    }
}





