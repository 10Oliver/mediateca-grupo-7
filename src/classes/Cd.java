package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cd extends MaterialAudiovisual {
    private int CdId;
    private String artista;
    private int numCanciones;

    public Cd(String codigoIdentificacion, String titulo, int unidadesDisponibles, String genero, String duracion, int cdId, String artista, int numCanciones) {
        super(codigoIdentificacion, titulo, unidadesDisponibles, genero, duracion);
        CdId = cdId;
        this.artista = artista;
        this.numCanciones = numCanciones;
    }

    public int getCdId() {
        return CdId;
    }

    public void setCdId(int cdId) {
        CdId = cdId;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }


    public void insertarCd(ConnectionDb conexion) {
        String query = "INSERT INTO cds (codigo_identificacion, titulo, artista, genero, duracion, num_canciones, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getCodigoIdentificacion());
            statement.setString(2, this.getTitulo());
            statement.setString(3, this.getArtista());
            statement.setString(4, this.getGenero());
            statement.setString(5, this.getGenero());
            statement.setInt(6, this.numCanciones);
            statement.setInt(7, this.getUnidadesDisponibles());
            statement.executeUpdate();
            System.out.println("CD insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el CD en la base de datos.");
            e.printStackTrace();
        }
    }

    public void actualizarCd(ConnectionDb conexion) {
        String query = "UPDATE cds SET titulo = ?, artista = ?, genero = ?, duracion = ?, num_canciones = ? WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getTitulo()); // Update with appropriate properties
            statement.setString(2, this.getArtista());
            statement.setString(3, this.getGenero());
            statement.setString(4, this.getDuracion());
            statement.setInt(5, this.numCanciones);
            statement.setString(6, this.getCodigoIdentificacion());
            statement.executeUpdate();
            System.out.println("CD actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el CD en la base de datos.");
            e.printStackTrace();
        }
    }

    public void borrarCd(ConnectionDb conexion) {
        String query = "DELETE FROM cds WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getCodigoIdentificacion()); // Delete based on the unique identifier
            statement.executeUpdate();
            System.out.println("CD eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el CD de la base de datos.");
            e.printStackTrace();
        }
    }

    public void seleccionarCd(ConnectionDb conexion, int codigoIdentificacion) {
        String query = "SELECT * FROM cds WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setInt(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Retrieve data from the result set and set it to the properties of the Cd object
                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                this.setTitulo(resultSet.getString("titulo"));
                this.setArtista(resultSet.getString("artista"));
                super.setGenero(resultSet.getString("genero"));
                this.setDuracion(resultSet.getString("duracion"));
                this.numCanciones = resultSet.getInt("num_canciones");
                // Set other properties accordingly
            }
            System.out.println("CD seleccionado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el CD de la base de datos.");
            e.printStackTrace();
        }
    }
}
