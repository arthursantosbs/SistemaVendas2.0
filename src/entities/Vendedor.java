package com.src.entities;

public class Vendedor extends Usuario {
    private String cnpj;
    private double totalVendas;

    public Vendedor() {}
    public Vendedor(Long id, String nome, String email, String senha, String cnpj, double totalVendas) {
        super(id, nome, email, senha);
        this.cnpj = cnpj;
        this.totalVendas = totalVendas;
    }

    // Getters and Setters
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public double getTotalVendas() { return totalVendas; }
    public void setTotalVendas(double totalVendas) { this.totalVendas = totalVendas; }
}