package br.unitins.tp1.repository.pedido;

import br.unitins.tp1.model.pedido.ItemPedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemPedidoRepository implements PanacheRepository<ItemPedido>{
    
}
