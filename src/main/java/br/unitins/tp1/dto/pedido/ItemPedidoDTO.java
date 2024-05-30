package br.unitins.tp1.dto.pedido;

public record ItemPedidoDTO(
    Double valor,
    Double desconto,
    Integer quantidade,
    
    Long idProduto
) {
    
}
