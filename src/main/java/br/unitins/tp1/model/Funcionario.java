package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Funcionario {

    @Column(length = 60, nullable = false)
    private String cargo;

    @Column(length = 60, nullable = false)
    private Double salario;

    @OneToOne
    @JoinColumn(name = "id_Pessoa", unique = true)
    private Pessoa pessoa;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    
}
