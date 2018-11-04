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
    private String SQL_INSERT_ENDERECO = "INSERT INTO endereco (id_usuario,rua,bairro,cep,cidade,estado,complemento,numero) VALUES (?,?,?,?,?,?,?,?);";

    public static EnderecoDAO getInstance() {
        return INSTANCE;
    }

    private EnderecoDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public Endereco getEnderecoByUsuario(int id_usuario) throws SQLException {
        Endereco endereco = null;
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
        return endereco;
    }

    public void adicionar(Integer id_usuario, Endereco endereco) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_ENDERECO)) {
            comando.setInt(1,id_usuario);
            comando.setString(2, endereco.getRua() );
            comando.setString(3, endereco.getBairro());
            comando.setString(4, endereco.getCep());
            comando.setString(5, endereco.getCidade());
            comando.setString(6, endereco.getEstado());
            comando.setString(7, endereco.getComplemento());
            comando.setString(8, endereco.getNumero());
            comando.execute();
            comando.close();
        }
    }

}
