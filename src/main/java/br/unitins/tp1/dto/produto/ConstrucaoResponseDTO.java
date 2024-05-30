package br.unitins.tp1.dto.produto;

import br.unitins.tp1.model.ecommerce.Construcao;

public record ConstrucaoResponseDTO(
    Long id,
    Float peso,
    Float comprimento,
    String revestimento,
    String cor
    
) {

    public static ConstrucaoResponseDTO valueOf(Construcao construcao){
        return new ConstrucaoResponseDTO(
            construcao.getId(), 
            construcao.getPeso(), 
            construcao.getComprimento(), 
            construcao.getRevestimento(), 
            construcao.getCor());
    }
}
