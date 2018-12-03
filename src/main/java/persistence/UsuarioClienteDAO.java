package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.Usuario;
import model.UsuarioCliente;

public class UsuarioClienteDAO extends UsuarioDAO {

    protected static UsuarioClienteDAO usuarioClienteDAO = new UsuarioClienteDAO();
    private final String SQL_INSERT_USUARIO_CLIENTE = "INSERT INTO usuariocliente(  id_usuario_cliente,  cpf) VALUES (?,?);";

    private UsuarioClienteDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public static UsuarioClienteDAO getInstance() {
        return usuarioClienteDAO;
    }

    @Override
    public Usuario getUsuarioByEmailSenha(Usuario usuario) {
        UsuarioCliente cliente = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_BY_LOGIN)) {
                consulta.setString(1, usuario.getEmail());
                consulta.setString(2, usuario.getSenha());
                consulta.setMaxRows(1);
                consulta.execute();
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    Endereco endereco = EnderecoDAO.getInstance().getEnderecoByUsuario(resultado.getInt("id_usuario"));
                    cliente = new UsuarioCliente(resultado.getInt("id_usuario"),
                            resultado.getString("email"),
                            resultado.getString("senha"),
                            resultado.getString("nome"),
                            resultado.getString("tipo"),
                            endereco,
                            resultado.getString("cpf"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public Usuario getUsuarioByID(Usuario usuario) {
        UsuarioCliente cliente = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_BY_ID)) {
                consulta.setInt(1, usuario.getIdUsuario());
                consulta.setMaxRows(1);
                consulta.execute();
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    Endereco endereco = EnderecoDAO.getInstance().getEnderecoByUsuario(resultado.getInt("id_usuario"));
                    cliente = new UsuarioCliente(resultado.getInt("id_usuario"),
                            resultado.getString("email"),
                            resultado.getString("senha"),
                            resultado.getString("nome"),
                            resultado.getString("tipo"),
                            endereco,
                            resultado.getString("cpf"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public Usuario getUsuarioByID(Integer id) {
        Usuario cliente = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_BY_ID)) {
                consulta.setInt(1, id);
                consulta.setMaxRows(1);
                consulta.execute();
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    Endereco endereco = EnderecoDAO.getInstance().getEnderecoByUsuario(resultado.getInt("id_usuario"));
                    cliente = new UsuarioCliente(resultado.getInt("id_usuario"),
                            resultado.getString("email"),
                            resultado.getString("senha"),
                            resultado.getString("nome"),
                            resultado.getString("tipo"),
                            endereco,
                            resultado.getString("cpf"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public void adicionarCliente(UsuarioCliente usuario) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_USUARIO_CLIENTE)) {
            comando.setInt(1, usuario.getIdUsuario());
            comando.setString(2, usuario.getCpf());
            comando.execute();
            comando.close();
        }

    }

    ;


    
    @Override
    public String getTabelaUsuario() {
        return "usuariocliente";
    }

    @Override
    public String getIdTabelaUsuario() {
        return "id_usuario_cliente";
    }

}
