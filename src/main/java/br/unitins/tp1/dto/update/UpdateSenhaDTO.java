package br.unitins.tp1.dto.update;

import jakarta.validation.constraints.NotBlank;

public record UpdateSenhaDTO(
    @NotBlank
    String oldPassword,
    @NotBlank
    String newPassword
) {
    
}
