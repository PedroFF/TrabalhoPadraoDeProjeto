package model;

import Util.MailJava;
import Util.MailJavaSender;
import java.util.Observable;
import java.util.Observer;

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
        Pedido pedido = (Pedido) pedidoSubject;
       // new MailJavaSender().sendMail(new MailJava(super.nome,super.email,this.estado));
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getTipo() {
        return EnumTipoUsuario.CLIENTE.getDescricao().toUpperCase();
    }
    
    
    
}
