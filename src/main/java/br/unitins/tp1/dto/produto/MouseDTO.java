package br.unitins.tp1.dto.produto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record MouseDTO(
    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String nome,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String modelo,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String descricao,

    Float valor,

    Integer quantidade,


    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String iluminacao,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String botao,

    @NotBlank(message = "O não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String made,
    
    @Valid
    Integer idPegada,

    @Valid
    Integer idConexao,

    @Valid
    Long idConstrucao,

    @Valid
    List<Long> sensores
) {
    
}
