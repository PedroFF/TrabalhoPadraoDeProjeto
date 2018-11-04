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
public class Usuario {
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

    public Usuario(String email, String senha, String nome, String tipo, Endereco endereco) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
        this.endereco = endereco;
    }
    
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public Usuario setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    
    
    public Usuario setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }
    
    
}
