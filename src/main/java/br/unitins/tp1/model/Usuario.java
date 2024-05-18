package br.unitins.tp1.model;

import jakarta.persistence.Column;

public class Usuario {

    @Column(length = 60, nullable = false)
    private String username;

    @Column(length = 60, nullable = false)
    private String senha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
