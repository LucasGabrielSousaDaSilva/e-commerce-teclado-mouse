package br.unitins.tp1.repository.pessoa;

import br.unitins.tp1.model.pessoa.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
    
        public Usuario findByUsername(String username){
        return find("UPPER(username) = ?1", username).firstResult();
    }
}