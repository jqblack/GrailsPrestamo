package grailsprestamo

import grails.gorm.transactions.Transactional

@Transactional
class PrestamoService {

    SqlService sqlService;

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
}
