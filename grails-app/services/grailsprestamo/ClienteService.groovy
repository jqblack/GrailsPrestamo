package grailsprestamo

import Funciones.Funciones
import grails.gorm.transactions.Transactional

@Transactional
class ClienteService {

    def serviceMethod() { }

    Funciones funciones = new Funciones();

    Map salvar(Long idrecord,String cedula,String nombre, String apellidos, String direccion, String email, String celular, String telefono){

        try{

            Tcliente tupla = Tcliente.findById(idrecord);

            if (tupla){
                tupla.setfCedula(cedula);
                tupla.setfNombre(nombre);
                tupla.setfApellidos(apellidos);
                tupla.setfDireccion(direccion);
                tupla.setfEmail(email);
                tupla.setfCelular(celular);
                tupla.setfTelefono(telefono);

                tupla.save(failOnError: true);
                return funciones.getRespuesta(true,"Cliente Actualizado correctamente!");
            }
            else{
                Tcliente tcliente = new Tcliente(
                        fCedula: cedula,
                        fNombre: nombre,
                        fApellidos: apellidos,
                        fDireccion: direccion,
                        fEmail: email,
                        fCelular: celular,
                        fTelefono: telefono,
                        fVisible: true
                );
                tcliente.save(failOnError: true);
                return funciones.getRespuesta(true,"Cliente Creado correctamente!");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    Tcliente Buscarbyid(Long idrecord){
        return Tcliente.findById(idrecord);
    }

    List<Tcliente> actualizartabla(){

        List<Tcliente> tclienteList = Tcliente.findAllByFVisible(true);
        return tclienteList;
    }

}
