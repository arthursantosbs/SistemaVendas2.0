package com.src.service;

import com.src.entities.Produto;
import java.util.List;

public interface ProdutoService {
    void createProduto(Produto produto);
    Produto getProduto(Integer id);
    List<Produto> getAllProdutos();
    void updateProduto(Produto produto);
    void deleteProduto(Integer id);
}