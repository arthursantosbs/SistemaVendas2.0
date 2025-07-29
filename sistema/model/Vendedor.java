// Classe Vendedor: representa um vendedor no sistema, herda de Usuario
package com.sistema.model;

public class Vendedor extends Usuario {
    // Porcentagem de comissão que o vendedor recebe sobre as vendas
    private double comissao;
    // Valor total das vendas realizadas pelo vendedor
    private double totalVendas;

    // Construtor: inicializa os dados do vendedor
    public Vendedor(String id, String nome, String email, String senha, double comissao) {
        super(id, nome, email, senha); // Chama o construtor da classe Usuario
        this.comissao = comissao; // Define a comissão
        this.totalVendas = 0.0; // Inicializa o total de vendas como zero
    }

    // Retorna a porcentagem de comissão do vendedor
    public double getComissao() {
        return comissao;
    }

    // Retorna o valor total das vendas realizadas
    public double getTotalVendas() {
        return totalVendas;
    }

    // Permite alterar a porcentagem de comissão do vendedor
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    // Adiciona o valor de uma venda ao total de vendas do vendedor
    public void adicionarVenda(double valor) {
        this.totalVendas += valor;
    }

    // Calcula o valor total de comissão que o vendedor deve receber
    public double calcularComissaoTotal() {
        return totalVendas * (comissao / 100);
    }

    // Exibe os detalhes do vendedor na tela
    @Override
    public void exibirDetalhes() {
        System.out.println("Vendedor: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Comissão: " + comissao + "%");
        System.out.println("Total de Vendas: R$ " + totalVendas);
    }
}
