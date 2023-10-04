package entities;

import java.util.ArrayList;
import java.util.List;


public class Produto {

    private String name;
    private String code;
    private Integer quantity;
    private Double price;

    private List<Produto> estoque = new ArrayList<>();

    private Vendedor vendedor;

    public Produto(String name, String code, Integer quantity, Double price, Vendedor vendedor) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
        this.vendedor = vendedor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Produto> getEstoque() {
        return estoque;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;

        return getCode().equals(produto.getCode());
    }

    @Override
    public int hashCode() {
        return getCode().hashCode();
    }

    @Override
    public String toString() {
        return getName() +
                " (cod.: " + getCode() +
                " | estoque: " + getQuantity() +
                " | Preco: " + getPrice() +
                " | Nome Vendedor: " + getVendedor().getNome() +
                " | Cpf Vendedor: " + getVendedor().getCpf() +
        ")" ;
    }
}


