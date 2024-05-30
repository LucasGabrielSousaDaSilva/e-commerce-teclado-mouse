package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.produto.TecladoDTO;
import br.unitins.tp1.dto.produto.TecladoResponseDTO;
import br.unitins.tp1.model.ecommerce.Teclado;
import br.unitins.tp1.repository.ConstrucaoRepository;
import br.unitins.tp1.repository.MarcaRepository;
import br.unitins.tp1.repository.TecladoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class TecladoServiceImpl implements TecladoService{

    @Inject
    public TecladoRepository tecladoRepository;

    @Inject
    public ConstrucaoRepository construcaoRepository;

    @Inject
    public MarcaRepository marcaRepository;

    @Override
    @Transactional
    public TecladoResponseDTO create(@Valid TecladoDTO dto) {
       Teclado teclado = new Teclado();

       teclado.setNome(dto.nome());
       teclado.setModelo(dto.modelo());
       teclado.setDescricao(dto.descricao());
       teclado.setValor(dto.valor());
       teclado.setQuantidade(dto.quantidade());

       teclado.setLayout(dto.layout());
       teclado.setDesign(dto.design());
       teclado.setTipoTeclado(dto.tipoTeclado());
       teclado.setIluminacao(dto.iluminacao());

       teclado.setConstrucao(construcaoRepository.findById(dto.idConstrucao()));

       teclado.setMarca(marcaRepository.findById(dto.idMarca()));

    tecladoRepository.persist(teclado);
    return TecladoResponseDTO.valueOf(teclado);
    }

    @Override
    @Transactional
    public void update(Long id, TecladoDTO dto) {
        Teclado teclado = tecladoRepository.findById(id);

        teclado.setNome(dto.nome());
       teclado.setModelo(dto.modelo());
       teclado.setDescricao(dto.descricao());
       teclado.setValor(dto.valor());
       teclado.setQuantidade(dto.quantidade());

       teclado.setLayout(dto.layout());
       teclado.setDesign(dto.design());
       teclado.setTipoTeclado(dto.tipoTeclado());
       teclado.setIluminacao(dto.iluminacao());

       teclado.setConstrucao(construcaoRepository.findById(dto.idConstrucao()));

    }

    @Override
    @Transactional
    public void delete(long id) {
        tecladoRepository.deleteById(id);
    }

    @Override
    public List<TecladoResponseDTO> findAll() {
        return tecladoRepository.listAll().stream()
        .map(t -> TecladoResponseDTO.valueOf(t)).toList();
    }

    @Override
    public TecladoResponseDTO findById(Long id) {
        return TecladoResponseDTO.valueOf(tecladoRepository.findById(id));
    }

    @Override
    public List<TecladoResponseDTO> findByNome(String nome) {
        return tecladoRepository.FindByNome(nome).stream()
        .map(t -> TecladoResponseDTO.valueOf(t)).toList();
    }
    
}
