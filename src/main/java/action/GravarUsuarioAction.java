
package action;

import controller.Action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rian Alves
 */
public class GravarUsuarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
         response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("CadastroUsuario.jsp").forward(request, response);
    
    }
    
}
