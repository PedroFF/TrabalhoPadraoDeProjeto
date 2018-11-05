
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

        <link rel="icon" type="image/png" sizes="32x32" href="icone/UAIFOOd.png">

        <title>Login - UAI Food</title>
    </head>
    <body>
        <div class="row">
            <div class="col"></div>
            <div class="col"></div>
            <div class="col"><br/>
                <div class="box-parent-login">
                    <div class="well bg-white box-login">

                        <br/>
                        <img src="icone/UAIFOOd.png" class="rounded mx-auto d-block" width="319" height="239" alt="Imagem">
                        <br/>
                        <br/>
                        <form method="post" action="UaiFat?action=LoginPost">
                            <fieldset>

                                <div class="form-group ls-login-user">
                                    <label for="userLogin">E-mail</label>
                                    <input class="form-control ls-login-bg-user input-lg" id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" name="usuario">
                                </div>

                                <div class="form-group ls-login-password">
                                    <label for="userPassword">Senha</label>
                                    <input class="form-control ls-login-bg-password input-lg" id="userPassword" type="password" aria-label="Senha" placeholder="Senha" name="senha">
                                </div>

                                <div class="form-group ls-login-password">
                                    <label for="userPassword">Tipo</label>
                                    <select id="tipo" name="tipo" class="form-control">
                                        <option value="CLIENTE">CLIENTE</option>
                                        <option value="RESTAURANTE">RESTAURANTE</option>
                                    </select>
                                </div>

                                <center><a href="">Esqueci minha senha</a></center><br/>

                                <input type="submit" value="Entrar" class="btn btn-primary btn-lg btn-block" name="acessar" >

                                <center>Não possui cadastro? </center>
                                <center> <a href="UaiFat?action=GravarUsuario">Cadastre-se agora</a></center>

                            </fieldset>
                        </form>
                    </div>
                    <c:if test="${param.erroLogin == true}">
                        <div class="alert alert-danger" role="alert">
                            <center>Erro ao realizar Login! Verifique a senha!</center>
                        </div>
                    </c:if>
                    <c:if test="${param.sucesso == true}">
                        <div class="alert alert-success" role="alert">
                            <center>Cadastro Realizado com sucesso!</center>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="col"></div>
            <div class="col"></div>
        </div>
    </body>
</html>