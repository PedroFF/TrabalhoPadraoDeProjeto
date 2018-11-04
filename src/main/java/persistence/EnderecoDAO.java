package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;

public class EnderecoDAO {

    private Connection conexao;
    private static final EnderecoDAO INSTANCE = new EnderecoDAO();
    private String SQL_GET_ENDERECO_BY_USUARIO = "SELECT * FROM ENDERECO WHERE ID_USUARIO = ?";

    public static EnderecoDAO getInstance() {
        return INSTANCE;
    }

    private EnderecoDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public Endereco getEnderecoByUsuario(int id_usuario) {
        Endereco endereco = null;
        try {
            try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_ENDERECO_BY_USUARIO)) {
                consulta.setInt(1, id_usuario);
                consulta.setMaxRows(1);
                consulta.execute();
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    endereco = new Endereco(resultado.getString("rua"),
                            resultado.getString("bairro"),
                            resultado.getString("cep"),
                            resultado.getString("cidade"),
                            resultado.getString("estado"),
                            resultado.getString("complemento"),
                            resultado.getString("numero"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

}
