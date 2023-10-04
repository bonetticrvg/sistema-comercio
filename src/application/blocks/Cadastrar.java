package application.blocks;

import entities.Produto;
import entities.Vendedor;

import java.util.InputMismatchException;

import static application.blocks.Menu.listaVendedores;
import static application.blocks.Menu.sc;

public class Cadastrar {

    public static void cadastrar(){
        System.out.println();
        System.out.println("Informe os dados do vendedor que esta cadastrando: ");
        System.out.println();
        sc.nextLine();
        System.out.print("Nome: ");
        String nomeVendedor = sc.nextLine();
        System.out.println();
        System.out.print("Cpf: ");
        String cpfVendedor = sc.nextLine();
        Vendedor vendedor = new Vendedor(nomeVendedor, cpfVendedor);
        listaVendedores.add(vendedor);
        System.out.println();
        System.out.println("Informe os dados do produto que deseja cadastrar: ");
        System.out.println();
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Codigo: ");
        String code = sc.nextLine();
        System.out.print("Preco: ");
        double preco = sc.nextDouble();
        System.out.println();
        System.out.println("Voce deseja adicionar alguma quantidade desse produto?");

        int opcaoAdicionar = 0;

        boolean entradaValida = false;

        while (!entradaValida)
        {
            try
            {
                System.out.print("Sim (1) | Nao (2): ");

                opcaoAdicionar = sc.nextInt();

                if (opcaoAdicionar > 2 || opcaoAdicionar < 1)
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

        if(opcaoAdicionar == 1)
        {
            entradaValida = false;

            int quantidade = 0;

            while (!entradaValida)
            {
                try
                {
                    System.out.print("Quantidade: ");

                    quantidade = sc.nextInt();

                    if (quantidade <= 0)
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


            Produto produto = new Produto(name, code, quantidade ,preco , vendedor);

            Menu.listaProdutos.add(produto);

            System.out.println();
            System.out.println("Produto adicionado com sucesso!");
            System.out.println();
            System.out.println("Valor total adicionado ao estoque: ");
            System.out.println("R$ " + quantidade * produto.getPrice());
        }
        else {
            Produto produto = new Produto(name,code,0, preco, vendedor);

            Menu.listaProdutos.add(produto);

            System.out.println();
            System.out.println("Produto cadastrado com sucesso!");
            System.out.println();
        }
    }

}
