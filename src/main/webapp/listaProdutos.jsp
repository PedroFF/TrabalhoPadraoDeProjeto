<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navEmpresa.jspf.jspf" %>
    
<table class="table table-stripped">
    <thead>
        <th>Produto</th>
        <th>Descrição</th>
        <th>Preço</th>
    </thead>
    <tbody>
        <c:forEach var="produto" items="${produtos}">
            <tr>
                <td>${produto.descricao}</td>
                <td>${produto.getDescricaoItens()}</td>
                <td>${produto.preco}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<br/>
<br/>
<%@include file="jspf/footer.jspf" %>