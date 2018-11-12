<%@include file="jspf/header.jspf" %>
<%@include file="jspf/nav.jspf" %>

<tbody>
    <c:choose>
        <c:when test="${empty pedidos}">
        <div class="text-center">
            <h2 class="text-danger">Não existem pedidos realizados!</h2>
        </div>
    </c:when>
    <c:otherwise>
        <table class="table table-stripped">
            <thead>
            <th>Pedidos</th>
            <th>Status</th>
            <th>Restaurante</th>
            <th>Detalhes</th>
        </thead>
        <c:forEach var="pedido" items="${pedidos}">
            <tr>
                <td>${pedido.getDescricao()}</td>
                <td>${pedido.status.getDescricao()}</td>
                <td>${pedido.restaurante.nome}</td>
                <td><a href="UaiFat?action=StatusPedido&id=${pedido.idPedido}&idRestaurante=${pedido.restaurante.idUsuario}">Ver mais</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:otherwise>
</c:choose>


<br/>
<br/>
<%@include file="jspf/footer.jspf" %>
