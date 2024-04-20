package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;

public record SensorDTO(

    @NotBlank(message = "O não pode ser nulo ou vazio")
    String nome,

    Double dpi,

    Double ips,

    Long idModelo,

    Long idFormato
) {
    
}
