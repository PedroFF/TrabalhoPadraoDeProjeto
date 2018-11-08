package model;

import java.math.BigDecimal;

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
            BigDecimal bd = new BigDecimal(p.getValorTotal() * percDesconto);
            bd.setScale(2,BigDecimal.ROUND_DOWN);
            return bd.doubleValue();
        } else {
            if (next != null) {
                next.calculaDesconto(p);
            }
            return 0.00;
        }

    }

}
