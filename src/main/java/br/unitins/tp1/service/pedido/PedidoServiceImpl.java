package br.unitins.tp1.service.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.unitins.tp1.dto.pedido.ItemPedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoResponseDTO;
import br.unitins.tp1.model.pedido.ItemPedido;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.repository.ProdutoRepository;
import br.unitins.tp1.repository.pedido.FormaPagamentoRepository;
import br.unitins.tp1.repository.pedido.PedidoRepository;
import br.unitins.tp1.repository.pessoa.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService{

    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public ProdutoRepository produtoRepository;

    @Inject
    public FormaPagamentoRepository formaPagamentoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.getValorTotal();
        pedido.setData(LocalDate.now());

        List<ItemPedido> itens = new ArrayList<ItemPedido>();
        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();

            item.setValor(itemDTO.valor());
            item.setDesconto(itemDTO.desconto());
            item.setQuantidade(itemDTO.quantidade());
            item.setProduto(produtoRepository.findById(itemDTO.idProduto()));

            itens.add(item);
        }
        pedido.setItens(itens);

        pedido.setFormaPagamento(formaPagamentoRepository.findById(dto.id_formaPagamento()));

        pedido.setCliente(clienteRepository.findById(dto.idCliente()));

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null)
            return PedidoResponseDTO.valueOf(pedido);
        return null;
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository
        .listAll()
        .stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente).stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }
    
}
