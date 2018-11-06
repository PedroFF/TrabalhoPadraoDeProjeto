package model;

import Util.MailJava;
import Util.MailJavaSender;
import java.io.UnsupportedEncodingException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

public class UsuarioCliente extends Usuario implements Observer {
    private Observable pedido;  
    private String cpf;

    public UsuarioCliente(int idUsuario, String email, String senha, String nome, String tipo, Endereco endereco, String cpf) {
        super(idUsuario, email, senha, nome, tipo, endereco);
        this.cpf = cpf;
    }

    public UsuarioCliente(String cpf, String email, String senha, String nome, String tipo, Endereco endereco) {
        super(email, senha, nome, tipo, endereco);
        this.cpf = cpf;
    }
    
    

    
    @Override
    public void update(Observable pedidoSubject, Object arg) {
        try {
            Pedido pedido = (Pedido) pedidoSubject;
            new MailJavaSender().senderMail(new MailJava(super.nome,super.email,pedido.getStatus().getDescricao()));
        } catch (UnsupportedEncodingException | MessagingException ex) {
            Logger.getLogger(UsuarioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCpf() {
        return cpf;
    }

    public UsuarioCliente setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    
    
    
}
