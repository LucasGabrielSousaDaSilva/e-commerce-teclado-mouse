package br.unitins.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Cliente {

    @Column(length = 60, nullable = false)
    private String endereço;

    @OneToOne
    @JoinColumn(name = "id_Pessoa", unique = true)
    private Pessoa pessoa;

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    

}
