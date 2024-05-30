package br.unitins.tp1.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ConstrucaoDTO(

    Float peso,

    Float comprimento,
    
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String revestimento,

    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String cor
) {  }
