package br.unitins.tp1.model;

public enum Pegada {
    CLAW (1,"Claw"),
    FINGERTIP (2, "FingerTip"),
    PALM (3, "Palm");

    private int id;
    private String nome;

    private Pegada(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    
    public static Pegada valueOf(Integer id) throws IllegalArgumentException {
        for (Pegada pegada : Pegada.values()) {
            if (pegada.id == id) 
                return pegada;
            
        }
        throw new IllegalArgumentException("id conexao invalido.");
    }
}
