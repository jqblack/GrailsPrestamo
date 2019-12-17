/**
 * The Ttipoprestamo entity.
 *
 * @author    
 *
 *
 */
package  grailsprestamo
class Ttipoprestamo {
    static mapping = {
         table 't_tipoprestamo'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'f_idrecord', params:[sequence:'t_tipoprestamo_sequence']
         id generator:'identity', column:'f_idrecord'
    }
    String fDescripcion

    static constraints = {
        fDescripcion(size: 0..20)
    }
}
