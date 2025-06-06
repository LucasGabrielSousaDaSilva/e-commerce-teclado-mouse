package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.produto.SensorDTO;
import br.unitins.tp1.dto.produto.SensorResponseDTO;
import br.unitins.tp1.model.ecommerce.Sensor;
import br.unitins.tp1.repository.FormatoRespository;
import br.unitins.tp1.repository.ModeloRespository;
import br.unitins.tp1.repository.SensorRepository;
import br.unitins.tp1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class SensorServiceImpl implements SensorService{

    @Inject
    public SensorRepository sensorRepository;

    @Inject
    public ModeloRespository modeloRespository;

    @Inject
    public FormatoRespository formatoRespository;

    @Override
    @Transactional
    public SensorResponseDTO create(@Valid SensorDTO dto) {
        validarNomeSensor(dto.nome());
        
        Sensor sensor = new Sensor();

        sensor.setNome(dto.nome());
        sensor.setDpi(dto.dpi());
        sensor.setIps(dto.ips());
        sensor.setModelo(modeloRespository.findById(dto.idModelo()));
        sensor.setFormato(formatoRespository.findById(dto.idFormato()));
        sensorRepository.persist(sensor);
        return SensorResponseDTO.valueOf(sensor);
    }

        public void validarNomeSensor(String nome){
        Sensor sensor = sensorRepository.findByNomeSensor(nome);
        if (sensor != null) {
            throw new ValidationException("nome", "O nome "+ nome +" já existe.");
        }
    }

    @Override
    @Transactional
    public void update(Long id, SensorDTO dto) {
        Sensor sensor = sensorRepository.findById(id);

        sensor.setNome(dto.nome());
        sensor.setDpi(dto.dpi());
        sensor.setIps(dto.ips());
        sensor.setModelo(modeloRespository.findById(dto.idModelo()));
        sensor.setFormato(formatoRespository.findById(dto.idFormato()));
        
    }

    @Override
    @Transactional
    public void delete(long id) {
       sensorRepository.deleteById(id);
    }

    @Override
    public List<SensorResponseDTO> findAll() {
        return sensorRepository.listAll().stream()
        .map(s -> SensorResponseDTO.valueOf(s)).toList();
    }

    @Override
    public SensorResponseDTO findById(Long id) {
        return SensorResponseDTO.valueOf(sensorRepository.findById(id));
    }

    @Override
    public List<SensorResponseDTO> findByNome(String nome) {
        return sensorRepository.FindByNome(nome).stream()
        .map(s -> SensorResponseDTO.valueOf(s)).toList();
    }
    
}
