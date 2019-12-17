package grailsprestamo

import org.apache.tools.ant.taskdefs.Get

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/inicio/inicio")
//        "500"(view:'/error')
//        "404"(view:'/notFound')

        "/registroclientes"(controller: "clientes"){
            action =[GET : "registroclientes"]
        }

        "/registroclientes/salvar"(controller: "clientes"){
            action =[POST : "salvar"]
        }

        "/registroclientes/Buscarbyid"(controller: "clientes"){
            action =[POST : "Buscarbyid"]
        }

        "/registroclientes/actualizartabla"(controller: "clientes"){
            action =[POST : "actualizartabla"]
        }

        //PRESTAMOS


        "/prestamo"(controller: "prestamo"){
            action =[GET : "prestamo"]
        }

        "/prestamo/buscarcliente"(controller: "prestamo"){
            action =[POST : "buscarcliente"]
        }

        "/prestamo/BuscarClientebyid"(controller: "prestamo"){
            action =[POST : "BuscarClientebyid"]
        }
    }
}
