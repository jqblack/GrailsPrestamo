package grailsprestamo

import grails.converters.JSON
import groovy.json.JsonOutput

class ClientesController {

    def index() { }

    ClienteService clienteService;

    def registroclientes(){
        List<Tcliente> tclienteList = clienteService.actualizartabla();
        render view: "/registros/registroclientes",model: [tclienteList:tclienteList];
    }

    def salvar(){

        Map mapa = clienteService.salvar(
                params.idrecord as Long,
                params.tcedula as String,
                params.tnombre as String,
                params.tapellidos as String,
                params.tcelular as String,
                params.ttelefono as String,
                params.tdireccion as String,
                params.temail as String);

        render JsonOutput.toJson(mapa);
    }

    def Buscarbyid(){
        Tcliente tcliente = clienteService.Buscarbyid(params.idrecord as Long);
        render tcliente as JSON;
    }

    def actualizartabla(){
        List<Tcliente> tclienteList = clienteService.actualizartabla();
        println(tclienteList);
        render JsonOutput.toJson(tclienteList);
    }
}
