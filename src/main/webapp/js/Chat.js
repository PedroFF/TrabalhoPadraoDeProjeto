
var dados = chat.mensagens;
var grupo = chat.grupo;

function adicionaMensagem(mensagem) {
     var imagem = typeof mensagem.usuario.foto_url === "undefined" ? "http://placehold.it/50/55C1E7/fff&text=U" : mensagem.usuario.foto_url;
        if (usuario === mensagem.usuario.id) {
            $("#chat").append('<li class="right clearfix"><span class="chat-img pull-right">' +
                    '<img src="' + imagem + '" alt="User Avatar" class="img-circle" width="70" height="70" /></span>' +
                    '<div class="chat-body clearfix"><div class="header"><small class=" text-muted"><span class="glyphicon glyphicon-time"></span>' + mensagem.data_hora + '</small>' +
                    '<strong class="pull-right primary-font">' + mensagem.usuario.nome + '</strong></div><p>' + mensagem.texto + '</p></div>' +
                    '</li>');
            setFocus();
        } else {
            $("#chat").append('<li class="left clearfix"><span class="chat-img pull-left">' +
                    '<img src="' + imagem + '" alt="User Avatar" class="img-circle" width="70" height="70" /></span>' +
                    '<div class="chat-body clearfix">' +
                    '<div class="header">' +
                    '<strong class="primary-font">' + mensagem.usuario.nome + '</strong> <small class="pull-right text-muted">' +
                    '<span class="glyphicon glyphicon-time"></span>' + mensagem.data_hora + '</small></div>' +
                    '<p>' + mensagem.texto + '</p>' +
                    '</div></li>');
            setFocus();
        }
}
function desenhaChat(dados) {
var id = typeof dados[dados.length - 1] == "undefined" ? 0 : dados[dados.length - 1].idMensagem;

    for (let i = 0; i < dados.length; i++) {
        adicionaMensagem(dados[i]);
    }
    sessionStorage.setItem("lastId", id);
}

$(document).ready(function () {
    desenhaChat(dados);
    var botao = document.getElementById('btn-chat');
    botao.addEventListener('click', function () {
        enviaMensagem();
    });
    window.setInterval(function () {
        atualizaChat();    
    },5000);
    
});


function setFocus() {
    var obj = $('#chat');
    if (obj.length) {
        obj.scrollTop(obj.height());
    }
}

function atualizaChat() {
    $.ajax({
        url: 'chatAtualiza.html',
        data: {
            idGrupo: grupo.idGrupo,
            idMensagem: sessionStorage.getItem("lastId")
        },
        type: 'post',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                adicionaMensagem(data[i]);   
            }
            var id = typeof data[data.length - 1] == "undefined" ? 0 : data[data.length - 1].idMensagem;
            if(id == 0){
                return;
            }else{
            sessionStorage.setItem("lastId", id);}
        }
    });
}

function enviaMensagem() {
    $.ajax({
        url: 'enviaMensagem.html',
        data: {
            mensagem: $("#btn-input").val(),
            idUsuario: usuario,
            idGrupo: grupo.idGrupo        
        },
        //dataType: "json",
        type: 'post',
        success: function (data) {
            $("#btn-input").val("");
            atualizaChat();
        }
    });
}
