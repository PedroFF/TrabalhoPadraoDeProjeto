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
import model.EstadoNaoPermitidoException;
import model.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author Rian Alves
 */
public class StateAguardandoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Pedido pedido = (Pedido) PedidoDAO.getInstance().getPedidoByIdByRestaurante(id);//Confirmar
            pedido.saveToMemento();
            PedidoDAO.getInstance().adicionarHistorico(pedido, pedido.getStatus().getDescricao(), false); //Confirmar
            PedidoDAO.getInstance().updateEstado(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(StateAguardandoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
