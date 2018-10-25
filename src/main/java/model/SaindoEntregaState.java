package model;

import model.Pedido;

public class SaindoEntregaState implements PedidoState{
    private StrategyInterface state;
    
    public SaindoEntregaState(){
        this.state=EnumStatePedido.SAINDOENTREGA;
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
        p.setStatus(new PreparandoState());
    }

    @Override
    public void sairParaEntrega(Pedido p) throws EstadoNaoPermitidoException {
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public void concluirPedido(Pedido p) throws EstadoNaoPermitidoException {
        p.setStatus(new ConcluidoState());
    }

    @Override
    public String getDescricao() {
        return this.state.getDescricao();
    }
}