
<%@include file="jspf/header.jspf" %>
<%@include file="jspf/nav.jspf" %>
<br/>

<div class="container-fluid">
    <div class="row">

        <div class="col"> 
        </div>
        <div class="col"> 
            <center><h5>Escolha o Estabelecimento para Realizar o Pedido</h5></center>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <td colspan="2"></td>
                    </tr> 

                </thead>
                <tbody>
                    <c:forEach var="restaurante" items="${restaurantes}">
                        <tr>
                            <td><center><a href="UaiFat=action?Pedido">${restaurante.nome}</center></td> 
                <input type="hidden" name="idRestaurante" value="${restaurante.id}">
                <td><center><img src="${restaurante.imagem}" id="imagemborda" alt="imagem " width="42" height="42"></center></td> 
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
        <div class="col"> 
        </div>
    </div>
</div>

<br/>
<%@include file="jspf/footer.jspf" %>
