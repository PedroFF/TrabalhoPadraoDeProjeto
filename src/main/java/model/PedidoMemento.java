
package model;

import java.time.LocalDateTime;


public class PedidoMemento {
    private PedidoState state;
    private LocalDateTime data_alteracao;
    private Integer id;

    public PedidoMemento(PedidoState state, LocalDateTime data_alteracao, Integer id) {
        this.state = state;
        this.data_alteracao = data_alteracao;
        this.id = id;
    }

    public PedidoMemento(PedidoState state, LocalDateTime data_alteracao) {
        this.state = state;
        this.data_alteracao = data_alteracao;
    }
    
    
    public PedidoState getState() {
        return state;
    }

    public PedidoMemento setState(PedidoState state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getData_alteracao() {
        return data_alteracao;
    }

    public PedidoMemento setData_alteracao(LocalDateTime data_alteracao) {
        this.data_alteracao = data_alteracao;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public PedidoMemento setId(Integer id) {
        this.id = id;
        return this;
    }
    
    
}
