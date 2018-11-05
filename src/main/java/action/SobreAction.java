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

/**
 *
 * @author pedrofreitas
 */
public class SobreAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("usuarioID", request.getSession().getAttribute("usuarioID"));
        response.sendRedirect("sobre.jsp");
//request.getRequestDispatcher("sobre.jsp").forward(request, response);
    }
    
}
