/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.util.List;
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
        response.setContentType("text/html;charset=UTF-8");
        UsuarioDAO dao = UsuarioDAO.getInstance();
        UsuarioRestaurante restaurante = dao.getUsuarioRestauranteByID((int)request.getSession().getAttribute("usuarioID"));
        List<Pedido> pedidos = PedidoDAO.getInstance().getAllPedidosByRestaurante(restaurante.getIdUsuario());
        request.setAttribute("restaurante", restaurante);
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("indexEmpresa.jsp").forward(request, response);
    }  
}
