package grailsprestamo

class ClientesController {

    def index() { }

    ClienteService clienteService;

    def registroclientes(){
        render view: "/registros/registroclientes";
    }

    def salvar(){

        clienteService.salvar(params.tcedula as String,
        params.tnombre as String,
        params.tapellidos as String,
        params.tcelular as String,
        params.ttelefono as String,
        params.tdireccion as String,
        params.temail as String)
    }
}
