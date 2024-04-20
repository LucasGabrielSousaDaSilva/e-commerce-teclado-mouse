package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.ModeloDTO;
import br.unitins.tp1.dto.ModeloResponseDTO;
import br.unitins.tp1.model.Modelo;
import br.unitins.tp1.repository.ModeloRespository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ModeloServiceImpl implements ModeloService{

    @Inject
    public ModeloRespository modeloRespository;

    @Override
    @Transactional
    public ModeloResponseDTO create(@Valid ModeloDTO dto) {
        Modelo modelo = new Modelo();

        modelo.setNome(dto.nome());
        modelo.setSerie(dto.serie());
        modeloRespository.persist(modelo);
        return ModeloResponseDTO.valueOf(modelo);
    }

    @Override
    @Transactional
    public void update(Long id, ModeloDTO dto) {
        Modelo modelo = modeloRespository.findById(id);

        modelo.setNome(dto.nome());
        modelo.setSerie(dto.serie());
    }

    @Override
    @Transactional
    public void delete(long id) {
        modeloRespository.deleteById(id);
    }

    @Override
    public List<ModeloResponseDTO> findAll() {
        return modeloRespository.listAll().stream()
        .map(m -> ModeloResponseDTO.valueOf(m)).toList();
    }

    @Override
    public ModeloResponseDTO findById(Long id) {
       return ModeloResponseDTO.valueOf(modeloRespository.findById(id));
    }
    
}
