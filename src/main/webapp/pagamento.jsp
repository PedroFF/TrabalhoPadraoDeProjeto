<%@include file="jspf/header.jspf" %>
<%@include file="jspf/nav.jspf" %>
<div class="container-fluid">
    <br/>
    <br/>
    
    <form method="post" action="UaiFat?action=PedidoPost">
        <div>
            <h5>Valor Total: ${pedido.valorTotal}</h5>
            <h5>Valor Desconto: ${pedido.valorDesconto} </h5>
            <h5>Valor Final: ${pedido.valorLiquido}</h5>
        </div>
        <hr>
        <div class="form-group">
            <label><h5>Forma de Pagamento</h5></label>
            <select name="pagamento" class="form-control col-md-4">
                <c:forEach var="pagamento" items="${formaPagamentos}">
                    <option value="${pagamento.descricao}"> ${pagamento.getDadosPagamento()}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Confirmar Pagamento</button>
    </form>

</div>
<br/>
<br/>

<%@include file="jspf/footer.jspf" %>

