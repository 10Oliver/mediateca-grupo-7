package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Genero {
    private int id_genero;
    private String nombre_genero;
    private boolean dvd_or_cd;

    public Genero(int id_genero, String nombre_genero, boolean dvd_or_cd) {
        this.id_genero = id_genero;
        this.nombre_genero = nombre_genero;
        this.dvd_or_cd = dvd_or_cd;
    }

    public Genero() {
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }

    public boolean isDvd_or_cd() {
        return dvd_or_cd;
    }

    public void setDvd_or_cd(boolean dvd_or_cd) {
        this.dvd_or_cd = dvd_or_cd;
    }

    public List<Genero> seleccionarTodosGeneros(ConnectionDb conexion) {
        String query = "SELECT * FROM generos";
        Genero genero;
        List<Genero> generos = new ArrayList<>();
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_genero");
                String nombre = resultSet.getString("nombre_genero");
                boolean dvdOrCd = resultSet.getBoolean("dvd_or_cd");
                genero = new Genero(id, nombre, dvdOrCd);
                generos.add(genero);
            }
            System.out.println("Todos los géneros seleccionados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar los géneros de la base de datos.");
            e.printStackTrace();
        }
        return generos;
    }
}