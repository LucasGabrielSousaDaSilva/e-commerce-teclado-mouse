package br.unitins.tp1.model.pessoa;

import br.unitins.tp1.model.DefautEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente extends DefautEntity{

    @Column(length = 60, nullable = false)
    private String endereço;

    @OneToOne
    @JoinColumn(name = "id_Pessoa", unique = true)
    private Pessoa pessoa;

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    

}
