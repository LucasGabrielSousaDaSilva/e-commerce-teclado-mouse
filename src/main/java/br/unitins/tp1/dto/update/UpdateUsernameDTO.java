package br.unitins.tp1.dto.update;

import jakarta.validation.constraints.NotBlank;

public record UpdateUsernameDTO(
    @NotBlank
    String newUsername
) {}
