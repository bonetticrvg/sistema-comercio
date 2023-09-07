package application.blocks;

import static application.blocks.Menu.listaProdutos;

public class Listar {

    public static void listarProdutos(){
        System.out.println();

        if(listaProdutos.isEmpty())
        {
            System.out.println("Estoque vazio");
        }

        for(int i = 0; i < listaProdutos.size(); i++)
        {
            System.out.println(i+1 + ") " + listaProdutos.get(i).toString());
        }

        System.out.println();
    }

}
