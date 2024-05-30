package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.ecommerce.Teclado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TecladoRepository implements PanacheRepository<Teclado>{
    
    public List<Teclado> FindByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }
}
