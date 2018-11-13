package model;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author pedrofreitas
 */
public class ProdutoFinal extends Produto {


    public ProdutoFinal() {
    }

    public ProdutoFinal(int id, UsuarioRestaurante Restaurante, List<Ingrediente> Ingredientes, String descricao, double preco) {
        this.id = id;
        this.Restaurante = Restaurante;
        this.Ingredientes = Ingredientes;
        this.descricao = descricao;
        this.preco = preco;
    }

    public ProdutoFinal(UsuarioRestaurante Restaurante, List<Ingrediente> Ingredientes, String descricao, double preco) {
        this.Restaurante = Restaurante;
        this.Ingredientes = Ingredientes;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public ProdutoFinal setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public UsuarioRestaurante getRestaurante() {
        return Restaurante;
    }

    @Override
    public ProdutoFinal setRestaurante(UsuarioRestaurante Restaurante) {
        this.Restaurante = Restaurante;
        return this;
    }

    @Override
    public List<Ingrediente> getIngredientes() {
        return Ingredientes;
    }

    @Override
    public ProdutoFinal setIngredientes(List<Ingrediente> Ingredientes) {
        this.Ingredientes = Ingredientes;
        return this;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public ProdutoFinal setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public ProdutoFinal setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    @Override
    public boolean isIngrediente() {
        return ingrediente;
    }

    @Override
    public ProdutoFinal setIngrediente(boolean ingrediente) {
        this.ingrediente = ingrediente;
        return this;
    }

    @Override
    public String getDescricaoItens() {
        StringBuilder str = new StringBuilder();

        Iterator it = Ingredientes.iterator();
        while (it.hasNext()) {
            str.append(((Ingrediente) it.next()).getDescricao());
            if (it.hasNext()) {
                str.append(", ");
            }else{
                str.append(".");
            }
        }
        return str.toString();
    }

}
