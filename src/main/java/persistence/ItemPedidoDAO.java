/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

/**
 *
 * @author pedrofreitas
 */
public class ItemPedidoDAO {

    private Connection conexao;
    private static final ItemPedidoDAO Instance = new ItemPedidoDAO();
    private String SQL_INSERT_ITEM_PEDIDO = "INSERT INTO item_pedido(  fk_pedido,fk_item,quantidade,valortotal) VALUES (?,?,?,?)";
    private String SQL_SELECT_ITEMPEDIDO = "SELECT * FROM ITEM_PEDIDO WHERE FK_PEDIDO = ?";

    public static ItemPedidoDAO getInstance() {
        return Instance;
    }

    private ItemPedidoDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public void adicionarItemPedido(Pedido pedido, ItemPedido item) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_ITEM_PEDIDO)) {
            comando.setInt(1, pedido.getIdPedido());
            comando.setInt(2, item.getProduto().getId());
            comando.setInt(3, item.getQuantidade());
            comando.setDouble(4, item.getValorTotal());
            comando.execute();
            comando.close();
        }
    }
    
        public List<ItemPedido> getItensPedido(int idPedido, int idRestaurante) throws SQLException, ClassNotFoundException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_SELECT_ITEMPEDIDO)) {
            List<ItemPedido> itensPedidos = new ArrayList<>();
            comando.setInt(1, idPedido);
            ResultSet rs = comando.executeQuery();
            if (rs.next()) {
                do {
                    Produto produto = ProdutoDAO.getINSTANCE().getProdutoByID(rs.getInt("fk_item"), idRestaurante);
                    ItemPedido itempedido = new ItemPedido().setProduto(produto).setQuantidade(rs.getInt("quantidade")).setValorItem(rs.getDouble("valorTotal"));
                    itensPedidos.add(itempedido);
                } while (rs.next());
            }
            return itensPedidos;
        }

    }
}
