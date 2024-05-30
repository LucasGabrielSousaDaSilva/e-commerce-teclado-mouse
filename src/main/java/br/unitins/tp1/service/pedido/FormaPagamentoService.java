package br.unitins.tp1.service.pedido;

import java.util.List;

import br.unitins.tp1.dto.pedido.FormaPagamentoDTO;
import br.unitins.tp1.dto.pedido.FormaPagamentoResponseDTO;
import jakarta.validation.Valid;

public interface FormaPagamentoService {
    
    public FormaPagamentoResponseDTO create(@Valid FormaPagamentoDTO dto);
    public FormaPagamentoResponseDTO findById(Long id);
    public List<FormaPagamentoResponseDTO> findAll();

}
