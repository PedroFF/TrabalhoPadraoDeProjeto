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
import model.UsuarioRestaurante;
import persistence.PedidoDAO;
import persistence.RestauranteDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author Rian Alves
 */
public class StateAguardandoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer idRestaurante = Integer.parseInt((String)request.getSession().getAttribute("usuarioID"));
            UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID(idRestaurante);
            Pedido pedido = PedidoDAO.getInstance().getPedidoByIdByRestaurante(id,restaurante.getIdUsuario());//Confirmar
            PedidoDAO.getInstance().adicionarHistorico(pedido, pedido.getStatus().getDescricao(), true); //Confirmar
            PedidoDAO.getInstance().updateEstado(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(StateAguardandoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
