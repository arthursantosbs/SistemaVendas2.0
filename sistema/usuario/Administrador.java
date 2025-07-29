// Classe Administrador: representa um administrador do sistema, herda de Usuario
package com.sistema.usuario;

// Aqui estamos criando uma classe chamada Administrador, que representa um usuário com poderes administrativos.
// Ela herda de Usuario, então aproveita todos os atributos e métodos da classe base.
public class Administrador extends Usuario {
    // Nível de acesso do administrador (quanto maior, mais permissões)
    private int nivelAcesso;
    // Departamento ao qual o administrador pertence
    private String departamento;

    // Construtor: inicializa os dados do administrador
    public Administrador(String id, String nome, String email, String senha, int nivelAcesso, String departamento) {
        super(id, nome, email, senha); // Chama o construtor da classe Usuario
        this.nivelAcesso = nivelAcesso;
        this.departamento = departamento;
    }

    // Retorna o nível de acesso do administrador
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    // Retorna o departamento do administrador
    public String getDepartamento() {
        return departamento;
    }

    // Permite alterar o nível de acesso do administrador
    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    // Permite alterar o departamento do administrador
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Verifica se o administrador tem permissão para uma ação, comparando o nível de acesso
    public boolean temPermissao(int nivelRequerido) {
        return this.nivelAcesso >= nivelRequerido;
    }

    // Exibe os detalhes do administrador na tela
    @Override
    public void exibirDetalhes() {
        System.out.println("Administrador: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Nível de Acesso: " + nivelAcesso);
        System.out.println("Departamento: " + departamento);
    }
}
