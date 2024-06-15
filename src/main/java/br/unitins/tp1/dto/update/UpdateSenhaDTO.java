package br.unitins.tp1.dto.update;

import jakarta.validation.constraints.NotBlank;

public record UpdateSenhaDTO(
    @NotBlank(message = "senha antiga não pode ser nulo")
    String oldPassword,
    
    @NotBlank(message = "senha nova não pode ser nulo" )
    String newPassword
) {
    
}
