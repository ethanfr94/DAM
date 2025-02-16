package org.example.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Empleado {
    @Id // solo con ID hay que asignarle valor al id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// la id se genera autoincrementada para cada tabla
    //@GeneratedValue(strategy = GenerationType.AUTO) = @GeneratedValue -- la id se genera autoincremenatada sobre la base de datos completa (todas las tablas)
    private long id;
    private String nombre;
    private String oficio;
    private LocalDate fechaAlta;
    private double salario;

    public Empleado() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
