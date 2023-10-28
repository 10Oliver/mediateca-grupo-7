package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Revista extends MaterialEscrito {
        private int revistaId;
        private String periodicidad;
        private String fechaPublicacion;
        final String INSERT_STATEMENT = "INSERT INTO revistas (titulo, id_editorial, periodicidad, fecha_publicacion, unidades_disponibles) VALUES (?, ?, ?, ?, ?)";
        final String SELECT_STATEMENT = "SELECT r.id_revista, r.codigo_identificacion, r.titulo, e.nombre_editorial, r.periodicidad, r.fecha_publicacion, r.unidades_disponibles FROM revistas r INNER JOIN editorial e ON r.id_editorial = e.id_editorial WHERE r.codigo_identificacion = ?";
        final String UPDATE_STATEMENT = "UPDATE revistas SET titulo = ?, id_editorial = ?, periodicidad = ?, fecha_publicacion = ?, unidades_disponibles = ? WHERE codigo_identificacion = ?";
        final String DELETE_STATEMENT = "DELETE FROM revistas WHERE codigo_identificacion = ?";
        final String SELECTALL_STATEMENT = "SELECT r.id_revista, r.codigo_identificacion, r.titulo, e.nombre_editorial, r.periodicidad, r.fecha_publicacion, r.unidades_disponibles FROM revistas r INNER JOIN editorial e ON r.id_editorial = e.id_editorial";

        public Revista() {

        }

        public Revista(String codigoIdentificacion) {
                super(codigoIdentificacion);
        }

        public Revista(String codigoIdentificacion, String titulo, int unidadesDisponibles, String editorial, int revistaId, String periodicidad, String fechaPublicacion) {
                super(codigoIdentificacion, titulo, unidadesDisponibles, editorial);
                this.revistaId = revistaId;
                this.periodicidad = periodicidad;
                this.fechaPublicacion = fechaPublicacion;
        }

        public int getRevistaId() {
                return revistaId;
        }

        public void setRevistaId(int revistaId) {
                this.revistaId = revistaId;
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

        public void insertRevista(ConnectionDb connection,int idEditorial) {
                try {
                        PreparedStatement statement = connection.getConnection().prepareStatement(INSERT_STATEMENT);
                        statement.setString(1, getTitulo());
                        statement.setInt(2, idEditorial);
                        statement.setString(3, getPeriodicidad());
                        statement.setString(4, getFechaPublicacion());
                        statement.setInt(5, getUnidadesDisponibles());

                        statement.executeUpdate();
                        System.out.println("Revista inserted successfully.");
                } catch (SQLException e) {
                        System.out.println("Error occurred while inserting revista: " + e.getMessage());
                        e.printStackTrace();
                }
        }

        public void updateRevista(ConnectionDb connection,int idEditorial) {
                try {
                        PreparedStatement statement = connection.getConnection().prepareStatement(UPDATE_STATEMENT);
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
                        e.printStackTrace();
                }
        }

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
                        e.printStackTrace();
                }
                return revista;
        }

        public List<Revista> SeleccionarTodasRevista(ConnectionDb connection){
                List<Revista> revistas = new ArrayList<Revista>();
                Revista revista = null;
                try {
                        PreparedStatement statement = connection.getConnection().prepareStatement(SELECTALL_STATEMENT);
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
                        e.printStackTrace();
                }
                return revistas;
        }

}
