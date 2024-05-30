package br.unitins.tp1.dto.pedido;

import br.unitins.tp1.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO(
    Long id,
    Double valor,
    Double desconto,
    Integer quantidade
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido itemPedido){
        return new ItemPedidoResponseDTO(
            itemPedido.getId(), 
            itemPedido.getValor(), 
            itemPedido.getDesconto(), 
            itemPedido.getQuantidade());
    }
}
