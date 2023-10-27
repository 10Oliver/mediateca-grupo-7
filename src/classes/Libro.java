package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Libro extends MaterialEscrito{
    private int LibroId;
    private String NombreAutor;
    private int NumPaginas;
    private int ISBN;
    private int AnioPublicacion;


    public Libro(){}
    public Libro(String codigoIdentificacion){
        super(codigoIdentificacion);
    }
    public Libro(String codigoIdentificacion, String titulo, int unidadesDisponibles, String editorial, int libroId, String nombreAutor, int numPaginas, int ISBN, int anioPublicacion) {
        super(codigoIdentificacion, titulo, unidadesDisponibles, editorial);
        LibroId = libroId;
        NombreAutor = nombreAutor;
        NumPaginas = numPaginas;
        this.ISBN = ISBN;
        AnioPublicacion = anioPublicacion;
    }

    public int getLibroId() {
        return LibroId;
    }

    public void setLibroId(int libroId) {
        LibroId = libroId;
    }

    public String getNombreAutor() {
        return NombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        NombreAutor = nombreAutor;
    }

    public int getNumPaginas() {
        return NumPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        NumPaginas = numPaginas;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnioPublicacion() {
        return AnioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        AnioPublicacion = anioPublicacion;
    }


    public void insertarLibro(ConnectionDb conexion) {
        String query = "INSERT INTO libros (codigo_identificacion, titulo, nombre_autor, num_paginas, editorial, ISBN, anio_publicacion, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            //line below required for an int (pending review)
            statement.setString(1, this.getCodigoIdentificacion());
            statement.setString(2, this.getTitulo());
            statement.setString(3, this.getNombreAutor());
            statement.setInt(4, this.getNumPaginas());
            statement.setString(5, this.getEditorial());
            statement.setInt(6, this.getISBN());
            statement.setInt(7, this.getAnioPublicacion());
            statement.setInt(8, this.getUnidadesDisponibles());
            statement.executeUpdate();
            System.out.println("Libro insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el libro en la base de datos.");
            e.printStackTrace();
        }
    }

    public void actualizarLibro(ConnectionDb conexion) {
        String query = "UPDATE libros SET titulo = ?, nombre_autor = ?, num_paginas = ?, editorial = ?, ISBN = ?, anio_publicacion = ?, unidades_disponibles = ? WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getTitulo()); // Update with appropriate properties
            statement.setString(2, this.getNombreAutor());
            statement.setInt(3, this.getNumPaginas());
            statement.setString(4,this.getEditorial());
            statement.setInt(5, this.getISBN());
            statement.setInt(6,this.getAnioPublicacion());
            statement.setInt(7,this.getUnidadesDisponibles());
            statement.setString(8, this.getCodigoIdentificacion());
            statement.executeUpdate();
            System.out.println("Libro actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el libro en la base de datos.");
            e.printStackTrace();
        }
    }

    public void borrarLibro(ConnectionDb conexion) {
        String query = "DELETE FROM libros WHERE codigo_identificacion = ?";
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, this.getCodigoIdentificacion());
            statement.executeUpdate();
            System.out.println("Libro eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro de la base de datos.");
            e.printStackTrace();
        }
    }

    public Libro seleccionarLibro(ConnectionDb conexion, String codigoIdentificacion) {
        String query = "SELECT * FROM libros WHERE codigo_identificacion = ?";
        Libro libro = null;
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            statement.setString(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                this.setTitulo(resultSet.getString("titulo"));
                this.setNombreAutor(resultSet.getString("nombre_autor"));
                this.setNumPaginas(resultSet.getInt("num_paginas"));
                this.setEditorial(resultSet.getString("editorial"));
                this.setISBN(resultSet.getInt("ISBN"));
                this.setAnioPublicacion(resultSet.getInt("anio_publicacion"));
                this.setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                libro = new Libro(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getEditorial(),getLibroId(),getNombreAutor(),getNumPaginas(),getISBN(),getAnioPublicacion());
            }
            System.out.println("Libro seleccionado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el libro de la base de datos.");
            e.printStackTrace();
        }
        return libro;
    }

    public List<Libro> seleccionarTodosLibro(ConnectionDb conexion) {
        String query = "SELECT * FROM libros";
        Libro libro = null;
        List<Libro> libros = new ArrayList<Libro>();
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(query);
            // statement.setString(1, codigoIdentificacion);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                this.setTitulo(resultSet.getString("titulo"));
                this.setNombreAutor(resultSet.getString("nombre_autor"));
                this.setNumPaginas(resultSet.getInt("num_paginas"));
                this.setEditorial(resultSet.getString("editorial"));
                this.setISBN(resultSet.getInt("ISBN"));
                this.setAnioPublicacion(resultSet.getInt("anio_publicacion"));
                this.setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                libro = new Libro(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getEditorial(),getLibroId(),getNombreAutor(),getNumPaginas(),getISBN(),getAnioPublicacion());
                libros.add(libro);
            }
            System.out.println("Libro seleccionado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el libro de la base de datos.");
            e.printStackTrace();
        }
        return libros;
    }
}