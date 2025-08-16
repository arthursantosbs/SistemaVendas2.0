package com.src.menu;

import com.src.Sistema;

import javax.swing.*;
import java.awt.*;

public class SistemaGR extends JFrame {
    private Sistema sistema;

    public SistemaGR() {
        sistema = Sistema.getInstance();
        setTitle("Sistema de Vendas Agrícolas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane abas = new JTabbedPane();
        abas.add("Produtos", criarPainelProdutos());
        abas.add("Usuários", criarPainelUsuarios());
        abas.add("Vendas", criarPainelVendas());

        add(abas);
        setVisible(true);
    }

    private JPanel criarPainelUsuarios() {
        //preciso implementar o painel de usuários
        // Implementação do painel de usuarios
        JPanel painel = new JPanel(new BorderLayout());
        // ...
        return painel;
    }
    private JPanel criarPainelProdutos() {
        // Implementação do painel de produtos
        JPanel painel = new JPanel(new BorderLayout());
        // ...
        return painel;
    }
    private JPanel criarPainelVendas() {
        // Implementação do painel de vendas
        JPanel painel = new JPanel(new BorderLayout());
        // ...
        return painel;
    }

}
