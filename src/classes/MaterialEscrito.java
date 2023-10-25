package classes;

public class MaterialEscrito extends Material {
    private String Editorial;

    public MaterialEscrito(String codigoIdentificacion, String titulo, int unidadesDisponibles, String editorial) {
        super(codigoIdentificacion, titulo, unidadesDisponibles);
        Editorial = editorial;
    }
    public MaterialEscrito(String codigoIdentificacion){
        super(codigoIdentificacion);
    }
    public MaterialEscrito(){

    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }
}
