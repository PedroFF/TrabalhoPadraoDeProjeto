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
    
    
    public void observarPedido(Pedido pedido){
        this.pedido = pedido;
        pedido.addObserver(this);
    }
    
    @Override
    public void update(Observable pedidoSubject, Object arg) {
        try {
            Pedido pedidoObject = (Pedido) pedidoSubject;
            new MailJavaSender().senderMail(new MailJava(super.nome,super.email,pedidoObject.getStatus().getDescricao()));
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

    public Observable getPedido() {
        return pedido;
    }

    public void setPedido(Observable pedido) {
        this.pedido = pedido;
    }

    @Override
    public int getIdUsuario() {
        return idUsuario;
    }

    @Override
    public UsuarioCliente setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public UsuarioCliente setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public UsuarioCliente setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public UsuarioCliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public UsuarioCliente setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    public UsuarioCliente setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    
    
    
}
