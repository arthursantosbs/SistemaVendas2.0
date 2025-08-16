package com.src.entities;



public class Cliente extends Usuario {
    private String cpf;

    public Cliente() {}
    public Cliente(int id, String nome, String email, String senha, String cpf) {
        super(id, nome, email, senha);
        this.cpf = cpf;
    }

    // Getters and Setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}
