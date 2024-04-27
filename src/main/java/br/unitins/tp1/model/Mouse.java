package br.unitins.tp1.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Mouse extends Produto{
    
    @Column(length = 60, nullable = false)
    private String iluminacao;
    @Column(length = 60, nullable = false)
    private String botao;
    @Column(length = 60, nullable = false)
    private String made;

    private Pegada pegada;

    @ManyToOne
    @JoinColumn(name="id_construcao")
    private Construcao construcao;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "id_mouse")
    private List<Sensor> listaSensors;

    
    public String getIluminacao() {
        return iluminacao;
    }

    public void setIluminacao(String iluminacao) {
        this.iluminacao = iluminacao;
    }

    public String getBotao() {
        return botao;
    }

    public void setBotao(String botao) {
        this.botao = botao;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public Pegada getPegada() {
        return pegada;
    }

    public void setPegada(Pegada pegada) {
        this.pegada = pegada;
    }

    public Construcao getConstrucao() {
        return construcao;
    }

    public void setConstrucao(Construcao construcao) {
        this.construcao = construcao;
    }

    public List<Sensor> getListaSensors() {
        return listaSensors;
    }

    public void setListaSensors(List<Sensor> listaSensors) {
        this.listaSensors = listaSensors;
    }
    

    
}
