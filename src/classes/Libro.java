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

<<<<<<< Updated upstream

=======
    final String INSERT_STATEMENT = "INSERT INTO libros (codigo_identificacion, titulo, id_autor, num_paginas, id_editorial, ISBN, anio_publicacion, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    final String SELECT_STATEMENT = "SELECT l.id_libro, l.codigo_identificacion, l.titulo, a.nombre_autor, l.num_paginas, e.nombre_editorial, l.ISBN, l.anio_publicacion, l.unidades_disponibles FROM libros l JOIN autor a ON l.id_autor = a.id_autor JOIN editorial e ON l.id_editorial = e.id_editorial WHERE codigo_identificacion = ?";
    final String UPDATE_STATEMENT = "UPDATE libros SET codigo_identificacion = ?, titulo = ?, id_autor = ?, num_paginas = ?, id_editorial = ?, ISBN = ?, anio_publicacion = ?, unidades_disponibles = ? WHERE id_libro = ?";
    final String DELETE_STATEMENT = "DELETE FROM libros WHERE id_libro = ?";
    final String SELECTALL_STATEMENT = "SELECT l.id_libro, l.codigo_identificacion, l.titulo, a.nombre_autor, l.num_paginas, e.nombre_editorial, l.ISBN, l.anio_publicacion, l.unidades_disponibles FROM libros l JOIN autor a ON l.id_autor = a.id_autor JOIN editorial e ON l.id_editorial = e.id_editorial";
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream

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
=======
    public Libro seleccionarLibro(String codigoIdentificacion,ConnectionDb connection) {
        Libro libro = null;
        try {

            PreparedStatement statement = connection.getConnection().prepareStatement(SELECT_STATEMENT);
            statement.setString(1, codigoIdentificacion);

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
>>>>>>> Stashed changes
            statement.setString(1, this.getCodigoIdentificacion());
            statement.executeUpdate();
            System.out.println("Libro eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro de la base de datos.");
            e.printStackTrace();
        }
    }
<<<<<<< Updated upstream

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
=======
    public void updateLibro(ConnectionDb connection,int idAutor,int idEditorial) {

        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(UPDATE_STATEMENT);
            statement.setString(1, getCodigoIdentificacion());
            statement.setString(2, getTitulo());
            statement.setInt(3, idAutor);
            statement.setInt(4, getNumPaginas());
            statement.setInt(5, idEditorial);
            statement.setInt(6, getISBN());
            statement.setInt(7, getAnioPublicacion());
            statement.setInt(8, getUnidadesDisponibles());
            statement.setInt(9, getLibroId());

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
            statement.setString(1, getCodigoIdentificacion());
            statement.setString(2, getTitulo());
            statement.setInt(3, autorId);
            statement.setInt(4, getNumPaginas());
            statement.setInt(5, editorialId);
            statement.setInt(6, getISBN());
            statement.setInt(7, getAnioPublicacion());
            statement.setInt(8, getUnidadesDisponibles());

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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}