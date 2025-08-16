package com.src;
import com.src.entities.*;
import com.src.facade.SistemaVendasFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static SistemaVendasFacade facade = new SistemaVendasFacade();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenuPrincipal();
            int opcao = lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    gerenciarProdutos();
                    break;
                case 2:
                    gerenciarUsuarios();
                    break;
                case 3:
                    gerenciarVendas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== Sistema de Vendas ===");
        System.out.println("1. Gerenciar Produtos");
        System.out.println("2. Gerenciar Usuários");
        System.out.println("3. Gerenciar Vendas");
        System.out.println("0. Sair");
    }

    private static void gerenciarProdutos() {
        while (true) {
            System.out.println("\n=== Gerenciar Produtos ===");
            System.out.println("1. Criar Produto");
            System.out.println("2. Listar Todos os Produtos");
            System.out.println("3. Consultar Produto por ID");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Deletar Produto");
            System.out.println("0. Voltar");
            int opcao = lerInteiro("Escolha uma opção: ");
            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    criarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    consultarProduto();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    deletarProduto();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void criarProduto() {
        System.out.println("\n=== Criar Produto ===");
        //melhorando a mensagem de seleção de tipo de produto
        System.out.println("Selecione o tipo de produto:");
        System.out.println("1. Esterco");
        System.out.println("2. Humus");
        System.out.println("3. Muda");

        int tipo = lerInteiro("Escolha o tipo: ");
        Produto produto;
        switch (tipo) {
            case 1:
                produto = new Esterco();
                break;
            case 2:
                produto = new Humus();
                break;
            case 3:
                produto = new Muda();
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }
        //gerar um ID para que o usuário não precise informar
        produto.setNome(lerString("Nome do produto: "));
        produto.setPreco(lerDouble("Preço do produto: "));
        produto.setDescricao(lerString("Descrição do produto: "));
        produto.setQuantidade(lerInteiro("Quantidade do produto: "));
        // Validar os campos obrigatórios
        if (produto.getNome().isEmpty() || produto.getPreco() < 0 || produto.getQuantidade() < 0) {
            System.out.println("Erro: Nome, preço e quantidade são obrigatórios e devem ser válidos.");
            return;
        }
        // Tentar criar o produto através do facade
        // e capturar possíveis exceções
        // para exibir mensagens de erro amigáveis
        if (produto.getQuantidade() <= 0) {
            System.out.println("Erro: A quantidade do produto deve ser maior que zero.");
            return;
        }
        if (produto.getPreco() < 0) {
            System.out.println("Erro: O preço do produto não pode ser negativo.");
            return;
        }
        if (produto.getNome().isEmpty()) {
            System.out.println("Erro: O nome do produto não pode ser vazio.");
            return;
        }
        if (produto.getDescricao().isEmpty()) {
            System.out.println("Erro: A descrição do produto não pode ser vazia.");
            return;
        }


        try {
            facade.createProduto(produto);
            System.out.println("Produto criado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void consultarProduto() {
        Integer id = lerInteiro("Digite o ID do produto: ");
        Produto produto = facade.getProduto(id);
        if (produto != null) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() +
                    ", Preço: " + produto.getPreco() + ", Descrição: " + produto.getDescricao() +
                    ", Quantidade: " + produto.getQuantidade() + ", Tipo: " + produto.getClass().getSimpleName());
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void listarProdutos() {
        List<Produto> produtos = facade.getAllProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() +
                        ", Preço: " + p.getPreco() + ", Descrição: " + p.getDescricao() +
                        ", Quantidade: " + p.getQuantidade() + ", Tipo: " + p.getClass().getSimpleName());
            }
        }
    }

    private static void atualizarProduto() {
        Integer id = lerInteiro("Digite o ID do produto a atualizar: ");
        Produto produto = facade.getProduto(id);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        String nome = lerString("Novo nome (" + produto.getNome() + "): ");
        if (!nome.isEmpty()) produto.setNome(nome);
        String precoStr = lerString("Novo preço (" + produto.getPreco() + "): ");
        if (!precoStr.isEmpty()) produto.setPreco(Double.parseDouble(precoStr));
        String descricao = lerString("Nova descrição (" + produto.getDescricao() + "): ");
        if (!descricao.isEmpty()) produto.setDescricao(descricao);
        String quantidadeStr = lerString("Nova quantidade (" + produto.getQuantidade() + "): ");
        if (!quantidadeStr.isEmpty()) produto.setQuantidade(Integer.parseInt(quantidadeStr));
        try {
            facade.updateProduto(produto);
            System.out.println("Produto atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void deletarProduto() {
        Integer id = lerInteiro("Digite o ID do produto a deletar: ");
        facade.deleteProduto(id);
        System.out.println("Produto deletado com sucesso!");
    }

    private static void gerenciarUsuarios() {
        while (true) {
            System.out.println("\n=== Gerenciar Usuários ===");
            System.out.println("1. Criar Usuário");
            System.out.println("2. Consultar Usuário por ID");
            System.out.println("3. Listar Todos os Usuários");
            System.out.println("4. Atualizar Usuário");
            System.out.println("5. Deletar Usuário");
            System.out.println("0. Voltar");
            int opcao = lerInteiro("Escolha uma opção: ");
            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    criarUsuario();
                    break;
                case 2:
                    consultarUsuario();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 4:
                    atualizarUsuario();
                    break;
                case 5:
                    deletarUsuario();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void criarUsuario() {
        System.out.println("\n=== Criar Usuário ===");
        System.out.println("Tipo de Usuário: 1. Cliente 2. Vendedor");
        int tipo = lerInteiro("Escolha o tipo: ");
        Usuario usuario;
        switch (tipo) {
            case 1:
                usuario = new Cliente();
                ((Cliente) usuario).setCpf(lerString("CPF: "));
                break;
            case 2:
                usuario = new Vendedor();
                ((Vendedor) usuario).setCnpj(lerString("CNPJ: "));
                ((Vendedor) usuario).setTotalVendas(0.0);
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        usuario.setNome(lerString("Nome: "));
        usuario.setEmail(lerString("Email: "));
        usuario.setSenha(lerString("Senha: "));
        try {
            facade.createUsuario(usuario);
            System.out.println("Usuário criado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void consultarUsuario() {
        Integer id = lerInteiro("Digite o ID do usuário: ");
        Usuario usuario = facade.getUsuario(id);
        if (usuario != null) {
            System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome() +
                    ", Email: " + usuario.getEmail() + ", Tipo: " + usuario.getClass().getSimpleName());
            if (usuario instanceof Cliente) {
                System.out.println("CPF: " + ((Cliente) usuario).getCpf());
            } else if (usuario instanceof Vendedor) {
                System.out.println("CNPJ: " + ((Vendedor) usuario).getCnpj() +
                        ", Total de Vendas: " + ((Vendedor) usuario).getTotalVendas());
            }
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    private static void listarUsuarios() {
        List<Usuario> usuarios = facade.getAllUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome() +
                        ", Email: " + u.getEmail() + ", Tipo: " + u.getClass().getSimpleName());
                if (u instanceof Cliente) {
                    System.out.println("CPF: " + ((Cliente) u).getCpf());
                } else if (u instanceof Vendedor) {
                    System.out.println("CNPJ: " + ((Vendedor) u).getCnpj() +
                            ", Total de Vendas: " + ((Vendedor) u).getTotalVendas());
                }
            }
        }
    }

    private static void atualizarUsuario() {
        Integer id = lerInteiro("Digite o ID do usuário a atualizar: ");
        Usuario usuario = facade.getUsuario(id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        String nome = lerString("Novo nome (" + usuario.getNome() + "): ");
        if (!nome.isEmpty()) usuario.setNome(nome);
        String email = lerString("Novo email (" + usuario.getEmail() + "): ");
        if (!email.isEmpty()) usuario.setEmail(email);
        String senha = lerString("Nova senha: ");
        if (!senha.isEmpty()) usuario.setSenha(senha);
        if (usuario instanceof Cliente) {
            String cpf = lerString("Novo CPF (" + ((Cliente) usuario).getCpf() + "): ");
            if (!cpf.isEmpty()) ((Cliente) usuario).setCpf(cpf);
        } else if (usuario instanceof Vendedor) {
            String cnpj = lerString("Novo CNPJ (" + ((Vendedor) usuario).getCnpj() + "): ");
            if (!cnpj.isEmpty()) ((Vendedor) usuario).setCnpj(cnpj);
        }
        try {
            facade.updateUsuario(usuario);
            System.out.println("Usuário atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void deletarUsuario() {
        Integer id = lerInteiro("Digite o ID do usuário a deletar: ");
        facade.deleteUsuario(id);
        System.out.println("Usuário deletado com sucesso!");
    }

    private static void gerenciarVendas() {
        while (true) {
            System.out.println("\n=== Gerenciar Vendas ===");
            System.out.println("1. Criar Venda");
            System.out.println("2. Consultar Venda por ID");
            System.out.println("3. Listar Todas as Vendas");
            System.out.println("4. Atualizar Venda");
            System.out.println("5. Deletar Venda");
            System.out.println("0. Voltar");
            int opcao = lerInteiro("Escolha uma opção: ");
            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    criarVenda();
                    break;
                case 2:
                    consultarVenda();
                    break;
                case 3:
                    listarVendas();
                    break;
                case 4:
                    atualizarVenda();
                    break;
                case 5:
                    deletarVenda();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void criarVenda() {
        System.out.println("\n=== Criar Venda ===");
        Integer clienteId = lerInteiro("ID do Cliente: ");
        Usuario cliente = facade.getUsuario(clienteId);
        if (!(cliente instanceof Cliente)) {
            System.out.println("Cliente não encontrado ou inválido!");
            return;
        }
        Integer vendedorId = lerInteiro("ID do Vendedor: ");
        Usuario vendedor = facade.getUsuario(vendedorId);
        if (!(vendedor instanceof Vendedor)) {
            System.out.println("Vendedor não encontrado ou inválido!");
            return;
        }
        List<Produto> produtos = new ArrayList<>();
        while (true) {
            Integer produtoId = lerInteiro("ID do Produto (0 para finalizar): ");
            if (produtoId == 0) break;
            Produto produto = facade.getProduto(produtoId);
            if (produto != null) {
                produtos.add(produto);
            } else {
                System.out.println("Produto não encontrado!");
            }
        }
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto selecionado!");
            return;
        }
        Venda venda = new Venda();
        venda.setCliente((Cliente) cliente);
        venda.setVendedor((Vendedor) vendedor);
        venda.setProdutos(produtos);
        try {
            facade.createVenda(venda);
            System.out.println("Venda criada com sucesso! Total: " + venda.getTotal());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void consultarVenda() {
        Integer id = lerInteiro("Digite o ID da venda: ");
        Venda venda = facade.getVenda(id);
        if (venda != null) {
            System.out.println("ID: " + venda.getId() + ", Cliente: " + venda.getCliente().getNome() +
                    ", Vendedor: " + venda.getVendedor().getNome() + ", Total: " + venda.getTotal());
            System.out.println("Produtos:");
            for (Produto p : venda.getProdutos()) {
                System.out.println("- " + p.getNome() + " (Preço: " + p.getPreco() + ")");
            }
        } else {
            System.out.println("Venda não encontrada!");
        }
    }

    private static void listarVendas() {
        List<Venda> vendas = facade.getAllVendas();
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            for (Venda v : vendas) {
                System.out.println("ID: " + v.getId() + ", Cliente: " + v.getCliente().getNome() +
                        ", Vendedor: " + v.getVendedor().getNome() + ", Total: " + v.getTotal());
                System.out.println("Produtos:");
                for (Produto p : v.getProdutos()) {
                    System.out.println("- " + p.getNome() + " (Preço: " + p.getPreco() + ")");
                }
            }
        }
    }

    private static void atualizarVenda() {
        Integer id = lerInteiro("Digite o ID da venda a atualizar: ");
        Venda venda = facade.getVenda(id);
        if (venda == null) {
            System.out.println("Venda não encontrada!");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        Integer clienteId = lerInteiro("Novo ID do Cliente (" + venda.getCliente().getId() + ", 0 para manter): ");
        if (clienteId != 0) {
            Usuario cliente = facade.getUsuario(clienteId);
            if (cliente instanceof Cliente) {
                venda.setCliente((Cliente) cliente);
            } else {
                System.out.println("Cliente inválido!");
                return;
            }
        }
        Integer vendedorId = lerInteiro("Novo ID do Vendedor (" + venda.getVendedor().getId() + ", 0 para manter): ");
        if (vendedorId != 0) {
            Usuario vendedor = facade.getUsuario(vendedorId);
            if (vendedor instanceof Vendedor) {
                venda.setVendedor((Vendedor) vendedor);
            } else {
                System.out.println("Vendedor inválido!");
                return;
            }
        }
        System.out.println("Atualizar produtos? (1-Sim, 0-Não)");
        int atualizarProdutos = lerInteiro("Escolha: ");
        if (atualizarProdutos == 1) {
            List<Produto> novosProdutos = new ArrayList<>();
            while (true) {
                Integer produtoId = lerInteiro("ID do Produto (0 para finalizar): ");
                if (produtoId == 0) break;
                Produto produto = facade.getProduto(produtoId);
                if (produto != null) {
                    novosProdutos.add(produto);
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }
            if (!novosProdutos.isEmpty()) {
                venda.setProdutos(novosProdutos);
            }
        }
        try {
            facade.updateVenda(venda);
            System.out.println("Venda atualizada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void deletarVenda() {
        Integer id = lerInteiro("Digite o ID da venda a deletar: ");
        facade.deleteVenda(id);
        System.out.println("Venda deletada com sucesso!");
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido!");
            }
        }
    }

    private static Long lerLong(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número longo válido!");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número decimal válido!");
            }
        }
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}