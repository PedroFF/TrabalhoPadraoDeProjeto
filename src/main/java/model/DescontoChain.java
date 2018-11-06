package model;

public class DescontoChain {
   
    protected DescontoChain next;
    protected int qtdItensDesconto;
    protected Double percDesconto;

    public DescontoChain(int qtdItensDesconto, Double percDesconto) {
        this.qtdItensDesconto = qtdItensDesconto;
        this.percDesconto = percDesconto;
    }

    public DescontoChain getNext() {
        return next;
    }

    public DescontoChain setNext(DescontoChain next) {
        this.next = next;
        return next;
    }

    public int getQtdItensDesconto() {
        return qtdItensDesconto;
    }

    public void setQtdItensDesconto(int qtdItensDesconto) {
        this.qtdItensDesconto = qtdItensDesconto;
    }

    public Double calculaDesconto(Pedido p) {
        if (p.getItensPedido().size() <= qtdItensDesconto) {
            return (p.getValorTotal() * percDesconto);
        } else {
            if (next != null) {
                next.calculaDesconto(p);
            }
            return 0.00;
        }

    }

}
