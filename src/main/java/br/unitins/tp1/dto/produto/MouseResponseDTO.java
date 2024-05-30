package br.unitins.tp1.dto.produto;

import java.util.List;

import br.unitins.tp1.model.ecommerce.Conexao;
import br.unitins.tp1.model.ecommerce.Mouse;
import br.unitins.tp1.model.ecommerce.Pegada;

public record MouseResponseDTO(
    Long id,
    String nome,
    String modelo,
    String descricao,
    Float valor,
    Integer quantidade,
    String iluminacao,
    String botao,
    String made,
    Pegada idPegada,
    Conexao idConexao,
    ConstrucaoResponseDTO idConstrucao,
    List<SensorResponseDTO> sensores
) {
    public static MouseResponseDTO valueOf(Mouse mouse){
        List<SensorResponseDTO> lista = mouse.getListaSensors()
        .stream().map(SensorResponseDTO::valueOf).toList();
        
        return new MouseResponseDTO(
            mouse.getId(),
            mouse.getNome(), 
            mouse.getModelo(), 
            mouse.getDescricao(), 
            mouse.getValor(), 
            mouse.getQuantidade(), 
            mouse.getIluminacao(), 
            mouse.getBotao(), 
            mouse.getMade(), 
            mouse.getPegada(),
            mouse.getConexao(),
            ConstrucaoResponseDTO.valueOf(mouse.getConstrucao()), 
            lista);
    }
}
