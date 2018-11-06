<%@include file="jspf/header.jspf" %>
<%@include file="jspf/nav.jspf" %>

<form method="post" action="UaiFat=action?ItemPedidoPost">
    <div class="form-group">
        <label>Produto</label>
        <select id="produto" name="produto" class="form-control col-md-4">
            <c:forEach var="produto" items="${produtos}">
                <option value="${produto.descricao}">Produto: ${produto.Ingredientes}, Valor: ${produto.valor}</option>
                <input type="hidden" name="produto" value="${produto.id}">
                <input type="hidden" name="restaurante" value="${restaurante.id}">
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label for="quantidade">Quantidade</label>
        <input type="number" min="0" name="quantidade" id="quantidade" class="form-control col-md-4"/>
    </div>
    <button type="submit" class="btn btn-success">Adicionar Item</button>
</form>
<hr>

<form method="post" action="UaiFat=action?PedidoPost">
    <table class="table table-stripped">
        <thead>
        <th>Produto</th>
        <th>Descrição</th>
        <th>Preço Unitário</th>
        <th>Quantidade</th>
        <th>Preço</th>
        </thead>
        <tbody>
            <c:forEach var="item" items="${itens}">
            <td>${item.produto.descricao}</td>
            <td>${item.produto.Ingredientes}</td>
            <td>${item.preco}</td>
            <td>${item.quantidade}</td>
            <td>${item.valorTotal}</td>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <button type="submit" class="btn btn-success">Concluir Pedido</button>
        <button type="reset" class="btn btn-danger">Esquecer Pedido</button>
    </div>
</form>

<%@include file="jspf/footer.jspf" %>