package model;

public class CanceladoState implements PedidoState {

    private StrategyInterface state;

    public CanceladoState() {
        this.state = EnumStatePedido.CANCELADO;
    }

    @Override
    public String getDescricao() {
        return this.state.getDescricao();
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

    public CanceladoState setState(StrategyInterface state) {
        this.state = state;
        return this;
    }

    @Override
    public String getStatus() {
        return this.state.getStatus();
    }
}
