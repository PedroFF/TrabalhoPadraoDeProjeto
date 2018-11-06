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
            <th>Pedidos</th>
            <th>Estados</th>
            </thead>
            <c:forEach var="pedido" items="pedidos">
                <tr>
                    <td rowspan="5">
                        ${pedido.usuario}
                        ${pedido.descricao}
                        ${pedido.status}
                        ${pedido.valorLiquido}
                        ${pedido.usuario.endereco}
                    </td>
                    <td rowspan="5">
                        <a href="UaiFat=action?StateAguardandoPedido" class="btn-primary">Aguardando Confirmação</a>
                        <a href="UaiFat=action?StateConfirmaPedido" class="btn-primary">Confirmar Pedido</a>
                        <a href="UaiFat=action?StatePreparandoPedido" class="btn-primary">Preparar Pedido</a>
                        <a href="UaiFat=action?StateSaindoEntrega" class="btn-primary">Entregar Peddo</a>
                        <a href="UaiFat=action?StateConcluido" class="btn-primary">Pedido Concluído</a>
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