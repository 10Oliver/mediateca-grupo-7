package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Editorial {
    private int id_editorial;
    private String nombre_editorial;
    private String contacto;
    private String telefono;

    public Editorial(int id_editorial, String nombre_editorial, String contacto, String telefono) {
        this.id_editorial = id_editorial;
        this.nombre_editorial = nombre_editorial;
        this.contacto = contacto;
        this.telefono = telefono;
    }

    public Editorial() {

    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Editorial> seleccionarTodosEditoriales(ConnectionDb conexion) {
        String query = "SELECT * FROM editorial";
        Editorial editorial;
        List<Editorial> editoriales = new ArrayList<>();
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_editorial");
                String nombre = resultSet.getString("nombre_editorial");
                String contacto = resultSet.getString("contacto");
                String telefono = resultSet.getString("telefono");
                editorial = new Editorial(id, nombre, contacto, telefono);
                editoriales.add(editorial);
            }
            System.out.println("Todos los editoriales seleccionados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar los editoriales de la base de datos.");
            e.printStackTrace();
        }
        return editoriales;
    }
}
