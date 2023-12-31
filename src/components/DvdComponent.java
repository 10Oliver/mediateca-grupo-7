/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import classes.ConnectionDb;
import classes.Dvd;
import classes.Genero;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Oliver-Dev
 */
public class DvdComponent extends javax.swing.JPanel {

    private String IdentificationCode = "";
    private ConnectionDb con = new ConnectionDb();
    private Genero genero = new Genero();
    private Map<String, Integer> generoMap = new HashMap<>();

    /**
     * Creates new form DvdComponent
     */
    public DvdComponent(int type) {
        initComponents();
        if (type == 1) {
            btnAgregar.setVisible(true);
            btnModificar.setVisible(false);
        } else {
            btnAgregar.setVisible(false);
            btnModificar.setVisible(true);
            do {
                this.fillView();
            } while (this.IdentificationCode == "");
        }

        this.fillGenero();
    }

    private void fillView() {
        JPanel optionPanel = new JPanel(new GridLayout(2, 1));
        JTextField txtIdentificationCode = new JTextField();
        optionPanel.add(new JLabel("Escribe el código de identificación:"));
        optionPanel.add(txtIdentificationCode);
        JOptionPane.showConfirmDialog(null, optionPanel, "Ingrese los datos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        // Check if input is empty
        if (txtIdentificationCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes de ingresar un código.", "Existen campos vacíos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // Search for specific dvd
        Dvd dvd = new Dvd();
        Dvd dvdSelected = dvd.seleccionarDvd(txtIdentificationCode.getText(), con);
        if (dvdSelected == null) {
            JOptionPane.showMessageDialog(null, "No existe ningún dvd con el código proporcionado.", "Registro inexistente", JOptionPane.INFORMATION_MESSAGE);
        }
        txtTitulo.setText(dvdSelected.getTitulo());
        txtUnidadesDisponibles.setText(String.valueOf(dvdSelected.getUnidadesDisponibles()));
        txtDirector.setText(dvdSelected.getDirector());
        txtDuracion.setText(dvdSelected.getDuracion());
        cmbGenero.setSelectedItem(dvdSelected.getGenero());
        IdentificationCode = txtIdentificationCode.getText();
    }

    private boolean checkFields() {
        return txtTitulo.getText().isEmpty() || txtUnidadesDisponibles.getText().isEmpty() || txtDirector.getText().isEmpty() || txtDuracion.getText().isEmpty();
    }

    private void cleanFields() {
        txtTitulo.setText("");
        txtUnidadesDisponibles.setText("");
        txtDirector.setText("");
        txtDuracion.setText("");
    }

    private void fillGenero() {
        cmbGenero.removeAllItems();
        List<Genero> generoList = genero.seleccionarTodosGeneros(con);
        for (Genero generoItem : generoList) {
            cmbGenero.addItem(generoItem.getNombre_genero());
            generoMap.put(generoItem.getNombre_genero(), generoItem.getId_genero());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitulo = new javax.swing.JLabel();
        lblDirector = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtDirector = new javax.swing.JTextField();
        lblDuracion = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        lblUnidadesDisponibles = new javax.swing.JLabel();
        txtUnidadesDisponibles = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        pnlAcciones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        pnlCancelar = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1024, 658));
        setMinimumSize(new java.awt.Dimension(1024, 658));
        setPreferredSize(new java.awt.Dimension(1024, 658));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTitulo.setText("Titulo");

        lblDirector.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblDirector.setText("Director");

        txtTitulo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDirector.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblDuracion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblDuracion.setText("Duración");

        txtDuracion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblGenero.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblGenero.setText("Genero");

        cmbGenero.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblUnidadesDisponibles.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblUnidadesDisponibles.setText("Unidades disponibles");

        txtUnidadesDisponibles.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        pnlBotones.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotones.setLayout(new java.awt.GridBagLayout());

        pnlAcciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlAcciones.setLayout(new java.awt.GridBagLayout());

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setMaximumSize(new java.awt.Dimension(100, 35));
        btnAgregar.setMinimumSize(new java.awt.Dimension(100, 35));
        btnAgregar.setPreferredSize(new java.awt.Dimension(100, 35));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        pnlAcciones.add(btnAgregar, gridBagConstraints);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setMaximumSize(new java.awt.Dimension(100, 35));
        btnModificar.setMinimumSize(new java.awt.Dimension(100, 35));
        btnModificar.setPreferredSize(new java.awt.Dimension(100, 35));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlAcciones.add(btnModificar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        pnlBotones.add(pnlAcciones, gridBagConstraints);

        pnlCancelar.setBackground(new java.awt.Color(255, 255, 255));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(100, 35));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCancelarLayout = new javax.swing.GroupLayout(pnlCancelar);
        pnlCancelar.setLayout(pnlCancelarLayout);
        pnlCancelarLayout.setHorizontalGroup(
            pnlCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCancelarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlCancelarLayout.setVerticalGroup(
            pnlCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCancelarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        pnlBotones.add(pnlCancelar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDirector))
                        .addGap(128, 128, 128))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnidadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnidadesDisponibles))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDuracion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGenero)
                        .addGap(427, 427, 427))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(128, 128, 128))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblDirector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracion)
                    .addComponent(lblGenero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(lblUnidadesDisponibles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUnidadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        int availableUnits = 0;
        int duracion = 0;
        this.con.getConnection();
        if (this.checkFields()) {
            JOptionPane.showMessageDialog(null, "Se deben de llenar todos los campos antes de guardar la revista.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Check type value conversion
        try {
            availableUnits = Integer.parseInt(txtUnidadesDisponibles.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cantidad de unidades disponibles debe de ser un número.", "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
        }
        try {
            duracion = Integer.parseInt(txtDuracion.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La duración debe de ser un número.", "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
        }
        // Save dvd
        try {
            Dvd dvd = new Dvd();
            dvd.setTitulo(txtTitulo.getText());
            dvd.setDirector(txtDirector.getText());
            dvd.setDuracion(String.valueOf(duracion) + "min");
            dvd.setUnidadesDisponibles(availableUnits);
            // Insert new dvd
            dvd.insertDVD(con, generoMap.get(cmbGenero.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(null, "El DVD se ha guardo correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.cleanFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        this.con.getConnection();
        int availableUnits = 0;
        if (this.checkFields()) {
            JOptionPane.showMessageDialog(null, "Se deben de seleccionar todos los campos antes de editar y guardar el DVD.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            availableUnits = Integer.parseInt(txtUnidadesDisponibles.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cantidad de unidades disponibles debe de ser un número.", "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
        }
        try {
            Dvd dvd = new Dvd(IdentificationCode, txtTitulo.getText(), availableUnits, "", txtDuracion.getText(), 1, txtDirector.getText());
            dvd.updateDVD(con, generoMap.get(cmbGenero.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(null, "Los cambios se han realizado exitosamente.", "Dato modificado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel lblDirector;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidadesDisponibles;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCancelar;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUnidadesDisponibles;
    // End of variables declaration//GEN-END:variables
}
