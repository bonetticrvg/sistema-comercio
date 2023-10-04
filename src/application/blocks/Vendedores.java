package application.blocks;

import entities.Produto;
import entities.Vendedor;

import java.util.Objects;

import static application.blocks.Menu.*;

public class Vendedores {

    public static void vendedores(){

        ListarVendedores.listarVendedores();

        if(!listaVendedores.isEmpty())
        {
            System.out.print("Informe o CPF do vendedor que deseja analisar: ");

            String CPF = sc.next();

            Vendedor vendedor = null;

            for (Vendedor V: listaVendedores)
            {
                if(Objects.equals(V.getCpf(), CPF))
                {
                    vendedor = V;
                }
            }

            int produtosCadastrados = 0;
            int somaProdutos = 0;

            for (Produto p: listaProdutos){
                if (Objects.equals(p.getVendedor().getNome(), vendedor.getNome()))
                {
                    produtosCadastrados++;
                    somaProdutos += p.getPrice();
                }
            }

            System.out.println();
            System.out.println("Informe qual informacao voce deseja analisar: ");
            System.out.println();
            System.out.println("1 - Produtos cadastrados pelo vendedor");
            System.out.println("2 - Quantidade de produtos cadastrados pelo vendedor");
            System.out.println("3 - Valor total dos produtos cadastrados pelo vendedor");
            System.out.print("Sua opcao: ");
            int opcao = sc.nextInt();



            switch (opcao){
                case 1:
                {
                    System.out.println();
                    System.out.println("Produtos cadastrados pelo vendedor: ");
                    System.out.println();
                    for (Produto p: listaProdutos){
                        if (Objects.equals(p.getVendedor().getNome(), vendedor.getNome()))
                        {
                            System.out.println(p);
                        }
                    }
                    break;
                }
                case 2:
                {
                    System.out.println();
                    System.out.println("Quantidade de produtos cadastrados pelo vendedor: " + produtosCadastrados);
                    break;
                }
                case 3:
                {
                    System.out.println();
                    System.out.println("Valor total dos produtos cadastrados pelo vendedor: R$ " + somaProdutos);
                    System.out.println();
                    break;
                }
            }
        }
    }
}
