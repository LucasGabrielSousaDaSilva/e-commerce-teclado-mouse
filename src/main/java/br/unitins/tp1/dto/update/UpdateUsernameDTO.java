package br.unitins.tp1.dto.update;

import jakarta.validation.constraints.NotBlank;

public record UpdateUsernameDTO(
    @NotBlank(message = "usarname não pode ser nulo" )
    String newUsername
) {}
