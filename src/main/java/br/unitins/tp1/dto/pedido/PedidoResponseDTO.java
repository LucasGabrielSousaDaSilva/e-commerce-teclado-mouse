package br.unitins.tp1.dto.pedido;

import java.time.LocalDate;
import java.util.List;

import br.unitins.tp1.dto.ClienteResponseDTO;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pedido.StatusPagamento;
import br.unitins.tp1.model.pedido.StatusPedido;

public record PedidoResponseDTO(
    Long id,
    Double valorTotal,
    LocalDate data,
    StatusPagamento idStatusPagamento,
    StatusPedido idStatusPedido,
    FormaPagamentoResponseDTO id_formaPagamento,
    ClienteResponseDTO idCliente,
    List<ItemPedidoResponseDTO> itens
) {
    public static PedidoResponseDTO valueOf(Pedido pedido){
        List<ItemPedidoResponseDTO> lista = pedido.getItens()
                                            .stream()
                                            .map(ItemPedidoResponseDTO::valueOf)
                                            .toList();

        return new PedidoResponseDTO(
            pedido.getId(), 
            pedido.getValorTotal(), 
            pedido.getData(), 
            pedido.getStatusPagamento(), 
            pedido.getStatusPedido(),
            FormaPagamentoResponseDTO.valueOf(pedido.getFormaPagamento()),
            ClienteResponseDTO.valueOf(pedido.getCliente()), 
            lista);
    }
    
}
