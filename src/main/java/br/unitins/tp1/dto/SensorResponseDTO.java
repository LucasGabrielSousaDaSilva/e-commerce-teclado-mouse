package br.unitins.tp1.dto;

import br.unitins.tp1.model.Sensor;

public record SensorResponseDTO(
    String nome,
    Double dpi,
    Double ips,
    ModeloResponseDTO idModelo,
    FormatoResponseDTO idFormato
) {
    public static SensorResponseDTO valueOf(Sensor sensor){
        return new SensorResponseDTO(
            sensor.getNome(), 
            sensor.getDpi(), 
            sensor.getIps(), 
            ModeloResponseDTO.valueOf(sensor.getModelo()), 
            FormatoResponseDTO.valueOf(sensor.getFormato()));
    }
}
