package br.unitins.tp1.dto.pessoa;

public record ClienteDTO(
    String nome,
    Integer idade,
    String email,
    String endereco,
    String username,
    String senha
    
) {
    
}
