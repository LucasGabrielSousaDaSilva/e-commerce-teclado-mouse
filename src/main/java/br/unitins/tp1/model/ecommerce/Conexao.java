package br.unitins.tp1.model.ecommerce;

public enum Conexao {
    CABO (1, "Cabo"),
    SEMFIO (2, "Sem_Fio");

    private int id;
    private String nome;

    
    private Conexao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }


    public static Conexao valueOf(Integer id) throws IllegalArgumentException {
        for (Conexao conexao : Conexao.values()) {
            if (conexao.id == id) {
                return conexao;
            }
        }
        throw new IllegalArgumentException("id conexao invalido.");

    }
}
