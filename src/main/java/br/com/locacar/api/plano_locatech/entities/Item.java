package br.com.locacar.api.plano_locatech.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String componente;
    private String operacao;
    private Integer intervaloKm;
    private Integer intervaloMeses;

    public Item () {}

    public Item(Long id, String componente, String operacao, Integer intervaloKm, Integer intervaloMeses) {
        this.id = id;
        this.componente = componente;
        this.operacao = operacao;
        this.intervaloKm = intervaloKm;
        this.intervaloMeses = intervaloMeses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Integer getIntervaloKm() {
        return intervaloKm;
    }

    public void setIntervaloKm(Integer intervaloKm) {
        this.intervaloKm = intervaloKm;
    }

    public Integer getIntervaloMeses() {
        return intervaloMeses;
    }

    public void setIntervaloMeses(Integer intervaloMeses) {
        this.intervaloMeses = intervaloMeses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", componente='" + componente + '\'' +
                ", operacao='" + operacao + '\'' +
                ", intervaloKm=" + intervaloKm +
                ", intervaloMeses=" + intervaloMeses +
                '}';
    }
}
