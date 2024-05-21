package br.unitins.tp1.dto;

public record ClienteDTO(
    String nome,
    Integer idade,
    String email,
    String endereco,
    String username,
    String senha
    
) {
    
}
