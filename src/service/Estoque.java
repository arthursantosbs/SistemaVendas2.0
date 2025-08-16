// Classe Estoque: gerencia os produtos armazenados e suas quantidades
package com.src.service;

import com.src.model.Estocavel;
import com.src.produto.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Estoque {
    // Instância única da classe Estoque (padrão Singleton)
    private static Estoque instance;
    // Lista que armazena todos os produtos presentes no estoque
    private List<Produto> produtosEmEstoque;

    // Construtor privado para garantir o padrão Singleton
    private Estoque() {
        this.produtosEmEstoque = new ArrayList<>(); // Inicializa a lista de produtos em estoque
    }

    // Método estático para obter a instância única do estoque
    public static Estoque getInstance() {
        if (instance == null) {
            instance = new Estoque(); // Cria a instância se ainda não existe
        }
        return instance;
    }

    // Método para adicionar produtos ao estoque
    // Recebe o produto e a quantidade a ser adicionada
    public void adicionarProduto(Produto produto, int quantidade) {
        // Verifica se o produto pode ser estocado (implementa Estocavel)
        if (produto instanceof Estocavel) {
            ((Estocavel) produto).adicionarEstoque(quantidade); // Adiciona ao estoque do produto
            if (!produtosEmEstoque.contains(produto)) {
                produtosEmEstoque.add(produto); // Adiciona à lista se ainda não estiver
            }
            System.out.println("Adicionado " + quantidade + " unidades de " + produto.getNome() + " ao estoque.");
        } else {
            System.out.println("Produto " + produto.getNome() + " não é estocável.");
        }
    }

    // Método para remover produtos do estoque
    // Recebe o produto e a quantidade a ser removida
    public void removerProduto(Produto produto, int quantidade) {
        // Verifica se o produto pode ser estocado
        if (produto instanceof Estocavel) {
            if (((Estocavel) produto).temEstoque(quantidade)) {
                ((Estocavel) produto).removerEstoque(quantidade);
                System.out.println("Removido " + quantidade + " unidades de " + produto.getNome() + " do estoque.");
            } else {
                System.out.println("Estoque insuficiente para " + produto.getNome() + ".");
            }
        } else {
            System.out.println("Produto " + produto.getNome() + " não é estocável.");
        }
    }

    // Método para buscar um produto no estoque pelo seu ID
    public Produto buscarProdutoPorId(String id) {
        Optional<Produto> produtoEncontrado = produtosEmEstoque.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return produtoEncontrado.orElse(null);
    }

    // Método para listar todos os produtos em estoque
    public void listarProdutosEmEstoque() {
        if (produtosEmEstoque.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        System.out.println("\n--- Produtos em Estoque ---");
        for (Produto produto : produtosEmEstoque) {
            if (produto instanceof Estocavel) {
                System.out.println(produto.getNome() + " (ID: " + produto.getId() + ") - Quantidade: " + ((Estocavel) produto).getQuantidadeEstoque());
            }
        }
        System.out.println("---------------------------");
    }
}
