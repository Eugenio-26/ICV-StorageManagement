package utilidades;

public class Utilidades {
    //Constantes tabla Materiales
    public static final String TABLA_MATERIALES="Material";
    public static final String CAMPO_NOMBRE="nombreDeMaterial";
    public static final String CAMPO_TIPO="tipoDeMaterial";
    public static final String CAMPO_PRECIO="precioDeMaterial";
    public static final String CAMPO_PROVEEDOR="proveedorDelMaterial";
    public static final String CAMPO_CANTIDAD="cantidadDelMaterial";

    public static final String CREAR_TABLA_MATERIALES = "CREATE TABLE " +
            "" + TABLA_MATERIALES + " (" + CAMPO_NOMBRE + " " +
            "TEXT, " + CAMPO_TIPO + " TEXT," + CAMPO_PRECIO + " INTEGER, " + CAMPO_PROVEEDOR +" TEXT," + CAMPO_CANTIDAD + " INTEGER)";
}
