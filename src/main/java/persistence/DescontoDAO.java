package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DescontoChain;
import model.DescontoChainNivelDois;
import model.DescontoChainNivelTres;
import model.DescontoChainNivelUm;

public class DescontoDAO {

    private final Connection conexao;
    private static final DescontoDAO INSTANCE = new DescontoDAO();
    private final String SQL_SELECT_DESCONTO = "SELECT desconto_nivel_um, quantidade_nivel_um, desconto_nivel_dois, quantidade_nivel_dois, desconto_nivel_tres, quantidade_nivel_tres FROM restaurante_desconto rd where rd.id_usuario_restaurante = ?";

    public static DescontoDAO getInstance() {
        return INSTANCE;
    }

    private DescontoDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }
    
    public DescontoChain getDescontoChain(int idRestaurante) throws SQLException{
       DescontoChain chain = null;
       
        try (PreparedStatement consulta = conexao.prepareStatement(SQL_SELECT_DESCONTO)) {
            consulta.setInt(1, idRestaurante);
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
            DescontoChainNivelTres chainTres = new DescontoChainNivelTres(resultado.getInt("quantidade_nivel_tres"),resultado.getDouble("desconto_nivel_tres"));
            DescontoChainNivelDois chainDois = new DescontoChainNivelDois(resultado.getInt("quantidade_nivel_dois"),resultado.getDouble("desconto_nivel_dois"));
            chain = new DescontoChainNivelUm(resultado.getInt("quantidade_nivel_um"),resultado.getDouble("desconto_nivel_um"));
            chain.setNext(chainDois).setNext(chainTres);
            }
        }
       return chain;
    }


}
