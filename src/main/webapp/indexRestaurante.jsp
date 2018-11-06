<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navEmpresa.jspf" %>
<div class="container-fluid">
    <br/>
    <h4> Bem-vindo ao UaiFood, ${restaurante.nome}!</h4>
    <p>Abaixo você encontra os pedidos feitos.</p>
    <hr>
</div>
<div class="container-fluid">
    <c:if test="${not empty pedidos}">
        <table class="table table-stripped">
            <thead>
            <th class="text-center">Pedidos</th>
            <th class="text-center">Status</th>
            </thead>
            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <td>
                        Cliente: ${pedido.getUsuario().getNome()}<br/>
                        Descrição: ${pedido.descricao}<br/>
                        Status: ${pedido.status.getDescricao()}<br/>
                        Valor: ${pedido.valorLiquido}<br/>
                        Endereço: ${pedido.usuario.endereco}
                    </td>
                    <td class="text-center">
                        <a href="UaiFat?action=StateConfirmaPedido&id=${pedido.idPedido}" class="btn btn-primary">Confirmar Pedido</a>
                        <a href="UaiFat?action=StatePreparandoPedido&id=${pedido.idPedido}" class="btn btn-primary">Preparar Pedido</a>
                        <a href="UaiFat?action=StateSaindoEntrega&id=${pedido.idPedido}" class="btn btn-primary">Entregar Peddo</a>
                        <a href="UaiFat?action=StateConcluido&id=${pedido.idPedido}" class="btn btn-primary">Pedido Concluído</a>
                        <a href="UaiFat?action=RestaurarAnterior&id=${pedido.idPedido}" class="btn btn-primary">Restaurar Status Anterior</a>
                   </td>
                </tr>
            </c:forEach>  
        </table>
    </c:if>
    <c:if test="${empty pedidos}">
        <div class="text-center">
            <h2 class="text-danger">Não existem pedidos!</h2>
        </div>
    </c:if>
</div>
<br/>
<br/>
<br/>



<%@include file="jspf/footer.jspf" %>