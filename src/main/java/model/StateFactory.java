package model;

public class StateFactory {
    public static PedidoState create(String state){
        PedidoState stateObject = null;
        String nomeClasse = "model."+state+"State";
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if(!(objeto instanceof PedidoState)) return null;
        stateObject = (PedidoState) objeto;
        return stateObject;
    }
}
