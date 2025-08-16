package com.src.util;

import java.util.Scanner;

public class Entrada {

    private static final Scanner scanner = new Scanner(System.in);

    public Entrada() {
    }

    public String lerString(String msg) {
        if (msg == null || msg.isEmpty()) {
            msg = "Digite uma string: ";
        }
        // Verifica se a mensagem está vazia e define uma mensagem padrão
        if (msg.endsWith(": ")) {
            msg = msg.substring(0, msg.length() - 2) + ": "; // Remove o espaço final
        } else {
            msg += ": "; // Adiciona ": " se não estiver presente
        }
        // Exibe a mensagem e lê a string
        System.out.print(msg);
        return scanner.nextLine();
    }

    public int lerInt(String msg) {
        if (msg == null || msg.isEmpty()) {
            msg = "Digite um número inteiro: ";
        }
        // Verifica se a mensagem está vazia e define uma mensagem padrão
        if (msg.endsWith(": ")) {
            msg = msg.substring(0, msg.length() - 2) + ": "; // Remove o espaço final
        } else {
            msg += ": "; // Adiciona ": " se não estiver presente
        }
        // Exibe a mensagem e lê o número inteiro
        System.out.print(msg);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public double lerDouble(String msg) {
        if (msg == null || msg.isEmpty()) {
            msg = "Digite um número decimal: ";
        }
        // Verifica se a mensagem está vazia e define uma mensagem padrão
        if (msg.endsWith(": ")) {
            msg = msg.substring(0, msg.length() - 2) + ": "; // Remove o espaço final
        } else {
            msg += ": "; // Adiciona ": " se não estiver presente
        }
        // Exibe a mensagem e lê o número decimal
        System.out.print(msg);
        double input = scanner.nextDouble();
        scanner.nextLine();
        return input;
    }


}