// Classe Muda: representa uma muda de planta, herda de Produto e implementa Vendavel e Estocavel
package com.src.produto;

import com.src.model.Estocavel;
import com.src.model.Vendavel;

// Aqui estamos criando uma classe chamada Muda, que representa uma muda de planta no sistema.
// Ela herda de Produto (ou seja, é um tipo de produto) e implementa as interfaces Vendavel e Estocavel,
// o que significa que pode ser vendida e estocada.
public class Muda extends Produto implements Vendavel, Estocavel {
    // Atributo que guarda a espécie da muda
    private String especie;
    // Tempo de maturação da muda, em dias
    private int tempoMaturacao;
    // Tipo de solo ideal para a muda
    private String tipoSolo;
    // Quantidade disponível no estoque
    private int quantidadeEstoque;

    // Construtor: inicializa todos os dados da muda
    public Muda(String id, String nome, double preco, String descricao, String especie, int tempoMaturacao, String tipoSolo) {
        super(id, nome, preco, descricao); // Chama o construtor da classe Produto
        this.especie = especie;
        this.tempoMaturacao = tempoMaturacao;
        this.tipoSolo = tipoSolo;
        this.quantidadeEstoque = 0; // Começa com estoque zero
    }

    // Métodos getters: permitem acessar os dados privados da muda
    public String getEspecie() {
        return especie;
    }

    public int getTempoMaturacao() {
        return tempoMaturacao;
    }

    public String getTipoSolo() {
        return tipoSolo;
    }

    // Métodos setters: permitem alterar os dados privados da muda
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setTempoMaturacao(int tempoMaturacao) {
        this.tempoMaturacao = tempoMaturacao;
    }

    public void setTipoSolo(String tipoSolo) {
        this.tipoSolo = tipoSolo;
    }

    // Método sobrescrito para exibir os detalhes da muda
    @Override
    public void exibirDetalhes() {
        System.out.println("Muda: " + getNome());
        System.out.println("Espécie: " + especie);
        System.out.println("Tempo de Maturação: " + tempoMaturacao + " dias");
        System.out.println("Tipo de Solo: " + tipoSolo);
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("ID ÚNICO: " + getId());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("-----------------------------");
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco();
    }

    @Override
    public void vender(int quantidade) {
        if (podeVender(quantidade)) {
            removerEstoque(quantidade);
        }
    }

    @Override
    public boolean podeVender(int quantidade) {
        return temEstoque(quantidade);
    }

    @Override
    public double calcularValorVenda(int quantidade) {
        return getPreco() * quantidade;
    }

    @Override
    public void adicionarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    @Override
    public void removerEstoque(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            this.quantidadeEstoque -= quantidade;
        }
    }

    @Override
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    @Override
    public boolean temEstoque(int quantidade) {
        return quantidadeEstoque >= quantidade;
    }
}
