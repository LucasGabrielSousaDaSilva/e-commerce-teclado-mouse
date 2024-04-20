package br.unitins.tp1.dto;

import br.unitins.tp1.model.Formato;

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
