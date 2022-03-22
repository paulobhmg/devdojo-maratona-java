package com.paulo.modulo01_basico;

public class A026_EstruturaSwitch {
    public static void main(String[] args) {
        int diaDaSemana = 9;
        char sexo = 'F';

        switch(diaDaSemana){
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Dia inválido.");
        }

        switch(diaDaSemana) {
            case 1:
            case 7:
                System.out.println("Final de semana.");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Dia de semana.");
                break;
            default:
                System.out.println("Dia inválido.");
        }

        switch(sexo) {
            case 'M':
                System.out.println("Sexo masculino.");
                break;
            case 'F':
                System.out.println("Sexo feminino.");
                break;
            default:
                System.out.println("Sexo indefinido.");
        }
    }
}
