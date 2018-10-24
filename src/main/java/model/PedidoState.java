package model;

import model.Pedido;

public interface PedidoState {

    public void aguardarConfirmacao(Pedido p) throws EstadoNaoPermitidoException;

    public void confirmarPedido(Pedido p) throws EstadoNaoPermitidoException;

    public void prepararPedido(Pedido p) throws EstadoNaoPermitidoException;

    public void sairParaEntrega(Pedido p) throws EstadoNaoPermitidoException;

    public void concluirPedido(Pedido p) throws EstadoNaoPermitidoException;

    public String getDescricao();

}
