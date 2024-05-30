package br.unitins.tp1.model.ecommerce;

import br.unitins.tp1.model.DefautEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sensor extends DefautEntity{
    
    @Column(length = 60, nullable = false)
    private String nome;
    @Column(length = 60, nullable = false)
    private Double dpi;
    @Column(length = 60, nullable = false)
    private Double ips;

    @ManyToOne
    @JoinColumn(name="id_modelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "id_formato")
    private Formato formato;
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getDpi() {
        return dpi;
    }
    public void setDpi(Double dpi) {
        this.dpi = dpi;
    }
    public Double getIps() {
        return ips;
    }
    public void setIps(Double ips) {
        this.ips = ips;
    }
    public Modelo getModelo() {
        return modelo;
    }
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    public Formato getFormato() {
        return formato;
    }
    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    
}
