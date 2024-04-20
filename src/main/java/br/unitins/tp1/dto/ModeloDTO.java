package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;

public record ModeloDTO(
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String nome,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String serie
) {
    
}
