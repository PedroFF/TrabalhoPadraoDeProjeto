<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navEmpresa.jspf" %>
</head>
<body>
    <div class="row">
        <div class = "col"></div>
        <div class = "col"><br/>
            <center><img src="icone\UAIFOOd.png" id="imagemborda" alt="imagem" align=center height="150"/></center></div>
        <div class = "col"></div>
    </div>
    <div class="container-fluid">
        <form class="form-horizontal" method="post" role="form" action="UaiFat?action=GravarProdutoPost">
            <fieldset>
                <!-- Form Name -->
                <hr>
                <p><h4 class="text-center">Cadastro de Produto</h4></p>
                <!-- Text input-->
                <div class="row">
                    <div class="col"></div>
                    <div class="col">
                        <div class="form-group">
                            <label class="col-md-12 control-label" for="nome">Nome : </label>  
                            <div class="col-md-12">
                                <input id="nome" name="nome" type="text" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-12 control-label" for="tipo">Tipo de Produto : </label>
                            <div class="col-md-12">
                                <select id="tipo" name="tipo" class="form-control">
                                    <option value="INGREDIENTE">INGREDIENTE</option>
                                    <option value="PFINAL" selected="">PRODUTO FINAL</option>

                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-12 control-label" for="preco">Preço : </label>  
                            <div class="col-md-12">
                                <input id="documento" name="preco" type="text" class="form-control input-md" required="">

                            </div>
                        </div>
                    </div>
                    <div class="col"></div>
                </div>
                <br/><br/><br/>
                <div class="row" id="combo">

                    <div class="col">  
                        <label for="origem" class="text-center font-weight-bold">Selecione um Ingrediente para composição do Produto</label>
                        <select class="custom-select" size="15" id="origem">
                            <c:forEach var="ingrediente" items="${ingredientes}">
                                <option value="${ingrediente.id}">${ingrediente.nome}</option>
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
                        <label for="origem" class="text-center font-weight-bold">Ingredientes Selecionados: </label>
                        <select multiple="multiple" class="custom-select" name="selecionados" size="15" id="destino">
                        </select> 
                        <br/>
                        <br/>
                        <br/>
                    </div>
                </div>
                <div class="row">
                    
                    <div class="col"></div>
                    <div class="col">
                        <div class="container-fluid">
                        <button type="submit" id="btnsalvar" name="btnsalvar" class="btn btn-success for" onclick="selectAll('destino')">Salvar</button>              
                        <a href="UaiFat?action=Login" name="btncancelar" class="btn btn-danger">Cancelar</a>
                        </div>
                    </div>
                    <div class="col"></div>
                </div>
                <br/>
            </fieldset>
        </form>
        <br/>    
    </div>
    <%@include file="jspf/footer.jspf" %>
    <script src="js/MoveCombobox.js" ></script>