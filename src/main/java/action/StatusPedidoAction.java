package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AguardandoState;
import model.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author Rian Alves
 */
public class StatusPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Integer idPedido = Integer.parseInt(request.getParameter("id"));
            Integer idRestaurante = Integer.parseInt(request.getParameter("idRestaurante"));
            Pedido pedido = PedidoDAO.getInstance().getPedidoByIdByRestaurante(idPedido, idRestaurante);
            request.setAttribute("pedido", pedido);
            request.getRequestDispatcher("statusPedido.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
