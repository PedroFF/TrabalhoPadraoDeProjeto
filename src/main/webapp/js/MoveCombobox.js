var comboboxOrigem, comboboxDestino;
comboboxOrigem = "origem";
comboboxDestino = "destino";
function MoveListBoxItem(leftListBoxID, rightListBoxID, isMoveAll) {
    if (isMoveAll === true) {

        $('#' + leftListBoxID + ' option').remove().appendTo('#' + rightListBoxID).removeAttr('selected');

    } else {

        $('#' + leftListBoxID + ' option:selected').remove().appendTo('#' + rightListBoxID).removeAttr('selected');
    }
}

function selectAll(listBox) {
    $("#" + listBox + " option").each(function () {
        $(this).prop('selected', true);
        //alert($(this).val());
    }
    );

    $("#" + listBox).prop('required', true);


}

$("#tipo").change(function () {
    var value = $("#tipo option:selected").val();
    var theDiv = $("#combo");

    if (value === "PFINAL") {
        theDiv.slideDown().addClass("hidden");
    } else if (value === "INGREDIENTE") {
        theDiv.slideUp().removeClass("hidden");
    }
});

$('#cancela-pedido').click(function () {
    window.location.href = "UaiFat?action=Index";
});

$('#btnsalvar').click(function () {

    var value = $("#tipo option:selected").val();
    if (value === "PFINAL") {
        selectAll('destino');
    }
});

$("#item").change(function () {
    getDados();
});

$("#item").ready(function () {
    getDados();
});

function getDados(){
var value = $("#item option:selected").val();

    $.get("UaiFat?action=ListarIngredientesProduto&produto=" + value, function (dados) {
        let option;
        if (dados.length > 0) {
            $.each(dados, function (i, obj) {
                option += '<option value="' + obj.id + '">' + obj.descricao + '</option>';
            });
            $('#origem').html(option).show();
        } else {
            Reset();
            $('#mensagem').html('<span class="mensagem">Não foram encontrados paises!</span>');
        }
    });
}