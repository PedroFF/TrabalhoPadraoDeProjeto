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
public class HomeAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String tipo = (String) request.getSession().getAttribute("usuarioTipo");
        Usuario restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID((int)request.getSession().getAttribute("usuarioID"));
        if(tipo == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if(tipo.equals("CLIENTE")){
            request.getRequestDispatcher("ClienteInicio.jsp").forward(request, response);
        } else if(tipo.equals("RESTAURANTE")){
            request.setAttribute("restaurante", restaurante);
            request.getRequestDispatcher("indexRestaurante.jsp").forward(request, response);
        }
    }
    
}
