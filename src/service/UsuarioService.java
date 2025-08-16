package com.src.service;

import com.src.entities.Usuario;
import java.util.List;

public interface UsuarioService {
    void createUsuario(Usuario usuario);
    Usuario getUsuario(int id);
    List<Usuario> getAllUsuarios();
    void updateUsuario(Usuario usuario);
    void deleteUsuario(int id);
}
