package model;

/**
 *
 * @author pedrofreitas
 */
public class Ingrediente extends Produto{



    @Override
    public Ingrediente setId(int id) {
        this.id = id;
        return this;
    }



    @Override
    public Ingrediente setRestaurante(UsuarioRestaurante Restaurante) {
        this.Restaurante = Restaurante;
        return this;
    }



    @Override
    public Ingrediente setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }


    @Override
    public Ingrediente setPreco(double preco) {
        this.preco = preco;
        return this;
    }


    @Override
    public Ingrediente setIngrediente(boolean ingrediente) {
        this.ingrediente = ingrediente;
        return this;
    }

    public Ingrediente from(Produto produto) {
        return new Ingrediente().setId(produto.getId()).setDescricao(produto.getDescricao()).setIngrediente(produto.isIngrediente()).setPreco(produto.getPreco()).setRestaurante(produto.getRestaurante());
    }
    
    

}
