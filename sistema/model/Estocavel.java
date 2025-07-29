// Interface Estocavel: define o contrato para produtos que podem ser estocados
package com.sistema.model;

// Uma interface em Java funciona como um conjunto de regras que as classes devem seguir.
// Qualquer classe que "implements Estocavel" precisa fornecer a lógica para controlar o estoque.
public interface Estocavel {
    // Método para adicionar uma quantidade ao estoque do produto
    void adicionarEstoque(int quantidade);
    // Método para remover uma quantidade do estoque do produto
    void removerEstoque(int quantidade);
    // Método para consultar a quantidade atual em estoque
    int getQuantidadeEstoque();
    // Método para verificar se há estoque suficiente para uma operação
    boolean temEstoque(int quantidade);
}
