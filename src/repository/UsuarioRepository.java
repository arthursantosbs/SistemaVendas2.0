package com.src.repository;

import com.src.entities.Usuario;
import java.util.List;

public interface UsuarioRepository {
    // A REGRA ESTÁ AQUI:
    void create(Usuario usuario);

    Usuario read(Integer id);
    List<Usuario> readAll();
    void update(Usuario usuario);
    void delete(Integer id);
}
