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

    final String INSERT_STATEMENT = "INSERT INTO libros (titulo, id_autor, num_paginas, id_editorial, ISBN, anio_publicacion, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String SELECT_STATEMENT = "SELECT l.id_libro, l.codigo_identificacion, l.titulo, a.nombre_autor, l.num_paginas, e.nombre_editorial, l.ISBN, l.anio_publicacion, l.unidades_disponibles FROM libros l JOIN autor a ON l.id_autor = a.id_autor JOIN editorial e ON l.id_editorial = e.id_editorial WHERE codigo_identificacion = ?";
    final String UPDATE_STATEMENT = "UPDATE libros SET titulo = ?, id_autor = ?, num_paginas = ?, id_editorial = ?, ISBN = ?, anio_publicacion = ?, unidades_disponibles = ? WHERE codigo_identificacion = ?";
    final String DELETE_STATEMENT = "DELETE FROM libros WHERE codigo_identificacion = ?";
    final String SELECTALL_STATEMENT = "SELECT l.id_libro, l.codigo_identificacion, l.titulo, a.nombre_autor, l.num_paginas, e.nombre_editorial, l.ISBN, l.anio_publicacion, l.unidades_disponibles FROM libros l JOIN autor a ON l.id_autor = a.id_autor JOIN editorial e ON l.id_editorial = e.id_editorial";
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

    public Libro seleccionarLibro(ConnectionDb connection) {
        Libro libro = null;
        try {

            PreparedStatement statement = connection.getConnection().prepareStatement(SELECT_STATEMENT);
            statement.setString(1, getCodigoIdentificacion());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                setLibroId(resultSet.getInt("id_libro"));
                setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                setTitulo(resultSet.getString("titulo"));
                setNombreAutor(resultSet.getString("nombre_autor"));
                setNumPaginas(resultSet.getInt("num_paginas"));
                setEditorial(resultSet.getString("nombre_editorial"));
                setISBN(resultSet.getInt("ISBN"));
                setAnioPublicacion(resultSet.getInt("anio_publicacion"));
                setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                libro = new Libro(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getEditorial(),getLibroId(),getNombreAutor(),getNumPaginas(),getISBN(),getAnioPublicacion());

            } else {
                System.out.println("No libro found with the provided ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while selecting the libro: " + e.getMessage());
            e.printStackTrace();
        }
        return libro;
    }
    public void borrarLibro(ConnectionDb conexion) {
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(DELETE_STATEMENT);
            statement.setString(1, this.getCodigoIdentificacion());
            statement.executeUpdate();
            System.out.println("Libro eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro de la base de datos.");
            e.printStackTrace();
        }
    }
    public void updateLibro(ConnectionDb connection,int idAutor,int idEditorial) {

        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(UPDATE_STATEMENT);
            statement.setString(1, getTitulo());
            statement.setInt(2, idAutor);
            statement.setInt(3, getNumPaginas());
            statement.setInt(4, idEditorial);
            statement.setInt(5, getISBN());
            statement.setInt(6, getAnioPublicacion());
            statement.setInt(7, getUnidadesDisponibles());
            statement.setString(8, getCodigoIdentificacion());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Libro updated successfully.");
            } else {
                System.out.println("No libro found with the provided ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating the libro: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void insertarLibro(ConnectionDb connection,int autorId,int editorialId){
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(INSERT_STATEMENT);
            statement.setString(1, getTitulo());
            statement.setInt(2, autorId);
            statement.setInt(3, getNumPaginas());
            statement.setInt(4, editorialId);
            statement.setInt(5, getISBN());
            statement.setInt(6, getAnioPublicacion());
            statement.setInt(7, getUnidadesDisponibles());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new libro was inserted successfully!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Libro> seleccionarTodosLibro(ConnectionDb conexion) {
        Libro libro = null;
        List<Libro> libros = new ArrayList<Libro>();
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(SELECTALL_STATEMENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                setLibroId(resultSet.getInt("id_libro"));
                setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                setTitulo(resultSet.getString("titulo"));
                setNombreAutor(resultSet.getString("nombre_autor"));
                setNumPaginas(resultSet.getInt("num_paginas"));
                setEditorial(resultSet.getString("nombre_editorial"));
                setISBN(resultSet.getInt("ISBN"));
                setAnioPublicacion(resultSet.getInt("anio_publicacion"));
                setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
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