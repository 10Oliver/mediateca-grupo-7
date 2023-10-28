package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dvd extends MaterialAudiovisual {
    private int DvdId;
    private String director;

    public Dvd() {}
public Dvd(String codigoIdentificacion){
    super(codigoIdentificacion);
}
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
        String query = "UPDATE dvds SET titulo = ?, director = ?, duracion = ?, genero = ?, unidades_disponibles = ? WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getTitulo()); // Update with appropriate properties
            statement.setString(2, this.director);
            statement.setString(3, this.getDuracion());
            statement.setString(4, this.getGenero());
             statement.setInt(5, this.getUnidadesDisponibles());
             statement.setString(6, this.getCodigoIdentificacion());
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

    public Dvd seleccionarDvd(ConnectionDb conexion, String codigoIdentificacion) {
        String query = "SELECT * FROM dvds WHERE codigo_identificacion = ?";
        Dvd dvd = null;
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Retrieve data from the result set and set it to the properties of the Dvd object
                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                this.setTitulo(resultSet.getString("titulo"));
                this.director = resultSet.getString("director");
                this.setDuracion(resultSet.getString("duracion"));
                this.setGenero(resultSet.getString("genero"));
                this.setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                // Set other properties accordingly
                dvd = new Dvd(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getGenero(),getDuracion(),getDvdId(),getDirector());
            }
            System.out.println("DVD seleccionado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el DVD de la base de datos.");
            e.printStackTrace();
        }
        return dvd;
    }

    public List<Dvd> seleccionarTodosDvd(ConnectionDb conexion) {
        String query = "SELECT * FROM dvds";
        Dvd dvd = null;
        List<Dvd> dvds = new ArrayList<Dvd>();
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            // statement.setString(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Retrieve data from the result set and set it to the properties of the Dvd object
                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                this.setTitulo(resultSet.getString("titulo"));
                this.director = resultSet.getString("director");
                this.setDuracion(resultSet.getString("duracion"));
                this.setGenero(resultSet.getString("genero"));
                this.setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                // Set other properties accordingly
                dvd = new Dvd(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getGenero(),getDuracion(),getDvdId(),getDirector());
                dvds.add(dvd);
            }
            System.out.println("DVD seleccionado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el DVD de la base de datos.");
            e.printStackTrace();
        }
        return dvds;
    }

    public boolean borrarDvd(ConnectionDb conexion, String codigoIdentificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
