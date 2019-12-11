

$("#frm").submit(function (e) {
    e.preventDefault();
    var params = {};

    params = formToJson(this);
    if (validar(params) != true) {
        return;
    }

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

        }
    })
}