package br.unitins.tp1.service.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.dto.pedido.FormaPagamentoDTO;
import br.unitins.tp1.dto.pedido.FormaPagamentoResponseDTO;
import br.unitins.tp1.model.pedido.FormaPagamento;
import br.unitins.tp1.model.pedido.TipoPagamento;
import br.unitins.tp1.repository.pedido.FormaPagamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class FormaPagamentoServiceImpl implements FormaPagamentoService{

    @Inject
    public FormaPagamentoRepository formaPagamentoRepository;

    @Override
    @Transactional
    public FormaPagamentoResponseDTO create(@Valid FormaPagamentoDTO dto) {
        FormaPagamento formaPagamento = new FormaPagamento();

        formaPagamento.getParcela();
        formaPagamento.setDataPagamento(LocalDateTime.now());
        formaPagamento.setTipoPagamento(TipoPagamento.valueOf(dto.idTipoPagamento()));

        formaPagamentoRepository.persist(formaPagamento);
       return FormaPagamentoResponseDTO.valueOf(formaPagamento);
    }

    @Override
    public FormaPagamentoResponseDTO findById(Long id) {
        FormaPagamento formaPagamento = formaPagamentoRepository.findById(id);
        if (formaPagamento != null)
            return FormaPagamentoResponseDTO.valueOf(formaPagamento);
        return null;
    }

    @Override
    public List<FormaPagamentoResponseDTO> findAll() {
        return formaPagamentoRepository
        .listAll()
        .stream()
        .map(e -> FormaPagamentoResponseDTO.valueOf(e)).toList();
    }
    

}
