package br.unitins.tp1.model.ecommerce;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Teclado extends Produto{
    
    @Column(length = 60, nullable = false)
    private String layout;

    @Column(length = 60, nullable = false)
    private String design;

    @Column(length = 60, nullable = false)
    private String tipoTeclado;

    @Column(length = 60, nullable = false)
    private String iluminacao;

    @ManyToOne
    @JoinColumn(name="id_construcao")
    private Construcao construcao;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getTipoTeclado() {
        return tipoTeclado;
    }

    public void setTipoTeclado(String tipoTeclado) {
        this.tipoTeclado = tipoTeclado;
    }

    public String getIluminacao() {
        return iluminacao;
    }

    public void setIluminacao(String iluminacao) {
        this.iluminacao = iluminacao;
    }

    public Construcao getConstrucao() {
        return construcao;
    }

    public void setConstrucao(Construcao construcao) {
        this.construcao = construcao;
    }

    
}
