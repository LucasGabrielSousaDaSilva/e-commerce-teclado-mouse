package br.unitins.tp1.dto;

import br.unitins.tp1.model.Pessoa;

public record UsuarioResponseDTO(
    String username,
    String nome
) {
    public static UsuarioResponseDTO valueOf(Pessoa pessoa){
        return new UsuarioResponseDTO(
            pessoa.getUsuario().getUsername(), 
            pessoa.getNome());
    }
}
