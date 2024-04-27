package br.unitins.tp1.dto;

import br.unitins.tp1.model.Teclado;

public record TecladoResponseDTO(
    Long id,
    String nome,
    String modelo,
    String descricao,
    Float valor,
    Integer quantidade,
    String layout,
    String design,
    String tipoTeclado,
    String iluminacao,
    ConstrucaoResponseDTO idConstrucao,
    MarcaResponseDTO idMarca
) {
    public static TecladoResponseDTO valueOf(Teclado teclado){
        return new TecladoResponseDTO(
            teclado.getId(), 
            teclado.getNome(), 
            teclado.getModelo(), 
            teclado.getDescricao(), 
            teclado.getValor(), 
            teclado.getQuantidade(), 
            teclado.getLayout(), 
            teclado.getDesign(), 
            teclado.getTipoTeclado(), 
            teclado.getIluminacao(), 
            ConstrucaoResponseDTO.valueOf(teclado.getConstrucao()),
            MarcaResponseDTO.valueOf(teclado.getMarca()));
    }
    
}
