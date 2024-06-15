package br.unitins.tp1.service.pessoa;

import br.unitins.tp1.model.pessoa.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{
    @Inject
    EntityManager em;

    @Override
    public Usuario findByUsername(String username) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public void update(Usuario usuario) {
        em.merge(usuario);
    }
}
