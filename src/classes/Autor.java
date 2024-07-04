package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Autor {
    private int id_autor;
    private String nombre_autor;
    private String nacionalidad;

    public Autor() {
    }

    public Autor(int id_autor, String nombre_autor, String nacionalidad) {
        this.id_autor = id_autor;
        this.nombre_autor = nombre_autor;
        this.nacionalidad = nacionalidad;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Autor> seleccionarTodosAutores(ConnectionDb conexion) {
        String query = "SELECT * FROM autor";
        Autor autor;
        List<Autor> autores = new ArrayList<>();
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_autor");
                String nombre = resultSet.getString("nombre_autor");
                String nacionalidad = resultSet.getString("nacionalidad");
                autor = new Autor(id, nombre, nacionalidad);
                autores.add(autor);
            }
            System.out.println("Todos los autores seleccionados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar los autores de la base de datos.");
            e.printStackTrace();
        }
        return autores;
    }
}
