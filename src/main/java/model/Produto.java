
package model;

import java.util.List;

/**
 *
 * @author pedrofreitas
 */
public class Produto {
    private int id;
    private UsuarioRestaurante Restaurante;
    private List<Ingrediente> Ingredientes;
    private String descricao;
    private double preco;

    public Produto() {
    }

    public Produto(int id, UsuarioRestaurante Restaurante, List<Ingrediente> Ingredientes, String descricao, double preco) {
        this.id = id;
        this.Restaurante = Restaurante;
        this.Ingredientes = Ingredientes;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto(UsuarioRestaurante Restaurante, List<Ingrediente> Ingredientes, String descricao, double preco) {
        this.Restaurante = Restaurante;
        this.Ingredientes = Ingredientes;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    

  
    public int getId() {
        return id;
    }

    public Produto setId(int id) {
        this.id = id;
        return this;
    }

    public UsuarioRestaurante getRestaurante() {
        return Restaurante;
    }

    
    public Produto setRestaurante(UsuarioRestaurante Restaurante) {
        this.Restaurante = Restaurante;
        return this;
    }

    public List<Ingrediente> getIngredientes() {
        return Ingredientes;
    }

    public Produto setIngredientes(List<Ingrediente> Ingredientes) {
        this.Ingredientes = Ingredientes;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public double getPreco() {
        return preco;
    }

    public Produto setPreco(double preco) {
        this.preco = preco;
        return this;
    }
    
}
