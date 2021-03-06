<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navEmpresa.jspf" %>
<div class="container-fluid">
    <br/>
    <h4> Bem-vindo ao UaiFood, ${restaurante.nome}!</h4>
    <p>Abaixo voc� encontra os pedidos feitos.</p>
    <hr>
</div>
<div class="container-fluid">
    <c:if test="${not empty pedidos}">
        <c:if test="${not empty ErroPedido}">
            <div class="alert alert-danger" role="alert">
                ${ErroPedido}
            </div>
        </c:if>
        <table class="table table-stripped table-responsive">
            <thead>
            <th class="text-center">Pedidos</th>
            <th class="text-center">Status</th>
            </thead>
            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <td>
                        ID: ${pedido.idPedido}<br/>
                        Cliente: ${pedido.getUsuario().getNome()}<br/>
                        Descri��o: ${pedido.descricao}<br/>
                        Status: ${pedido.status.getDescricao()}<br/>
                        Valor: ${pedido.valorLiquido}<br/>
                        Endere�o: ${pedido.usuario.endereco}
                    </td>
                    <td class="text-center">
                        <a href="UaiFat?action=StateConfirmaPedido&id=${pedido.idPedido}" class="btn btn-primary">Confirmar</a>
                        <a href="UaiFat?action=StatePreparandoPedido&id=${pedido.idPedido}" class="btn btn-primary">Preparar</a>
                        <a href="UaiFat?action=StateSaindoEntrega&id=${pedido.idPedido}" class="btn btn-primary">Entregar</a>
                        <a href="UaiFat?action=StateConcluido&id=${pedido.idPedido}" class="btn btn-primary">Concluir</a>
                        <a href="UaiFat?action=StateCancelado&id=${pedido.idPedido}" class="btn btn-primary">Cancelar</a>
                        <a href="UaiFat?action=RestaurarAnterior&id=${pedido.idPedido}" class="btn btn-primary">Restaurar Status Anterior</a>
                        <a href="UaiFat?action=RestaurarPosterior&id=${pedido.idPedido}" class="btn btn-primary">Restaurar Status Posterior</a>
                    </td>
                </tr>
            </c:forEach>  
        </table>
    </c:if>
    <c:if test="${empty pedidos}">
        <div class="text-center">
            <h2 class="text-danger">N�o existem pedidos!</h2>
        </div>
    </c:if>
</div>
<br/>
<br/>
<br/>



<%@include file="jspf/footer.jspf" %>