package com.sistema;

import com.sistema.model.*;
import com.sistema.service.Controlador;
import com.sistema.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        Controlador controlador = sistema.getControlador();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE VENDAS AGRÍCOLAS ===\n");

        // --- Criação de Usuários via Entrada do Usuário ---
        System.out.println("\n--- CADASTRO DE USUÁRIOS ---");

        // Cadastrar Administrador
        System.out.println("\nCadastrar Administrador:");
        System.out.print("Nome: ");
        String adminNome = scanner.nextLine();
        System.out.print("Email: ");
        String adminEmail = scanner.nextLine();
        System.out.print("Senha: ");
        String adminSenha = scanner.nextLine();
        System.out.print("Nível de Acesso: ");
        int adminNivelAcesso = Integer.parseInt(scanner.nextLine());
        System.out.print("Departamento: ");
        String adminDepartamento = scanner.nextLine();
        Administrador admin = new Administrador(
            Util.gerarIdUnico(),
            adminNome,
            adminEmail,
            adminSenha,
            adminNivelAcesso,
            adminDepartamento
        );
        sistema.cadastrarUsuario(admin);

        // Cadastrar Vendedor
        System.out.println("\nCadastrar Vendedor:");
        System.out.print("Nome: ");
        String vendedorNome = scanner.nextLine();
        System.out.print("Email: ");
        String vendedorEmail = scanner.nextLine();
        System.out.print("Senha: ");
        String vendedorSenha = scanner.nextLine();
        System.out.print("Comissão (%): ");
        double vendedorComissao = Double.parseDouble(scanner.nextLine());
        Vendedor vendedor = new Vendedor(
            Util.gerarIdUnico(),
            vendedorNome,
            vendedorEmail,
            vendedorSenha,
            vendedorComissao
        );
        sistema.cadastrarUsuario(vendedor);

        // Cadastrar Cliente
        System.out.println("\nCadastrar Cliente:");
        System.out.print("Nome: ");
        String clienteNome = scanner.nextLine();
        System.out.print("Email: ");
        String clienteEmail = scanner.nextLine();
        System.out.print("Senha: ");
        String clienteSenha = scanner.nextLine();
        System.out.print("CPF: ");
        String clienteCpf = scanner.nextLine();
        System.out.print("Endereço: ");
        String clienteEndereco = scanner.nextLine();
        Cliente cliente = new Cliente(
            Util.gerarIdUnico(),
            clienteNome,
            clienteEmail,
            clienteSenha,
            clienteCpf,
            clienteEndereco
        );
        sistema.cadastrarUsuario(cliente);

        // --- Criação de Produtos via Entrada do Usuário ---
        System.out.println("\n--- CADASTRO DE PRODUTOS ---");

        // Cadastrar Muda
        System.out.println("\nCadastrar Muda:");
        System.out.print("Nome: ");
        String mudaNome = scanner.nextLine();
        System.out.print("Preço: ");
        double mudaPreco = Double.parseDouble(scanner.nextLine());
        System.out.print("Descrição: ");
        String mudaDescricao = scanner.nextLine();
        System.out.print("Espécie: ");
        String mudaEspecie = scanner.nextLine();
        System.out.print("Tempo de Maturação (dias): ");
        int mudaTempoMaturacao = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de Solo: ");
        String mudaTipoSolo = scanner.nextLine();
        Muda muda = new Muda(
            Util.gerarIdUnico(),
            mudaNome,
            mudaPreco,
            mudaDescricao,
            mudaEspecie,
            mudaTempoMaturacao,
            mudaTipoSolo
        );
        sistema.adicionarProdutoDisponivel(muda);
        System.out.print("Quantidade em Estoque para " + mudaNome + ": ");
        int mudaEstoque = Integer.parseInt(scanner.nextLine());
        controlador.adicionarProdutoEstoque(muda, mudaEstoque);

        // Cadastrar Húmus
        System.out.println("\nCadastrar Húmus:");
        System.out.print("Nome: ");
        String humusNome = scanner.nextLine();
        System.out.print("Preço: ");
        double humusPreco = Double.parseDouble(scanner.nextLine());
        System.out.print("Descrição: ");
        String humusDescricao = scanner.nextLine();
        System.out.print("Origem: ");
        String humusOrigem = scanner.nextLine();
        System.out.print("Peso da Embalagem (kg): ");
        double humusPesoEmbalagem = Double.parseDouble(scanner.nextLine());
        System.out.print("Composição Nutricional: ");
        String humusComposicaoNutricional = scanner.nextLine();
        Humus humus = new Humus(
            Util.gerarIdUnico(),
            humusNome,
            humusPreco,
            humusDescricao,
            humusOrigem,
            humusPesoEmbalagem,
            humusComposicaoNutricional
        );
        sistema.adicionarProdutoDisponivel(humus);
        System.out.print("Quantidade em Estoque para " + humusNome + ": ");
        int humusEstoque = Integer.parseInt(scanner.nextLine());
        controlador.adicionarProdutoEstoque(humus, humusEstoque);

        // Cadastrar Esterco
        System.out.println("\nCadastrar Esterco:");
        System.out.print("Nome: ");
        String estercoNome = scanner.nextLine();
        System.out.print("Preço: ");
        double estercoPreco = Double.parseDouble(scanner.nextLine());
        System.out.print("Descrição: ");
        String estercoDescricao = scanner.nextLine();
        System.out.print("Tipo de Animal: ");
        String estercoTipoAnimal = scanner.nextLine();
        System.out.print("Processamento (Curtido/Não Curtido): ");
        String estercoProcessamento = scanner.nextLine();
        System.out.print("Nível de Acidez: ");
        double estercoNivelAcidez = Double.parseDouble(scanner.nextLine());
        Esterco esterco = new Esterco(
            Util.gerarIdUnico(),
            estercoNome,
            estercoPreco,
            estercoDescricao,
            estercoTipoAnimal,
            estercoProcessamento,
            estercoNivelAcidez
        );
        sistema.adicionarProdutoDisponivel(esterco);
        System.out.print("Quantidade em Estoque para " + estercoNome + ": ");
        int estercoEstoque = Integer.parseInt(scanner.nextLine());
        controlador.adicionarProdutoEstoque(esterco, estercoEstoque);

        // --- Operações do Sistema ---
        sistema.listarProdutosDisponiveis();
        controlador.gerarRelatorioEstoque();

        // Exemplo de Venda (com produtos criados acima)
        System.out.println("\n--- REALIZANDO VENDA DE EXEMPLO ---");
        System.out.print("ID do Produto para Venda: ");
        String idProdutoVenda = scanner.nextLine();
        Produto produtoParaVenda = sistema.buscarProdutoDisponivelPorId(idProdutoVenda);

        if (produtoParaVenda != null) {
            System.out.print("Quantidade para Venda: ");
            int quantidadeVenda = Integer.parseInt(scanner.nextLine());
            controlador.realizarVenda(cliente, produtoParaVenda, quantidadeVenda, vendedor);
        } else {
            System.out.println("Produto não encontrado.");
        }

        controlador.gerarRelatorioVendedor(vendedor);
        controlador.gerarRelatorioEstoque();

        // Demonstrando polimorfismo
        System.out.println("\n=== DEMONSTRANDO POLIMORFISMO ===");
        Produto[] produtosArray = {muda, humus, esterco};
        for (Produto produto : produtosArray) {
            produto.exibirDetalhes();
            System.out.println("Preço Final: R$ " + Util.formatarValor(produto.calcularPrecoFinal()));
            System.out.println("----------------------------------------");
        }

        // Demonstrando herança
        System.out.println("\n=== DEMONSTRANDO HERANÇA ===");
        Usuario[] usuariosArray = {admin, vendedor, cliente};
        for (Usuario usuario : usuariosArray) {
            usuario.exibirDetalhes();
            System.out.println("----------------------------------------");
        }

        System.out.println("\n=== SISTEMA FINALIZADO ===");
        scanner.close();
    }
}

