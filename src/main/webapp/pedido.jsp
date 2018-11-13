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

            </select>
            <input type="hidden" name="restaurante" value="${restaurante.idUsuario}">
        </div>
        <br/><br/><br/>
        <div class="row" id="combo">

            <div class="col">  
                <label for="origem" class="text-center font-weight-bold">Escolha os produtos que deseja em seu lanche: </label>
                <select class="custom-select" size="15" id="origem">
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <option value="${ingrediente.id}">${ingrediente.descricao}</option>
                    </c:forEach>
                </select>

            </div>
            <div class="col btn-group-vertical">
                <br/><br/><br/><br/>
                <button type="button" id="add" class="btn btn-primary" onclick="MoveListBoxItem('origem', 'destino', false)">Adicionar</button>
                <button type="button" id="addAll" class="btn btn-primary" onclick="MoveListBoxItem('origem', 'destino', true)">Adicionar Todos</button>
                <button type="button" id="remove" class="btn btn-danger" onclick="MoveListBoxItem('destino', 'origem', false)">Remover</button>
                <button type="button" id="removeAll" class="btn btn-danger" onclick="MoveListBoxItem('destino', 'origem', true)">Remover Todos</button>
            </div>
            <div class="col">  
                <label for="destino" class="text-center font-weight-bold">Ingredientes Selecionados para o lanche: </label>
                <select multiple="multiple" class="custom-select" name="selecionados" size="15" id="destino">
                </select> 
                <br/>
                <br/>
                <br/>
            </div>
        </div>

        <br/> <br/>
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