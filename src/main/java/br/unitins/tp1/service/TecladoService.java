package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.produto.TecladoDTO;
import br.unitins.tp1.dto.produto.TecladoResponseDTO;
import jakarta.validation.Valid;

public interface TecladoService {
    
    public TecladoResponseDTO create(@Valid TecladoDTO dto);
    public void update(Long id, TecladoDTO dto);
    public void delete(long id);
    public List<TecladoResponseDTO> findAll();
    public TecladoResponseDTO findById(Long id);
    public List<TecladoResponseDTO> findByNome(String nome);
}
