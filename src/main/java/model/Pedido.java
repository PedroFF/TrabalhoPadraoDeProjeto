/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author pedrofreitas
 */
public class Pedido {
    private int idPedido;
    private String descricao;
    private PedidoState status;
    private Restaurante restaurante;
    private Usuario usuario;
    private PedidoMemento memento;
    private List<ItemPedido> itensPedido;
    private Double valorTotal;
    private Double valorDesconto;
    private Double valorLiquido;

    public Double getValorTotal() {
        if(valorTotal==null){
            valorTotal =0.00;
            for (ItemPedido itemPedido : itensPedido) {
                valorTotal+=itemPedido.getValorItem();
            }
        }
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }
    
     

    public PedidoMemento getMemento() {
        return memento;
    }

    public void setMemento(PedidoMemento memento) {
        this.memento = memento;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
    
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PedidoState getStatus() {
        return status;
    }

    public void setStatus(PedidoState status) {
        this.status = status;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void saveToMemento(){
       this.memento = new PedidoMemento(this.status,LocalDateTime.now());
    }
    
    public void restoreFromMemento(){
        this.status = memento.getState();
    }
    
}
