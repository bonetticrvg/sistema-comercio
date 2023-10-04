package application.blocks;

import entities.Produto;

import java.util.InputMismatchException;
import java.util.Objects;

import static application.blocks.Menu.listaProdutos;
import static application.blocks.Menu.sc;

public class Vender {
    public static void vender(){
        Listar.listarProdutos();

        boolean entradaValida = false;

        String codigo = "";

        sc.nextLine();

        if(!listaProdutos.isEmpty())
        {
            while(!entradaValida){
                try
                {

                    System.out.print("Informe o codigo do produto que deseja vender: ");

                    codigo = sc.nextLine();

                    System.out.println();

                    Produto produtoParaVender = null;

                    for (Produto produto: listaProdutos)
                    {
                        if(Objects.equals(produto.getCode(), codigo))
                        {
                            produtoParaVender = produto;
                        }
                    }

                    if (produtoParaVender == null)
                    {
                        throw new InputMismatchException();
                    }

                    System.out.print("Informe a quantidade que deseja vender: ");

                    int quantidade = sc.nextInt();

                    if (quantidade <= 0)
                    {
                        throw new InputMismatchException();
                    }

                    if(quantidade > produtoParaVender.getQuantity())
                    {
                        System.out.println();
                        System.out.println("Quantidade em estoque insuficiente para venda!");
                        System.out.println();
                    }
                    else
                    {
                        produtoParaVender.setQuantity(produtoParaVender.getQuantity() - quantidade);

                        System.out.println();
                        System.out.println("Produto vendido com sucesso!");
                        System.out.println();
                        System.out.println("Valor total vendido: ");
                        System.out.println("R$ " + quantidade * produtoParaVender.getPrice());
                        System.out.println();
                    }

                    entradaValida = true;
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Caractere inválido! Tente novamente: ");
                    System.out.println();
                }
            }
        }
    }
}
