package application.blocks;

import entities.Produto;

import java.util.InputMismatchException;

import static application.blocks.Menu.listaProdutos;
import static application.blocks.Menu.sc;

public class Adicionar {

    public static void adicionar(){

        Listar.listarProdutos();

        int codigo = 0;

        int quantidade = 0;

        boolean entradaValida = false;

        while(!entradaValida){
            try
            {
                System.out.print("Informe o codigo do produto que deseja adicionar: ");

                codigo = sc.nextInt();

                System.out.println();

                System.out.print("Informe a quantidade: ");

                quantidade = sc.nextInt();

                Produto produto = listaProdutos.get(codigo - 1);

                produto.setQuantity(produto.getQuantity() + quantidade);

                System.out.println();
                System.out.println("Quantidade alterada com sucesso!");
                System.out.println();

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
