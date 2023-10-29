package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cd extends MaterialAudiovisual {
    private int id_cd;
    private String artista;
    private int num_canciones;
    final String INSERT_STATEMENT = "INSERT INTO cds (titulo, id_artista, id_genero, duracion, num_canciones, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?)";
    final String SELECT_STATEMENT = "SELECT c.id_cd, c.codigo_identificacion, c.titulo, a.nombre_artista, g.nombre_genero, c.duracion, c.num_canciones, c.unidades_disponibles FROM cds c INNER JOIN artista a ON c.id_artista = a.id_artista INNER JOIN generos g ON c.id_genero = g.id_genero WHERE c.codigo_identificacion = ?";
    final String UPDATE_STATEMENT = "UPDATE cds SET titulo = ?, id_artista = ?, id_genero = ?, duracion = ?, num_canciones = ?, unidades_disponibles = ? WHERE codigo_identificacion = ?";
    final String DELETE_STATEMENT = "DELETE FROM cds WHERE codigo_identificacion = ?";
    final String SELECTALL_STATEMENT = "SELECT c.id_cd, c.codigo_identificacion, c.titulo, a.nombre_artista, g.nombre_genero, c.duracion, c.num_canciones, c.unidades_disponibles FROM cds c INNER JOIN artista a ON c.id_artista = a.id_artista INNER JOIN generos g ON c.id_genero = g.id_genero";

    public Cd() {
    }

    public Cd(String codigo_identificacion) {
        super(codigo_identificacion);
    }

    public Cd(String codigo_identificacion, String titulo, int unidades_disponibles, String genero, String duracion, int id_cd, String artista, int num_canciones) {
        super(codigo_identificacion, titulo, unidades_disponibles, genero, duracion);
        this.id_cd = id_cd;
        this.artista = artista;
        this.num_canciones = num_canciones;
    }

    public int getId_cd() {
        return id_cd;
    }

    public void setId_cd(int id_cd) {
        this.id_cd = id_cd;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNum_canciones() {
        return num_canciones;
    }

    public void setNum_canciones(int num_canciones) {
        this.num_canciones = num_canciones;
    }

    public Cd selectCD(ConnectionDb connection) {
            Cd cd = null;
            try {
                PreparedStatement statement = connection.getConnection().prepareStatement(SELECT_STATEMENT);
                statement.setString(1, getCodigoIdentificacion());
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id_cd");
                    String codigo = resultSet.getString("codigo_identificacion");
                    String titulo = resultSet.getString("titulo");
                    String artista = resultSet.getString("nombre_artista");
                    String genero = resultSet.getString("nombre_genero");
                    String duracion = resultSet.getString("duracion");
                    int numCanciones = resultSet.getInt("num_canciones");
                    int unidadesDisponibles = resultSet.getInt("unidades_disponibles");
                    cd = new Cd(codigo,titulo,unidadesDisponibles,genero,duracion,id,artista,numCanciones);
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while selecting CD: " + e.getMessage());
                e.printStackTrace();
            }
            return cd;
        }
    public void insertCD(ConnectionDb connection,int idArtista, int idGenero) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(INSERT_STATEMENT);
            statement.setString(1, getTitulo());
            statement.setInt(2, idArtista);
            statement.setInt(3, idGenero);
            statement.setString(4, getDuracion());
            statement.setInt(5, getNum_canciones());
            statement.setInt(6, getUnidadesDisponibles());
            statement.executeUpdate();
            System.out.println("CD inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting CD: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void updateCD(ConnectionDb connection,int idArtista,int idGenero) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(UPDATE_STATEMENT);
            statement.setString(1, getTitulo());
            statement.setInt(2, idArtista);
            statement.setInt(3, idGenero);
            statement.setString(4, getDuracion());
            statement.setInt(5, getNum_canciones());
            statement.setInt(6, getUnidadesDisponibles());
            statement.setString(7, getCodigoIdentificacion());
            statement.executeUpdate();
            System.out.println("CD updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while updating CD: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public List<Cd> selectTodosCd(ConnectionDb connection){
        Cd cd = null;
        List<Cd> cds = new ArrayList<Cd>();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(SELECTALL_STATEMENT);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_cd");
                String codigo = resultSet.getString("codigo_identificacion");
                String titulo = resultSet.getString("titulo");
                String artista = resultSet.getString("nombre_artista");
                String genero = resultSet.getString("nombre_genero");
                String duracion = resultSet.getString("duracion");
                int numCanciones = resultSet.getInt("num_canciones");
                int unidadesDisponibles = resultSet.getInt("unidades_disponibles");
                cd = new Cd(codigo,titulo,unidadesDisponibles,genero,duracion,id,artista,numCanciones);
                cds.add(cd);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while selecting CD: " + e.getMessage());
            e.printStackTrace();
        }
        return cds;
    }
    public boolean borrarCd(ConnectionDb connection) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(DELETE_STATEMENT);
            statement.setString(1, getCodigoIdentificacion());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("CD deleted successfully.");
                return true;
            } else {
                System.out.println("CD with id " + getCodigoIdentificacion() + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting CD: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

 }

