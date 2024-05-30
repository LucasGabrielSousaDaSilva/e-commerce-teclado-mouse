package br.unitins.tp1.dto.pedido;

import java.time.LocalDateTime;

import br.unitins.tp1.model.pedido.FormaPagamento;
import br.unitins.tp1.model.pedido.TipoPagamento;

public record FormaPagamentoResponseDTO(
    Long id,
    Integer parcela,
    LocalDateTime dataPagamento,
    TipoPagamento idTipoPagamento
) {
    public static FormaPagamentoResponseDTO valueOf(FormaPagamento formaPagamento){
        return new FormaPagamentoResponseDTO(
            formaPagamento.getId(), 
            formaPagamento.getParcela(), 
            formaPagamento.getDataPagamento(), 
            formaPagamento.getTipoPagamento());
    }
    
}
