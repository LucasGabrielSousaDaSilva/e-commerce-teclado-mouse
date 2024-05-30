package br.unitins.tp1.dto.pessoa;

import br.unitins.tp1.model.pessoa.Pessoa;

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
