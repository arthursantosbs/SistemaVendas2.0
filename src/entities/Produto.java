package com.src.entities;


import java.util.Objects;

public abstract class Produto {
    private static Integer contadorDeId = 0;

    private Integer id;
    private String nome;
    private double preco;
    private String descricao;
    private int quantidade;

    public Produto() {
    }

    public Produto(int id, String nome, double preco, String descricao, int quantidade) {
        this.id = ++contadorDeId;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    // Getters and Setters
    public int getId() {
        return this.id;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}