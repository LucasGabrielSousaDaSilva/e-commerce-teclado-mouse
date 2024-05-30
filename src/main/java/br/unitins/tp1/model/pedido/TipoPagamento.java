package br.unitins.tp1.model.pedido;

public enum TipoPagamento {
    CREDITO (1, "Credito"),
    DEBITO (2, "Debito"),
    PIX (3, "Pix");

    private int id;
    private String nome;


    private TipoPagamento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }



        public static TipoPagamento valueOf(Integer id) throws IllegalArgumentException {
        for (TipoPagamento tipoPagamento : TipoPagamento.values()) {
            if (tipoPagamento.id == id) 
                return tipoPagamento;
            
        }
        throw new IllegalArgumentException("id conexao invalido.");
    }

}
