
package model;

/**
 *
 * @author Rian Alves
 */
public class FormaPagamentoFactory {
    public static FormaPagamento create(String forma, Integer id) {
        FormaPagamento actionObject = null;
        String nomeClasse = "model.FormaPagamento" + forma;
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if(!(objeto instanceof FormaPagamento)) return null;
        actionObject = (FormaPagamento) objeto;
        actionObject.setId(id);
        actionObject.setDescricao(forma);
        return actionObject;
    }
}
