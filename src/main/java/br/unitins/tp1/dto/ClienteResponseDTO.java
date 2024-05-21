package br.unitins.tp1.dto;

import br.unitins.tp1.model.Cliente;

public record ClienteResponseDTO(
    Long id,
    String nome,
    Integer idade,
    String email,
    String endereco,
    String username,
    String senha
    
) {
    public static ClienteResponseDTO valueOf(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getPessoa().getNome(),
            cliente.getPessoa().getIdade(),
            cliente.getPessoa().getEmail(),
            cliente.getEndereço(),
            cliente.getPessoa().getUsuario().getUsername(),
            cliente.getPessoa().getUsuario().getSenha());
    }
}
