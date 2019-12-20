var idcliente = 0;
var idcodeudor = 0;
var lista_cuotas;
var miparams = {};

function limpiarModal() {
    $("#bcedula").val("");
    $("#bnombre").val("");
    $("#tablacodeudor").hide();
}

function limpiarModalcli() {
    $("#bcedulacli").val("");
    $("#bnombrecli").val("");
    $("#tablacliente").hide();
}

function cosummit() {
    $("#frmBuscarCoudeudor").submit();
}

$("#frmBuscarCoudeudor").submit(function (e) {
    e.preventDefault();
    var params = {};
    params = formToJson(this);
    if (validarco(params) != true) {
        return;
    }
    BuscarCodeudor(params);
});

function validarco(params) {

    if (params.bcedula != ""){
        return true;
    }else if (params.bnombre != ""){
        return true;
    }
    return false;
}

function BuscarCodeudor(params) {
    $.ajax({
        url: window.location+"/buscarcodeudor",
        data: params,
        type: 'POST',
        success: function (response) {
            var json = JSON.parse(response);

            if (json.length > 0){
                $("#tablacodeudor").show();

                var html = "";

                for (let i = 0; i < json.length ; i++) {

                    html = html + `<tr>
                    <th scope="row">${json[i].f_cedula}</th>
                    <td>${json[i].f_nombre}&nbsp;${json[i].f_apellidos}</td>
                    <td>${json[i].f_direccion}</td>
                    <td>${json[i].f_celular}</td>
                    <td>
                        <button class="btn btn-outline-primary" onclick="SeleccionarCodeudor('${json[i].f_idrecord}')">Seleccionar</button>
                    </tr>`;

                }

                $("#bodycodeudor").html(html);

            }
        }
    });
}

function SeleccionarCodeudor(idco) {
    $.ajax({
        url: window.location+"/BuscarCodeudorbyid",
        data: {idrecord:idco},
        type: 'POST',
        success: function (response) {
            var json = eval(response);

            idcodeudor = idco;
            $("#tcodeudor").val(json.fNombre);
            $("#modalBuscarCodeudor").modal('hide');
            limpiarModal();
        }
    });
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
    idcliente = 0;
    idcodeudor = 0;
    $("#tablaprestamo").hide();
}

$("#frm").submit(function (e) {
    e.preventDefault();
    var params = {};
    params = formToJson(this);

    if (validarForm(params) != true) {
        return;
    }

    params.tfecha = params.tfecha.replace("-","/");
    params.tfecha = params.tfecha.replace("-","/");

    realizarPrestamo(params);
});

function validarForm(params) {

    if (idcliente <= 0){
        show_no("Alerta","El cliente al que se le va a hacer el préstampo debe de estar seleccionado");
        return false;
    }else if (idcodeudor <= 0){
        show_no("Alerta","El codeudor del cliente debe de estar seleccionado");
        return false;
    } else if (params.tmonto <= 0){
        show_no("Alerta","El monto del préstamo no puede ser cero o menor");
        return false
    }else if (params.ttipo <= 0){
        show_no("Alerta","Seleccione el tipo de préstamo");
        return false;
    } else if (params.tperiodo <= 0){
        show_no("Alerta","Seleccione el periodo del préstamo");
        return false;
    }else if (params.tmora <= 0){
        show_no("Alerta","La mora del préstamo no puede ser cero o menor");
        return false;
    }else if (params.tcantidad <= 0){
        show_no("Alerta","La cantidad de pagos del préstamo no puede ser cero o menor");
        return false;
    }else if (parseFloat(params.ttasa)<= 0){
        show_no("Alerta","La tasa del préstamo no puede ser cero o menor");
        return false;
    }else if (params.tfecha == ""){
        show_no("Alerta","La fecha del préstamo no puede ser cero o menor");
        return false;
    }

    return true
}

function realizarPrestamo(params) {
    $.ajax({
        url: window.location+"/generarTablaprestamo",
        data: params,
        type: 'POST',
        success: function (response) {
            var json = JSON.parse(response);

            if (json.length > 0){
                $("#tablaprestamo").show();

                lista_cuotas = response;
                miparams = params;
                miparams.f_tabla_cuotas = lista_cuotas;

                var html = "";

                for (let i = 0; i < json.length ; i++) {

                    html = html + `<tr>
                    <th scope="row">${json[i].f_numero}</th>
                    <td>${json[i].f_fecha_prestamo}</td>
                    <td>${json[i].f_monto}</td>
                    <td>${json[i].f_capital}</td>
                    <td>${json[i].f_interes}</td>`;

                }

                $("#bodyprestamo").html(html);
            }
        }
    });
}

function generarprestamo() {
    if (lista_cuotas.length <= 0){
        show_no("Error","Ups primero tiene que generar la tabla de cuotas");
        return;
    }

    if (!validarForm(miparams)){
        console.log("Black Star men :p");
        return;
    }

    miparams.f_idcliente = idcliente;
    miparams.f_id_codeudor = idcodeudor;

    $.ajax({
        url: window.location+"/realizarprestamo",
        data: miparams,
        type: 'POST',
        success: function (response) {
            var json = JSON.parse(response);

            if (json.key){
                show_yes("Correcto",json.msj);
                idcliente = 0;
                idcodeudor = 0;
                LimpiarForm();
                $("#tablaprestamo").hide();
            }
            else{
                show_no("Error",json.msj);
            }
        }
    });
}