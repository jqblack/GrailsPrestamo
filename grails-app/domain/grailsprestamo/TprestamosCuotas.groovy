/**
 * The TprestamosCuotas entity.
 *
 * @author    
 *
 *
 */
package grailsprestamo
class TprestamosCuotas {
    static mapping = {
         table 't_prestamos_cuotas'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'f_idrecord'
    }
    Long fIdPrestamo
    Date fFechaVencimiento
    java.math.BigDecimal fMontoCapital
    java.math.BigDecimal fMontoInteres
    java.math.BigDecimal fMontoMora
    Boolean fPagada

    static constraints = {
        fIdPrestamo(nullable: true, max: 9999999999L)
        fFechaVencimiento(nullable: true)
        fMontoCapital(nullable: true)
        fMontoInteres(nullable: true)
        fMontoMora(nullable: true)
        fPagada(nullable: true)
    }

}
