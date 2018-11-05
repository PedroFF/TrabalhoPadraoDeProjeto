
package model;

/**
 *
 * @author Rian Alves
 */
public class FormaPagamentoFactory {
    public static FormaPagamento create(String action) {
        FormaPagamento actionObject = null;
        String nomeClasse = "FormaPagamento" + action;
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
        return actionObject;
    }
}
