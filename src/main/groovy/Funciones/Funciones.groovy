package Funciones

import java.text.NumberFormat

class Funciones {

    Map getRespuesta(Boolean key,String mensaje){
        Map mapa = new HashMap()
        mapa.key = key;
        mapa.msj = mensaje;
        return mapa
    }

    def String CurrencyFormat(Object obj) {
        NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale('en'));
        try {
            if (obj.toString().substring(0, 1).equals("-")) {
                return "-" + fm.format(obj).substring(2, fm.format(obj).length());
            } else {
                return fm.format(obj).substring(1, fm.format(obj).length());
            }
        }catch(Exception e){
            return fm.format(0).substring(1, fm.format(0).length());
        }
    }
    BigDecimal NormalFormat(Object obj) {

        try {
            if (!obj.toString().equals("")) {
                obj = obj.toString()
                        .replace(',', '')
                        .replace('f', '')
                        .replace('d', '')
                        .replace('F', '')
                        .replace('D', '')
                        .replace('$','')
                        .replace(';','');
                if (obj.isNumber()){
                    return obj as BigDecimal;
                }else {
                    return 0;
                }
            }
            return 0;
        }catch(Exception e){
            return 0;
        }


    }
}
