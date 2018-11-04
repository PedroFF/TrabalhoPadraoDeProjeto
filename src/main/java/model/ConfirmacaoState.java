package model;

import model.Pedido;

public class ConfirmacaoState implements PedidoState{
    
    private StrategyInterface state;
    
    public ConfirmacaoState(){
        this.state = EnumStatePedido.CONFIRMACAO;
    }

    @Override
    public void aguardarConfirmacao(Pedido p) throws EstadoNaoPermitidoException {
       p.setStatus(new AguardandoPedidoState());
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
        throw new EstadoNaoPermitidoException();
    }

    @Override
    public String getDescricao() {
        return this.state.getDescricao();
    }
    
    public ConfirmacaoState setState(StrategyInterface state){
        this.state = state;
        return this;
    }
}
