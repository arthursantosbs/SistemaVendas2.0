package com.src.menu;

import com.src.Sistema;
import com.src.produto.*;
import com.src.service.Controlador;
import com.src.usuario.*;
import com.src.util.Entrada;
import com.src.util.Util;

import java.util.Scanner;

public class Menu {

    private Sistema sistema;
    private Controlador controlador;
    private Entrada entrada;
    private Scanner scanner;

    public Menu() {
        this.sistema = Sistema.getInstance();
        this.controlador = sistema.getControlador();
        this.entrada = new Entrada();
        this.scanner = new Scanner(System.in);
    }

    public void mostraMenu() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE VENDAS AGRÍCOLAS ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Produto");
            System.out.println("3. Listar Produtos Disponíveis");
            System.out.println("4. Realizar Venda");
            System.out.println("5. Gerar Relatório de Estoque");
            System.out.println("6. Gerar Relatório de Vendedor");
            System.out.println("7. Atualizar Produto Existente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.lerInt("");

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    cadastrarProduto();
                    break;
                case 3:
                    sistema.listarProdutosDisponiveis();
                    break;
                case 4:
                    realizarVenda();
                    break;
                case 5:
                    controlador.gerarRelatorioEstoque();
                    break;
                case 6:
                    gerarRelatorioVendedor();
                    break;
                case 7:
                    atualizarProdutoExistente();
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void cadastrarUsuario() {
        System.out.println("\n--- CADASTRO DE USUÁRIOS ---");
        System.out.println("1. Vendedor");
        System.out.println("2. Cliente");
        int tipo = entrada.lerInt("Escolha o tipo de usuário: ");

        switch (tipo) {

            case 1:
                String vendNome = entrada.lerString("Nome: ");
                String vendEmail = entrada.lerString("E-mail: ");
                if (!Util.validarEmail(vendEmail)) {
                    System.out.println("Email inválido.");
                    return;
                }
                String vendSenha = entrada.lerString("Senha: ");
                double vendComissao = entrada.lerDouble("Comissão (%): ");
                Vendedor vendedor = new Vendedor(
                        Util.gerarIdUnico(), vendNome, vendEmail, vendSenha, vendComissao
                );
                sistema.cadastrarUsuario(vendedor);
                break;

            case 2:
                String cliNome = entrada.lerString("Nome: ");
                String cliEmail = entrada.lerString("E-mail: ");
                if (!Util.validarEmail(cliEmail)) {
                    System.out.println("Email inválido.");
                    return;
                }
                String cliSenha = entrada.lerString("Senha: ");
                String cliCpf = entrada.lerString("CPF: ");
                if (!Util.validarCpf(cliCpf)) {
                    System.out.println("CPF inválido.");
                    return;
                }
                String cliEndereco = entrada.lerString("Endereço: ");
                Cliente cliente = new Cliente(
                        Util.gerarIdUnico(), cliNome, cliEmail, cliSenha, cliCpf, cliEndereco
                );
                sistema.cadastrarUsuario(cliente);
                break;

            default:
                System.out.println("Tipo inválido.");
        }
    }

    private void cadastrarProduto() {
        System.out.println("\n--- CADASTRO DE PRODUTOS ---");
        System.out.println("1. Muda");
        System.out.println("2. Húmus");
        System.out.println("3. Esterco");
        int tipo = entrada.lerInt("Escolha o tipo de produto: ");

        switch (tipo) {
            case 1:
                String mudaNome = entrada.lerString("Nome: ");
                double mudaPreco = entrada.lerDouble("Preço: ");
                String mudaDesc = entrada.lerString("Descrição: ");
                String mudaEsp = entrada.lerString("Espécie: ");
                int mudaMatur = entrada.lerInt("Tempo de Maturação (dias): ");
                String mudaSolo = entrada.lerString("Tipo de solo: ");
                Muda muda = new Muda(Util.gerarIdUnico(), mudaNome, mudaPreco, mudaDesc, mudaEsp, mudaMatur, mudaSolo);
                sistema.adicionarProdutoDisponivel(muda);
                controlador.adicionarProdutoEstoque(muda, entrada.lerInt("Quantidade em Estoque: "));
                break;

            case 2:
                String humusNome = entrada.lerString("Nome: ");
                double humusPreco = entrada.lerDouble("Preço: ");
                String humusDesc = entrada.lerString("Descrição: ");
                String humusOrigem = entrada.lerString("Origem: ");
                double humusPeso = entrada.lerDouble("Peso da Embalagem (kg): ");
                String humusComp = entrada.lerString("Composição Nutricional: ");
                Humus humus = new Humus(Util.gerarIdUnico(), humusNome, humusPreco, humusDesc, humusOrigem, humusPeso, humusComp);
                sistema.adicionarProdutoDisponivel(humus);
                controlador.adicionarProdutoEstoque(humus, entrada.lerInt("Quantidade em Estoque: "));
                break;

            case 3:
                String estNome = entrada.lerString("Nome: ");
                double estPreco = entrada.lerDouble("Preço: ");
                String estDesc = entrada.lerString("Descrição: ");
                String estAnimal = entrada.lerString("Tipo de animal: ");
                String estProc = entrada.lerString("Processamento (Curtido/Não Curtido): ");
                double estAcidez = entrada.lerDouble("Nível de Acidez: ");
                Esterco esterco = new Esterco(Util.gerarIdUnico(), estNome, estPreco, estDesc, estAnimal, estProc, estAcidez);
                sistema.adicionarProdutoDisponivel(esterco);
                controlador.adicionarProdutoEstoque(esterco, entrada.lerInt("Quantidade em Estoque: "));
                break;

            default:
                System.out.println("Tipo inválido.");
        }
    }

    private void realizarVenda() {
        String emailCliente = entrada.lerString("E-mail do Cliente: ");
        String emailVendedor = entrada.lerString("E-mail do Vendedor: ");
        Cliente cliente = (Cliente) sistema.getUsuarios().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(emailCliente))
                .findFirst().orElse(null);

        Vendedor vendedor = (Vendedor) sistema.getUsuarios().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(emailVendedor))
                .findFirst().orElse(null);

