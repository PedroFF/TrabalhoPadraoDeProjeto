
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
public class StatePreparandoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer idRestaurante =  (int)request.getSession().getAttribute("usuarioID");
            UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID(idRestaurante);
            Pedido pedido = PedidoDAO.getInstance().getPedidoByIdByRestaurante(id,restaurante.getIdUsuario());
            pedido.saveToMemento();
            pedido.prepararPedido();
            PedidoDAO.getInstance().adicionarHistorico(pedido, pedido.getStatus().getStatus(), true); //Confirmar
            PedidoDAO.getInstance().updateEstado(pedido);
IndexRestauranteAction comando = new IndexRestauranteAction();
            comando.execute(request, response);        } catch (SQLException | EstadoNaoPermitidoException ex) {
            Logger.getLogger(StatePreparandoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
