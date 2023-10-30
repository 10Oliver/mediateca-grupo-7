/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import classes.ConnectionDb;
import classes.Dvd;
import classes.Cd;
import classes.Libro;
import classes.Revista;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oliver
 */
public class ListMaterial extends javax.swing.JPanel {

    private ConnectionDb con = new ConnectionDb();

    // Posible columns
    private String[] dvdColumns = {"Código de identificación", "Titulo", "Director", "Duración", "Genero", "Unidades disponibles"};
    private String[] cdColumns = {"Código de identificación", "Titulo", "Artista", "Genero", "Duración", "Número de canciones", "Unidades disponibles"};
    private String[] bookColumns = {"Código de identificación", "Titulo", "Autor", "Número de páginas", "Editorial", "ISBN", "Año de publicación", "Unidades disponibles"};
    private String[] megazineColumns = {"Código de identificación", "Titulo", "Editorial", "Periocidad", "Fecha de publicación", "Unidades disponibles"};

    // Charge fill model
    private DefaultTableModel fillDvd(ConnectionDb connection) {
        Dvd dvd = new Dvd();
        List<Dvd> dvdList = dvd.seleccionarTodosDvd(connection);
        Vector<Vector<Object>> data = new Vector<>();
        for (Dvd dvdItem : dvdList) {
            Vector<Object> row = new Vector<>();
            row.add(dvdItem.getCodigoIdentificacion());
            row.add(dvdItem.getTitulo());
            row.add(dvdItem.getDirector());
            row.add(dvdItem.getDuracion());
            row.add(dvdItem.getGenero());
            row.add(dvdItem.getUnidadesDisponibles());
            data.add(row);
        }

        Vector<Object> columns = new Vector<>(Arrays.asList(dvdColumns));
        DefaultTableModel model = new DefaultTableModel(data, columns);
        return model;
    }

    private DefaultTableModel fillCd(ConnectionDb connection) {
        Cd cd = new Cd();
        List<Cd> cdList = cd.selectTodosCd(connection);
        Vector<Vector<Object>> data = new Vector<>();
        for (Cd cdItem : cdList) {
            Vector<Object> row = new Vector<>();
            row.add(cdItem.getCodigoIdentificacion());
            row.add(cdItem.getTitulo());
            row.add(cdItem.getArtista());
            row.add(cdItem.getGenero());
            row.add(cdItem.getDuracion());
            row.add(cdItem.getNum_canciones());
            row.add(cdItem.getUnidadesDisponibles());
            data.add(row);
        }

        Vector<Object> columns = new Vector<>(Arrays.asList(cdColumns));
        DefaultTableModel model = new DefaultTableModel(data, columns);
        return model;
    }

    private DefaultTableModel fillBook(ConnectionDb connection) {
        Libro book = new Libro();
        List<Libro> bookList = book.seleccionarTodosLibro(connection);
        Vector<Vector<Object>> data = new Vector<>();
        for (Libro bookItem : bookList) {
            Vector<Object> row = new Vector<>();
            row.add(bookItem.getCodigoIdentificacion());
            row.add(bookItem.getTitulo());
            row.add(bookItem.getNombreAutor());
            row.add(bookItem.getNumPaginas());
            row.add(bookItem.getEditorial());
            row.add(bookItem.getISBN());
            row.add(bookItem.getAnioPublicacion());
            row.add(bookItem.getUnidadesDisponibles());
            data.add(row);
        }
        Vector<Object> columns = new Vector<>(Arrays.asList(bookColumns));
        DefaultTableModel model = new DefaultTableModel(data, columns);
        return model;
    }

    private DefaultTableModel fillMegazine(ConnectionDb connection) {
        Revista megazine = new Revista();
        List<Revista> megazineList = megazine.SeleccionarTodasRevista(connection);
        Vector<Vector<Object>> data = new Vector<>();
        for (Revista megazineItem : megazineList) {
            Vector<Object> row = new Vector<>();
            row.add(megazineItem.getCodigoIdentificacion());
            row.add(megazineItem.getTitulo());
            row.add(megazineItem.getEditorial());
            row.add(megazineItem.getPeriodicidad());
            row.add(megazineItem.getFechaPublicacion());
            row.add(megazineItem.getUnidadesDisponibles());
            data.add(row);
        }
        Vector<Object> columns = new Vector<>(Arrays.asList(megazineColumns));
        DefaultTableModel model = new DefaultTableModel(data, columns);
        return model;
    }

    /**
     * Creates new form ListMaterial
     */
    public ListMaterial(int materialOption) {
        initComponents();

        // Start database conection
        con.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        switch (materialOption) {
            case 1:
                model = this.fillBook(con);
                break;
            case 2:
                model = this.fillMegazine(con);
                break;
            case 3:
                model = this.fillCd(con);
                break;
            case 4:
                model = this.fillDvd(con);
                break;
        }
        tbtMaterial.setModel(model);
        tbtMaterial.revalidate();
        tbtMaterial.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lblMaterial = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtMaterial = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1024, 720));
        setPreferredSize(new java.awt.Dimension(1024, 720));

        pnlTitle.setBackground(new java.awt.Color(140, 214, 255));
        pnlTitle.setLayout(new java.awt.GridBagLayout());

        lblMaterial.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMaterial.setText("Listar materiales");
        pnlTitle.add(lblMaterial, new java.awt.GridBagConstraints());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbtMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbtMaterial);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTable tbtMaterial;
    // End of variables declaration//GEN-END:variables
}
