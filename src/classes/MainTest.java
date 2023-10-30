package classes;

public class MainTest {

    public static void main(String[] args) {
        ConnectionDb conexion = new ConnectionDb();
        /*Hay 2 tipos de constructores, el primero es para la insercion de data asi como edicion
        en el primero se coloca el numero que se desea para identificacion
        luego la base de datos se encargara de crear el codigo de identificacion
        dependiendo el material

        el segundo constructor es para buscar y hacer los Select statements asi como el de borrado
        ya que en ambos metodos solo se necesite esa informacion debajo estaran los dos constructores
        pero el segundo estara comentado para que se pueda modificar,
        para saber el codigo que la base de datos creara puedes consultarla al crear el material
        */



        // Cd cd = new Cd("1", "Best of Pop", 15, "Pop", "2 hours", 1, "Various Artists", 20);
//        Cd cd = new Cd("");
// Cd cds = new Cd();
        // List<Cd> cdShow = cds.seleccionarTodosCds(conexion);

        // for (Cd cdShower : cdShow) {
        //         System.out.println("Duracion: "+cdShower.getDuracion());
        //         System.out.println("Titulo: "+cdShower.getTitulo());
        //         System.out.println("Unidades Disponibles :"+cdShower.getUnidadesDisponibles());
        //     System.out.println("");
        //     System.out.println("");
        // }
        // cd.insertarCd(conexion);
        // cd.seleccionarCd(conexion, cd.getCodigoIdentificacion());
        // cd.actualizarCd(conexion);
        // cd.borrarCd(conexion);


//        Dvd dvd = new Dvd("1", "Movie Night", 5, "Comedy", "2 hours", 1, "John Doe");
////        Dvd dvd = new Dvd("");
//        dvd.insertarDvd(conexion);
//        dvd.seleccionarDvd(conexion, dvd.getCodigoIdentificacion());
//        dvd.actualizarDvd(conexion);
//        dvd.borrarDvd(conexion);
//
//
//        Libro libro = new Libro("1", "Introduction to Programming", 10, "Tech Publications", 1, "Jane Smith", 300, 1234567890, 2020);
////        Libro libro = new Libro("");
//        libro.insertarLibro(conexion);
//        libro.seleccionarLibro(conexion, libro.getCodigoIdentificacion());
//        libro.actualizarLibro(conexion);
//        libro.borrarLibro(conexion);
//
//
//        Revista revista = new Revista("1", "Tech Today", 20, "Tech Publications", 1, "Monthly", "2023-10-01");
////        Revista revista = new Revista("");
//        revista.insertarRevista(conexion);
//        revista.seleccionarRevista(conexion, revista.getCodigoIdentificacion());
//        revista.actualizarRevista(conexion);
//        revista.borrarRevista(conexion);


    }

}
