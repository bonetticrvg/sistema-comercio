package application.blocks;

import entities.Produto;
import entities.Vendedor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    static List<Produto> listaProdutos = new ArrayList<>();
    static List<Vendedor> listaVendedores = new ArrayList<>();

    public static void menu(int opcao){
        while(opcao != 7) {
            System.out.println("Informe o que deseja fazer:");
            System.out.println();
            System.out.println("1 - Listar");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Remover");
            System.out.println("5 - Vender");
            System.out.println("6 - Informacoes de vendedores");
            System.out.println("7 - Sair");
            System.out.println();

            boolean entradaValida = false;

            while (!entradaValida) {
                try
                {
                    System.out.print("Sua opção: ");

                    opcao = sc.nextInt();

                    if(opcao > 7 || opcao < 1)
                    {
                        throw new InputMismatchException();
                    }
                    entradaValida = true;
                }
                catch (InputMismatchException e)
                {
                    System.out.println();
                    System.out.println("Caractere inválido! Tente novamente: ");
                    System.out.println();
                    sc.nextLine();
                }
            }


            switch (opcao) {
                case 1 -> {
                    Listar.listarProdutos();
                }
                case 2 -> {
                    Cadastrar.cadastrar();
                }
                case 3 -> {
                    Adicionar.adicionar();
                }
                case 4 -> {
                    Remover.remover();
                }
                case 5 -> {
                    Vender.vender();
                }
                case 6 -> {
                    Vendedores.vendedores();
                }
            }
        }

    }

}
