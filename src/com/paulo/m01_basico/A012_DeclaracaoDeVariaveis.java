package com.paulo.m01_basico;

import java.util.Scanner;

public class A012_DeclaracaoDeVariaveis {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        byte  day;
        byte  age;
        short month;
        int   year;
        long  country = 1L;
        float initialSalary = 1600.9F;
        double nextSalary = 13000.0;
        char   gender = 'M';
        boolean status = true;

        System.out.print("What's your name? ");
        String name = in.nextLine();

        System.out.print("What's your date? dd/mm/yyyy: ");
        day = in.nextByte();
        month = in.nextShort();
        year = in.nextInt();
        age = (byte) (2022 - year); // Casting explícito convertendo INT para BYTE.

        in.nextLine(); // Limpa o buffer do Scanner

        System.out.print("What do you want be? ");
        String toBe = in.nextLine();

        System.out.printf("Hi, %s! You date is %d/%d/%d. Your first salary was R$ %.2f and your next salary will be R$ %.2f.\n",
                name, day, month, year, initialSalary, nextSalary);
        System.out.printf("Today your age is %d and you'll be '%s'.\n", age, toBe);
    }
}
