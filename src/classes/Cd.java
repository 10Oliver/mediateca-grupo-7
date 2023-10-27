package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cd extends MaterialAudiovisual {
    private int CdId;
    private String artista;
    private int numCanciones;

    public Cd(){}
    public Cd(String codigoIdentificacion){
        super(codigoIdentificacion);
    }
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
            statement.setString(5, this.getDuracion());
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
        String query = "UPDATE cds SET titulo = ?, artista = ?, genero = ?, duracion = ?, num_canciones = ?, unidades_disponibles = ? WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getTitulo()); // Update with appropriate properties
            statement.setString(2, this.getArtista());
            statement.setString(3, this.getGenero());
            statement.setString(4, this.getDuracion());
            statement.setInt(5, this.numCanciones);
            statement.setInt(6,this.getUnidadesDisponibles());
            statement.setString(7, this.getCodigoIdentificacion());
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

    public Cd seleccionarCd(ConnectionDb conexion, String codigoIdentificacion) {
        String query = "SELECT * FROM cds WHERE codigo_identificacion = ?";
        Cd cd = null;
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                this.setTitulo(resultSet.getString("titulo"));
                this.setArtista(resultSet.getString("artista"));
                super.setGenero(resultSet.getString("genero"));
                this.setDuracion(resultSet.getString("duracion"));
                this.numCanciones = resultSet.getInt("num_canciones");
                this.setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                cd = new Cd(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getGenero(),getDuracion(),getCdId(),getArtista(),getNumCanciones());
            }
            System.out.println("CD seleccionado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el CD de la base de datos.");
            e.printStackTrace();
        }
        return cd;
    }
    public List<Cd> seleccionarTodosCds(ConnectionDb conexion) {
        String query = "SELECT codigo_identificacion, titulo, nombre_artista as artista, nombre_genero as genero, duracion, num_canciones, unidades_disponibles FROM cds c\n" +
        "INNER JOIN generos g ON g.id_genero = c.id_genero\n" +
        "INNER JOIN artista a ON a.id_artista = c.id_artista;";
        Cd cd = null;
        List<Cd> cds = new ArrayList<Cd>();
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                this.setTitulo(resultSet.getString("titulo"));
                this.setArtista(resultSet.getString("artista"));
                super.setGenero(resultSet.getString("genero"));
                this.setDuracion(resultSet.getString("duracion"));
                this.numCanciones = resultSet.getInt("num_canciones");
                this.setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                cd = new Cd(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getGenero(),getDuracion(),getCdId(),getArtista(),getNumCanciones());
                cds.add(cd);
            }
            System.out.println("CD seleccionado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el CD de la base de datos.");
            e.printStackTrace();
        }
        return cds;
    }
}
