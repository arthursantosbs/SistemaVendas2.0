package com.src.service.impl;


import com.src.entities.Usuario;
import com.src.repository.UsuarioRepository;
import com.src.service.UsuarioService;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void createUsuario(Usuario usuario) {
        // Business logic, e.g., validate email
        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        repository.create(usuario);
    }

    public Usuario getUsuario(int id) {
        return repository.read(id);
    }

    public List<Usuario> getAllUsuarios() {
        return repository.readAll();
    }

    public void updateUsuario(Usuario usuario) {
        repository.update(usuario);
    }

    public void deleteUsuario(int id) {
        repository.delete(id);
    }
}
