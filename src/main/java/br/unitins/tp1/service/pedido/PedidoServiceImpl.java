package br.unitins.tp1.service.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.unitins.tp1.dto.pedido.ItemPedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoResponseDTO;
import br.unitins.tp1.model.ecommerce.Produto;
import br.unitins.tp1.model.pedido.ItemPedido;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.repository.ProdutoRepository;
import br.unitins.tp1.repository.pedido.FormaPagamentoRepository;
import br.unitins.tp1.repository.pedido.PedidoRepository;
import br.unitins.tp1.repository.pessoa.ClienteRepository;
import br.unitins.tp1.validation.ValidationException;
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
  
        pedido.setData(LocalDate.now());
        pedido.setFormaPagamento(formaPagamentoRepository.findById(dto.id_formaPagamento()));
        pedido.setCliente(clienteRepository.findById(dto.idCliente()));       

        List<ItemPedido> itens = new ArrayList<ItemPedido>();
        double total = 0;

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();
            Produto produto = produtoRepository.findById(itemDTO.idProduto());

            item.setQuantidade(itemDTO.quantidade());
            item.setProduto(produtoRepository.findById(itemDTO.idProduto()));

            if (item.getQuantidade() <= item.getProduto().getQuantidade()) {
                item.getProduto().setQuantidade(item.getProduto().getQuantidade() - item.getQuantidade());
            } else {
                throw new ValidationException("Estoque Insuficiente", 
                                             "estoque insuficiente do produto: "+produto.getNome()
                                             +"\n"
                                             +"Estoque do produto:"+ produto.getQuantidade());
            }

            total += calcularValorTotal(item.getProduto(), item);
            total = total - (total * calcularDesconto(item));

            itens.add(item);
        }
        pedido.setItens(itens);
        pedido.setValorTotal(total);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    private double calcularDesconto(ItemPedido item) {

        double desconto = 0;
        if (item.getQuantidade() == 4) {
            desconto = 0.40;
        }
        if (item.getQuantidade() >= 6) {
            desconto = 0.60;
        }
        return desconto;
    }

    private double calcularValorTotal(Produto produto, ItemPedido item) {
        double precoProduto = produto.getValor();
        return precoProduto * item.getQuantidade();
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
