package br.unitins.tp1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.tp1.dto.MouseDTO;
import br.unitins.tp1.dto.MouseResponseDTO;
import br.unitins.tp1.model.Conexao;
import br.unitins.tp1.model.Mouse;
import br.unitins.tp1.model.Pegada;
import br.unitins.tp1.model.Sensor;
import br.unitins.tp1.repository.ConstrucaoRepository;
import br.unitins.tp1.repository.MouseRespository;
import br.unitins.tp1.repository.SensorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class MouseServiceImpl implements MouseService{

    @Inject
    public MouseRespository mouseRespository;

    @Inject
    public ConstrucaoRepository construcaoRepository;

    @Inject
    public SensorRepository sensorRepository;

    @Override
    @Transactional
    public MouseResponseDTO create(@Valid MouseDTO dto) {
        Mouse mouse = new Mouse();

        mouse.setNome(dto.nome());
        mouse.setModelo(dto.modelo());
        mouse.setDescricao(dto.descricao());
        mouse.setValor(dto.valor());
        mouse.setQuantidade(dto.quantidade());

        mouse.setIluminacao(dto.iluminacao());
        mouse.setBotao(dto.botao());
        mouse.setMade(dto.made());

        mouse.setPegada(Pegada.valueOf(dto.idPegada()));
        mouse.setConexao(Conexao.valueOf(dto.idConexao()));

        mouse.setConstrucao(construcaoRepository.findById(dto.idConstrucao()));

        mouse.setListaSensors(new ArrayList<Sensor>());

        for (Long sensor : dto.sensores()) {
            if (sensor != null && sensor != 0) {
                mouse.getListaSensors()
                .add(sensorRepository.findById(sensor));
            }
        }

        mouseRespository.persist(mouse);

        return MouseResponseDTO.valueOf(mouse);
    }

    @Override
    @Transactional
    public void update(Long id, MouseDTO dto) {
       
        Mouse mouse = mouseRespository.findById(id);

        mouse.setNome(dto.nome());
        mouse.setModelo(dto.modelo());
        mouse.setDescricao(dto.descricao());
        mouse.setValor(dto.valor());
        mouse.setQuantidade(dto.quantidade());

        mouse.setIluminacao(dto.iluminacao());
        mouse.setBotao(dto.botao());
        mouse.setMade(dto.made());

        mouse.setPegada(Pegada.valueOf(dto.idPegada()));
        mouse.setConexao(Conexao.valueOf(dto.idConexao()));

        mouse.setConstrucao(construcaoRepository.findById(dto.idConstrucao()));
        
        for (Long sensor : dto.sensores()) {
            if (sensor != null && sensor != 0) {
                mouse.getListaSensors()
                .add(sensorRepository.findById(sensor));
            }
        }

    }

    @Override
    @Transactional
    public void delete(long id) {
        mouseRespository.deleteById(id);
    }

    @Override
    public List<MouseResponseDTO> findAll() {
        return mouseRespository.listAll().stream()
        .map(m -> MouseResponseDTO.valueOf(m)).toList();
    }

    @Override
    public MouseResponseDTO findById(Long id) {
        return MouseResponseDTO.valueOf(mouseRespository.findById(id));
    }

    @Override
    public List<MouseResponseDTO> findByNome(String nome) {
        return mouseRespository.FindByNome(nome).stream()
        .map(m -> MouseResponseDTO.valueOf(m)).toList();
    }
    
}
