package org.example.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Sueldo {
    @Column(nullable = false)
    private double salario;
    private double comision;

    public Sueldo() {
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}
