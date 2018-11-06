package model;

import model.Pedido;

public class PreparandoState implements PedidoState {

    private StrategyInterface state = EnumStatePedido.PREPARANDO;

    @Override
    public void aguardarConfirmacao(Pedido p) throws EstadoNaoPermitidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirmarPedido(Pedido p) throws EstadoNaoPermitidoException {
        p.setStatus(new PreparandoState());
    }

    @Override
    public void prepararPedido(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public void sairParaEntrega(Pedido p) throws EstadoNaoPermitidoException {
        p.setStatus(new SaindoEntregaState());
    }

    @Override
    public void concluirPedido(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public String getDescricao() {
        return this.state.getDescricao();
    }

    public PreparandoState setState(StrategyInterface state) {
        this.state = state;
        return this;
    }

    @Override
    public String getStatus() {

        return this.state.getStatus();
    }

}
