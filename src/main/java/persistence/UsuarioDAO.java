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

public class UsuarioDAO {

    private Connection conexao;
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private String SQL_GET_USUARIO_CLIENTE_BY_LOGIN = "SELECT * FROM usuario inner join usuariocliente on usuario.id_usuario = usuariocliente.id_usuario_cliente WHERE email = ? AND senha = ?";
    private String SQL_GET_USUARIO_CLIENTE_BY_ID = "SELECT * FROM usuario inner join usuariocliente on usuario.id_usuario = usuariocliente.id_usuario_cliente WHERE id_usuario = ?";
    private String SQL_GET_USUARIO_RESTAURANTE_BY_LOGIN = "SELECT * FROM usuario inner join usuariorestaurante on usuario.id_usuario = usuariorestaurante.id_usuario_restaurante WHERE email = ? AND senha = ?";
    private String SQL_GET_USUARIO_RESTAURANTE_BY_ID = "SELECT * FROM usuario inner join usuariorestaurante on usuario.id_usuario = usuariorestaurante.id_usuario_restaurante WHERE id_usuario = ?";
    private String SQL_GET_ALL_USUARIOS_RESTAURANTES = "SELECT id_usuario FROM usuario inner join usuariorestaurante on usuario.id_usuario = usuariorestaurante.id_usuario_restaurante ";
    private String SQL_INSERT_USUARIO = "INSERT INTO usuario(nome,senha,email,tipo)VALUES (?,?,?,?);";
    private String SQL_INSERT_USUARIO_CLIENTE = "INSERT INTO usuariocliente(  id_usuario_cliente,  cpf) VALUES (?,?);";
    private String SQL_INSERT_USUARIO_RESTAURANTE = "INSERT INTO usuariorestaurante(id_usuario_restaurante, avaliacao) VALUES (?,null);";

    private UsuarioDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public static UsuarioDAO getInstance() {
        return usuarioDAO;
    }
    
    public Usuario getUsuario(Usuario usuario) {
        if ("CLIENTE".equals(usuario.getTipo().toUpperCase())) {
            return getUsuarioClienteByEmailSenha(usuario);
        } else if ("RESTAURANTE".equals(usuario.getTipo().toUpperCase())) {
            return getUsuarioRestauranteByEmailSenha(usuario);
        }
        return null;
    }

    public UsuarioCliente getUsuarioClienteByEmailSenha(Usuario usuario) {
        UsuarioCliente cliente = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_CLIENTE_BY_LOGIN)) {
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public UsuarioRestaurante getUsuarioRestauranteByEmailSenha(Usuario usuario) {
        UsuarioRestaurante restaurante = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_RESTAURANTE_BY_LOGIN)) {
                consulta.setString(1, usuario.getEmail());
                consulta.setString(2, usuario.getSenha());
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurante;
    }

    public UsuarioRestaurante getUsuarioRestauranteByID(Usuario usuario) {
        UsuarioRestaurante restaurante = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_RESTAURANTE_BY_ID)) {
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurante;
    }

    public UsuarioCliente getUsuarioClienteByID(Usuario usuario) {
        UsuarioCliente cliente = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_RESTAURANTE_BY_ID)) {
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public UsuarioRestaurante getUsuarioRestauranteByID(Integer id) {
        UsuarioRestaurante restaurante = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_USUARIO_RESTAURANTE_BY_ID)) {
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurante;
    }

    public List<UsuarioRestaurante> getAllUsuariosRestaurante() throws SQLException {
        List<UsuarioRestaurante> restaurantes = new ArrayList<>();
        PreparedStatement consulta = conexao.prepareStatement(SQL_GET_ALL_USUARIOS_RESTAURANTES);
        ResultSet resultado = consulta.executeQuery();
        if (resultado.next()) {
            do {
                restaurantes.add(this.getUsuarioRestauranteByID(resultado.getInt("id_usuario")));
            } while (resultado.next());
        }
        return restaurantes;
    }

    public void adicionarUsuario(Usuario usuario) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_USUARIO, Statement.RETURN_GENERATED_KEYS)) {
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
                    adicionarCliente((UsuarioCliente) usuario);
                }else if(usuario.getTipo().equals(EnumTipoUsuario.RESTAURANTE.getDescricao().toUpperCase())){
                    adicionarRestaurante((UsuarioRestaurante) usuario);
                }
            }
        }
    }

    public void adicionarCliente(UsuarioCliente usuario) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_USUARIO_CLIENTE)) {
            comando.setInt(1, usuario.getIdUsuario());
            comando.setString(2, usuario.getCpf());
            comando.execute();
        }
        
    }

    ;
    public void adicionarRestaurante(UsuarioRestaurante usuario) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_USUARIO_RESTAURANTE)) {
            comando.setInt(1, usuario.getIdUsuario());
            comando.execute();
        }
    }
;
}
