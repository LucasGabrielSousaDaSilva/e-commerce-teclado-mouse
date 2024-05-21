package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario>{
    
    public List<Funcionario> findByNome(String nome){
        return find("UPPER(pessoa.nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public Funcionario findByUsernameAndSenha(String username, String senha) {
        return find("pessoa.usuario.username = ?1 AND pessoa.usuario.senha = ?2", username, senha).firstResult();
    }
}