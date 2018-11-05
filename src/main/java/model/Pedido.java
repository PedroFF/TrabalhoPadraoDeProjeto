/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author pedrofreitas
 */
public class Pedido extends Observable {

    private int idPedido;
    private String descricao;
    private PedidoState status;
    private UsuarioRestaurante restaurante;
    private UsuarioCliente usuario;
    private PedidoMemento memento;
    private FormaPagamento formapgto;
    private List<ItemPedido> itensPedido;
    private Double valorTotal;
    private Double valorDesconto;
    private Double valorLiquido;
    

    public Double getValorTotal() {
        if (valorTotal == null) {
            valorTotal = 0.00;
            Iterator itemIterator = itensPedido.iterator();

            while (itemIterator.hasNext()) {
                valorTotal += ((ItemPedido) itemIterator.next()).getValorTotal();
            }
        }
        return valorTotal;
    }

    public Pedido setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Double getValorDesconto() {
        if (valorDesconto == null) {
            valorDesconto = DescontoChain.getInstance().calculaDesconto(this);
        }
        return valorDesconto;
    }

    public Pedido setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
        return this;
    }

    public Double getValorLiquido() {
        if (valorLiquido == null) {
            valorLiquido = calculaValorLiquido();
        }

        return valorLiquido;
    }

    public Pedido setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
        return this;
    }

    public PedidoMemento getMemento() {
        return memento;
    }

    public Pedido setMemento(PedidoMemento memento) {
        this.memento = memento;
        return this;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Pedido setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
        return this;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Pedido setIdPedido(int idPedido) {
        this.idPedido = idPedido;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Pedido setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public PedidoState getStatus() {
        return status;
    }

    public Pedido setStatus(PedidoState status) {
        this.status = status;
        return this;
    }

    public UsuarioRestaurante getRestaurante() {
        return restaurante;
    }

    public Pedido setRestaurante(UsuarioRestaurante restaurante) {
        this.restaurante = restaurante;
        return this;
    }

    public UsuarioCliente getUsuario() {
        return usuario;
    }

    public Pedido setUsuario(UsuarioCliente usuario) {
        this.usuario = usuario;
        return this;
    }

    public void saveToMemento() {
        this.memento = new PedidoMemento(this.status, LocalDateTime.now());
    }

    public void restoreFromMemento() {
        this.status = memento.getState();
    }

    public Double calculaValorLiquido() {
        return this.valorTotal - valorDesconto;
    }

    public FormaPagamento getFormapgto() {
        return formapgto;
    }

    public void setFormapgto(FormaPagamento formapgto) {
        this.formapgto = formapgto;
    }



    
}
