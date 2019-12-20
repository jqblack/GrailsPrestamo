/**
 * The Tprestamos entity.
 *
 * @author    
 *
 *
 */
package grailsprestamo
class Tprestamos {
    static mapping = {
         table 't_prestamos'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'f_idrecord'
    }

    Long fIdCliente
    Long fIdCodeudor
    java.math.BigDecimal fMontoPrestamo
    java.math.BigDecimal fBalance
    java.math.BigDecimal fMontoCuota
    java.math.BigDecimal fProcentajeMora
    java.math.BigDecimal fTasaPrestamo
    Long fTipoPrestamo
    Long fPeriodoPago
    Long fCantidadPagos
    Long fMoneda
    Date fFechaPrestamo
    Boolean fPagado

    static constraints = {
        fIdCliente(nullable: true, max: 9999999999L)
        fIdCodeudor(nullable: true, max: 9999999999L)
        fMontoPrestamo(nullable: true)
        fBalance(nullable: true)
        fMontoCuota(nullable: true)
        fProcentajeMora(nullable: true)
        fTasaPrestamo(nullable: true)
        fTipoPrestamo(nullable: true, max: 9999999999L)
        fPeriodoPago(nullable: true, max: 9999999999L)
        fCantidadPagos(nullable: true, max: 9999999999L)
        fMoneda(nullable: true, max: 9999999999L)
        fFechaPrestamo(nullable: true)
        fPagado(nullable: true)
    }
}
