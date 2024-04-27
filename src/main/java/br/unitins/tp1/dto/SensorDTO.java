package br.unitins.tp1.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SensorDTO(

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String nome,

    Double dpi,

    Double ips,

    @Valid
    Long idModelo,

    @Valid
    Long idFormato
) {
    
}
