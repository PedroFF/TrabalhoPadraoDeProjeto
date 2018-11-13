/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.google.gson.Gson;
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
import model.Usuario;
import persistence.ProdutoDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author pedrofreitas
 */
public class ListarIngredientesProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            Integer id_produto = Integer.parseInt(request.getParameter("produto"));
            List<Ingrediente> ingredientes = ProdutoDAO.getINSTANCE().getIngredientes(id_produto);
            String json = new Gson().toJson(ingredientes);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException ex) {
            Logger.getLogger(ListarIngredientesProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
