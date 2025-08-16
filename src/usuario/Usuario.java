// Classe abstrata Usuario: serve como base para todos os tipos de usuários do sistema
package com.src.usuario;

// Uma classe abstrata não pode ser instanciada diretamente, ou seja, não podemos criar um "Usuario" genérico.
// Ela existe para ser herdada por outras classes, como Administrador, Vendedor e Cliente.
public abstract class Usuario {
    // Identificador único do usuário
    private String id;
    // Nome do usuário
    private String nome;
    // Email do usuário (usado para login e contato)
    private String email;
    // Senha do usuário (usada para autenticação)
    private String senha;

    // Construtor: inicializa os dados do usuário
    public Usuario(String id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Métodos getters: permitem acessar os dados privados do usuário
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    // Métodos setters: permitem alterar os dados privados do usuário
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   /* @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Usuario other = (Usuario) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    */
    // Método abstrato: obriga as subclasses a implementar a exibição dos detalhes do usuário
    public abstract void exibirDetalhes();

}
