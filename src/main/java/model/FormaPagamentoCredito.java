
package model;

/**
 *
 * @author Rian Alves
 */
public class FormaPagamentoCredito extends FormaPagamento {

    public FormaPagamentoCredito(int id, String descricao) {
        super(id, descricao);
    }

    @Override
    public String getDescricaoCompleta() {
        return " da máquina de Cartão. Compras acima de R$ 200,00 poderão ser parceladas";
    }
    
}
