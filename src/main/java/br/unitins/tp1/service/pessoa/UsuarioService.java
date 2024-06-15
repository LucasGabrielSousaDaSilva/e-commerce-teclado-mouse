package br.unitins.tp1.service.pessoa;

import br.unitins.tp1.model.pessoa.Usuario;

public interface UsuarioService {
    public Usuario findByUsername(String username);
    public void update(Usuario usuario);
}
