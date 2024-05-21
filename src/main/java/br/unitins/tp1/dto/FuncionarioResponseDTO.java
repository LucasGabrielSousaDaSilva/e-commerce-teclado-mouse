package br.unitins.tp1.dto;

import br.unitins.tp1.model.Funcionario;

public record FuncionarioResponseDTO(
    Long id,
    String nome,
    Integer idade,
    String email,
    String cargo,
    Double salario,
    String username,
    String senha
) {
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario){
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getPessoa().getNome(),
            funcionario.getPessoa().getIdade(),
            funcionario.getPessoa().getEmail(),
            funcionario.getCargo(), 
            funcionario.getSalario(),
            funcionario.getPessoa().getUsuario().getUsername(),
            funcionario.getPessoa().getUsuario().getSenha());
    }
}
