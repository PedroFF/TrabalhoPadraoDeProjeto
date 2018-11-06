/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AguardandoState;
import model.FormaPagamento;
import model.Pedido;
import persistence.FormaPagamentoDAO;
import persistence.PedidoDAO;
import persistence.RestauranteDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author pedrofreitas
 */
public class PedidoPostAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            FormaPagamento formapg = FormaPagamentoDAO.getInstance().getFormaPagamento(request.getParameter("pagamento"));
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            pedido.setFormapgto(formapg);
            PedidoDAO dao = PedidoDAO.getInstance();
            pedido.setStatus(new AguardandoState());
            dao.adicionar(pedido);
            request.setAttribute("pedido", request.getSession().getAttribute("pedido"));
            request.getRequestDispatcher("statusPedido.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoPostAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
