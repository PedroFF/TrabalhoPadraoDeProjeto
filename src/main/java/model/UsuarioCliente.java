/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pedrofreitas
 */
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
        
    }
}
