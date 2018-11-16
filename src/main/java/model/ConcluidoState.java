package model;

import model.Pedido;

public class ConcluidoState implements PedidoState {

    private StrategyInterface state;

    public ConcluidoState() {
        this.state = EnumStatePedido.CONCLUIDO;
    }

    @Override
    public void aguardarConfirmacao(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public void confirmarPedido(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public void prepararPedido(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public void sairParaEntrega(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public void concluirPedido(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public void cancelarPedido(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public String getDescricao() {
        return this.state.getDescricao();
    }

    public ConcluidoState setState(StrategyInterface state) {
        this.state = state;
        return this;
    }

    @Override
    public String getStatus() {
        return this.state.getStatus();
    }
}
