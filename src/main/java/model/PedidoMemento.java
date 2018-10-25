
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

    public void setState(PedidoState state) {
        this.state = state;
    }

    public LocalDateTime getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(LocalDateTime data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
