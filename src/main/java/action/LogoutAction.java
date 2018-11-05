/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedrofreitas
 */
public class LogoutAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
         try {
            request.getSession().invalidate();
            response.sendRedirect("login.jsp");
        } catch (IOException ex) {
            Logger.getLogger(LogoutAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
