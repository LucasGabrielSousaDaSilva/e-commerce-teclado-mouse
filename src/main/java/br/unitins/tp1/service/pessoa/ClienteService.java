package br.unitins.tp1.service.pessoa;

import java.util.List;

import br.unitins.tp1.dto.pessoa.ClienteDTO;
import br.unitins.tp1.dto.pessoa.ClienteResponseDTO;
import br.unitins.tp1.dto.pessoa.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface ClienteService {
    public ClienteResponseDTO create(@Valid ClienteDTO dto);
    public void update(Long id, ClienteDTO dto);
    public void delete(long id);
    public List<ClienteResponseDTO> findAll();
    public ClienteResponseDTO findById(Long id);
    public List<ClienteResponseDTO> findByNome(String nome);
    public UsuarioResponseDTO login(String username, String senha);
}
