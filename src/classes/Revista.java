package classes;

<<<<<<< Updated upstream
=======
import java.sql.Connection;
>>>>>>> Stashed changes
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Revista extends MaterialEscrito {
<<<<<<< Updated upstream
        private int RevistaId;
        private String periodicidad;
        private String fechaPublicacion;
=======
        private int revistaId;
        private String periodicidad;
        private String fechaPublicacion;
        final String INSERT_STATEMENT = "INSERT INTO revistas (codigo_identificacion, titulo, id_editorial, periodicidad, fecha_publicacion, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?)";
        final String SELECT_STATEMENT = "SELECT r.id_revista, r.codigo_identificacion, r.titulo, e.nombre_editorial, r.periodicidad, r.fecha_publicacion, r.unidades_disponibles FROM revistas r INNER JOIN editorial e ON r.id_editorial = e.id_editorial WHERE r.codigo_identificacion = ?";
        final String UPDATE_STATEMENT = "UPDATE revistas SET codigo_identificacion = ?, titulo = ?, id_editorial = ?, periodicidad = ?, fecha_publicacion = ?, unidades_disponibles = ? WHERE codigo_identificacion = ?";
        final String DELETE_STATEMENT = "DELETE FROM revistas WHERE id_revista = ?";
        final String SELECTALL_STATEMENT = "SELECT r.id_revista, r.codigo_identificacion, r.titulo, e.nombre_editorial, r.periodicidad, r.fecha_publicacion, r.unidades_disponibles FROM revistas r INNER JOIN editorial e ON r.id_editorial = e.id_editorial";
>>>>>>> Stashed changes

        public Revista() {

        }

<<<<<<< Updated upstream
public Revista(String codigoIdentificacion){
        super(codigoIdentificacion);
}
        public Revista(String codigoIdentificacion, String titulo, int unidadesDisponibles, String editorial, int revistaId, String periodicidad, String fechaPublicacion) {
                super(codigoIdentificacion, titulo, unidadesDisponibles, editorial);
                RevistaId = revistaId;
=======
        public Revista(String codigoIdentificacion) {
                super(codigoIdentificacion);
        }

        public Revista(String codigoIdentificacion, String titulo, int unidadesDisponibles, String editorial, int revistaId, String periodicidad, String fechaPublicacion) {
                super(codigoIdentificacion, titulo, unidadesDisponibles, editorial);
                this.revistaId = revistaId;
>>>>>>> Stashed changes
                this.periodicidad = periodicidad;
                this.fechaPublicacion = fechaPublicacion;
        }

        public int getRevistaId() {
<<<<<<< Updated upstream
                return RevistaId;
        }

        public void setRevistaId(int revistaId) {
                RevistaId = revistaId;
=======
                return revistaId;
        }

        public void setRevistaId(int revistaId) {
                this.revistaId = revistaId;
>>>>>>> Stashed changes
        }

        public String getPeriodicidad() {
                return periodicidad;
        }

        public void setPeriodicidad(String periodicidad) {
                this.periodicidad = periodicidad;
        }

        public String getFechaPublicacion() {
                return fechaPublicacion;
        }

        public void setFechaPublicacion(String fechaPublicacion) {
                this.fechaPublicacion = fechaPublicacion;
        }

<<<<<<< Updated upstream


        public void insertarRevista(ConnectionDb conexion) {
                String query = "INSERT INTO revistas (codigo_identificacion, titulo, editorial, periodicidad, fecha_publicacion, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?)";
                try {
                        PreparedStatement statement = conexion.getConnection().prepareStatement(query);
                        statement.setString(1, this.getCodigoIdentificacion());
                        statement.setString(2, this.getTitulo());
                        statement.setString(3, this.getEditorial());
                        statement.setString(4, this.periodicidad);
                        statement.setString(5, this.fechaPublicacion);
                        statement.setInt(6, this.getUnidadesDisponibles());
                        statement.executeUpdate();
                        System.out.println("Revista insertada correctamente.");
                } catch (SQLException e) {
                        System.out.println("Error al insertar la revista en la base de datos.");
=======
        public void insertRevista(ConnectionDb connection,int idEditorial) {
                try {
                        PreparedStatement statement = connection.getConnection().prepareStatement(INSERT_STATEMENT);
                        statement.setString(1, getCodigoIdentificacion());
                        statement.setString(2, getTitulo());
                        statement.setInt(3, idEditorial);
                        statement.setString(4, getPeriodicidad());
                        statement.setString(5, getFechaPublicacion());
                        statement.setInt(6, getUnidadesDisponibles());

                        statement.executeUpdate();
                        System.out.println("Revista inserted successfully.");
                } catch (SQLException e) {
                        System.out.println("Error occurred while inserting revista: " + e.getMessage());
>>>>>>> Stashed changes
                        e.printStackTrace();
                }
        }

<<<<<<< Updated upstream
        public void actualizarRevista(ConnectionDb conexion) {
                String query = "UPDATE revistas SET titulo = ?, editorial = ?, periodicidad = ?, fecha_publicacion = ?, unidades_disponibles = ? WHERE codigo_identificacion = ?";
                try {
                        PreparedStatement statement = conexion.getConnection().prepareStatement(query);
                        statement.setString(1, this.getTitulo()); // Update with appropriate properties
                        statement.setString(2, super.getEditorial());
                        statement.setString(3, this.periodicidad);
                        statement.setString(4, this.fechaPublicacion);
                        statement.setInt(5,this.getUnidadesDisponibles());
                        statement.setString(6, this.getCodigoIdentificacion());
                        statement.executeUpdate();
                        System.out.println("Revista actualizada correctamente.");
                } catch (SQLException e) {
                        System.out.println("Error al actualizar la revista en la base de datos.");
=======
        public void updateRevista(ConnectionDb connection,int idEditorial) {
                try {
                        PreparedStatement statement = connection.getConnection().prepareStatement(UPDATE_STATEMENT);
//                        statement.setString(1, getCodigoIdentificacion());
                        statement.setString(1, getTitulo());
                        statement.setInt(2, idEditorial);
                        statement.setString(3, getPeriodicidad());
                        statement.setString(4, getFechaPublicacion());
                        statement.setInt(5, getUnidadesDisponibles());
                        statement.setString(6, getCodigoIdentificacion());

                        statement.executeUpdate();
                        System.out.println("Revista updated successfully.");
                } catch (SQLException e) {
                        System.out.println("Error occurred while updating revista: " + e.getMessage());
>>>>>>> Stashed changes
                        e.printStackTrace();
                }
        }

<<<<<<< Updated upstream
        public void borrarRevista(ConnectionDb conexion) {
                String query = "DELETE FROM revistas WHERE codigo_identificacion = ?";
                try {
                        PreparedStatement statement = conexion.getConnection().prepareStatement(query);
                        statement.setString(1, this.getCodigoIdentificacion()); // Delete based on the unique identifier
                        statement.executeUpdate();
                        System.out.println("Revista eliminada correctamente.");
                } catch (SQLException e) {
                        System.out.println("Error al eliminar la revista de la base de datos.");
                        e.printStackTrace();
                }
        }

        public Revista seleccionarRevista(ConnectionDb conexion, String codigoIdentificacion) {
                String query = "SELECT * FROM revistas WHERE codigo_identificacion = ?";
                Revista revista = null;
                try {
                        PreparedStatement statement = conexion.getConnection().prepareStatement(query);
                        statement.setString(1, codigoIdentificacion);
                        ResultSet resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                                this.setTitulo(resultSet.getString("titulo"));
                                this.setEditorial(resultSet.getString("editorial"));
                                this.periodicidad = resultSet.getString("periodicidad");
                                this.fechaPublicacion = resultSet.getString("fecha_publicacion");
                                this.setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                                revista = new Revista(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getEditorial(),getRevistaId(),getPeriodicidad(),getFechaPublicacion());
                        }
                        System.out.println("Revista seleccionada correctamente.");
                } catch (SQLException e) {
                        System.out.println("Error al seleccionar la revista de la base de datos.");
=======
        public void deleteRevista(ConnectionDb connection) {
                try {
                        PreparedStatement statement = connection.getConnection().prepareStatement(DELETE_STATEMENT);
                        statement.setString(1, getCodigoIdentificacion());

                        statement.executeUpdate();
                        System.out.println("Revista deleted successfully.");
                } catch (SQLException e) {
                        System.out.println("Error occurred while deleting revista: " + e.getMessage());
                        e.printStackTrace();
                }
        }
        public Revista SeleccionarRevista(ConnectionDb connection){
                Revista revista = null;
                try {
                        PreparedStatement statement = connection.getConnection().prepareStatement(SELECT_STATEMENT);
                        statement.setString(1, getCodigoIdentificacion());
                        ResultSet resultSet = statement.executeQuery();

                        while (resultSet.next()) {
                                setRevistaId(resultSet.getInt("id_revista"));
                                setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                                setTitulo(resultSet.getString("titulo"));
                                setEditorial(resultSet.getString("nombre_editorial"));
                                setPeriodicidad(resultSet.getString("periodicidad"));
                                setFechaPublicacion(resultSet.getString("fecha_publicacion"));
                                setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                                revista = new Revista(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getEditorial(),getRevistaId(),getPeriodicidad(),getFechaPublicacion());
                        }
                } catch (SQLException e) {
                        System.out.println("Error occurred while selecting revista: " + e.getMessage());
>>>>>>> Stashed changes
                        e.printStackTrace();
                }
                return revista;
        }

<<<<<<< Updated upstream
                public List<Revista> seleccionarTodosRevista(ConnectionDb conexion) {
                String query = "SELECT * FROM revistas";
                Revista revista = null;
                List<Revista> revistas = new ArrayList<Revista>();
                try {
                        PreparedStatement statement = conexion.getConnection().prepareStatement(query);
                        // statement.setString(1, codigoIdentificacion);
                        ResultSet resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                                this.setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                                this.setTitulo(resultSet.getString("titulo"));
                                this.setEditorial(resultSet.getString("editorial"));
                                this.periodicidad = resultSet.getString("periodicidad");
                                this.fechaPublicacion = resultSet.getString("fecha_publicacion");
                                this.setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                                revista = new Revista(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getEditorial(),getRevistaId(),getPeriodicidad(),getFechaPublicacion());
                                revistas.add(revista);
                        }
                        System.out.println("Revista seleccionada correctamente.");
                } catch (SQLException e) {
                        System.out.println("Error al seleccionar la revista de la base de datos.");
=======
        public List<Revista> SeleccionarTodasRevista(ConnectionDb connection){
                List<Revista> revistas = new ArrayList<Revista>();
                Revista revista = null;
                try {
                        PreparedStatement statement = connection.getConnection().prepareStatement(SELECTALL_STATEMENT);
//                        statement.setString(1, getCodigoIdentificacion());
                        ResultSet resultSet = statement.executeQuery();

                        while (resultSet.next()) {
                                setRevistaId(resultSet.getInt("id_revista"));
                                setCodigoIdentificacion(resultSet.getString("codigo_identificacion"));
                                setTitulo(resultSet.getString("titulo"));
                                setEditorial(resultSet.getString("nombre_editorial"));
                                setPeriodicidad(resultSet.getString("periodicidad"));
                                setFechaPublicacion(resultSet.getString("fecha_publicacion"));
                                setUnidadesDisponibles(resultSet.getInt("unidades_disponibles"));
                                revista = new Revista(getCodigoIdentificacion(),getTitulo(),getUnidadesDisponibles(),getEditorial(),getRevistaId(),getPeriodicidad(),getFechaPublicacion());
                                revistas.add(revista);
                        }
                } catch (SQLException e) {
                        System.out.println("Error occurred while selecting revista: " + e.getMessage());
>>>>>>> Stashed changes
                        e.printStackTrace();
                }
                return revistas;
        }
<<<<<<< Updated upstream
}
=======

}
>>>>>>> Stashed changes
