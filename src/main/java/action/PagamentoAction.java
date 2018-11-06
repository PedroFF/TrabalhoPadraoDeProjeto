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
import model.DescontoChain;
import model.FormaPagamento;
import model.Pedido;
import persistence.DescontoDAO;
import persistence.FormaPagamentoDAO;

/**
 *
 * @author pedrofreitas
 */
public class PagamentoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            
            List<FormaPagamento> pagamentos = FormaPagamentoDAO.getInstance().getAllFormaPagamento();
            request.setAttribute("formaPagamentos", pagamentos);
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            DescontoChain chain = DescontoDAO.getInstance().getDescontoChain(pedido.getRestaurante().getIdUsuario());
            pedido.setValorDesconto(chain.calculaDesconto(pedido));
            request.getRequestDispatcher("pagamento.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
