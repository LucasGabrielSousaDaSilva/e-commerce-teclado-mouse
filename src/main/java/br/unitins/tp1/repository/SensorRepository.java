package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Sensor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SensorRepository implements PanacheRepository<Sensor>{
    
    public List<Sensor> FindByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }
}
