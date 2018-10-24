package model;
import model.Pedido;

public class AguardandoPedidoState implements PedidoState{
    private StrategyInterface state;
    
    public AguardandoPedidoState(){
        this.state = EnumStatePedido.AGUARDANDO;
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
        p.setStatus(new ConfirmacaoState());
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


}
