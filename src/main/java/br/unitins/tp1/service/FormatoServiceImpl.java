package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.FormatoDTO;
import br.unitins.tp1.dto.FormatoResponseDTO;
import br.unitins.tp1.model.Formato;
import br.unitins.tp1.repository.FormatoRespository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class FormatoServiceImpl implements FormatoService{

    @Inject
    public FormatoRespository formatoRespository;

    @Override
    @Transactional
    public FormatoResponseDTO create(@Valid FormatoDTO dto) {
       Formato formato = new Formato();

       formato.setComprimento(dto.comprimento());
       formato.setLargura(dto.largura());
       formatoRespository.persist(formato);
       return FormatoResponseDTO.valueOf(formato);
    }

    @Override
    @Transactional
    public void update(Long id, FormatoDTO dto) {
        Formato formato = formatoRespository.findById(id);

        formato.setComprimento(dto.comprimento());
        formato.setLargura(dto.largura());
    }

    @Override
    @Transactional
    public void delete(long id) {
       formatoRespository.deleteById(id);
    }

    @Override
    public List<FormatoResponseDTO> findAll() {
        return formatoRespository
        .listAll()
        .stream()
        .map(f -> FormatoResponseDTO.valueOf(f)).toList();
    }

    @Override
    public FormatoResponseDTO findById(Long id) {
        return FormatoResponseDTO.valueOf(formatoRespository.findById(id));
    }
    
}
