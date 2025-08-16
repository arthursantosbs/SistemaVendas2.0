package com.src.service;

import com.src.entities.Venda;
import java.util.List;

public interface VendaService {
    void createVenda(Venda venda);
    Venda getVenda(Long id);
    List<Venda> getAllVendas();
    void updateVenda(Venda venda);
    void deleteVenda(Long id);
}
