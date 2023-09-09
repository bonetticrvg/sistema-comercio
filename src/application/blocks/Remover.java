package application.blocks;

import entities.Produto;

import java.util.InputMismatchException;
import java.util.Objects;

import static application.blocks.Menu.listaProdutos;
import static application.blocks.Menu.sc;

public class Remover {

    public static void remover(){
        Listar.listarProdutos();

        String codigo = "";

        boolean entradaValida = false;

        sc.nextLine();

        if (!listaProdutos.isEmpty())
        {
            while(!entradaValida)
            {
                try
                {
                    System.out.println("Informe o codigo do produto que deseja remover: ");

                    codigo = sc.nextLine();

                    System.out.println();

                    Produto produtoParaRemover = null;

                    for (Produto produto: listaProdutos)
                    {
                        if(Objects.equals(produto.getCode(), codigo))
                        {
                            produtoParaRemover = produto;
                        }
                    }

                    if (produtoParaRemover == null)
                    {
                        throw new InputMismatchException();
                    }

                    listaProdutos.remove(produtoParaRemover);

                    System.out.println("Produto removido com sucesso!");
                    System.out.println();

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
