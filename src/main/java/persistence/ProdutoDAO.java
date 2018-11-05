package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Ingrediente;
import model.Produto;
import model.UsuarioRestaurante;

/**
 *
 * @author Rian Alves
 */
public class ProdutoDAO {

    private Connection conexao;
    private static final ProdutoDAO INSTANCE = new ProdutoDAO();
    private String SQL_INSERT_ITEM = "INSERT INTO item(nome,preco,fk_restaurante,ingrediente) VALUES (?,?,?,?,?)";
    private String SQL_INSERT_ITEM_INGREDIENTE = "INSERT INTO INGREDIENTE(id_item_composto,id_item_componente) VALUES (?,?)";
    private String SQL_SELECT_ITEM_BY_ID_AND_RESTAURANTE = "SELECT * FROM ITEM WHERE ID = ? AND FK_RESTAURANTE = ?";
    private String SQL_SELECT_ALL_ITEMS_COMPOSTOS = "SELECT id_item FROM ITEM WHERE FK_RESTAURANTE = ? AND INGREDIENTE = FALSE";
    private String SQL_SELECT_ITEM_INGREDIENTES = "SELECT id_item FROM ITEM WHERE INGREDIENTE = TRUE AND FK_RESTAURANTE = ?";
    private String SQL_SELECT_INGREDIENTES = "SELECT id_item, fk_restaurante FROM ITEM inner join ingrediente on item.id_item = ingrediente.id_item_componente where id_item_composto = ?";

    public static ProdutoDAO getINSTANCE() {
        return INSTANCE;
    }

    public Integer adicionar(Produto produto, Integer id_restaurante) throws SQLException, ClassNotFoundException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_ITEM, Statement.RETURN_GENERATED_KEYS)) {
            comando.setString(1, produto.getDescricao());
            comando.setDouble(2, produto.getPreco());
            comando.setInt(3, id_restaurante);
            comando.setBoolean(4, produto.isIngrediente());
            comando.execute();
            ResultSet rs = comando.getGeneratedKeys();

            if (rs.next()) {
                Integer id = rs.getInt(1);
                produto.setId(id);
            }
            comando.close();
        }
        return produto.getId();
    }

    public Produto getProdutoByID(Integer id_item, Integer id_restaurante) throws ClassNotFoundException, SQLException {
        Produto item = null;
        try (PreparedStatement consulta = conexao.prepareStatement(SQL_SELECT_ITEM_BY_ID_AND_RESTAURANTE)) {
            consulta.setInt(1, id_item);
            consulta.setInt(2, id_restaurante);
            consulta.execute();
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID(id_restaurante);
                item = new Produto().setId(resultado.getInt("id_item"))
                        .setDescricao(resultado.getString("nome"))
                        .setPreco(resultado.getDouble("preco")).
                        setRestaurante(restaurante)
                        .setIngrediente(resultado.getBoolean("ingrediente"));
                if (!item.isIngrediente()) {
                    List<Ingrediente> ingredientes = this.getIngredientes(id_item);
                    item.setIngredientes(ingredientes);
                }
            }
        }
        return item;
    }

    public List<Ingrediente> getIngredientes(Integer id_item) throws SQLException, ClassNotFoundException {
        List<Ingrediente> ingredientes = new ArrayList<>();
        try (PreparedStatement consulta = conexao.prepareStatement(SQL_SELECT_INGREDIENTES)) {
            consulta.setInt(1, id_item);
            consulta.execute();
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                do {
                    ingredientes.add((Ingrediente) this.getProdutoByID(resultado.getInt("id_item"), resultado.getInt("fk_restaurante")));
                } while (resultado.next());

            }
        }
        return ingredientes;
    }

    public List<Produto> getAllProdutos(Integer id_restaurante) throws SQLException, ClassNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement consulta = conexao.prepareStatement(SQL_SELECT_ALL_ITEMS_COMPOSTOS)) {
            consulta.setInt(1, id_restaurante);
            consulta.execute();
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                do {
                    produtos.add(this.getProdutoByID(resultado.getInt("id_item"), id_restaurante));
                } while (resultado.next());

            }
        }
        return produtos;
    }

    public List<Ingrediente> getIngredientesByRestaurante(Integer id_restaurante) throws SQLException, ClassNotFoundException {
        List<Ingrediente> ingredientes = new ArrayList<>();
        try (PreparedStatement consulta = conexao.prepareStatement(SQL_SELECT_ITEM_INGREDIENTES)) {
            consulta.setInt(1, id_restaurante);
            consulta.execute();
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                do {
                    ingredientes.add((Ingrediente) this.getProdutoByID(resultado.getInt("id_item"), id_restaurante));
                } while (resultado.next());

            }
        }
        return ingredientes;
    }

    public void adicionarIngrediente(Integer id_item, Integer id_ingrediente) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_ITEM_INGREDIENTE)) {
            comando.setInt(1, id_item);
            comando.setInt(2, id_ingrediente);
            comando.execute();
            comando.close();
        }
    }

}
