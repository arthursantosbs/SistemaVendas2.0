// Classe principal do sistema, responsável por gerenciar usuários e produtos
package com.sistema;

import com.sistema.produto.Produto;
import com.sistema.usuario.Usuario;
import com.sistema.service.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sistema {
    // Instância única da classe (padrão Singleton)
    private static Sistema instance;
    // Lista que armazena todos os usuários cadastrados
    private List<Usuario> usuarios;
    // Lista que armazena todos os produtos disponíveis
    private List<Produto> produtosDisponiveis;
    // Referência ao controlador do sistema
    private Controlador controlador;

    // Construtor privado para garantir o padrão Singleton
    private Sistema() {
        this.usuarios = new ArrayList<>(); // Inicializa a lista de usuários
        this.produtosDisponiveis = new ArrayList<>(); // Inicializa a lista de produtos
        this.controlador = Controlador.getInstance(); // Obtém a instância do controlador
    }

    // Método estático para obter a instância única do sistema
    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema(); // Cria a instância se ainda não existe
        }
        return instance;
    }

    // Método para cadastrar um novo usuário no sistema
    public void cadastrarUsuario(Usuario usuario) {
        // Simplificação: apenas adiciona, sem validação de ID único
        usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " cadastrado com sucesso.");
    }

    // Método para realizar login de um usuário
    public Usuario realizarLogin(String email, String senha) {
        // Busca o usuário na lista pelo email e senha
        Optional<Usuario> usuarioLogado = usuarios.stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha))
                .findFirst();
        if (usuarioLogado.isPresent()) {
            System.out.println("Login realizado com sucesso para " + usuarioLogado.get().getNome() + ".");
            return usuarioLogado.get(); // Retorna o usuário logado
        } else {
            System.out.println("Email ou senha inválidos.");
            return null; // Retorna null se não encontrar
        }
    }

    // Método para adicionar um produto à lista de disponíveis
    public void adicionarProdutoDisponivel(Produto produto) {
        // Simplificação: apenas adiciona, sem validação de ID único
        produtosDisponiveis.add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado à lista de produtos disponíveis.");
    }

    // Método para buscar um produto disponível pelo ID
    public Produto buscarProdutoDisponivelPorId(String id) {
        Optional<Produto> produtoEncontrado = produtosDisponiveis.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return produtoEncontrado.orElse(null); // Retorna o produto ou null se não encontrar
    }

    // Método para listar todos os produtos disponíveis
    public void listarProdutosDisponiveis() {
        if (produtosDisponiveis.isEmpty()) {
            System.out.println("Nenhum produto disponível no sistema.");
            return;
        }
        System.out.println("\n--- Produtos Disponíveis no Sistema ---");
        for (Produto produto : produtosDisponiveis) {
            produto.exibirDetalhes(); // Exibe os detalhes de cada produto
            System.out.println("----------------------------------------");
        }
    }
    public void atualizarProdutoDisponivel(Produto produtoAtualizado) {
        // Busca o produto pelo ID e atualiza seus dados
        Optional<Produto> produtoExistente = produtosDisponiveis.stream()
                .filter(p -> p.getId().equals(produtoAtualizado.getId()))
                .findFirst();
        if (produtoExistente.isPresent()) {
            int index = produtosDisponiveis.indexOf(produtoExistente.get());
            produtosDisponiveis.set(index, produtoAtualizado); // Atualiza o produto na lista
            System.out.println("Produto " + produtoAtualizado.getNome() + " atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado para atualização.");
        }
    }

    // Métodos getters para acessar os atributos privados
    public Controlador getControlador() {
        return controlador;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Produto> getProdutosDisponiveis() {
        return produtosDisponiveis;
    }
}
