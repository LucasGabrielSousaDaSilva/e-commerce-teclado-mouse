package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.MarcaDTO;
import br.unitins.tp1.dto.MarcaResponseDTO;
import br.unitins.tp1.model.Marca;
import br.unitins.tp1.repository.MarcaRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService{

    @Inject
    public MarcaRepository marcaRepository;

    @Override
    @Transactional
    public MarcaResponseDTO create(@Valid MarcaDTO dto) {
      validarNomeMarca(dto.nome());
      
        Marca marca = new Marca();

       marca.setNome(dto.nome());
       marca.setEmpresa(dto.empresa());
       marcaRepository.persist(marca);
       return MarcaResponseDTO.valueOf(marca);
    }

    public void validarNomeMarca(String nome){
        Marca marca = marcaRepository.findByNomeMarca(nome);
        if (marca != null) {
            throw new ValidationException("nome", "O nome "+nome+" já existe.");
        }
    }

    @Override
    @Transactional
    public void update(Long id, MarcaDTO dto) {
       Marca marca = marcaRepository.findById(id);

       marca.setNome(dto.nome());
       marca.setEmpresa(dto.empresa());
    }

    @Override
    @Transactional
    public void delete(long id) {
        marcaRepository.deleteById(id);
    }

    @Override
    public List<MarcaResponseDTO> findAll() {
        return marcaRepository
        .listAll()
        .stream()
        .map(m -> MarcaResponseDTO.valueOf(m)).toList();
    }

    @Override
    public MarcaResponseDTO findById(Long id) {
       return MarcaResponseDTO.valueOf(marcaRepository.findById(id));
    }

    @Override
    public List<MarcaResponseDTO> findByNome(String nome) {
        return marcaRepository.FindByNome(nome).stream()
        .map(m -> MarcaResponseDTO.valueOf(m)).toList();
    }
    

}
