<%-- 
    Document   : ClienteOpcoes
    Created on : 04/11/2018, 10:01:16
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
                <center><h5>Clique no Item para mais detalhes e realização do Pedido</h5></center>
                 <table class="table table-hover">
                    <thead>
                        <tr >
                            <td colspan="2"></td>
                        </tr> 

                    </thead>
                    <tbody>
                        <c:forEach var="produto" items="${produtos}">
                            <tr>
                                <td><center><a href="${produto.id}" target="_blank">${produto.descricao}</center></td> 
                                <td><center><img src="${produto.imagem}" id="imagemborda" alt="imagem " width="42" height="42"></center></td> 
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
