package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;

public record TecladoDTO(

    @NotBlank(message = "O não pode ser nulo ou vazio")
    String nome,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String modelo,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String descricao,
    
    Float valor,
    Integer quantidade,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String layout,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String design,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String tipoTeclado,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String iluminacao,
    Long idConstrucao
) {
    
}
