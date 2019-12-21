/**
 * The Tzonas entity.
 *
 * @author    
 *
 *
 */
class Tzonas {
    static mapping = {
         table 't_zonas'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'f_idrecord'
    }
    Long fIdrecord
    String fCodigo
    String fDescripcion

    static constraints = {
        fIdrecord()
        fCodigo(size: 0..20)
        fDescripcion(size: 0..30)
    }
    String toString() {
        return "${fIdrecord}" 
    }
}
