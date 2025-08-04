Sistema de Vendas Agrícolas 2.0
📌 Visão Geral
O Sistema de Vendas Agrícolas 2.0 é uma aplicação Java desenvolvida para gerenciar vendas de produtos agrícolas, controle de estoque e gestão de usuários.
O sistema permite o cadastro de diferentes tipos de produtos (mudas, húmus e esterco), diferentes perfis de usuários (administradores, vendedores e clientes), além de oferecer funcionalidades para controle de estoque e registro de vendas.

🚀 Funcionalidades Principais
1. Gestão de Usuários
Cadastro de administradores com níveis de acesso e departamentos.

Cadastro de vendedores com sistema de comissão.

Cadastro de clientes com informações pessoais.

Sistema de login e autenticação.

2. Gestão de Produtos
Cadastro de diferentes tipos de produtos agrícolas:

Mudas → espécie, tempo de maturação e tipo de solo.

Húmus → origem, peso da embalagem e composição nutricional.

Esterco → tipo de animal, processamento e nível de acidez.

Cada produto possui ID único, nome, preço e descrição.

3. Controle de Estoque
Adição de produtos ao estoque com quantidades.

Remoção de produtos do estoque.

Verificação de disponibilidade para vendas.

Geração de relatórios de estoque.

4. Sistema de Vendas
Registro de vendas com cliente, produto, quantidade e vendedor.

Cálculo automático de valores.

Atualização automática do estoque após vendas.

Cálculo de comissão para vendedores.

5. Relatórios
Relatório de estoque atual.

Relatório de vendas por vendedor.

Detalhamento de produtos disponíveis.

🏗 Arquitetura do Sistema
O sistema foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), incluindo:

Padrões de Projeto
Singleton → Utilizado nas classes Sistema, Controlador e Estoque para garantir instância única.

Interface e Polimorfismo → Implementados através das interfaces Vendavel e Estocavel.

Estrutura de Pacotes
plaintext
Copiar
Editar
com.sistema/
├── main/
│   └── Main.java                 # Ponto de entrada da aplicação
├── menu/
│   └── Menu.java                 # Interface de usuário via console
├── model/
│   ├── Estocavel.java            # Interface para produtos que podem ser estocados
│   └── Vendavel.java             # Interface para produtos que podem ser vendidos
├── produto/
│   ├── Produto.java              # Classe base para todos os produtos
│   ├── Muda.java                 # Especialização para mudas de plantas
│   ├── Humus.java                # Especialização para húmus
│   └── Esterco.java              # Especialização para esterco
├── service/
│   ├── Controlador.java          # Gerencia operações do sistema
│   └── Estoque.java              # Gerencia o estoque de produtos
├── usuario/
│   ├── Usuario.java              # Classe base para todos os usuários
│   ├── Administrador.java        # Especialização para administradores
│   ├── Vendedor.java             # Especialização para vendedores
│   └── Cliente.java              # Especialização para clientes
├── util/
│   ├── Entrada.java              # Utilitário para entrada de dados
│   └── Util.java                 # Funções utilitárias diversas
└── Sistema.java                  # Classe principal que gerencia o sistema
📊 Diagrama de Classes Simplificado
plaintext
Copiar
Editar
+----------------+       +----------------+       +----------------+
|   Sistema      | ----> |  Controlador   | ----> |    Estoque     |
+----------------+       +----------------+       +----------------+
        |                        |                        |
        v                        v                        v
+----------------+       +----------------+
|    Usuario     |       |    Produto     |
+----------------+       +----------------+
   /   |   \                /   |   \
Admin Vend Cliente       Muda Humus Esterco
💡 Conceitos de POO Implementados
Herança → Hierarquia de classes para usuários e produtos.

Polimorfismo → Tratamento genérico de produtos e usuários.

Encapsulamento → Atributos privados com métodos getters/setters.

Interfaces → Definição de comportamentos com Vendavel e Estocavel.

Composição → Relacionamentos entre Sistema, Controlador e Estoque.

