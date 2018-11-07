<%@include file="jspf/header.jspf" %>
<%@include file="jspf/nav.jspf" %>
    
<table>
    <thead>
        <th>Pedidos</th>
        <th>Detalhes</th>
    </thead>
    <tbody>
        <c:forEach var="pedido" items="${pedidos}">
            <tr>
                <td>${pedido.descricao}</td>
                <td><a href="UaiFat?action=PedidoPost&id=${pedido.idPedido}"></a>Ver mais</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<br/>
<br/>
<%@include file="jspf/footer.jspf" %>
