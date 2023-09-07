package application;

import application.blocks.Menu;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bem vindo ao nosso sistema de gerenciamento comercial");
        System.out.println();
        int opcao = 0;
        Menu.menu(opcao);
        System.out.println();
        System.out.println("Muito obrigado por usar nosso sistema!");

    }
}