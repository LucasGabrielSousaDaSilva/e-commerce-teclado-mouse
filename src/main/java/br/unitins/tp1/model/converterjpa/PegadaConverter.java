package br.unitins.tp1.model.converterjpa;

import br.unitins.tp1.model.ecommerce.Pegada;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PegadaConverter implements AttributeConverter<Pegada, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Pegada pegada) {
        return pegada.getId();
    }

    @Override
    public Pegada convertToEntityAttribute(Integer id) {
        return Pegada.valueOf(id);
    }
    
}
