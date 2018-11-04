<%-- 
    Document   : CadastroUsuario
    Created on : 04/11/2018, 10:31:16
    Author     : Rian Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="jspf/header.jspf" %>
<title>Cadastro de Usuário</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="row">
        <div class = "col"></div>
        <div class = "col"><center><h1>UAI Food</h1></center><br/>
            <center><img src="icone\UAIFOOd.png" id="imagemborda" alt="imagem" align=center height="150"/></center></div>
        <div class = "col"></div>
    </div>
    <div>
        <form class="form-horizontal" method="post" role="form" action="UaiFat?action=GravarUsuarioPost">
            <fieldset>

                <!-- Form Name -->
                <legend>Cadastro de Usuário</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="nome">Nome : </label>  
                    <div class="col-md-6">
                        <input id="nome" name="nomeUsuario" type="text" placeholder="" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="tipo">Tipo de Usuário : </label>
                    <div class="col-md-4">
                        <select id="tipo" name="tipo" class="form-control">
                            <option value="CLIENTE">CLIENTE</option>
                            <option value="RESTAURANTE">RESTAURANTE</option>

                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-md-4 control-label" for="documento">CPF/ CNPJ : </label>  
                    <div class="col-md-2">
                        <input id="documento" name="documento" type="text" class="form-control input-md" required="">

                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="rua">Rua : </label>  
                    <div class="col-md-2">
                        <input id="rua" name="rua" type="text" class="form-control input-md" required="">

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="numero">Número : </label>  
                    <div class="col-md-2">
                        <input id="numero" name="numero" type="text" class="form-control input-md" required="">

                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-4 control-label" for="complemento">Bairro: </label>  
                    <div class="col-md-2">
                        <input id="bairro" name="bairro" type="text" class="form-control input-md" required="">

                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="complemento">Complemento : </label>  
                    <div class="col-md-2">
                        <input id="complemento" name="complemento" type="text" class="form-control input-md" required="">

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cep">CEP : </label>  
                    <div class="col-md-2">
                        <input id="cep" name="cep" type="text" class="form-control input-md" required="">

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cidade">Cidade : </label>  
                    <div class="col-md-2">
                        <input id="cidade" name="cidade" type="text" class="form-control input-md" required="">

                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="selectEstado">Estado : </label>
                    <div class="col-md-4">
                        <select id="estado" name="selectEstado" class="form-control">
                            <option value="RJ">RJ</option>
                            <option value="MG">MG</option>
                            <option value="SP">SP</option>
                            <option value="ES">ES</option>
                            <option value="BA">BA</option>
                            <option value="PB">PB</option>

                        </select>
                    </div>
                </div>


                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">Email : </label>  
                    <div class="col-md-4">
                        <input id="email" name="email" type="text" placeholder="" class="form-control input-md">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="senha">Senha : </label>  
                    <div class="col-md-2">
                        <input id="senha" name="senha" type="text" placeholder="" class="form-control input-md" required="">

                    </div>
                </div>




                <!-- Button (Double) -->
                <div class="form-group row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <button type="submit" id="btnsalvar" name="btnsalvar" class="btn btn-primary">Salvar</button>              
                        <a href="UaiFat?action=Login" name="btncancelar" class="btn btn-danger">Cancelar</a>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </fieldset>
        </form>
        <br/>    
    </div>
    <%@include file="jspf/footer.jspf" %>
