package br.unitins.tp1.dto.pedido;

import java.time.LocalDateTime;

public record FormaPagamentoDTO(
    Integer parcela,
    LocalDateTime dataPagamento,
    Integer idTipoPagamento
) {
    
}
