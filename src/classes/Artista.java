package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Artista {

    private int id_artista;
    private String nombre_artista;

    public Artista(int id_artista, String nombre_artista) {
        this.id_artista = id_artista;
        this.nombre_artista = nombre_artista;
    }

    public Artista() {
    }

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }

    public List<Artista> seleccionarTodosArtistas(ConnectionDb conexion) {
        String query = "SELECT * FROM artista";
        Artista artista;
        List<Artista> artistas = new ArrayList<>();
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_artista");
                String nombre = resultSet.getString("nombre_artista");
                artista = new Artista(id, nombre);
                artistas.add(artista);
            }
            System.out.println("Todos los artistas seleccionados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar los artistas de la base de datos.");
            e.printStackTrace();
        }
        return artistas;
    }
}

