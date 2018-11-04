
package model;

/**
 *
 * @author Rian Alves
 */
public class FormaPagamentoDinheiro extends FormaPagamento {

    public FormaPagamentoDinheiro(int id, String descricao) {
        super(id, descricao);
    }

    @Override
    public String getDescricaoCompleta() {
        return " de levar o troco. Confira também quando entregar ";}
    
}
