// Classe Esterco: representa um tipo de produto orgânico, herda de Produto e implementa Vendavel e Estocavel
package com.src.produto;

import com.src.model.Estocavel;
import com.src.model.Vendavel;

// Aqui estamos criando uma classe chamada Esterco, que representa um produto orgânico no sistema.
// Ela herda de Produto (ou seja, é um tipo de produto) e implementa as interfaces Vendavel e Estocavel,
// o que significa que pode ser vendida e estocada.
public class Esterco extends Produto implements Vendavel, Estocavel {
    // Tipo de animal de onde o esterco foi originado (ex: vaca, galinha)
    private String tipoAnimal;
    // Tipo de processamento que o esterco passou (ex: seco, úmido)
    private String processamento;
    // Nível de acidez do esterco
    private double nivelAcidez;
    // Quantidade disponível no estoque
    private int quantidadeEstoque;

    // Construtor: inicializa todos os dados do esterco
    public Esterco(String id, String nome, double preco, String descricao, String tipoAnimal, String processamento, double nivelAcidez) {
        super(id, nome, preco, descricao); // Chama o construtor da classe Produto
        this.tipoAnimal = tipoAnimal;
        this.processamento = processamento;
        this.nivelAcidez = nivelAcidez;
        this.quantidadeEstoque = 0; // Começa com estoque zero
    }

    // Métodos getters: permitem acessar os dados privados do esterco
    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public String getProcessamento() {
        return processamento;
    }

    public double getNivelAcidez() {
        return nivelAcidez;
    }

    // Métodos setters: permitem alterar os dados privados do esterco
    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void setProcessamento(String processamento) {
        this.processamento = processamento;
    }

    public void setNivelAcidez(double nivelAcidez) {
        this.nivelAcidez = nivelAcidez;
    }

    // Método sobrescrito para exibir os detalhes do esterco
    @Override
    public void exibirDetalhes() {
        System.out.println("Esterco: " + getNome());
        System.out.println("Tipo de Animal: " + tipoAnimal);
        System.out.println("Processamento: " + processamento);
        System.out.println("Nível de Acidez: " + nivelAcidez);
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("ID ÚNICO: " + getId());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("-----------------------------");
    }

    // Cálculo do preço final do esterco, considerando o tipo de processamento
    @Override
    public double calcularPrecoFinal() {
        if (processamento.equals("Curtido")) {
            return getPreco() * 1.2;
        }
        return getPreco();
    }

    // Método para vender uma quantidade de esterco
    @Override
    public void vender(int quantidade) {
        if (podeVender(quantidade)) {
            removerEstoque(quantidade);
        }
    }

    // Verifica se é possível vender a quantidade desejada
    @Override
    public boolean podeVender(int quantidade) {
        return temEstoque(quantidade);
    }

    // Cálculo do valor total da venda
    @Override
    public double calcularValorVenda(int quantidade) {
        return calcularPrecoFinal() * quantidade;
    }

    // Adiciona uma quantidade ao estoque
    @Override
    public void adicionarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    // Remove uma quantidade do estoque
    @Override
    public void removerEstoque(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            this.quantidadeEstoque -= quantidade;
        }
    }

    // Retorna a quantidade disponível em estoque
    @Override
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    // Verifica se há estoque suficiente para a quantidade desejada
    @Override
    public boolean temEstoque(int quantidade) {
        return quantidadeEstoque >= quantidade;
    }
}
