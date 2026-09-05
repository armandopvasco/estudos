package br.com.alura.jpahibernate.JPAHibernate.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    private Long id;
    private LocalDate data;
    @ManyToMany
    @JoinTable(name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produto = new ArrayList<>();

    public Pedido(Long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public Pedido() {
    }

    public List<Produto> getProdutos() {
        return produto;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produto = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
