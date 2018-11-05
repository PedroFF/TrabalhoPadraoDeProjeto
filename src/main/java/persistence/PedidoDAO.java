package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import model.ItemPedido;
import model.Pedido;
import model.StateFactory;

public class PedidoDAO {

    private Connection conexao;
    private static final PedidoDAO INSTANCE = new PedidoDAO();
    private String SQL_INSERT_PEDIDO = "INSERT INTO pedido(descricao,status,valorpedido,valordesconto,valorliquido,fk_forma_pagamento,fk_pedido_cliente,fk_pedido_restaurante) VALUES (?,?,?,?,?,?,?,?)";
    private String SQL_INSERT_PEDIDO_HISTORICO = "INSERT INTO historico_pedido(fk_pedido,estado,data_alteracao,atual) VALUES (?,?,?,?)";
    private String SQL_INSERT_ITEM_PEDIDO = "INSERT INTO item_pedido(  fk_pedido,fk_item,quantidade,valortotal) VALUES (?,?,?,?)";
    private String SQL_UPDATE_STATE_PEDIDO = "UPDATE PEDIDO SET STATUS = ? WHERE ID_PEDIDO = ? ";
    private String SQL_SELECT_ALL_PEDIDOS_POR_RESTAURANTE = "SELECT id_pedido FROM PEDIDO WHERE FK_RESTAURANTE = ?";
    private String SQL_SELECT_PEDIDO_POR_ID = "SELECT * FROM PEDIDO WHERE id_pedido = ? and fk_restaurante = ?";
	private String SQL_SELECT_ITEMPEDIDO = "SELECT * FROM ITEM_PEDIDO WHERE FK_PEDIDO = ?";
    private String SQL_SELECT_ESTADO_POSTERIOR = "SELECT * FROM HISTORICO_PEDIDO WHERE FK_ALUNO = ? AND ID < (SELECT ID FROM HISTORICO_PEDIDO WHERE ATUAL = TRUE AND FK_PEDIDO= ?) ORDER BY ID DESC";
    private String SQL_SELECT_ESTADO_ANTERIOR = "SELECT * FROM HISTORICO_PEDIDO WHERE FK_ALUNO = ? AND ID > (SELECT ID FROM HISTORICO_PEDIDO WHERE ATUAL = TRUE AND FK_PEDIDO = ?) ORDER BY ID ASC";
    private String SQL_UPDATE_ATUAL = "UPDATE HISTORICO_PEDIDO SET ATUAL = ? WHERE ID = ? AND FK_PEDIDO = ?";
    private String SQL_SELECT_ATUAL = "SELECT ID FROM HISTORICO_PEDIDO WHERE ATUAL = TRUE AND FK_PEDIDO = ?";

    public static PedidoDAO getInstance() {
        return INSTANCE;
    }

    private PedidoDAO() {
        this.conexao = DatabaseLocator.getInstance().getConnection();
    }

