package grailsprestamo

import grails.gorm.transactions.Transactional

@Transactional
class ClienteService {

    def serviceMethod() {

    }

    def salvar(String cedula,String nombre, String apellidos, String direccion, String email, String celular, String telefono){

        try{

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

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
