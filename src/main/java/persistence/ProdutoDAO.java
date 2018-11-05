package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.mail.FetchProfile.Item;
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
    private String SQL_INSERT_ITEM = "INSERT INTO item(id_item,nome,preco,fk_restaurante,ingrediente) VALUES (?,?,?,?,?)";
    private String SQL_INSERT_ITEM_INGREDIENTE = "INSERT INTO INGREDIENTE(id_item_composto,id_item_componente) VALUES (?,?)";
    private String SQL_SELECT_ITEM_BY_ID_AND_RESTAURANTE = "SELECT * FROM ITEM WHERE ID = ? AND FK_RESTAURANTE = ?";
    private String SQL_SELECT_ALL_ITEMS = "SELECT * FROM ITEM WHERE FK_RESTAURANTE = ?";
    private String SQL_SELECT_ITEM_INGREDIENTES = "SELECT * FROM ITEM WHERE INGREDIENTE = TRUE AND FK_RESTAURANTE = ?";
    private String SQL_SELECT_INGREDIENTES = "SELECT id_item, fk_restaurante FROM ITEM inner join ingrediente on item.id_item = ingrediente.id_item_componente where id_item_composto = ?";

    public static ProdutoDAO getINSTANCE() {
        return INSTANCE;
    }

    public void save(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa(nomeEmpresa) values ('" + produto + "')");
        } catch (SQLException e) {
            throw e;
        }
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

    public List<Produto> getProdutos() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        List<Produto> produtos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM PRODUTO";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                produtos.add(new Produto());
            }
        } catch (SQLException e) {
            throw e;
        }
        return produtos;
    }

    public void delete(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM empresa WHERE nomeEmpresa ='" + produto + "'");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE empresa SET nomeEmpresa ='" + produto + "' WHERE id =");
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Produto> listAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Produto> produtos = new ArrayList<>();
        conn = DatabaseLocator.getInstance().getConnection();
        PreparedStatement consulta = conn.prepareStatement("Select * from produto");
        ResultSet resultado = consulta.executeQuery();
        if (resultado.next()) {
            do {
                produtos.add(new Produto());

            } while (resultado.next());
        }
        return produtos;
    }
}
