package grailsprestamo

import grails.gorm.transactions.Transactional
import grails.util.Holders
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate

import java.sql.Timestamp
import java.text.SimpleDateFormat

@Transactional
class SqlService {

    static transactional = true;
    def dataSource = Holders.getGrailsApplication().mainContext.getBean("dataSource")
//    def jdbcTemplate
    JdbcTemplate jdbcTemplate;

    def Date GetNow() {
        def template = new JdbcTemplate(dataSource);
        return template.queryForObject("select now()", Date.class);
    }


    Map<String, Object> GetQueryMap(String sql) {
        try {
            def template = new JdbcTemplate(dataSource);
            return template.queryForMap(sql);
        } catch (Exception e) {
//            e.printStackTrace();
            return [:]
        }
    }

    Map<String,Object> GetQueryMap(String sql, Collection collection){
        try {
            def template = new JdbcTemplate(dataSource);
            return jdbcTemplate.queryForMap(sql,collection.toArray());
        } catch (Exception e) {
//            e.printStackTrace();
            return [:]
        }
    }


    def List<Map<String, Object>> GetQuery(String sql, Collection collection) {
        def template = new JdbcTemplate(dataSource)
        return template.queryForList(sql, collection.toArray())
    }

    def List<Map<String, Object>> GetQuery(String sql) {
        def template = new JdbcTemplate(dataSource);
        return template.queryForList(sql);

    }

    def Integer GetSecuencia(String tipodocumento, Long empresa) {
        def template = new JdbcTemplate(dataSource);
        Integer a = template.queryForObject("select get_secuencia('$tipodocumento',false,$empresa)", Integer.class);
        return a.toInteger();
    }


    def EjecutarSql(String sql) {
        def template = new JdbcTemplate(dataSource);
        template.execute(sql);
    }

    def EjecutarSql(String sql, Collection collection) {
        def template = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,collection.toArray())
    }

    def List<Map<String, Object>> GetQueryListOfMap(String sql, Collection collection) {
        try {
            def template = new JdbcTemplate(dataSource);
            return template.queryForList(sql, collection.toArray());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    def  Timestamp Get_Sumar_Dias(Date fecha_inicial, Long dias)
    {
        def template = new JdbcTemplate(dataSource);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String f1=simpleDateFormat.format(fecha_inicial);
        Timestamp a=template.queryForObject("SELECT ('$f1'::date +'$dias days'::INTERVAL )::TIMESTAMP",Timestamp.class);
        return a;
    }

    def serviceMethod() {

    }
}
