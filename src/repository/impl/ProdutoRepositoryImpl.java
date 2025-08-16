package com.src.repository.impl;


import com.src.entities.Produto;
import com.src.repository.ProdutoRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private Map<Integer, Produto> storage = new HashMap<>();

    @Override
    public void create(Produto produto) {
        // O produto já chega com o ID (int) correto.
        // Apenas o salvamos no Map.
        storage.put(produto.getId(), produto);
    }

    // O parâmetro do método 'read' agora é Integer.
    @Override
    public Produto read(Integer id) {
        return storage.get(id);
    }

    @Override
    public List<Produto> readAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(Produto produto) {
        if (storage.containsKey(produto.getId())) {
            storage.put(produto.getId(), produto);
        }
    }

    // O parâmetro do método 'delete' agora é Integer.
    @Override
    public void delete(Integer id) {
        storage.remove(id);
    }
}