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

    public UsuarioRestaurante(double avaliacao, String email, String senha, String nome, String tipo, Endereco endereco) {
        super(email, senha, nome, tipo, endereco);
        this.avaliacao = avaliacao;
    }

    public UsuarioRestaurante(String email, String senha, String nome, String tipo, Endereco endereco) {
        super(email, senha, nome, tipo, endereco);
    }
    
    
    
  
    public double getAvaliacao() {
        return avaliacao;
    }

    public UsuarioRestaurante setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
        return this;
    }    

    public UsuarioRestaurante setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioRestaurante setEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioRestaurante setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsuarioRestaurante setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioRestaurante setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public UsuarioRestaurante setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }
    
    
}
