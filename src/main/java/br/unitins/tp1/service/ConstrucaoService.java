package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.produto.ConstrucaoDTO;
import br.unitins.tp1.dto.produto.ConstrucaoResponseDTO;
import jakarta.validation.Valid;

public interface ConstrucaoService {
    
    public ConstrucaoResponseDTO create(@Valid ConstrucaoDTO dto);
    public void update(Long id, ConstrucaoDTO dto);
    public void delete(long id);
    public List<ConstrucaoResponseDTO> findAll();
    public ConstrucaoResponseDTO findById(Long id);
    public List<ConstrucaoResponseDTO> findByCor(String cor);
}
