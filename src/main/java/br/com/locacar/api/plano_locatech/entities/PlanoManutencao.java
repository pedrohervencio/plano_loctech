package br.com.locacar.api.plano_locatech.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_plano")
public class PlanoManutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @ManyToOne
    @JoinColumn(name = "inspetor_numero")
    private Inspetor inspetor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<Item> itens;

    public PlanoManutencao() {}

    public PlanoManutencao(Long numero, Inspetor inspetor, Veiculo veiculo, List<Item> itens) {
        this.numero = numero;
        this.inspetor = inspetor;
        this.veiculo = veiculo;
        this.itens = itens;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Inspetor getInspetor() {
        return inspetor;
    }

    public void setInspetor(Inspetor inspetor) {
        this.inspetor = inspetor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanoManutencao that = (PlanoManutencao) o;
        return Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "PlanoManutencao{" +
                "numero=" + numero +
                ", inspetor=" + inspetor +
                ", veiculo=" + veiculo +
                ", itens=" + itens +
                '}';
    }
}

