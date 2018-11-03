
package model;

import java.util.List;

/**
 *
 * @author pedrofreitas
 */
public class Produto {
    private int id;
    private Restaurante Restaurante;
    private List<Ingrediente> Ingredientes;
    private String descricao;
    private double preco;

    public Produto() {
    }

    public Produto(int id, Restaurante Restaurante, List<Ingrediente> Ingredientes, String descricao, double preco) {
        this.id = id;
        this.Restaurante = Restaurante;
        this.Ingredientes = Ingredientes;
        this.descricao = descricao;
        this.preco = preco;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurante getRestaurante() {
        return Restaurante;
    }

    
    public void setRestaurante(Restaurante Restaurante) {
        this.Restaurante = Restaurante;
    }

    public List<Ingrediente> getIngredientes() {
        return Ingredientes;
    }

    public void setIngredientes(List<Ingrediente> Ingredientes) {
        this.Ingredientes = Ingredientes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
