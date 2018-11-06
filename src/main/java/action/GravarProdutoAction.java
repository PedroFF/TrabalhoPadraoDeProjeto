
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
import model.Ingrediente;
import persistence.ProdutoDAO;

/**
 *
 * @author Rian Alves
 */
public class GravarProdutoAction implements Action  {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            List<Ingrediente> ingredientes = ProdutoDAO.getINSTANCE().
                    getIngredientesByRestaurante((int)request.getSession().getAttribute("usuarioID"));
            request.setAttribute("ingredientes", ingredientes);
            request.getRequestDispatcher("CadastroProduto.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GravarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
