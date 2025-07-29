// Interface Vendavel: define o contrato para produtos que podem ser vendidos
package com.sistema.model;

// Uma interface em Java é como um conjunto de regras que as classes devem seguir.
// Aqui, qualquer classe que "implements Vendavel" precisa fornecer a lógica para vender produtos.
public interface Vendavel {
    // Método para realizar a venda de uma quantidade do produto
    void vender(int quantidade);
    // Método para verificar se é possível vender uma quantidade do produto (ex: se tem estoque suficiente)
    boolean podeVender(int quantidade);
    // Método para calcular o valor total da venda de uma quantidade do produto
    double calcularValorVenda(int quantidade);
}
