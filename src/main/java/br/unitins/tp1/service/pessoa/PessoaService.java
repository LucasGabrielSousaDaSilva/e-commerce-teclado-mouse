package br.unitins.tp1.service.pessoa;

import java.util.List;

import br.unitins.tp1.dto.pessoa.PessoaDTO;
import br.unitins.tp1.dto.pessoa.PessoaResponseDTO;
import jakarta.validation.Valid;

public interface PessoaService {
    public PessoaResponseDTO create(@Valid PessoaDTO dto);
    public void update(Long id, PessoaDTO dto);
    public void delete(long id);
    public List<PessoaResponseDTO> findAll();
    public PessoaResponseDTO findById(Long id);
}
