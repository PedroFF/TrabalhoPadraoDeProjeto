/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        Pedido pedido = (Pedido) PedidoDAO.getInstance().getByID(id);
        pedido.saveToMemento();
        pedido.PedidoDAO.getInstance().insertHistorico(pedido, pedido.restoreFromMemento(0).getEstadoSalvo().getNomeEstado(), false);
        PedidoDAO.getInstance().updateEstado(pedido);
    }

}
