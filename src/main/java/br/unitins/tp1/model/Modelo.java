package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Modelo extends DefautEntity{
    
    @Column(length = 60, nullable = false)
    private String nome;
    @Column(length = 60, nullable = false)
    private String serie;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }

    
}
