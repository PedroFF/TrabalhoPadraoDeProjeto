package model;

public class EstadoNaoPermitidoException extends Exception {

    @Override
    public String getMessage() {
        return "Mudança de Status não permitida";
    }
    
}
