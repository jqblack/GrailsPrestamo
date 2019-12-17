var idrecordmod = 0;

$("#frm").submit(function (e) {
    e.preventDefault();
    var params = {};
    params = formToJson(this);
    if (validar(params) != true) {
        return;
    }

    params.idrecord = idrecordmod;
    Salvar(params);

});

function validar(params) {

    if (params.tcedula == ""){
        show_no("Alerta","La cédula no puede estar vacia");
        return false;
    }else if (params.tnombre == ""){
        show_no("Alerta","El nombre no puede estar vacio");
        return false;
    } else if (params.tapellidos ==""){
        show_no("Alerta","El apellido no puede estar vacio");
        return false
    }else if (params.tcelular == ""){
        show_no("Alerta","El celular no puede estar en blanco");
        return false;
    } else if (params.tdireccion == ""){
        show_no("Alerta","La dirección no puede estar en blanco");
        return false;
    }
    return true
}

function Salvar(params) {

    $.ajax({
        url: window.location+"/salvar",
        data: params,
        type: 'POST',
        success: function (response) {
            var json = JSON.parse(response);

            if (json.key){
                show_yes("Correcto",json.msj);
                idrecordmod = 0;
                ActualizarTabla();
            }
            else{
                show_no("Error",json.msj);
            }
        }
    });
}

function editar(idrecord) {

    $.ajax({
        url: window.location+"/Buscarbyid",
        data: {idrecord:idrecord},
        type: 'POST',
        success: function (response) {
            var json = eval(response);

            idrecordmod = idrecord;

            $("#tcedula").val(json.fCedula);
            $("#tnombre").val(json.fNombre);
            $("#tapellidos").val(json.fApellidos);
            $("#tcelular").val(json.fCelular);
            $("#ttelefono").val(json.fTelefono);
            $("#tdireccion").val(json.fDireccion);
            $("#temail").val(json.fEmail);

        }
    });
}

function ActualizarTabla() {
    $.ajax({
        url: window.location+"/actualizartabla",
        data: {data:"hola"},
        type: 'POST',
        success: function (response) {
            var json = eval(response);

            var html = "";

            for (var i = 0; i < json.length; i++) {
                html = html + `<tr>
            <th scope="row">${json[i].fCedula}</th>
            <td>${json[i].fNombre}&nbsp;${json[i].fApellidos}</td>
            <td>${json[i].fDireccion}</td>
            <td>${json[i].fCelular}</td>
            <td>
                <div class="dropdown">
                    <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Acción
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a onclick="editar('${json[i].id}')" class="dropdown-item" style="cursor: pointer;"><span
                                class=" fa fa-pencil"></span> Editar</a>
                        <a class="dropdown-item" style="cursor: pointer;">
                            <span class="fa fa-trash"></span> Eliminar</a>
                    </div>
                </div>
            </td>
        </tr>`;
            }
            
            $("#tablacliente").html(html);

        }


    });
}