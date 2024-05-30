package br.unitins.tp1.model.pedido;

import java.time.LocalDateTime;

import br.unitins.tp1.model.DefautEntity;
import jakarta.persistence.Entity;

@Entity
public class FormaPagamento extends DefautEntity{
    
    private Integer parcela;
    private LocalDateTime dataPagamento;

    private TipoPagamento tipoPagamento;

    public Integer getParcela() {
        return parcela;
    }
    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }
    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    
}
