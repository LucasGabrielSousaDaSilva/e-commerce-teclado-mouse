package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Construcao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConstrucaoRepository implements PanacheRepository<Construcao>{
    
    public List<Construcao> findByCor(String cor){
        return find("UPPER(cor) LIKE ?1", "%" + cor.toUpperCase() + "%").list();
    }
}
