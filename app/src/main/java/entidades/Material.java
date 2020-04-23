package entidades;

public class Material {

    private String nombreDeMaterial;
    private String tipoDeMaterial;
    private Integer precioDeMaterial;
    private String proveedorDelMaterial;
    private Integer cantidadDelMaterial;


    public Material(String nombreDeMaterial, String tipoDeMaterial, Integer precioDeMaterial, String proveedorDelMaterial, Integer cantidadDelMaterial)
    {
        this.nombreDeMaterial = nombreDeMaterial;
        this.tipoDeMaterial = tipoDeMaterial;
        this.precioDeMaterial = precioDeMaterial;
        this.proveedorDelMaterial = proveedorDelMaterial;
        this.cantidadDelMaterial = cantidadDelMaterial;
    }

    public Material(){

    }

    public String getNombreDeMaterial(){
        return nombreDeMaterial;
    }
    public void setNombreDeMaterial(String nombreDeMaterial) {
        this.nombreDeMaterial = nombreDeMaterial;
    }

    public String getTipoDeMaterial(){
        return tipoDeMaterial;
    }
    public void setTipoDeMaterial(String tipoDeMaterial){
        this.tipoDeMaterial = tipoDeMaterial;
    }

    public Integer getPrecioDeMaterial(){
        return  precioDeMaterial;
    }

    public void setPrecioDeMaterial(Integer precioDeMaterial) {
        this.precioDeMaterial = precioDeMaterial;
    }

    public String getProveedorDelMaterial() {
        return proveedorDelMaterial;
    }

    public void setProveedorDelMaterial(String proveedorDelMaterial) {
        this.proveedorDelMaterial = proveedorDelMaterial;
    }

    public Integer getCantidadDelMaterial() {
        return cantidadDelMaterial;
    }

    public void setCantidadDelMaterial(Integer cantidadDelMaterial) {
        this.cantidadDelMaterial = cantidadDelMaterial;
    }
}