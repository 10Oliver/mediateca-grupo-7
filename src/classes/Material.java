package classes;
public class Material {
    private String CodigoIdentificacion;
    private String Titulo;
    private int UnidadesDisponibles;

    public Material(){

    }

    public Material(String codigoIdentificacion, String titulo, int unidadesDisponibles) {
        CodigoIdentificacion = codigoIdentificacion;
        Titulo = titulo;
        UnidadesDisponibles = unidadesDisponibles;
    }
    public Material(String codigoIdentificacion) {
        CodigoIdentificacion = codigoIdentificacion;
    }

    public String getCodigoIdentificacion() {
        return CodigoIdentificacion;
    }

    public void setCodigoIdentificacion(String codigoIdentificacion) {
        CodigoIdentificacion = codigoIdentificacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getUnidadesDisponibles() {
        return UnidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        UnidadesDisponibles = unidadesDisponibles;
    }
}
