package br.unitins.tp1.model.pedido;

import br.unitins.tp1.model.DefautEntity;
import br.unitins.tp1.model.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends DefautEntity{
    private Double valor;
    private Integer quantidade;
    private Double desconto;

    @ManyToOne
    @JoinColumn(name = "id_produto") 
    private Produto produto;
    
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Double getDesconto() {
        return desconto;
    }
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
