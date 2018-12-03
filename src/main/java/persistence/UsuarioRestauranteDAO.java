package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.EnumTipoUsuario;
import model.Usuario;
import model.UsuarioCliente;
import model.UsuarioRestaurante;

public class UsuarioRestauranteDAO extends UsuarioDAO {

    protected static UsuarioRestauranteDAO usuarioRestauranteDAO = new UsuarioRestauranteDAO();
    private final String SQL_GET_ALL_USUARIOS_RESTAURANTES = "SELECT id_usuario FROM usuario inner join usuariorestaurante on usuario.id_usuario = usuariorestaurante.id_usuario_restaurante ";
    private final String SQL_INSERT_USUARIO_RESTAURANTE = "INSERT INTO usuariorestaurante(id_usuario_restaurante, avaliacao) VALUES (?,null);";

    private UsuarioRestauranteDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public static UsuarioRestauranteDAO getInstance() {
        return usuarioRestauranteDAO;
    }

    @Override
    public Usuario getUsuarioByID(Usuario usuario) {
        UsuarioRestaurante restaurante = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_BY_ID)) {
                consulta.setInt(1, usuario.getIdUsuario());
                consulta.setMaxRows(1);
                consulta.execute();
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    Endereco endereco = EnderecoDAO.getInstance().getEnderecoByUsuario(resultado.getInt("id_usuario"));
                    restaurante = new UsuarioRestaurante(resultado.getInt("id_usuario"),
                            resultado.getString("email"),
                            resultado.getString("senha"),
                            resultado.getString("nome"),
                            resultado.getString("tipo"),
                            endereco,
                            resultado.getDouble("avaliacao"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRestauranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurante;
    }

    @Override
    public UsuarioRestaurante getUsuarioByID(Integer id) {
        UsuarioRestaurante restaurante = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_BY_ID)) {
                consulta.setInt(1, id);
                consulta.setMaxRows(1);
                consulta.execute();
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    Endereco endereco = EnderecoDAO.getInstance().getEnderecoByUsuario(resultado.getInt("id_usuario"));
                    restaurante = new UsuarioRestaurante(resultado.getInt("id_usuario"),
                            resultado.getString("email"),
                            resultado.getString("senha"),
                            resultado.getString("nome"),
                            resultado.getString("tipo"),
                            endereco,
                            resultado.getDouble("avaliacao"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRestauranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurante;
    }

    public List<UsuarioRestaurante> getAllUsuariosRestaurante() throws SQLException {
        List<UsuarioRestaurante> restaurantes = new ArrayList<>();
        PreparedStatement consulta = conexao.prepareStatement(SQL_GET_ALL_USUARIOS_RESTAURANTES);
        ResultSet resultado = consulta.executeQuery();
        if (resultado.next()) {
            do {
                restaurantes.add(this.getUsuarioByID(resultado.getInt("id_usuario")));
            } while (resultado.next());
        }
        return restaurantes;
    }

    public void adicionarRestaurante(UsuarioRestaurante usuario) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_USUARIO_RESTAURANTE)) {
            comando.setInt(1, usuario.getIdUsuario());
            comando.execute();
            comando.close();
        }
    }

    ;

    @Override
    public Usuario getUsuarioByEmailSenha(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTabelaUsuario() {
        return "usuariorestaurante";
    }

    @Override
    public String getIdTabelaUsuario() {
        return "id_usuario_restaurante";
    }
}
