package br.unitins.tp1.dto;

import br.unitins.tp1.model.Marca;

public record MarcaResponseDTO(
    Long id,
    String nome, 
    String empresa
) {
    public static MarcaResponseDTO valueOf(Marca marca){
        return new MarcaResponseDTO(
            marca.getId(),
            marca.getNome(), 
            marca.getEmpresa());
    }
    
}
