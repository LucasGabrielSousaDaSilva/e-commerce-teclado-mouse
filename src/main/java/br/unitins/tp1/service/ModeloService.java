package br.unitins.tp1.service;


import java.util.List;

import br.unitins.tp1.dto.produto.ModeloDTO;
import br.unitins.tp1.dto.produto.ModeloResponseDTO;
import jakarta.validation.Valid;

public interface ModeloService {
    
    public ModeloResponseDTO create(@Valid ModeloDTO dto);
    public void update(Long id, ModeloDTO dto);
    public void delete(long id);
    public List<ModeloResponseDTO> findAll();
    public ModeloResponseDTO findById(Long id);
}
