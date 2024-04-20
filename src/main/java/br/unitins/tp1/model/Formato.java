package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Formato extends DefautEntity{
    
    @Column(length = 60, nullable = false)
    private Float comprimento;
    @Column(length = 60, nullable = false)
    private Float largura;
    
    public Float getComprimento() {
        return comprimento;
    }
    public void setComprimento(Float comprimento) {
        this.comprimento = comprimento;
    }
    public Float getLargura() {
        return largura;
    }
    public void setLargura(Float largura) {
        this.largura = largura;
    }

    
}
