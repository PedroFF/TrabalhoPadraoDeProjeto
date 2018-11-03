var addCols = function (colaboradores) {
    for (let i = 0; i < colaboradores.length; i++) {
        var email = colaboradores[i].email;
        var localizacao = typeof colaboradores[i].lugar === "undefined" ? "Não Informado" : colaboradores[i].lugar;
        var botaoEnvio = document.createElement('button');
        botaoEnvio.type = "button";
        botaoEnvio.className = "btn btn-light";
        botaoEnvio.id = i;
        botaoEnvio.title = "Convidar por E-mail";
        botaoEnvio.textContent = "Convidar por E-mail";
        botaoEnvio.addEventListener('click', function () {
            enviaEmail(i, validadores[i].nome, validadores[i].email,validadores[i].id);
        });
        var empresa = typeof colaboradores[i].empresa === "undefined" ? "Não Informado" : colaboradores[i].empresa;
        var myCol = $('<div class="col-sm-4 col-md-4 col-lg-4 pb-2"></div>');
        var myPanel = $('<div class="card text-white bg-success mb-4" style="max-width: 18rem">'
                + '<img class="card-img-top" src="' + colaboradores[i].foto_url + '" alt="Card image cap">'
                + '<div class="card-header"><h4>' + colaboradores[i].nome + '</h4></div>'
                + '<div class="card-body" id="body' + i + '">'
                + '<h6>E-mail: ' + email + '</h6>'
                + '<h6>Seguidores: ' + colaboradores[i].seguidores + '</h6>'
                + '<h6>Localização: ' + localizacao + '</h6>'
                + '<h6>Empresa: ' + empresa + '</h6>'
                + '<h6>Link do Perfil: <a target="_blank" class="text-white" href="' + colaboradores[i].perfil_url + '">' + colaboradores[i].perfil_url + '</a></h6>'
                + '<h6>Contribuições (Commits Totais): ' + colaboradores[i].contribuicoes + '</h6>'
                + '<h6>Presença: ' + colaboradores[i].presenca + '</h6>'
                + '</div>'
                + '</div>');
       
        myPanel.appendTo(myCol);
        myCol.appendTo('#contentPanel');
        document.getElementById("body"+i).append(botaoEnvio);
    }
};


$(document).ready(function () {
    addCols(validadores);
});

function enviaEmail(id,nome, email,idUsuario) {
    $("#" + id).text("Enviando Convite. Aguarde...");
    $("#" + id).prop("disabled",true);
    var grupo = sessionStorage.getItem("grupo");
    $.ajax({
        url: 'ajaxEmail.html',
        data: {
            nome: nome,
            email: "soufreitas.pedro@gmail.com",
            contexto: contexto,
            login:email,
            id:idUsuario,
            idGrupo:grupo
        },
        type: 'post',
        success: function (data) {
            $("#" + id).text("Convite Enviado");
        }
    });

}


