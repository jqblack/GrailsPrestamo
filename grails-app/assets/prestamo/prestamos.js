var idcliente = 0;
var idcodeudor = 0;

function limpiarModal() {
    $("#bcedula").val("");
    $("#bnombre").val("");
}

function limpiarModalcli() {
    $("#bcedulacli").val("");
    $("#bnombrecli").val("");
    $("#tablacliente").hide();
}

function clisummit(){
    $("#frmBuscarCliente").submit();
}

$("#frmBuscarCliente").submit(function (e) {
    e.preventDefault();
    var params = {};
    params = formToJson(this);
    if (validar(params) != true) {
        return;
    }
    BuscarCliente(params);
});

function validar(params) {

    if (params.bcedulacli != ""){
        return true;
    }else if (params.bnombrecli != ""){
        return true;
    }
    return false;
}

function BuscarCliente(params) {
    $.ajax({
        url: window.location+"/buscarcliente",
        data: params,
        type: 'POST',
        success: function (response) {
            var json = JSON.parse(response);

            if (json.length > 0){
                $("#tablacliente").show();

                var html = "";

                for (let i = 0; i < json.length ; i++) {

                    html = html + `<tr>
                    <th scope="row">${json[i].f_cedula}</th>
                    <td>${json[i].f_nombre}&nbsp;${json[i].f_apellidos}</td>
                    <td>${json[i].f_direccion}</td>
                    <td>${json[i].f_celular}</td>
                    <td>
                        <button class="btn btn-outline-primary" onclick="SeleccionarCliente('${json[i].f_idrecord}')">Seleccionar</button>
                    </tr>`;

                }

                $("#bodycliente").html(html);

            }


        }
    });
}

function SeleccionarCliente(idcli) {
    $.ajax({
        url: window.location+"/BuscarClientebyid",
        data: {idrecord:idcli},
        type: 'POST',
        success: function (response) {
            var json = eval(response);

            console.log(json);
            idcliente = idcli;
            $("#tcliente").val(json.fNombre);
            $("#modalBuscarCliente").modal('hide');
            limpiarModalcli();
        }
    });
}

function LimpiarForm() {
    $("#frm").trigger('reset');
}