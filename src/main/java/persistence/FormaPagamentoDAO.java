package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private String SQL_GET_ALL_FORMA_PAGAMENTO = "SELECT DESCRICAO FROM FORMA_PAGAMENTO";

    public static FormaPagamentoDAO getInstance() {
        return INSTANCE;
    }

    private FormaPagamentoDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public FormaPagamento getFormaPagamento(String descricao) throws SQLException {
        FormaPagamento formaPag = null;
        try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_FORMA_PAGAMENTO_BY_DESCRICAO)) {
            consulta.setString(1, descricao);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                do {
                    formaPag = FormaPagamentoFactory.create(resultado.getString("descricao"), resultado.getInt("id_forma_pagamento"));
                } while (resultado.next());
            }
        }
        return formaPag;
    }

    public List<FormaPagamento> getAllFormaPagamento() throws SQLException {
        List<FormaPagamento> formas = new ArrayList<>();
        try (PreparedStatement consulta = conexao.prepareStatement(SQL_GET_ALL_FORMA_PAGAMENTO)) {
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                do {
                    formas.add(this.getFormaPagamento(resultado.getString("DESCRICAO")));
                } while (resultado.next());
            }
        }
        return formas;
    }

}
