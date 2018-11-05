
package persistence;

import java.sql.Connection;


public class PedidoDAO {
    
    private Connection conexao;
     private static final PedidoDAO INSTANCE = new PedidoDAO();
     private String SQL_GET_FORMA_PAGAMENTO_BY_DESCRICAO = "SELECT * FROM ENDERECO WHERE DESCRICAO = ?";
    public static PedidoDAO getInstance() {
        return INSTANCE;
    }

    private PedidoDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }
    
}
