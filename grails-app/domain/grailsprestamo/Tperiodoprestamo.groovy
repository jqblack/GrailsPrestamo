/**
 * The Tperiodoprestamo entity.
 *
 * @author    
 *
 *
 */
package  grailsprestamo
class Tperiodoprestamo {
    static mapping = {
         table 't_periodoprestamo'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'f_idrecord', params:[sequence:'t_periodoprestamo_sequence']
         id generator:'identity', column:'f_idrecord'
    }
    Long fCantdias
    String fDescripcion

    static constraints = {
        fCantdias(nullable: true, max: 9999999999L)
        fDescripcion(size: 0..20)
    }

}
