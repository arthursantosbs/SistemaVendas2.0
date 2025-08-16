// Classe Util: contém métodos utilitários para facilitar operações comuns no sistema
package com.src.util;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

    // Variável estática para gerar IDs únicos
    private static int nextId = 1;

    // Método para formatar datas no padrão brasileiro (dd/MM/yyyy)
    public static String formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter); // Retorna a data formatada como String
    }

    // Método para formatar valores monetários com duas casas decimais
    public static String formatarValor(double valor) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(valor); // Retorna o valor formatado como String
    }

    // Método para validar CPF: verifica se tem 11 dígitos numéricos
    public static boolean validarCpf(String cpf) {
        // Simplificação: apenas verifica se tem 11 dígitos e são todos números
        return cpf != null && cpf.matches("\\d{11}");
    }

    // Método para validar e-mail: verifica se contém '@' e '.'
    public static boolean validarEmail(String email) {
        // Simplificação: apenas verifica se contém '@' e '.'
        return email != null && email.contains("@") && email.contains(".");
    }

    // Método para gerar um ID único para objetos do sistema
    public static String gerarIdUnico() {
        return String.valueOf(nextId++); // Incrementa e retorna o próximo ID
    }


}
