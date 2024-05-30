package br.unitins.tp1.dto.produto;

import br.unitins.tp1.model.ecommerce.Modelo;

public record ModeloResponseDTO(
    Long id,
    String nome,
    String serie
) {
    public static ModeloResponseDTO valueOf(Modelo modelo){
        return new ModeloResponseDTO(
            modelo.getId(),
            modelo.getNome(), 
            modelo.getSerie());
    }
}
