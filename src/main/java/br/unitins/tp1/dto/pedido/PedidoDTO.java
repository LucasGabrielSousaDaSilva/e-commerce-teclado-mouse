package br.unitins.tp1.dto.pedido;

import java.time.LocalDate;
import java.util.List;

public record PedidoDTO(

    Double valorTotal,
    LocalDate data,

    Integer idStatusPagamento,

    Integer idStatusPedido,

    Long id_formaPagamento,

    Long idCliente,

    List<ItemPedidoDTO> itens

) {
    
}
