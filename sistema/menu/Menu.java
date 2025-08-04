package com.sistema.menu;

import com.sistema.Sistema;
import com.sistema.produto.Esterco;
import com.sistema.produto.Humus;
import com.sistema.produto.Muda;
import com.sistema.produto.Produto;
import com.sistema.service.Controlador;
import com.sistema.usuario.Administrador;
import com.sistema.usuario.Cliente;
import com.sistema.usuario.Usuario;
import com.sistema.usuario.Vendedor;
import com.sistema.util.Entrada;
import com.sistema.util.Util;

import java.util.Scanner;

public class Menu {

    public Menu() {

    }

    public void mostraMenu() {
        Sistema sistema = Sistema.getInstance();
        Controlador controlador = sistema.getControlador();
        Scanner scanner = new Scanner(System.in);
        Entrada entrada = new Entrada();

        System.out.println("=== SISTEMA DE VENDAS AGRÍCOLAS ===\n");

        // --- Criação de Usuários via Entrada do Usuário ---
        System.out.println("\n--- CADASTRO DE USUÁRIOS ---");

        // Cadastrar Administrador
        System.out.println("\nCadastrar Administrador:"); //entrada a partir do sistema.entrada
        String adminNome = entrada.lerString("Nome: ");

        String adminEmail = entrada.lerString("E-mail: ");
        //verificar se o email é válido (opcional, pode ser implementado)
        if (!Util.validarEmail(adminEmail)) {
            System.out.println("Email inválido. Por favor, insira um email válido.");
            return; // Encerra o cadastro se o email for inválido
        }

        String adminSenha = entrada.lerString("Senha: ");
        //
        int adminNivelAcesso = entrada.lerInt("Nível de Acesso: ");
        // Verifica se o nível de acesso é válido (opcional, pode ser implementado)
        if (adminNivelAcesso < 1 || adminNivelAcesso > 10){
            System.out.println("Nível de acesso inválido. Por favor, insira um nível entre 1 e 10.");
            return; // Encerra o cadastro se o nível de acesso for inválido
        }

        String adminDepartamento = entrada.lerString("Departamento: ");
        // Verifica se o departamento não está vazio (opcional, pode ser implementado)
        if (adminDepartamento.isEmpty()) {
            System.out.println("Departamento inválido. Por favor, insira um departamento válido.");
            return; // Encerra o cadastro se o departamento for inválido
        }

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
        String vendedorNome = entrada.lerString("Nome: ");
        String vendedorEmail = entrada.lerString("Email: ");
        // Verifica se o email é válido (opcional, pode ser implementado)
        if (!Util.validarEmail(vendedorEmail)) {
            System.out.println("Email inválido. Por favor, insira um email válido.");
            return; // Encerra o cadastro se o email for inválido
        }
        String vendedorSenha = entrada.lerString("Senha: ");
        // Verifica se a senha atende aos critérios mínimos (opcional, pode ser implementado)
        //if (!Util.validarSenha(vendedorSenha)) {
        //    System.out.println("Senha inválida. A senha deve ter pelo menos 6 caracteres.");
        //    return; // Encerra o cadastro se a senha for inválida
        //}
        double vendedorComissao = entrada.lerDouble("Comissão (%): ");

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
        String clienteNome = entrada.lerString("Nome: ");
        String clienteEmail = entrada.lerString("Email: ");
        // Verifica se o email é válido (opcional, pode ser implementado)
        if (!Util.validarEmail(vendedorEmail)) {
            System.out.println("Email inválido. Por favor, insira um email válido.");
            return; // Encerra o cadastro se o email for inválido
        }
        String clienteSenha = entrada.lerString("Senha: ");

        String clienteCpf = entrada.lerString("CPF: ");
        // Verifica se o CPF é válido (opcional, pode ser implementado)
        if (!Util.validarCpf(clienteCpf)) {
            System.out.println("CPF inválido. Por favor, insira um CPF válido.");
            return; // Encerra o cadastro se o CPF for inválido
        }

        String clienteEndereco = entrada.lerString("Endereço: ");
        // Verifica se o endereço não está vazio (opcional, pode ser implementado)
        if (clienteEndereco.isEmpty()) {
            System.out.println("Endereço inválido. Por favor, insira um endereço válido.");
            return; // Encerra o cadastro se o endereço for inválido
        }

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
        String mudaNome = entrada.lerString("Nome: ");
        double mudaPreco = entrada.lerDouble("Preço: ");
        String mudaDescricao = entrada.lerString("Descrição: ");
        String mudaEspecie = entrada.lerString("Espécie: ");
        int mudaTempoMaturacao = entrada.lerInt("Tempo de Maturação (dias): ");
        String mudaTipoSolo = entrada.lerString("Tipo de solo: ");

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

        System.out.println("\nCadastrar Húmus:");
        String humusNome = entrada.lerString("Nome: ");
        double humusPreco = entrada.lerDouble("Preço: ");
        String humusDescricao = entrada.lerString("Descrição: ");
        String humusOrigem = entrada.lerString("Origem: ");
        double humusPesoEmbalagem = entrada.lerDouble("Peso da Embalagem (kg): ");
        String humusComposicaoNutricional = entrada.lerString("Composição Nutricional: ");
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
        String estercoNome = entrada.lerString("Nome: ");
        double estercoPreco = entrada.lerDouble("Preço: ");
        String estercoDescricao = entrada.lerString("Desicrição: ");
        String estercoTipoAnimal = entrada.lerString("Tipo de animal: ");
        String estercoProcessamento = entrada.lerString("Processamento (Curtido/Não Curtido): ");
        double estercoNivelAcidez = entrada.lerDouble("Nível de Acidez: ");

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
        int estercoEstoque = entrada.lerInt("Quantidade em Estoque para " + estercoNome + ": ");
        controlador.adicionarProdutoEstoque(esterco, estercoEstoque);

        // --- Operações do Sistema ---
        sistema.listarProdutosDisponiveis();
        controlador.gerarRelatorioEstoque();

        // Exemplo de Venda (com produtos criados acima)
        System.out.println("\n--- REALIZANDO VENDA DE EXEMPLO ---");
        String idProdutoVenda = entrada.lerString("ID do Produto para Venda: ");
        Produto produtoParaVenda = sistema.buscarProdutoDisponivelPorId(idProdutoVenda);

        if (produtoParaVenda != null) {
            int quantidadeVenda = entrada.lerInt("Quantidade para Venda: ");
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

    }
}
