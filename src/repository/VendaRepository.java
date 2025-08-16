package com.src.repository;

import com.src.entities.Venda;
import java.util.List;

public interface VendaRepository {
    void create(Venda venda);
    Venda read(Long id);
    List<Venda> readAll();
    void update(Venda venda);
    void delete(Long id);
}