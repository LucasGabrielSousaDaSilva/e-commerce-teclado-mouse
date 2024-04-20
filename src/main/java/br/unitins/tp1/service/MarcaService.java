package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.MarcaDTO;
import br.unitins.tp1.dto.MarcaResponseDTO;
import jakarta.validation.Valid;

public interface MarcaService {

    public MarcaResponseDTO create(@Valid MarcaDTO dto);
    public void update(Long id, MarcaDTO dto);
    public void delete(long id);
    public List<MarcaResponseDTO> findAll();
    public MarcaResponseDTO findById(Long id);
    public List<MarcaResponseDTO> findByNome(String nome);
}
