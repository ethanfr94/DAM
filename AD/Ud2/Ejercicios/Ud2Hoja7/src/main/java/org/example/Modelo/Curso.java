package org.example.Modelo;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NamedQueries({@NamedQuery(name = "Curso.findAll", query = "select c from Curso c")})
@Table(name = "curso")
public class Curso {
    @Id
    @Column(name = "id", nullable = false, length = 4)
    private String id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tutor_id", nullable = false)
    private Profesor tutor;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getTutor() {
        return tutor;
    }

    public void setTutor(Profesor tutor) {
        this.tutor = tutor;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

}