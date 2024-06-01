package com.example.demo.user.domain;
import com.example.demo.lista_reproducción.domain.Playlist;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String nombre;
    private String email;
    private Date fechaDeRegistro;

    @OneToMany(mappedBy = "user")
    private List<Playlist> listasDeReproduccion;

    public int getIdUser() {
        return idUser;
    }

    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Playlist> getListasDeReproduccion() {
        return listasDeReproduccion;
    }


    public void setListasDeReproduccion(List<Playlist> listasDeReproduccion) {
        this.listasDeReproduccion = listasDeReproduccion;
    }
}





