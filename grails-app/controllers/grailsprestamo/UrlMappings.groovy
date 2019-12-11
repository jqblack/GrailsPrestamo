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
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/registroclientes"(controller: "clientes"){
            action =[GET : "registroclientes"]
        }

        "/registroclientes/salvar"(controller: "clientes"){
            action =[POST : "salvar"]
        }
    }
}
