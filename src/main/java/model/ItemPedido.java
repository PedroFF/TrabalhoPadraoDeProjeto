/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jpdia
 */
public class ItemPedido {
    private ProdutoFinal produto;
    private Integer quantidade;
    private Double valorTotal;

    public Double getValorTotal() {
        return valorTotal;
    }

    public ItemPedido setValorItem(Double valorItem) {
        this.valorTotal = valorItem;
        return this;
    }

    public ProdutoFinal getProduto() {
        return produto;
    }

    public ItemPedido setProduto(ProdutoFinal produto) {
        this.produto = produto;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ItemPedido setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }
    
}
