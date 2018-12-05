
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioRestaurante;
import persistence.UsuarioDAO;
import persistence.UsuarioRestauranteDAO;

/**
 *
 * @author Rian Alves
 */
public class ListarRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("restaurantes", UsuarioRestauranteDAO.getInstance().getAllUsuariosRestaurante());
            RequestDispatcher despachante = request.getRequestDispatcher("/ClienteInicio.jsp");
            despachante.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
    
}
