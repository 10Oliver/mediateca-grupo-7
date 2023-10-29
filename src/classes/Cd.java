package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cd extends MaterialAudiovisual {
<<<<<<< Updated upstream
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
=======
    private int id_cd;
    private String artista;
    private int num_canciones;
    final String INSERT_STATEMENT = "INSERT INTO cds (codigo_identificacion, titulo, id_artista, id_genero, duracion, num_canciones, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String SELECT_STATEMENT = "SELECT c.id_cd, c.codigo_identificacion, c.titulo, a.nombre_artista, g.nombre_genero, c.duracion, c.num_canciones, c.unidades_disponibles FROM cds c INNER JOIN artista a ON c.id_artista = a.id_artista INNER JOIN generos g ON c.id_genero = g.id_genero WHERE c.codigo_identificacion = ?";
    final String UPDATE_STATEMENT = "UPDATE cds SET codigo_identificacion = ?, titulo = ?, id_artista = ?, id_genero = ?, duracion = ?, num_canciones = ?, unidades_disponibles = ? WHERE id_cd = ?";
    final String DELETE_STATEMENT = "DELETE FROM cds WHERE id_cd = ?";
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
>>>>>>> Stashed changes
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

<<<<<<< Updated upstream
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
        String query = "SELECT * FROM cds";
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
=======
    public int getNum_canciones() {
        return num_canciones;
    }

    public void setNum_canciones(int num_canciones) {
        this.num_canciones = num_canciones;
    }

    public Cd selectCD(ConnectionDb connection,int idCD) {
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
            statement.setString(1, getCodigoIdentificacion());
            statement.setString(2, getTitulo());
            statement.setInt(3, idArtista);
            statement.setInt(4, idGenero);
            statement.setString(5, getDuracion());
            statement.setInt(6, getNum_canciones());
            statement.setInt(7, getUnidadesDisponibles());
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
            statement.setString(1, getCodigoIdentificacion());
            statement.setString(2, getTitulo());
            statement.setInt(3, idArtista);
            statement.setInt(4, idGenero);
            statement.setString(5, getDuracion());
            statement.setInt(6, getNum_canciones());
            statement.setInt(7, getUnidadesDisponibles());
            statement.setInt(8, getId_cd());
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
>>>>>>> Stashed changes
            e.printStackTrace();
        }
        return cds;
    }
<<<<<<< Updated upstream
=======
    public void deleteCD(ConnectionDb connection) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(DELETE_STATEMENT);
            statement.setInt(1, getId_cd());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("CD deleted successfully.");
            } else {
                System.out.println("CD with id " + getCodigoIdentificacion() + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting CD: " + e.getMessage());
            e.printStackTrace();
        }
    }


>>>>>>> Stashed changes
}
