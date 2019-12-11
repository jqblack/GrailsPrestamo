/**
 * The Tcliente entity.
 *
 * @author    
 *
 *
 */
package  grailsprestamo
class Tcliente {
    static mapping = {
         table 't_cliente'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'f_idrecord', params:[sequence:'t_cliente_sequence']
         id generator:'identity', column:'f_idrecord'
    }

    String fNombre
    String fApellidos
    String fCedula
    String fEmail
    String fDireccion
    String fCelular
    String fTelefono
    Boolean fVisible

    static constraints = {
        fNombre(size: 0..30)
        fApellidos(size: 0..50)
        fCedula(size: 0..20)
        fEmail(size: 0..30)
        fDireccion()
        fCelular(size: 0..20)
        fTelefono(size: 0..20)
        fVisible(nullable: true)
    }

}
