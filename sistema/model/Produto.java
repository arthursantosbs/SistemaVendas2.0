// Classe abstrata Produto: serve como base para todos os tipos de produtos do sistema
package com.sistema.model;

// Uma classe abstrata não pode ser instanciada diretamente. Ela existe para ser herdada por outras classes específicas de produto.
public abstract class Produto {
    // Identificador único do produto
    private String id;
    // Nome do produto
    private String nome;
    // Preço base do produto
    private double preco;
    // Descrição do produto
    private String descricao;

    // Construtor: inicializa os dados do produto
    public Produto(String id, String nome, double preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    // Métodos getters: permitem acessar os dados privados do produto
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    // Métodos setters: permitem alterar os dados privados do produto
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método abstrato: obriga as subclasses a implementar a exibição dos detalhes do produto
    public abstract void exibirDetalhes();
    // Método abstrato: obriga as subclasses a implementar o cálculo do preço final do produto
    public abstract double calcularPrecoFinal();
}
