package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.EnumTipoUsuario;
import model.Usuario;
import model.UsuarioCliente;
import model.UsuarioRestaurante;

public abstract class UsuarioDAO {

    protected static UsuarioDAO usuarioDAO;
    protected Connection conexao;
    protected final String SQL_GET_USUARIO_BY_LOGIN = "SELECT * FROM usuario inner join" + this.getTabelaUsuario() + "on usuario.id_usuario = " + this.getTabelaUsuario() + "." + this.getIdTabelaUsuario() + " WHERE email = ? AND senha = ?";
    protected final String SQL_GET_USUARIO_BY_ID = "SELECT * FROM usuario inner join " + this.getTabelaUsuario() + " on usuario.id_usuario = " + this.getTabelaUsuario() + ".id_usuario_cliente WHERE id_usuario = ?";
    private final String SQL_INSERT_USUARIO = "INSERT INTO usuario(nome,senha,email,tipo)VALUES (?,?,?,?);";

    protected UsuarioDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public static UsuarioDAO getInstance() {
        return usuarioDAO;
    }

    public Usuario getUsuario(Usuario usuario) {
        return getUsuarioByEmailSenha(usuario);

    }

    public abstract Usuario getUsuarioByEmailSenha(Usuario usuario);

    public abstract Usuario getUsuarioByID(Usuario usuario);

    public abstract Usuario getUsuarioByID(Integer id);

    public abstract String getTabelaUsuario();

    public abstract String getIdTabelaUsuario();

    public void adicionarUsuario(Usuario usuario) throws SQLException {
        try (final PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_USUARIO, Statement.RETURN_GENERATED_KEYS)) {
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getTipo());
            comando.execute();
            ResultSet rs = comando.getGeneratedKeys();
            if (rs.next()) {
                Integer id = rs.getInt(1);
                usuario.setIdUsuario(id);
                if (usuario.getTipo().equals(EnumTipoUsuario.CLIENTE.getDescricao().toUpperCase())) {
                    UsuarioClienteDAO.getInstance().adicionarCliente((UsuarioCliente) usuario);
                } else if (usuario.getTipo().equals(EnumTipoUsuario.RESTAURANTE.getDescricao().toUpperCase())) {
                    UsuarioRestauranteDAO.getInstance().adicionarRestaurante((UsuarioRestaurante) usuario);
                }
            }
            comando.close();
        }
    }

}
