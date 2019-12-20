package grailsprestamo

import Funciones.Funciones
import grails.converters.JSON
import groovy.json.JsonOutput

class PrestamoController {

    def index() { }
    private static List lista_cuo;

    PrestamoService prestamoService;
    Funciones funciones = new Funciones();

    def prestamo(){
        Map mapa = prestamoService.GetCombos();
        render view: "/registros/reg_prestamos", model: [combo:mapa];
    }

    def buscarcliente(){

        List list = prestamoService.buscarcliente(
                params.bcedulacli as String,
                params.bnombrecli as String
        );

        render JsonOutput.toJson(list);
    }

    def BuscarClientebyid(){
        Tcliente tcliente = prestamoService.BuscarClientebyid(params.idrecord as Long);
        render tcliente as JSON;
    }

    def buscarcodeudor(){
        List list = prestamoService.buscarcliente(
                params.bcedula as String,
                params.bnombre as String
        );

        render JsonOutput.toJson(list);
    }

    def generarTablaprestamo(){

        List list = prestamoService.generarTablaprestamo(
                new Date(params.tfecha as String) ,
                params.tmonto as BigDecimal,
                params.ttasa as BigDecimal,
                params.tcantidad as Long,
                params.tperiodo as Long,
                params.ttipo as Long
        );

        lista_cuo = list;

        render JsonOutput.toJson(list);
    }
    
    def realizarprestamo(){

        Map mapa = prestamoService.salvarPrestamos(
                params.f_idcliente as Long,
                params.f_id_codeudor as Long,
                funciones.NormalFormat(params.tmonto),
                funciones.NormalFormat(params.ttasa),
                params.ttipo as Long,
                params.tperiodo as Long,
                params.tmoneda as Long,
                funciones.NormalFormat(params.tmora),
                params.tcantidad as Long,
                funciones.NormalFormat(params.tmontoc),
                new Date((params.tfecha as String).replace("-","/")),
                lista_cuo

        );
        if(mapa.get("key")){
            lista_cuo = [];
        }
        render JsonOutput.toJson(mapa);
    }
}
