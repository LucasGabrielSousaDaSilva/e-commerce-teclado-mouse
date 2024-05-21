package br.unitins.tp1.dto;

public record FuncionarioDTO(
    String nome,
    Integer idade,
    String cargo,
    String email,
    Double salario,
    String username,
    String senha
) {

}
