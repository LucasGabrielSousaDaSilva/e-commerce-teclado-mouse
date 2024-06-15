package br.unitins.tp1.service.pessoa;

import java.util.List;

import br.unitins.tp1.dto.pessoa.FuncionarioDTO;
import br.unitins.tp1.dto.pessoa.FuncionarioResponseDTO;
import br.unitins.tp1.dto.pessoa.UsuarioResponseDTO;
import br.unitins.tp1.dto.update.UpdateSenhaDTO;
import br.unitins.tp1.dto.update.UpdateUsernameDTO;
import jakarta.validation.Valid;

public interface FuncionarioService {
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);
    public void update(Long id, FuncionarioDTO dto);
    public void delete(long id);
    public void updateUsuarioPassword(Long id, UpdateSenhaDTO dto);
    public void updateUsuarioUsername(Long id, UpdateUsernameDTO dto);
    public List<FuncionarioResponseDTO> findAll();
    public FuncionarioResponseDTO findById(Long id);
    public List<FuncionarioResponseDTO> findByNome(String nome);
    public UsuarioResponseDTO login(String username, String senha);  
}
