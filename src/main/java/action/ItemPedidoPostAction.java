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
import model.ItemPedido;
import model.Pedido;
import model.ProdutoFinal;
import model.UsuarioRestaurante;
import persistence.ProdutoDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author pedrofreitas
 */
public class ItemPedidoPostAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            int idProduto = Integer.parseInt(request.getParameter("item"));
            int idRestaurante = Integer.parseInt(request.getParameter("restaurante"));
            UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID(idRestaurante);
            List<ProdutoFinal> produtos = ProdutoDAO.getINSTANCE().getAllProdutos(idRestaurante);
            ProdutoFinal produto = ProdutoDAO.getINSTANCE().getProdutoByID(idProduto,restaurante.getIdUsuario());
            Double preco = produto.getPreco();
            Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProduto(produto).setValorItem(preco*quantidade).setQuantidade(quantidade);
            pedido.getItensPedido().add(itemPedido);
            String ingredientes = pedido.getItensPedido().toString();
            request.getSession().setAttribute("pedido", pedido);
            request.setAttribute("ingredientes", ingredientes);
            request.setAttribute("produtos", produtos);
            request.setAttribute("pedido", pedido);
            request.setAttribute("restaurante", restaurante );
            request.getRequestDispatcher("pedido.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ItemPedidoPostAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