    public void adicionar(Pedido pedido) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_PEDIDO, Statement.RETURN_GENERATED_KEYS)) {
            comando.setString(1, pedido.getDescricao());
            comando.setString(2, pedido.getStatus().getDescricao());
            comando.setDouble(3, pedido.getValorTotal());
            comando.setDouble(4, pedido.getValorDesconto());
            comando.setDouble(5, pedido.getValorLiquido());
            comando.setInt(6, pedido.getFormapgto().getId());
            comando.setInt(7, pedido.getUsuario().getIdUsuario());
            comando.setInt(8, pedido.getRestaurante().getIdUsuario());
            comando.execute();
            ResultSet rs = comando.getGeneratedKeys();

            if (rs.next()) {
                Integer id = rs.getInt(1);
                pedido.setIdPedido(id);
                Iterator iter = pedido.getItensPedido().iterator();
                while (iter.hasNext()) {
                    this.adicionarItemPedido(pedido, (ItemPedido) iter.next());
                }
                adicionarHistorico(pedido, pedido.getStatus().getDescricao(), true);
            }
            comando.close();
        }
    }

    public void adicionarHistorico(Pedido pedido, String estado, boolean ativo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = DatabaseLocator.getInstance().getConnection();
        Integer atual = this.getAtual(pedido.getIdPedido());
        if (atual != 0) {
            this.setAtual(atual, false, pedido.getIdPedido());
        }
        stmt = conn.prepareStatement(SQL_INSERT_PEDIDO_HISTORICO);
        stmt.setInt(1, pedido.getIdPedido());
        stmt.setString(2, estado);
        stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        stmt.setBoolean(4, ativo);
        stmt.execute();
        stmt.close();
        conn.close();

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

    public void updateEstado(Pedido pedido) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = DatabaseLocator.getInstance().getConnection();
        stmt = conn.prepareStatement(SQL_UPDATE_STATE_PEDIDO);
        stmt.setString(1, pedido.getStatus().getDescricao());
        stmt.setInt(2, pedido.getIdPedido());
        stmt.execute();

    }

    public List<Pedido> getAllPedidosByRestaurante(int idRestaurante) {
	
    }

    public Pedido getPedidoByIdByRestaurante(int idPedido, int idRestaurante) {
			Pedido pedido = null;
			try (PreparedStatement comando = conexao.prepareStatement(SQL_SELECT_PEDIDO_POR_ID)) {
            comando.setInt(1, idPedido);
            comando.setInt(2, idRestaurante);
			comando.setMaxRows(1);
			ResultSet rs = comando.executeQuery();
			if (rs.next()) {
				do{
					List<ItemPedido> itens = this.getItensPedido(idPedido, idRestaurante);
					PedidoState state = StateFactory.create(rs.getString("estado");
					UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID(idRestaurante);
					UsuarioCliente cliente = UsuarioDAO.getInstance().getUsuarioRestauranteByID(rs.getInt("fk_usuario_cliente ");
					FormaPagamento formapgto = FormaFactory.create(rs.getString(descricao));
					pedido = new Pedido().setValorTotal(rs.getDouble("valorPedido"))
					.setValorDesconto(rs.getDouble("valorDesconto"))
					.setValorLiquido(rs.getDouble("valorLiquido"))
					.setItensPedido(itens)
					.setIdPedido(rs.getInt("id_pedido"))
					.setDescricao(rs.getString("descricao"))
					.setStatus(state)
					.setRestaurante(restaurante)
					.setUsuario(cliente)
					.setFormapgto(formapgto)
				}while(rs.next);
				
			}
			}
    }
	
	public List<ItemPedido> getItensPedido(int idPedido, int idRestaurante){
		try (PreparedStatement comando = conexao.prepareStatement(SQL_SELECT_ITEMPEDIDO)) {
			List<ItemPedido> itensPedidos = new ArrayList<>();
			comando.setInt(1,idPedido);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				do{
					Produto produto = ProdutoDAO.getProdutoByID(rs.getInt(fk_pedido),idRestaurante);
					ItemPedido itempedido = new ItemPedido().setProduto(produto).setQuantidade(rs.getInt("quantidade ")).setValorTotal(rs.getInt("valorTotal"));
					itensPedidos.add(itempedido);
				}while(rs.next);
			}
			return itensPedidos;
		}
		
	}
    public void restaurarEstadoPedido(Pedido pedido) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = DatabaseLocator.getInstance().getConnection();
        stmt = conn.prepareStatement(SQL_SELECT_ESTADO_ANTERIOR);
        stmt.setInt(1, pedido.getIdPedido());
        stmt.setInt(2, pedido.getIdPedido());
        stmt.setMaxRows(1);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            pedido.setStatus(StateFactory.create(rs.getString("estado")));
            Integer antigo = this.getAtual(pedido.getIdPedido());
            this.setAtual(rs.getInt("id"), true, pedido.getIdPedido());
            this.setAtual(antigo, false, pedido.getIdPedido());
            this.updateEstado(pedido);
        }

    }

    public void restaurarEstadoPedidoPosterior(Pedido pedido) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = DatabaseLocator.getInstance().getConnection();
        stmt = conn.prepareStatement(SQL_SELECT_ESTADO_POSTERIOR);
        stmt.setInt(1, pedido.getIdPedido());
        stmt.setInt(2, pedido.getIdPedido());
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            pedido.setStatus(StateFactory.create(rs.getString("estado")));
            Integer antigo = this.getAtual(pedido.getIdPedido());
            this.setAtual(rs.getInt("id"), true, pedido.getIdPedido());
            this.setAtual(antigo, false, pedido.getIdPedido());
            this.updateEstado(pedido);
        }
    }

    public void setAtual(Integer id, boolean atual, Integer id_pedido) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = DatabaseLocator.getInstance().getConnection();
        stmt = conn.prepareStatement(SQL_UPDATE_ATUAL);
        stmt.setInt(1, id);
        stmt.setInt(2, id_pedido);
        stmt.execute();
    }

    public Integer getAtual(Integer id_pedido) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = DatabaseLocator.getInstance().getConnection();
        String sql = "SELECT ID FROM ALUNO_HISTORICO_ESTADO WHERE ATUAL = TRUE AND FK_ALUNO = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_pedido);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_historico_pedido");
        }
        return 0;
    }

}
