package br.unitins.tp1.dto.pessoa;

import br.unitins.tp1.model.pessoa.Pessoa;


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
