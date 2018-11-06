
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
                        <td><center><a href="UaiFat?action=Pedido&idRestaurante=${restaurante.idUsuario}">${restaurante.nome}</center></td> 
                        <td><center><img src="" id="imagemborda" alt="imagem_restaurante" width="42" height="42"></center></td> 
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
