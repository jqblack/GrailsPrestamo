<!doctype html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registros de Clientes</title>
</head>

<body>

<form id="frm" method="post">

    <div class="row">

        <div class="col">

            <div class="form-group">
                <label for="tcedula">Cédula</label>
                <input type="number" class="form-control" id="tcedula" name="tcedula" >
            </div>

            <div class="form-group">
                <label for="tnombre">Nombre</label>
                <input type="text" class="form-control" id="tnombre" name="tnombre" >
            </div>

            <div class="form-group">
                <label for="tapellidos">Apellidos</label>
                <input type="text" class="form-control" id="tapellidos" name="tapellidos" >
            </div>

            <div class="form-group">
                <label for="tcelular">Celular</label>
                <input type="tel" class="form-control" id="tcelular" name="tcelular" >
            </div>

        </div>

        <div class="col">

            <div class="form-group">
                <label for="ttelefono">Télefono</label>
                <input type="tel" class="form-control" id="ttelefono" name="ttelefono" >
            </div>

            <div class="form-group">
                <label for="tdireccion">Dirección</label>
                <input type="text" class="form-control" id="tdireccion" name="tdireccion" >
            </div>

            <div class="form-group">
                <label for="temail">Email</label>
                <input type="email" class="form-control" id="temail" name="temail" aria-describedby="emailHelp">
            </div>

        </div>

    </div>

    <div class="float-right">

        <button type="submit" class="btn btn-primary">Agregar</button>
        <button type="button" class="btn btn-outline-danger">Cancelar</button>


    </div>
</form>

<br><br><br><br>
<h3>Lista de Clientes</h3>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Cédula</th>
        <th scope="col">Nombre</th>
        <th scope="col">Dirección</th>
        <th scope="col">Celular</th>
        <th scope="col">Acción</th>
    </tr>
    </thead>
    <tbody id="tablacliente">

    <g:each in="${tclienteList}">

        <tr>
            <th scope="row">${it.fCedula}</th>
            <td>${it.fNombre}&nbsp;${it.fApellidos}</td>
            <td>${it.fDireccion}</td>
            <td>${it.fCelular}</td>
            <td>
                <div class="dropdown">
                    <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Acción
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a onclick="editar('${it.id}')" class="dropdown-item" style="cursor: pointer;"><span
                                class=" fa fa-pencil"></span> Editar</a>
                        <a class="dropdown-item" style="cursor: pointer;">
                            <span class="fa fa-trash"></span> Eliminar</a>
                    </div>
                </div>
            </td>
        </tr>

    </g:each>

    </tbody>
</table>

<br><br><br><br><br><br><br>



<asset:javascript src="registroclientes.js"/>
</body>
</html>