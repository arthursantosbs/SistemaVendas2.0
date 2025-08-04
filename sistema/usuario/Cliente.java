package com.sistema.usuario;

import com.sistema.produto.Produto;

import java.util.ArrayList;
import java.util.List;

// Classe Cliente: representa um cliente do sistema, herda de Usuario
// Aqui estamos criando uma classe chamada Cliente, que representa um usuário do tipo cliente.
// Ela herda de Usuario, então aproveita todos os atributos e métodos da classe base.
public class Cliente extends Usuario {
    // CPF do cliente, usado para identificação
    private String cpf;
    // Endereço do cliente, usado para entregas
    private String endereco;
    // Carrinho de compras do cliente, armazena os produtos que ele deseja comprar
    private List<Produto> carrinho;

    // Construtor: inicializa os dados do cliente e o carrinho de compras
    public Cliente(String id, String nome, String email, String senha, String cpf, String endereco) {
        super(id, nome, email, senha); // Chama o construtor da classe Usuario
        this.cpf = cpf;
        this.endereco = endereco;
        this.carrinho = new ArrayList<>(); // Inicializa o carrinho vazio
    }

    // Métodos getters: permitem acessar os dados privados do cliente
    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    // Métodos setters: permitem alterar os dados privados do cliente
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Adiciona um produto ao carrinho de compras
    public void adicionarProdutoCarrinho(Produto produto) {
        carrinho.add(produto);
    }

    // Remove um produto do carrinho de compras
    public void removerProdutoCarrinho(Produto produto) {
        carrinho.remove(produto);
    }

    // Calcula o valor total dos produtos no carrinho
    public double calcularTotalCarrinho() {
        double total = 0.0;
        for (Produto produto : carrinho) {
            total += produto.calcularPrecoFinal();
        }
        return total;
    }

    // Limpa o carrinho de compras, removendo todos os produtos
    public void limparCarrinho() {
        carrinho.clear();
    }

    // Exibe os detalhes do cliente e informações do carrinho

    public void exibirDetalhes() {
        System.out.println("Cliente: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Itens no carrinho: " + carrinho.size());
    }
}
