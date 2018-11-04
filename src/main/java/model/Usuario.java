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
public abstract class Usuario {
    protected int idUsuario;
    protected String email;
    protected String senha; 
    protected String nome;
    protected String tipo;
    protected Endereco endereco;

    public Usuario(int idUsuario, String email, String senha, String nome, String tipo, Endereco endereco) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
        this.endereco = endereco;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getTipo();

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
