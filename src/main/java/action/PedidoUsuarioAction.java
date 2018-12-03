package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;
import model.Usuario;
import persistence.PedidoDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author pedrofreitas
 */
public class PedidoUsuarioAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Usuario usuario = UsuarioDAO.getInstance().getUsuarioClienteByID((int)request.getSession().getAttribute("usuarioID"));
            request.setAttribute("pedidos", PedidoDAO.getInstance().getAllPedidosByUsuario(usuario.getIdUsuario()));
            request.getRequestDispatcher("listaPedidos.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
