<%@include file="jspf/header.jspf" %>
<%@include file="jspf/nav.jspf" %>
<div class="container-fluid">
    <br/>
    <br/>
    <form method="post" action="UaiFat?action=ItemPedidoPost">
        <div class="form-group">
            <label>Produto</label>
            <select id="item" name="item" class="form-control col-md-4">
                <c:forEach var="produto" items="${produtos}"> 
                    <option value="${produto.id}">Produto: ${produto.descricao}, Ingredientes: ${produto.getDescricaoItens()}, Valor: ${produto.preco}</option>
                </c:forEach>
                <input type="hidden" name="restaurante" value="${restaurante.idUsuario}">

            </select>
        </div>

        <div class="form-group">
            <label for="quantidade">Quantidade</label>
            <input type="number" min="0" name="quantidade" id="quantidade" placeholder="0" required="" class="form-control col-md-4"/>
        </div>
        <button type="submit" class="btn btn-success">Adicionar Item</button>
    </form>
    <hr>

    <form method="post" action="UaiFat?action=PedidoPost">
        <table class="table table-stripped">
            <thead>
            <th>Produto</th>
            <th>Descrição</th>
            <th>Preço Unitário</th>
            <th>Quantidade</th>
            <th>Preço</th>
            </thead>
            <tbody>
            <div id="item">
                <c:forEach var="item" items="${pedido.itensPedido}">

                    <tr>
                        <td>${item.produto.descricao}</td>
                        <td>${item.produto.getDescricaoItens()}</td>
                        <td>${item.produto.preco}</td>
                        <td>${item.quantidade}</td>
                        <td>${item.valorTotal}</td>
                    </tr>
                </c:forEach>
            </div>
            </tbody>
        </table>
        <br/>
        <br/>
        <div>
            <a href="UaiFat?action=Pagamento" class="btn btn-success">Concluir Pedido</a>
            <button type="reset" id="cancela-pedido" class="btn btn-danger">Esquecer Pedido</button>
        </div>
    </form>
</div>
<br/>
<br/>
<%@include file="jspf/footer.jspf" %>
<script src="js/MoveCombobox.js" ></script>