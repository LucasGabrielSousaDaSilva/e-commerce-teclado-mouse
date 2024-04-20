package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;

public record ConstrucaoDTO(


    Float peso,

    Float comprimento,
    
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    String revestimento,
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    String cor
) {
    
}
