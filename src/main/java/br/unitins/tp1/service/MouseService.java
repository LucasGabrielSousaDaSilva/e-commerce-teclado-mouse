package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.produto.MouseDTO;
import br.unitins.tp1.dto.produto.MouseResponseDTO;
import jakarta.validation.Valid;

public interface MouseService {
    
    public MouseResponseDTO create(@Valid MouseDTO dto);
    public void update(Long id, MouseDTO dto);
    public void delete(long id);
    public List<MouseResponseDTO> findAll();
    public MouseResponseDTO findById(Long id);
    public List<MouseResponseDTO> findByNome(String nome);
}
