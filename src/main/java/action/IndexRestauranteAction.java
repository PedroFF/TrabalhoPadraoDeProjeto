/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.UsuarioRestaurante;
import persistence.PedidoDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author pedrofreitas
 */
class IndexRestauranteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            UsuarioDAO dao = UsuarioDAO.getInstance();
            UsuarioRestaurante restaurante = dao.getUsuarioRestauranteByID((int)request.getSession().getAttribute("usuarioID"));
            List<Pedido> pedidos = PedidoDAO.getInstance().getAllPedidosByRestaurante(restaurante.getIdUsuario());
            request.setAttribute("restaurante", restaurante);
            request.setAttribute("pedidos", pedidos);
            request.getRequestDispatcher("indexRestaurante.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(IndexRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
