package application.blocks;

import entities.Produto;

import java.util.InputMismatchException;

import static application.blocks.Menu.listaProdutos;
import static application.blocks.Menu.sc;

public class Vender {

    public static void vender(){
        Listar.listarProdutos();

        boolean entradaValida = false;

        while(!entradaValida){
            try
            {
                System.out.print("Informe o codigo do produto que deseja vender: ");

                int codigo = sc.nextInt();

                System.out.println();

                System.out.print("Informe a quantidade que deseja vender: ");

                int quantidade = sc.nextInt();

                Produto produto = listaProdutos.get(codigo - 1);

                if(quantidade > produto.getQuantity())
                {
                    System.out.println();
                    System.out.println("Quantidade em estoque insuficiente para venda!");
                    System.out.println();
                }
                else
                {
                    produto.setQuantity(produto.getQuantity() - quantidade);

                    System.out.println();
                    System.out.println("Produto vendido com sucesso!");
                    System.out.println();
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
            catch (IndexOutOfBoundsException e)
            {
                System.out.println();
                System.out.println("Codigo de produto invalido! Tente novamente: ");
                System.out.println();
            }
        }



    }
}
