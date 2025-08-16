package com.src.service.impl;


import com.src.entities.Venda;
import com.src.entities.Produto;
import com.src.entities.Vendedor;
import com.src.repository.VendaRepository;
import com.src.repository.ProdutoRepository;
import java.util.List;

public class VendaServiceImpl implements com.src.service.VendaService {
    private VendaRepository vendaRepository;
    private ProdutoRepository produtoRepository;

    public VendaServiceImpl(VendaRepository vendaRepository, ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
    }

    public void createVenda(Venda venda) {
        // Business logic: calculate total, update stock, update vendedor totalVendas
        double total = 0;
        for (Produto p : venda.getProdutos()) {
            if (p.getQuantidade() <= 0) {
                throw new IllegalArgumentException("Produto sem estoque: " + p.getNome());
            }
            total += p.getPreco();
            p.setQuantidade(p.getQuantidade() - 1); // Assume 1 unit per product for simplicity
            produtoRepository.update(p);
        }
        venda.setTotal(total);
        Vendedor vendedor = venda.getVendedor();
        vendedor.setTotalVendas(vendedor.getTotalVendas() + total);
        vendaRepository.create(venda);
    }

    public Venda getVenda(Long id) {
        return vendaRepository.read(id);
    }

    public List<Venda> getAllVendas() {
        return vendaRepository.readAll();
    }

    public void updateVenda(Venda venda) {
        vendaRepository.update(venda);
    }

    public void deleteVenda(Long id) {
        vendaRepository.delete(id);
    }
}
