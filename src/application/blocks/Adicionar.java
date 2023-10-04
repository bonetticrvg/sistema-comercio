package application.blocks;

import entities.Produto;

import java.util.InputMismatchException;
import java.util.Objects;

import static application.blocks.Menu.listaProdutos;
import static application.blocks.Menu.sc;

public class Adicionar {

    public static void adicionar(){

        Listar.listarProdutos();

        String codigo = "";

        int quantidade = 0;

        boolean entradaValida = false;

        sc.nextLine();

        if(!listaProdutos.isEmpty())
        {
            while(!entradaValida){
                try
                {
                    System.out.print("Informe o codigo do produto que deseja adicionar: ");

                    codigo = sc.nextLine();

                    Produto produtoParaAdicionar = null;

                    for (Produto produto: listaProdutos)
                    {
                        if(Objects.equals(produto.getCode(), codigo))
                        {
                            produtoParaAdicionar = produto;
                        }
                    }

                    if (produtoParaAdicionar == null)
                    {
                        throw new InputMismatchException();
                    }

                    System.out.println();

                    System.out.print("Informe a quantidade: ");

                    quantidade = sc.nextInt();

                    if(quantidade <= 0)
                    {
                        throw new InputMismatchException();
                    }

                    produtoParaAdicionar.setQuantity(produtoParaAdicionar.getQuantity() + quantidade);

                    System.out.println();
                    System.out.println("Quantidade alterada com sucesso!");
                    System.out.println();
                    System.out.println("Valor total adicionado ao estoque: ");
                    System.out.println("R$ " + quantidade * produtoParaAdicionar.getPrice());

                    entradaValida = true;

                }
                catch (InputMismatchException e)
                {
                    System.out.println();
                    System.out.println("Caractere inválido! Tente novamente: ");
                    System.out.println();
                }
            }
        }
    }
}
