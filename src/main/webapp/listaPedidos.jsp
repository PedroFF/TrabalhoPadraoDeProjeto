<%@include file="jspf/header.jspf" %>
<%@include file="jspf/nav.jspf" %>
    
<table class="table table-stripped">
    <thead>
        <th>Pedidos</th>
        <th>Detalhes</th>
    </thead>
    <tbody>
        <c:forEach var="pedido" items="${pedidos}">
            <tr>
                <td>${pedido.descricao}</td>
                <td><a href="UaiFat?action=PedidoPost&id=${pedido.idPedido}">Ver mais</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<br/>
<br/>
<%@include file="jspf/footer.jspf" %>
