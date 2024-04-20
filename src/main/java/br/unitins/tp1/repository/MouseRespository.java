package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Mouse;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MouseRespository implements PanacheRepository<Mouse>{
    
    public List<Mouse> FindByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }
}
