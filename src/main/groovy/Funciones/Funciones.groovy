package Funciones

class Funciones {

    Map getRespuesta(Boolean key,String mensaje){
        Map mapa = new HashMap()
        mapa.key = key;
        mapa.msj = mensaje;
        return mapa
    }
}
