package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Revista extends MaterialEscrito {
        private int RevistaId;
        private String periodicidad;
        private String fechaPublicacion;

        public Revista() {

        }

public Revista(String codigoIdentificacion){
        super(codigoIdentificacion);
}
        public Revista(String codigoIdentificacion, String titulo, int unidadesDisponibles, String editorial, int revistaId, String periodicidad, String fechaPublicacion) {
                super(codigoIdentificacion, titulo, unidadesDisponibles, editorial);
                RevistaId = revistaId;
                this.periodicidad = periodicidad;
                this.fechaPublicacion = fechaPublicacion;
        }

        public int getRevistaId() {
                return RevistaId;
        }

        public void setRevistaId(int revistaId) {
                RevistaId = revistaId;
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
                        e.printStackTrace();
                }
        }

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
                        e.printStackTrace();
                }
        }

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
                        e.printStackTrace();
                }
                return revista;
        }

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
                        e.printStackTrace();
                }
                return revistas;
        }

    public boolean borrarRevista(ConnectionDb conexion, String codigoIdentificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }
}
    
