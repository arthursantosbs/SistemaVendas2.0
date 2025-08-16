package com.src.entities;


import java.util.List;
import java.util.Objects;

public class Venda {
    private static int contadorDeId = 0;
    private int id;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<Produto> produtos;
    private double total;

    public Venda() {}

    public Venda(Long id, Cliente cliente, Vendedor vendedor, List<Produto> produtos, double total) {
        this.id = ++contadorDeId;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produtos = produtos;
        this.total = total;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }
    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

