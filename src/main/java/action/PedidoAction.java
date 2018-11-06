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
import model.Produto;
import model.Usuario;
import model.UsuarioCliente;
import model.UsuarioRestaurante;
import persistence.ProdutoDAO;
import persistence.RestauranteDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author pedrofreitas
 */
public class PedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Integer idRestaurante = Integer.parseInt(request.getParameter("idRestaurante"));
            UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID(idRestaurante);
            List<Produto> produtos = ProdutoDAO.getINSTANCE().getAllProdutos(idRestaurante);
            Pedido pedido = new Pedido();
            Usuario cliente = UsuarioDAO.getInstance().getUsuarioClienteByID((int)request.getSession().getAttribute("usuarioID"));
            pedido.setUsuario(cliente).setRestaurante(restaurante);
            request.getSession().setAttribute("pedido", pedido);
            request.setAttribute("produtos", produtos);
            request.setAttribute("restaurante", restaurante);
            request.getRequestDispatcher("pedido.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
