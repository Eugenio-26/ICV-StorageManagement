package com.example.icv_storagemanagement.utilidades;

public class Utilidades {
    //Constantes tabla Materiales
    public static final String TABLA_MATERIALES="Material";
    public static final String CAMPO_NOMBRE="Nombre de Material";
    public static final String CAMPO_TIPO="Tipo de Material";
    public static final String CAMPO_PRECIO="Precio de Material";
    public static final String CAMPO_PROVEEDOR="Proveedor de Material";
    public static final String CAMPO_CANTIDAD="Cantidad de Material";

    public static final String CREAR_TABLA_MATERIALES="CREATE TABLE " +""+TABLA_MATERIALES+" ("+CAMPO_NOMBRE+" TEXT, "+CAMPO_TIPO+" TEXT, "+CAMPO_PRECIO+" INTEGER,"+CAMPO_PROVEEDOR+" TEXT,"+CAMPO_CANTIDAD+"INTEGER)";
}
