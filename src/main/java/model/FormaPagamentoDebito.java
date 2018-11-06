/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rian Alves
 */
public class FormaPagamentoDebito extends FormaPagamento {

    public FormaPagamentoDebito(int id, String descricao) {
        super(id, descricao);
    }

    public FormaPagamentoDebito() {
    }
    
    

    @Override
    public String getDescricaoCompleta() {
    return " da máquina de Cartão. Pagamento apenas a Vista ";  
    }
    
}
