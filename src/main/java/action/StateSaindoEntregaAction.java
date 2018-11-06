package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EstadoNaoPermitidoException;
import model.Pedido;
import model.UsuarioRestaurante;
import persistence.PedidoDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author Rian Alves
 */
public class StateSaindoEntregaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer idRestaurante = Integer.parseInt((String)request.getSession().getAttribute("usuarioID"));
            UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID(idRestaurante);
            Pedido pedido = PedidoDAO.getInstance().getPedidoByIdByRestaurante(id,restaurante.getIdUsuario());
            pedido.saveToMemento();
            pedido.sairParaEntrega();
            PedidoDAO.getInstance().adicionarHistorico(pedido, pedido.getStatus().getDescricao(), true); //Confirmar
            PedidoDAO.getInstance().updateEstado(pedido);
        } catch (SQLException | EstadoNaoPermitidoException ex) {
            Logger.getLogger(StateSaindoEntregaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
