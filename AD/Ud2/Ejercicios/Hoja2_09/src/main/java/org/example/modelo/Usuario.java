package org.example.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@NamedQueries({
        @NamedQuery(name = "Usuario.sinVotos", query = "select u from Usuario u where u.numvotos = 0")
})

public class Usuario {
    @Id
    @Column(name = "user", nullable = false, length = 15)
    private String user;

    @Column(name = "`contraseña`", nullable = false, length = 32)
    private String contraseña;

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;

    @Column(name = "fechanac")
    private LocalDate fechanac;

    @Column(name = "numvotos")
    private Integer numvotos;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public Integer getNumvotos() {
        return numvotos;
    }

    public void setNumvotos(Integer numvotos) {
        this.numvotos = numvotos;
    }

}