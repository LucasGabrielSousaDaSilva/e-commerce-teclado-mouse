package br.unitins.tp1.service.pessoa;

import java.util.List;

import br.unitins.tp1.dto.pessoa.ClienteDTO;
import br.unitins.tp1.dto.pessoa.ClienteResponseDTO;
import br.unitins.tp1.dto.pessoa.UsuarioResponseDTO;
import br.unitins.tp1.dto.update.UpdateSenhaDTO;
import br.unitins.tp1.dto.update.UpdateUsernameDTO;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.pessoa.Cliente;
import jakarta.validation.Valid;

public interface ClienteService {
    public ClienteResponseDTO create(@Valid ClienteDTO dto);
    public void update(Long id, ClienteDTO dto);
    public void delete(long id);
    public void updateUsuarioPassword(Long id, UpdateSenhaDTO dto);
    public void updateUsuarioUsername(Long id, UpdateUsernameDTO dto);
    public List<ClienteResponseDTO> findAll();
    public ClienteResponseDTO findById(Long id);
    public List<ClienteResponseDTO> findByNome(String nome);
    public UsuarioResponseDTO login(String username, String senha);
    public Cliente dadosCliente();
    public List<Pedido> dadosClienteVenda();
}
