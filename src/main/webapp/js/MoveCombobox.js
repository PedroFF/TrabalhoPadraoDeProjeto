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
})
