package application.blocks;

import static application.blocks.Menu.listaProdutos;
import static application.blocks.Menu.listaVendedores;

public class ListarVendedores {

    public static void listarVendedores(){
        System.out.println();

        if(listaVendedores.isEmpty())
        {
            System.out.println("Sem vendedores cadastrados");
            System.out.println();
        }
        else
        {
            for(int i = 0; i < listaVendedores.size(); i++)
            {
                System.out.println(i+1 + ") " + listaVendedores.get(i).toString());
            }
            System.out.println();
        }

    }

}
