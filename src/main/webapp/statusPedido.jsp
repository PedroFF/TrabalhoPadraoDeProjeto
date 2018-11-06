<%@include file="jspf/header.jspf" %>
<%@include file="jspf/nav.jspf" %>
<div class="container-fluid">
    <br/>
    <br/> 
    <div class="container-fluid">
        <div class="row">
            <h3> Status do pedido: ${pedido.status.getDescricao()}</h3>
        </div>
        <br/>
        <br/>
        <div class="row">
            <h5>Valor Total: ${pedido.valorTotal}</h5><br/>
        </div> 
        <div class="row">
            <h5>Valor Desconto: ${pedido.valorDesconto} </h5><br/>
        </div> 
        <div class="row">
            <h5>Valor Final: ${pedido.valorLiquido}</h5><br/>

        </div> 
        <div class="row">
            <h5>Forma de Pagamento: ${pedido.formapgto.descricao}</h5><br/>

        </div> 
    </div>
    <br/>
    <br/>
    <div class="row">
        <table class="table table-stripped">
            <thead>
            <th>Produto</th>
            <th>Preço Unitário</th>
            <th>Quantidade</th>
            <th>Valor total do item</th>
            </thead>
            <tbody>
            <div id="item">
                <c:forEach var="item" items="${pedido.itensPedido}">

                    <tr>
                        <td>${item.produto.descricao}</td>
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
    </div>
</div>
            <br/>
            <br/>
<%@include file="jspf/footer.jspf" %>