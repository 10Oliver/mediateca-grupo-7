package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dvd extends MaterialAudiovisual {
<<<<<<< Updated upstream
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
=======
    private int id_dvd;
    private String director;
    final String INSERT_STATEMENT = "INSERT INTO dvds (codigo_identificacion, titulo, director, duracion, id_genero, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?)";
    final String SELECT_STATEMENT = "SELECT dvds.id_dvd, dvds.codigo_identificacion, dvds.titulo, dvds.director, dvds.duracion, generos.nombre_genero, dvds.unidades_disponibles FROM dvds JOIN generos ON dvds.id_genero = generos.id_genero WHERE dvds.codigo_identificacion = ?";
    final String SELECTALL_STATEMENT = "SELECT dvds.id_dvd, dvds.codigo_identificacion, dvds.titulo, dvds.director, dvds.duracion, generos.nombre_genero, dvds.unidades_disponibles FROM dvds JOIN generos ON dvds.id_genero = generos.id_genero";
    final String UPDATE_STATEMENT = "UPDATE dvds SET codigo_identificacion=?, titulo=?, director=?, duracion=?, id_genero=?, unidades_disponibles=? WHERE id_dvd=?";
    final String DELETE_STATEMENT = "DELETE FROM dvds WHERE id_dvd=?";

    public Dvd() {
    }

    public Dvd(String codigo_identificacion) {
        super(codigo_identificacion);
    }

    public Dvd(String codigo_identificacion, String titulo, int unidades_disponibles, String genero, String duracion, int id_dvd, String director) {
        super(codigo_identificacion, titulo, unidades_disponibles, genero, duracion);
        this.id_dvd = id_dvd;
        this.director = director;
    }

    public int getId_dvd() {
        return id_dvd;
    }

    public void setId_dvd(int id_dvd) {
        this.id_dvd = id_dvd;
>>>>>>> Stashed changes
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

<<<<<<< Updated upstream
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
=======
    public void insertDVD(ConnectionDb connection, int idGenero) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(INSERT_STATEMENT);
            statement.setString(1, getCodigoIdentificacion());
            statement.setString(2, getTitulo());
            statement.setString(3, getDirector());
            statement.setString(4, getDuracion());
            statement.setInt(5, idGenero);
            statement.setInt(6, getUnidadesDisponibles());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new DVD was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting DVD: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void updateDVD(ConnectionDb connection,int idGenero) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(UPDATE_STATEMENT);
            statement.setString(1, getCodigoIdentificacion());
            statement.setString(2, getTitulo());
            statement.setString(3, getDirector());
            statement.setString(4, getDuracion());
            statement.setInt(5, idGenero);
            statement.setInt(6, getUnidadesDisponibles());
            statement.setInt(7, getId_dvd());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("DVD was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating DVD: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteDVD(ConnectionDb connection) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(DELETE_STATEMENT);
            statement.setInt(1, getId_dvd());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("DVD was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting DVD: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public Dvd seleccionarDvd(String codigoIdentificacion, ConnectionDb connection) {
        Dvd dvd = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SELECT_STATEMENT);
            statement.setString(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id_dvd");
                String codigo = resultSet.getString("codigo_identificacion");
                String titulo = resultSet.getString("titulo");
                String director = resultSet.getString("director");
                String duracion = resultSet.getString("duracion");
                String genero = resultSet.getString("nombre_genero");
                int unidades = resultSet.getInt("unidades_disponibles");
                dvd = new Dvd(codigo,titulo,unidades,genero,duracion,id,director);
            } else {
                System.out.println("No DVD found with the provided ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while selecting the DVD: " + e.getMessage());
>>>>>>> Stashed changes
            e.printStackTrace();
        }
        return dvd;
    }
<<<<<<< Updated upstream

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
=======
    public List<Dvd> seleccionarTodosDvd(String codigoIdentificacion, ConnectionDb connection) {
        List<Dvd> dvds = new ArrayList<Dvd>();
        Dvd dvd = null;
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SELECT_STATEMENT);
            statement.setString(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id_dvd");
                String codigo = resultSet.getString("codigo_identificacion");
                String titulo = resultSet.getString("titulo");
                String director = resultSet.getString("director");
                String duracion = resultSet.getString("duracion");
                String genero = resultSet.getString("nombre_genero");
                int unidades = resultSet.getInt("unidades_disponibles");
                dvd = new Dvd(codigo,titulo,unidades,genero,duracion,id,director);
                dvds.add(dvd);
            } else {
                System.out.println("No DVD found with the provided ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while selecting the DVD: " + e.getMessage());
>>>>>>> Stashed changes
            e.printStackTrace();
        }
        return dvds;
    }
<<<<<<< Updated upstream
}
=======


}
>>>>>>> Stashed changes
