package grailsprestamo

import Funciones.Funciones
import grails.gorm.transactions.Transactional

import java.text.SimpleDateFormat

@Transactional
class PrestamoService {

    SqlService sqlService;
    Funciones funciones = new Funciones();

    def serviceMethod() {}

    def GetCombos(){
        Map mapa = new HashMap();

        List<Tmonedas> tmonedasList = Tmonedas.findAll();
        mapa.put("monedas",tmonedasList);

        List<Tperiodoprestamo> tperiodoprestamoList = Tperiodoprestamo.findAll();
        mapa.put("periodo",tperiodoprestamoList);

        List<Ttipoprestamo> ttipoprestamoList = Ttipoprestamo.findAll();
        mapa.put("tipoprestamo",ttipoprestamoList);

        return mapa;
    }

    List buscarcliente(String cedula, String nombre){

        String sql = "SELECT \n" +
                "c.* \n" +
                "FROM \n" +
                "t_cliente AS c\n" +
                "WHERE 1=1 ";

        Collection collection = [];

        if (!cedula.equals("")){
            sql += " and c.f_cedula = ?"
            collection.add(cedula);
        }

        if (!nombre.equals("")){
            sql += " and c.f_nombre ILIKE(?)"
            collection.add(nombre+"%");
        }

        return sqlService.GetQuery(sql,collection);
    }

    Tcliente BuscarClientebyid(Long idrecord){
        return Tcliente.findById(idrecord);
    }

    def generarTablaprestamo(Date fecha, BigDecimal monto_prestamo, BigDecimal tasa_prestamo, Long cantidad_pagos, Long periodo_pago,
    Long tipo_prestamo){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat('yyyy/MM/dd');
        BigDecimal monto = 0.0;
        BigDecimal interes = 0.0;
        BigDecimal capital = 0.0;
        BigDecimal tasa = 0.0;
        Long cantidad = 0;
        Long dias = 0;
        Date fecha_prestamos = new Date();


        fecha_prestamos = fecha;
        capital = monto_prestamo;
        tasa = tasa_prestamo;
        cantidad = cantidad_pagos;

        Tperiodoprestamo tperiodoprestamo = Tperiodoprestamo.findById(periodo_pago);
        dias = tperiodoprestamo.fCantdias;

        List<Map<String, Object>> lista_cuotas = []

        if (tipo_prestamo == 1 as Long) {

            interes = capital * (tasa / 100);

            monto = capital * (tasa / 100) * cantidad;

            monto = (monto + capital) / cantidad;

            for (int i = 0; i < cantidad; i++) {
                capital = monto - interes;
                fecha_prestamos = sqlService.Get_Sumar_Dias(fecha_prestamos, dias);
                Map tupla = new HashMap();
                tupla.put("f_numero", i + 1)
                tupla.put("f_fecha_prestamo", simpleDateFormat.format(fecha_prestamos))
                tupla.put("f_monto", funciones.CurrencyFormat(monto))
                tupla.put("f_capital", funciones.CurrencyFormat(capital))
                tupla.put("f_interes", funciones.CurrencyFormat(interes))
                lista_cuotas.add(tupla);

            }
        }

        return lista_cuotas;

    }

}