        if (cliente == null || vendedor == null) {
            System.out.println("Cliente ou vendedor não encontrado.");
            return;
        }

        String idProduto = entrada.lerString("ID do Produto: ");
        Produto produto = sistema.buscarProdutoDisponivelPorId(idProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        int qtd = entrada.lerInt("Quantidade: ");
        controlador.realizarVenda(cliente, produto, qtd, vendedor);
    }

    private void gerarRelatorioVendedor() {
        String emailVendedor = entrada.lerString("E-mail do Vendedor: ");
        Usuario vendedor = sistema.getUsuarios().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(emailVendedor))
                .findFirst().orElse(null);
        if (vendedor == null) {
            System.out.println("Vendedor não encontrado.");
            return;
        }
        controlador.gerarRelatorioVendedor((Vendedor) vendedor);
    }

    private void atualizarProdutoExistente() {
        System.out.println("\n--- ATUALIZAÇÃO DE PRODUTO ---");
        String idProduto = entrada.lerString("ID do Produto a ser atualizado: ");
        Produto produto = sistema.buscarProdutoDisponivelPorId(idProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        if ((produto instanceof Muda)) {
            String mudaNome = entrada.lerString("Nome: ");
            double mudaPreco = entrada.lerDouble("Preço: ");
            String mudaDesc = entrada.lerString("Descrição: ");
            String mudaEsp = entrada.lerString("Espécie: ");
            int mudaMatur = entrada.lerInt("Tempo de Maturação (dias): ");
            String mudaSolo = entrada.lerString("Tipo de solo: ");

            Muda muda = new Muda(produto.getId(), mudaNome, mudaPreco, mudaDesc, mudaEsp, mudaMatur, mudaSolo);
            sistema.atualizarProdutoDisponivel(muda);


        }else if ((produto instanceof Humus)) {
            String humusNome = entrada.lerString("Nome: ");
            double humusPreco = entrada.lerDouble("Preço: ");
            String humusDesc = entrada.lerString("Descrição: ");
            String humusOrigem = entrada.lerString("Origem: ");
            double humusPeso = entrada.lerDouble("Peso da Embalagem (kg): ");
            String humusComp = entrada.lerString("Composição Nutricional: ");
            Humus humus = new Humus(produto.getId(), humusNome, humusPreco, humusDesc, humusOrigem, humusPeso, humusComp);

            sistema.atualizarProdutoDisponivel(humus);

        } else if ((produto instanceof Esterco)) {
            String estNome = entrada.lerString("Nome: ");
            double estPreco = entrada.lerDouble("Preço: ");
            String estDesc = entrada.lerString("Descrição: ");
            String estAnimal = entrada.lerString("Tipo de animal: ");
            String estProc = entrada.lerString("Processamento (Curtido/Não Curtido): ");
            double estAcidez = entrada.lerDouble("Nível de Acidez: ");
            Esterco esterco = new Esterco(produto.getId(), estNome, estPreco, estDesc, estAnimal, estProc, estAcidez);

            sistema.atualizarProdutoDisponivel(esterco);
        } else {
            System.out.println("Tipo de produto não suportado para atualização.");
        }


    }
}
