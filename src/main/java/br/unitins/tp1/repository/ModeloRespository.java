package br.unitins.tp1.repository;

import br.unitins.tp1.model.ecommerce.Modelo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ModeloRespository implements PanacheRepository<Modelo>{
    
        public Modelo findByNomeModelo(String nome){
        return find("UPPER(nome) = ?1", nome.toUpperCase()).firstResult();
    }
}
