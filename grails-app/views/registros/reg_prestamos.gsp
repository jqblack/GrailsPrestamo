<!doctype html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registros de Prestamos</title>
</head>

<body>
<br><br>
<form id="frm" method="post">

    <div class="row">

        <div class="col">

            <div class="form-group">

                <label >Cliente</label>
                <div class="input-group">

                    <input type="text" class="form-control" id="tcliente" name="tcliente" disabled>
                    <div class="input-group-append">
                        <button class="btn btn-success" type="button" data-toggle="modal" data-target="#modalBuscarCliente">Buscar</button>
                    </div>
                </div>

            </div>

            <div class="form-group">

                <label>Codeudor</label>
                <div class="input-group">

                    <input type="text" class="form-control" id="tcodeudor" name="tcodeudor" disabled >
                    <div class="input-group-append">
                        <button class="btn btn-success" type="button" data-toggle="modal" data-target="#modalBuscarCodeudor">Buscar</button>
                    </div>
                </div>
            </div>



            <div class="form-group">
                <label>Monto</label>
                <input type="number" class="form-control" id="tmonto" name="tmonto" >
            </div>

            <div class="form-group">
                <label>Tasa Préstamos</label>
                <input type="number" class="form-control" id="ttasa" name="ttasa" >
            </div>

            <div class="form-group">
                <label>Tipo de Préstamos</label>
                <select class="form-control" id="ttipo" name="ttipo">
                    <option value="0">Seleccione</option>
                    <g:each in="${combo.tipoprestamo}">
                        <option value="${it.id}">${it.fDescripcion}</option>
                    </g:each>
                </select>
            </div>

            <div class="form-group">
                <label>Periodos</label>
                <select class="form-control" id="tperiodo" name="tperiodo">
                    <option value="0">Seleccione</option>
                    <g:each in="${combo.periodo}">
                        <option value="${it.id}">${it.fDescripcion}</option>
                    </g:each>
                </select>
            </div>

        </div>

        <div class="col">

            <div class="form-group">
                <label>Moneda</label>
                <select class="form-control" id="tmoneda" name="tmoneda">
                    <option value="0">Seleccione</option>
                    <g:each in="${combo.monedas}">
                        <option value="${it.id}">${it.fDescripcion}</option>
                    </g:each>
                </select>
            </div>

            <div class="form-group">
                <label>Mora</label>
                <input type="number" class="form-control" id="tmora" name="tmora" >
            </div>

            <div class="form-group">
                <label>cantidad de pagos</label>
                <input type="number" class="form-control" id="tcantidad" name="tcantidad">
            </div>

            <div class="form-group">
                <label>Monto Coutas</label>
                <input type="number" class="form-control" id="tmontoc" name="tmontoc" disabled>
            </div>

            <div class="form-group">
                <label>Fecha</label>
                <input type="date"  class="form-control" id="tfecha" name="tfecha">
            </div>

        </div>

    </div>

    <div class="float-right">

        <button type="submit" class="btn btn-primary">Generar</button>
        <button type="button" class="btn btn-outline-danger" onclick="LimpiarForm()">Limpiar</button>


    </div>
</form>


<div class="modal fade" tabindex="-1" role="dialog" id="modalBuscarCodeudor">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Buscar</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form id="frmBuscarCoudeudor" method="post">
                    <div class="row">

                        <div class="col">

                            <div class="form-group">
                                <label>Cédula</label>
                                <input type="number" class="form-control" id="bcedula" name="bcedula" placeholder="00000000000">
                            </div>

                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" id="bnombre" name="bnombre" placeholder="Nombre">
                            </div>


                        </div>

                    </div>
                </form>
                <br><br><br>
                <table class="table" style="display: none" id="tablacodeudor">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Cédula</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Celular</th>
                        <th scope="col">Acción</th>
                    </tr>
                    </thead>

                    <tbody id="bodycodeudor">

                    </tbody>

                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-danger" onclick="limpiarModal()" data-dismiss="modal">Cerrar</button>
                <button type="button" class="btn btn-success" onclick="cosummit()">Buscar</button>
            </div>
        </div>
    </div>
</div>


%{--MODAL CLIENTE--}%

<div class="modal fade" tabindex="-1" role="dialog" id="modalBuscarCliente">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Buscar</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form id="frmBuscarCliente" method="post">
                    <div class="row">

                        <div class="col">

                            <div class="form-group">
                                <label>Cédula</label>
                                <input type="number" class="form-control" id="bcedulacli" name="bcedulacli" placeholder="00000000000">
                            </div>

                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" id="bnombrecli" name="bnombrecli" placeholder="Nombre">
                            </div>


                        </div>

                    </div>
                </form>

                <br><br><br>
                <table class="table" style="display: none" id="tablacliente">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Cédula</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Celular</th>
                        <th scope="col">Acción</th>
                    </tr>
                    </thead>

                    <tbody id="bodycliente">

                    </tbody>

                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-danger" onclick="limpiarModalcli()" data-dismiss="modal">Cerrar</button>
                <button type="button" onclick="clisummit()" class="btn btn-success">Buscar</button>
            </div>
        </div>
    </div>
</div>


<br><br><br><br>

<table class="table" id="tablaprestamo" style="display: none">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Fecha</th>
        <th scope="col">Monto Cuota</th>
        <th scope="col">Monto Capital</th>
        <th scope="col">Monto Interes</th>
    </tr>
    </thead>
    <tbody id="bodyprestamo">

    </tbody>
</table>

<br><br><br><br><br><br><br>


<asset:javascript src="prestamos.js"/>

</body>
</html>