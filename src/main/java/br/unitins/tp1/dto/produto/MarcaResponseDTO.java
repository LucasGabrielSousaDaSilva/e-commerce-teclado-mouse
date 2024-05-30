package br.unitins.tp1.dto.produto;

import br.unitins.tp1.model.ecommerce.Marca;

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
