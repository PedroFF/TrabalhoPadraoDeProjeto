package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author Rian Alves
 */
public class ProdutoDAO {

    private static final ProdutoDAO INSTANCE = new ProdutoDAO();
    private String SQL_INSERT_ITEM = "INSERT INTO item(id_item,nome,preco,fk_restaurante,ingrediente) VALUES (?,?,?,?,?)";
    private String SQL_INSERT_ITEM_INGREDIENTE = "INSERT INTO INGREDIENTE(id_item_composto,id_item_componente) VALUES (?,?)";
    private String SQL_SELECT_ITEM_BY_ID_AND_RESTAURANTE = "SELECT * FROM ITEM WHERE ID = ? AND FK_RESTAURANTE = ?";
    private String SQL_SELECT_ALL_ITEMS = "SELECT * FROM ITEM WHERE FK_RESTAURANTE = ?";
    private String SQL_SELECT_ITEM_INGREDIENTES = "SELECT * FROM ITEM WHERE INGREDIENTE = TRUE AND FK_RESTAURANTE = ?";
    
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

    public Produto getProdutoByID(Integer id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM PRODUTO WHERE ID =" + id;
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Produto();
            }

        } catch (SQLException e) {
            throw e;
        }
        return null;
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
