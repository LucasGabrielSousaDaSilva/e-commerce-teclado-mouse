package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Construcao extends DefautEntity{
    
    @Column(length = 60, nullable = false)
    private Float peso;
    @Column(length = 60, nullable = false)
    private Float comprimento;
    @Column(length = 60, nullable = false)
    private String revestimento;
    @Column(length = 60, nullable = false)
    private String cor;

    
    public Float getPeso() {
        return peso;
    }
    public void setPeso(Float peso) {
        this.peso = peso;
    }
    public Float getComprimento() {
        return comprimento;
    }
    public void setComprimento(Float comprimento) {
        this.comprimento = comprimento;
    }
    public String getRevestimento() {
        return revestimento;
    }
    public void setRevestimento(String revestimento) {
        this.revestimento = revestimento;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    
}
