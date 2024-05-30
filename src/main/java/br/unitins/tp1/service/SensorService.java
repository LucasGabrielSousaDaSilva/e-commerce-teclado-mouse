package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.produto.SensorDTO;
import br.unitins.tp1.dto.produto.SensorResponseDTO;
import jakarta.validation.Valid;

public interface SensorService {
    
    public SensorResponseDTO create(@Valid SensorDTO dto);
    public void update(Long id, SensorDTO dto);
    public void delete(long id);
    public List<SensorResponseDTO> findAll();
    public SensorResponseDTO findById(Long id);
    public List<SensorResponseDTO> findByNome(String nome);
}
