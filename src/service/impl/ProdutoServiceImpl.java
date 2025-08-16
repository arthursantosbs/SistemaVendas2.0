package com.src.service.impl;


import com.src.entities.Produto;
import com.src.repository.ProdutoRepository;
import com.src.service.ProdutoService;

import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void createProduto(Produto produto) {
        // Business logic, e.g., validate
        if (produto.getPreco() < 0 || produto.getQuantidade() < 0) {
            throw new IllegalArgumentException("Preço ou quantidade inválidos");
        }
        repository.create(produto);
    }

    public Produto getProduto(Long id) {
        return repository.read(id);
    }

    public List<Produto> getAllProdutos() {
        return repository.readAll();
    }

    public void updateProduto(Produto produto) {
        repository.update(produto);
    }

    public void deleteProduto(Integer id) {
        repository.delete(id);
    }
}

