package com.sistema.util;

import java.util.Scanner;

public class Entrada {

    private static final Scanner scanner = new Scanner(System.in);

    public Entrada() {
    }

    public String lerString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public int lerInt(String msg) {
        System.out.print(msg);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public double lerDouble(String msg) {
        System.out.print(msg);
        double input = scanner.nextDouble();
        scanner.nextLine();
        return input;
    }


}