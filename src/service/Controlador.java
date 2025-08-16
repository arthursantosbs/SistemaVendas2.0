// Classe Controlador: responsável por gerenciar operações do sistema, como vendas
package com.src.service;

import com.src.produto.Produto;
import com.src.model.*;
import com.src.usuario.Cliente;
import com.src.usuario.Vendedor;
import com.src.util.Util;

public class Controlador {
    // Instância única da classe (padrão Singleton)
    private static Controlador instance;
    // Referência ao estoque do sistema
    private Estoque estoque;

    // Construtor privado para garantir o padrão Singleton
    private Controlador() {
        this.estoque = Estoque.getInstance(); // Obtém a instância do estoque
    }

    // Método estático para obter a instância única do controlador
    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador(); // Cria a instância se ainda não existe
        }
        return instance;
    }

    // Método para realizar uma venda
    // Recebe o cliente, produto, quantidade e vendedor
    public void realizarVenda(Cliente cliente, Produto produto, int quantidade, Vendedor vendedor) {
        // Verifica se o produto pode ser vendido (implementa Vendavel)
        if (produto instanceof Vendavel) {
            Vendavel produtoVendavel = (Vendavel) produto;
            // Verifica se há estoque suficiente para a venda
            if (produtoVendavel.podeVender(quantidade)) {
                double valorVenda = produtoVendavel.calcularValorVenda(quantidade); // Calcula o valor total
                produtoVendavel.vender(quantidade); // Realiza a venda (atualiza estoque)
                vendedor.adicionarVenda(valorVenda); // Adiciona o valor à comissão do vendedor
                System.out.println("\nVenda realizada com sucesso!");
                System.out.println("Cliente: " + cliente.getNome());
                System.out.println("Produto: " + produto.getNome());
                System.out.println("Quantidade: " + quantidade);
                System.out.println("Valor Total: R$ " + Util.formatarValor(valorVenda));
                System.out.println("Vendedor: " + vendedor.getNome());
            } else {
                System.out.println("Não é possível realizar a venda. Estoque insuficiente.");
            }
        } else {
            System.out.println("Produto não é vendável.");
        }
    }

    public void adicionarProdutoEstoque(Produto produto, int quantidade) {
        estoque.adicionarProduto(produto, quantidade);
    }

    public void removerProdutoEstoque(Produto produto, int quantidade) {
        estoque.removerProduto(produto, quantidade);
    }

    public Produto buscarProduto(String id) {
        return estoque.buscarProdutoPorId(id);
    }

    public void gerarRelatorioEstoque() {
        System.out.println("\n=== RELATÓRIO DE ESTOQUE ===");
        estoque.listarProdutosEmEstoque();
    }

    public void gerarRelatorioVendedor(Vendedor vendedor) {
        System.out.println("\n=== RELATÓRIO DO VENDEDOR ===");
        vendedor.exibirDetalhes();
        System.out.println("Comissão Total: R$ " + Util.formatarValor(vendedor.calcularComissaoTotal()));
        System.out.println("=============================");
    }
}
