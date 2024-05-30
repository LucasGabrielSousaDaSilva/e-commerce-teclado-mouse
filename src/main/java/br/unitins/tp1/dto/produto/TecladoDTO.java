package br.unitins.tp1.dto.produto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TecladoDTO(

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String nome,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String modelo,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String descricao,
    
    Float valor,

    Integer quantidade,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String layout,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String design,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String tipoTeclado,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String iluminacao,

    @Valid
    Long idConstrucao,

    @Valid
    Long idMarca
) {
    
}
