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
    
    $("#"+listBox).prop('required', true);


}