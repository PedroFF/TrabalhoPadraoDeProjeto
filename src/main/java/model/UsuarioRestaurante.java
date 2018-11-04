/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedrofreitas
 */
public class UsuarioRestaurante extends Usuario {
    private double avaliacao;

    public UsuarioRestaurante(int idUsuario, String email, String senha, String nome, String tipo, Endereco endereco, Double avaliacao) {
        super(idUsuario, email, senha, nome, tipo, endereco);
        this.avaliacao = avaliacao;
    }

  
    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String getTipo() {
        return EnumTipoUsuario.RESTAURANTE.getDescricao().toUpperCase();
    }
    
    
    
}
