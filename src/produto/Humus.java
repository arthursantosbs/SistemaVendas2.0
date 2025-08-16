// Classe Humus: representa um tipo de produto orgânico, herda de Produto e implementa Vendavel e Estocavel
package com.src.produto;

import com.src.model.Estocavel;
import com.src.model.Vendavel;

// Aqui estamos criando uma classe chamada Humus, que representa um produto orgânico no sistema.
// Ela herda de Produto (ou seja, é um tipo de produto) e implementa as interfaces Vendavel e Estocavel,
// o que significa que pode ser vendida e estocada.
public class Humus extends Produto implements Vendavel, Estocavel {
    // Origem do humus (ex: minhoca, composto)
    private String origem;
    // Peso da embalagem do humus, em quilos
    private double pesoEmbalagem;
    // Composição nutricional do humus
    private String composicaoNutricional;
    // Quantidade disponível no estoque
    private int quantidadeEstoque;

    // Construtor: inicializa todos os dados do humus
    public Humus(String id, String nome, double preco, String descricao, String origem, double pesoEmbalagem, String composicaoNutricional) {
        super(id, nome, preco, descricao); // Chama o construtor da classe Produto
        this.origem = origem;
        this.pesoEmbalagem = pesoEmbalagem;
        this.composicaoNutricional = composicaoNutricional;
        this.quantidadeEstoque = 0; // Começa com estoque zero
    }

    // Métodos getters: permitem acessar os dados privados do humus
    public String getOrigem() {
        return origem;
    }

    public double getPesoEmbalagem() {
        return pesoEmbalagem;
    }

    public String getComposicaoNutricional() {
        return composicaoNutricional;
    }

    // Métodos setters: permitem alterar os dados privados do humus
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setPesoEmbalagem(double pesoEmbalagem) {
        this.pesoEmbalagem = pesoEmbalagem;
    }

    public void setComposicaoNutricional(String composicaoNutricional) {
        this.composicaoNutricional = composicaoNutricional;
    }

    // Método sobrescrito para exibir os detalhes do humus
    @Override
    public void exibirDetalhes() {
        System.out.println("Húmus: " + getNome());
        System.out.println("Origem: " + origem);
        System.out.println("Peso da Embalagem: " + pesoEmbalagem + " kg");
        System.out.println("Composição Nutricional: " + composicaoNutricional);
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("ID ÚNICO: " + getId());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("-----------------------------");
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() * 1.1;
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
        return calcularPrecoFinal() * quantidade;
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
