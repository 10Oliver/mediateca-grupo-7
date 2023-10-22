package classes;

public class MaterialAudiovisual extends Material{
    private String genero;
    private String duracion;

    public MaterialAudiovisual(String codigoIdentificacion, String titulo, int unidadesDisponibles, String genero, String duracion) {
        super(codigoIdentificacion, titulo, unidadesDisponibles);
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}







