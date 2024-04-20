package br.unitins.tp1.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;


public record MouseDTO(
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String nome,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String modelo,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String descricao,

    Float valor,
    Integer quantidade,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String iluminacao,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String botao,
    @NotBlank(message = "O não pode ser nulo ou vazio")
    String made,

    Integer idPegada,
    Integer idConexao,
    Long idConstrucao,
    List<Long> sensores
) {
    
}
