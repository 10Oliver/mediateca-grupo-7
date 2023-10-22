package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dvd extends MaterialAudiovisual {
    private int DvdId;
    private String director;

    public Dvd(String codigoIdentificacion, String titulo, int unidadesDisponibles, String genero, String duracion, int dvdId, String director) {
        super(codigoIdentificacion, titulo, unidadesDisponibles, genero, duracion);
        DvdId = dvdId;
        this.director = director;
    }

    public int getDvdId() {
        return DvdId;
    }

    public void setDvdId(int dvdId) {
        DvdId = dvdId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void insertarDvd(ConnectionDb conexion) {
        String query = "INSERT INTO dvds (codigo_identificacion, titulo, director, duracion, genero, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getCodigoIdentificacion());
            statement.setString(2, this.getTitulo());
            statement.setString(3, this.director);
            statement.setString(4, this.getDuracion());
            statement.setString(5, this.getGenero());
            statement.setInt(6, this.getUnidadesDisponibles());
            statement.executeUpdate();
            System.out.println("DVD insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el DVD en la base de datos.");
            e.printStackTrace();
        }
    }

    public void actualizarDvd(ConnectionDb conexion) {
        String query = "UPDATE dvds SET titulo = ?, director = ?, duracion = ?, genero = ? WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getTitulo()); // Update with appropriate properties
            statement.setString(2, this.director);
            statement.setString(3, this.getDuracion());
            statement.setString(4, this.getGenero());
            statement.setString(5, this.getCodigoIdentificacion());
            statement.executeUpdate();
            System.out.println("DVD actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el DVD en la base de datos.");
            e.printStackTrace();
        }
    }

    public void borrarDvd(ConnectionDb conexion) {
        String query = "DELETE FROM dvds WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getCodigoIdentificacion()); // Delete based on the unique identifier
            statement.executeUpdate();
            System.out.println("DVD eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el DVD de la base de datos.");
            e.printStackTrace();
        }
    }

    public void seleccionarDvd(ConnectionDb conexion, int codigoIdentificacion) {
        String query = "SELECT * FROM dvds WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setInt(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Retrieve data from the result set and set it to the properties of the Dvd object
                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                this.setTitulo(resultSet.getString("titulo"));
                this.director = resultSet.getString("director");
                this.setDuracion(resultSet.getString("duracion"));
                this.setGenero(resultSet.getString("genero"));
                // Set other properties accordingly
            }
            System.out.println("DVD seleccionado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el DVD de la base de datos.");
            e.printStackTrace();
        }
    }
}
