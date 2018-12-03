/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.UsuarioDAO;

/**
 *
 * @author pedrofreitas
 */
public class HomeAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String tipo = (String) request.getSession().getAttribute("usuarioTipo");
        Usuario restaurante = UsuarioDAO.getInstance().getUsuarioByID((int) request.getSession().getAttribute("usuarioID"));
        if (tipo == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (tipo.equals("CLIENTE")) {
            ListarRestauranteAction comando = new ListarRestauranteAction();
            comando.execute(request, response);
        } else if (tipo.equals("RESTAURANTE")) {
            IndexRestauranteAction comando = new IndexRestauranteAction();
            comando.execute(request, response);
        }
    }

}
