/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author pedrofreitas
 */
public class HistoricoPedido {
    private int idHistorico;
    private int idPedido;
    private String estado;
    private Date dataAlteracao;
    private int atual;

    public HistoricoPedido setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
        return this;
    }

    public HistoricoPedido setIdPedido(int idPedido) {
        this.idPedido = idPedido;
        return this;
    }

    public HistoricoPedido setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public HistoricoPedido setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
        return this;
    }

    public HistoricoPedido setAtual(int atual) {
        this.atual = atual;
        return this;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public int getAtual() {
        return atual;
    }
    
    
    
}
