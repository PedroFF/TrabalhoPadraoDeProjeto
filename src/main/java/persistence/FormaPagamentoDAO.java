package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Endereco;
import model.FormaPagamento;
import model.FormaPagamentoFactory;

/**
 *
 * @author Rian Alves
 */
public class FormaPagamentoDAO {
     private Connection conexao;
     private static final FormaPagamentoDAO INSTANCE = new FormaPagamentoDAO();
     private String SQL_GET_FORMA_PAGAMENTO_BY_DESCRICAO = "SELECT * FROM FORMA_PAGAMENTO WHERE DESCRICAO = ?";
    public static FormaPagamentoDAO getInstance() {
        return INSTANCE;
    }

    private FormaPagamentoDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public FormaPagamento getFormaPagamento(String descricao) throws SQLException {
        FormaPagamento formaPag = null;
        try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_FORMA_PAGAMENTO_BY_DESCRICAO)) {
            consulta.setString(1,descricao);
            consulta.execute();
            ResultSet resultado = consulta.executeQuery();
           formaPag = FormaPagamentoFactory.create(descricao);
        }
        return formaPag;
    }

}
