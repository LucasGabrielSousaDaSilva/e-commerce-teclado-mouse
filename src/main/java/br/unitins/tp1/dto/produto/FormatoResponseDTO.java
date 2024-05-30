package br.unitins.tp1.dto.produto;

import br.unitins.tp1.model.ecommerce.Formato;

public record FormatoResponseDTO(
    Long id,
    Float comprimento,
    Float largura
) {
    public static FormatoResponseDTO valueOf(Formato formato){
        return new FormatoResponseDTO(
            formato.getId(), 
            formato.getComprimento(), 
            formato.getLargura());
    }
    
}
