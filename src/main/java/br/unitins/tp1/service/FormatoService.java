package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.produto.FormatoDTO;
import br.unitins.tp1.dto.produto.FormatoResponseDTO;
import jakarta.validation.Valid;

public interface FormatoService {
    public FormatoResponseDTO create(@Valid FormatoDTO dto);
    public void update(Long id, FormatoDTO dto);
    public void delete(long id);
    public List<FormatoResponseDTO> findAll();
    public FormatoResponseDTO findById(Long id);
}
