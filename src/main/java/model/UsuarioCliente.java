package model;

import Util.MailJava;
import Util.MailJavaSender;
import java.util.Observable;
import java.util.Observer;

public class UsuarioCliente extends Usuario implements Observer {
    private String cpf;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;
    private String numero;
    private int idUsuarioCliente;
    private Observable pedido;  

    @Override
    public void update(Observable pedidoSubject, Object arg) {
        Pedido pedido = (Pedido) pedidoSubject;
       // new MailJavaSender().sendMail(new MailJava(super.nome,super.email,this.estado));
    }
}
