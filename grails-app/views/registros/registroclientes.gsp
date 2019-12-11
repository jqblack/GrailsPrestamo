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

<form id="frm">

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
        <button type="submit" class="btn btn-outline-danger">Cancelar</button>


    </div>
</form>

</body>
</html>