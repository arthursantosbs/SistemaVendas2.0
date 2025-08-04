# 🌱 Sistema de Vendas Agrícolas 2.0

## 📌 Visão Geral
O **Sistema de Vendas Agrícolas 2.0** é uma aplicação Java para **gestão de vendas, controle de estoque e administração de usuários**.

Ele oferece:
- Cadastro e autenticação de usuários.
- Gestão de produtos agrícolas.
- Controle de estoque.
- Registro e cálculo de vendas.
- Relatórios detalhados.

---

## 🚀 Funcionalidades

### **1. Gestão de Usuários**
- 👑 **Administradores** → Níveis de acesso e departamentos.
- 💼 **Vendedores** → Cálculo automático de comissão.
- 👤 **Clientes** → Dados pessoais armazenados.
- 🔑 **Login seguro** → Autenticação de usuários.

---

### **2. Gestão de Produtos**
- Cadastro de **produtos agrícolas**:
  - 🌱 **Mudas** → Espécie, tempo de maturação, tipo de solo.
  - 🌿 **Húmus** → Origem, peso da embalagem, composição nutricional.
  - 💩 **Esterco** → Tipo de animal, processamento, nível de acidez.
- Cada produto possui:
  - `ID único`
  - `Nome`
  - `Preço`
  - `Descrição`

---

### **3. Controle de Estoque**
- 📥 Adicionar produtos ao estoque.
- 📤 Remover produtos do estoque.
- 🔍 Consultar disponibilidade.
- 📑 Relatórios de estoque.

---

### **4. Vendas**
- 📝 Registrar vendas com **cliente**, **produto**, **quantidade** e **vendedor**.
- 💰 Calcular automaticamente valores e comissões.
- 📉 Atualizar estoque após venda.

---

### **5. Relatórios**
- 📊 Estoque atual.
- 📈 Vendas por vendedor.
- 📦 Lista de produtos disponíveis.

---

## 🏗 Arquitetura e Padrões

**Padrões de Projeto**
- 🧩 **Singleton** → `Sistema`, `Controlador`, `Estoque`
- 🔄 **Interfaces e Polimorfismo** → `Vendavel`, `Estocavel`

**Conceitos de POO**
- 🏷 **Herança** → Usuários e produtos.
- 🔄 **Polimorfismo** → Tratamento genérico.
- 🔒 **Encapsulamento** → Getters/Setters.
- ⚙ **Composição** → `Sistema` + `Controlador` + `Estoque`.

