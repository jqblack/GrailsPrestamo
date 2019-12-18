package grailsprestamo

import grails.converters.JSON
import groovy.json.JsonOutput

class PrestamoController {

    def index() { }

    PrestamoService prestamoService;

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

        render JsonOutput.toJson(list);
    }
}
