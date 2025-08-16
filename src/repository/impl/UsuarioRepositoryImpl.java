package com.src.repository.impl;


import com.src.entities.Usuario;
import com.src.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    // A "chave" do Map agora é Integer.
    private Map<Integer, Usuario> storage = new HashMap<>();

    @Override
    public void create(Usuario usuario) {
        // A lógica de criar ID foi removida.
        // O usuário já chega com um ID pronto.
        storage.put(usuario.getId(), usuario);
    }

    @Override
    public Usuario read(Integer id) {
        return storage.get(id);
    }

    @Override
    public List<Usuario> readAll() {
        return new ArrayList<>(storage.values());
    }



    @Override
    public void update(Usuario usuario) {
        if (storage.containsKey(usuario.getId())) {
            storage.put(usuario.getId(), usuario);
        }
    }

    @Override
    public void delete(Integer id) {
        storage.remove(id);
    }
}