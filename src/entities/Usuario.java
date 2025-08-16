package com.src.entities;


import java.util.Objects;

public abstract class Usuario {
    private static int contadorDeId = 0;
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String senha) {
        this.id = ++contadorDeId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
