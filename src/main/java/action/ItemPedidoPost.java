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
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.UsuarioRestaurante;
import persistence.ProdutoDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author pedrofreitas
 */
public class ItemPedidoPost implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID(Integer.parseInt(request.getParameter("restaurante")));
            Produto produto = ProdutoDAO.getINSTANCE().getProdutoByID(Integer.parseInt(request.getParameter("produto")), restaurante.getIdUsuario());
            Double preco = produto.getPreco();
            Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProduto(produto).setValorItem(preco*quantidade).setQuantidade(quantidade);
            pedido.getItensPedido().add(itemPedido);
            request.getSession().setAttribute("pedido", pedido);
            request.setAttribute("pedido", pedido);
            request.getRequestDispatcher("pedido.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ItemPedidoPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
