package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.PessoaDTO;
import br.unitins.tp1.dto.PessoaResponseDTO;
import jakarta.validation.Valid;

public interface PessoaService {
    public PessoaResponseDTO create(@Valid PessoaDTO dto);
    public void update(Long id, PessoaDTO dto);
    public void delete(long id);
    public List<PessoaResponseDTO> findAll();
    public PessoaResponseDTO findById(Long id);
}
