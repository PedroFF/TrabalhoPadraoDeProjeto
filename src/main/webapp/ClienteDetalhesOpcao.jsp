<%-- 
    Document   : ClienteDetalhesOpcao
    Created on : 04/11/2018, 10:08:42
    Author     : Rian Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="jspf/header.jspf" %>
        <title>Início </title>
    </head>
    <body>
        <%@include file="jspf/nav.jspf" %>
        <br/>

        <div class="container-fluid">
        <div class="row">

            <div class="col"> 
            </div>
            <div class="col"> 
                <center><h4>Detalhes do Pedido </h4></center>
                <h5>${pedido.nome}</h5>
                    ${pedido.imagem}
                 <table class="table table-hover">
                    <thead>
                        <tr >
                            <td colspan="2"></td>
                        </tr> 

                    </thead>
                    <tbody>
                        <c:forEach var="ingrediente" items="${ingredientes}">
                            <tr>
                                <td><center><a href="${ingrediente.id}" target="_blank">${ingrediente.descricao}</center></td> 
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
