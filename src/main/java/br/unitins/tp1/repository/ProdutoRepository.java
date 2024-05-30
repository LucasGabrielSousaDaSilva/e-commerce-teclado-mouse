package br.unitins.tp1.repository;

import br.unitins.tp1.model.ecommerce.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto>{
    
}
