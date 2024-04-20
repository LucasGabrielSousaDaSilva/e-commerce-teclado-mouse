package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.ConstrucaoDTO;
import br.unitins.tp1.dto.ConstrucaoResponseDTO;
import br.unitins.tp1.model.Construcao;
import br.unitins.tp1.repository.ConstrucaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ConstrucaoServiceImpl implements ConstrucaoService{

    @Inject
    public ConstrucaoRepository construcaoRepository;


    @Override
    @Transactional
    public ConstrucaoResponseDTO create(@Valid ConstrucaoDTO dto) {
        Construcao construcao = new Construcao();

        construcao.setPeso(dto.peso());
        construcao.setComprimento(dto.comprimento());
        construcao.setRevestimento(dto.revestimento());
        construcao.setCor(dto.cor());
        construcaoRepository.persist(construcao);
        return ConstrucaoResponseDTO.valueOf(construcao);
    }

    @Override
    @Transactional
    public void update(Long id, ConstrucaoDTO dto) {
        Construcao construcao = construcaoRepository.findById(id);

        construcao.setPeso(dto.peso());
        construcao.setComprimento(dto.comprimento());
        construcao.setRevestimento(dto.revestimento());
        construcao.setCor(dto.cor());
    }

    @Override
    @Transactional
    public void delete(long id) {
       construcaoRepository.deleteById(id);
    }

    @Override
    public List<ConstrucaoResponseDTO> findAll() {
       return construcaoRepository
       .listAll()
       .stream()
       .map(c -> ConstrucaoResponseDTO.valueOf(c)).toList();
    }

    @Override
    public ConstrucaoResponseDTO findById(Long id) {
       return ConstrucaoResponseDTO.valueOf(construcaoRepository.findById(id));
    }

    @Override
    public List<ConstrucaoResponseDTO> findByCor(String cor) {
        return construcaoRepository.findByCor(cor).stream()
        .map(c -> ConstrucaoResponseDTO.valueOf(c)).toList();
    }
    
}
