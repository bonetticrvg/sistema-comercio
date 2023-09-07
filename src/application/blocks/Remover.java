package application.blocks;

import java.util.InputMismatchException;

import static application.blocks.Menu.listaProdutos;
import static application.blocks.Menu.sc;

public class Remover {

    public static void remover(){
        Listar.listarProdutos();

        int codigo = 0;

        boolean entradaValida = false;

        while(!entradaValida)
        {
            try
            {
                System.out.print("Informe o codigo do produto que deseja remover: ");

                codigo = sc.nextInt();

                System.out.println();

                listaProdutos.remove(codigo - 1);

                System.out.println("Produto removido com sucesso!");
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
                System.out.println("Codigo de produto invalido! Tente novamente: ");
                System.out.println();
            }
        }

    }
}
