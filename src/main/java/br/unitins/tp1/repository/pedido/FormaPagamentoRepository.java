package br.unitins.tp1.repository.pedido;

import br.unitins.tp1.model.pedido.FormaPagamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FormaPagamentoRepository implements PanacheRepository<FormaPagamento>{
    
}
