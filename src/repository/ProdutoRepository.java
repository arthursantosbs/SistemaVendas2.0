package com.src.repository;

import com.src.entities.Produto;

import java.util.List;

public interface ProdutoRepository {
    void create(Produto produto);

    // CORRIGIDO: O contrato agora define o ID como Integer.
    Produto read(Integer id);

    List<Produto> readAll();

    void update(Produto produto);

    // CORRIGIDO: O contrato agora define o ID como Integer.
    void delete(Integer id);
}