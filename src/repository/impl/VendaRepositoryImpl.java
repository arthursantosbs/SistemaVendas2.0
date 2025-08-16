package com.src.repository.impl;


import com.src.entities.Venda;
import com.src.repository.VendaRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendaRepositoryImpl implements VendaRepository {
    private Map<Long, Venda> storage = new HashMap<>();
    private static Long idCounter = 1L;

    @Override
    public void create(Venda venda) {
        if (venda.getId() == null) {
            venda.setId(idCounter++);
        }
        storage.put(venda.getId(), venda);
    }

    @Override
    public Venda read(Long id) {
        return storage.get(id);
    }

    @Override
    public List<Venda> readAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(Venda venda) {
        if (storage.containsKey(venda.getId())) {
            storage.put(venda.getId(), venda);
        }
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }
}
