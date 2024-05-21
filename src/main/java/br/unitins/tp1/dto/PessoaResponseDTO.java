package br.unitins.tp1.dto;

import br.unitins.tp1.model.Pessoa;


public record PessoaResponseDTO(
    Long id,
    String nome,
    Integer idade,
    String email
) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa){
        return new PessoaResponseDTO(
            pessoa.getId(),
            pessoa.getNome(), 
            pessoa.getIdade(), 
            pessoa.getEmail());
    }
}
