/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import classes.Revista;
import classes.ConnectionDb;
import javax.swing.JOptionPane;

/**
 *
 * @author Oliver-Dev
 */
public class MegazineComponent extends javax.swing.JPanel {

    private ConnectionDb con = new ConnectionDb();

    /**
     * Creates new form MegazineComponent
     */
    public MegazineComponent(int type) {
        initComponents();
        // 1 is for add, 2 for modify
        if (type == 1) {
            btnAgregar.setVisible(true);
            btnModificar.setVisible(false);
        } else {

            btnAgregar.setVisible(false);
            btnModificar.setVisible(true);
        }
    }

    private boolean checkFields() {
        return txtTitulo.getText().isEmpty() || txtUnidadesDisponibles.getText().isEmpty() || txtPeriodicidad.getText().isEmpty() || txtFechaPublicidad.getText().isEmpty();
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
        txtTitulo = new javax.swing.JTextField();
        lblEditorial = new javax.swing.JLabel();
        cmbEditorial = new javax.swing.JComboBox<>();
        lblPeriodicidad = new javax.swing.JLabel();
        txtPeriodicidad = new javax.swing.JTextField();
        lblFechaPublicacion = new javax.swing.JLabel();
        txtFechaPublicidad = new javax.swing.JTextField();
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

        txtTitulo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblEditorial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblEditorial.setText("Editorial");

        cmbEditorial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblPeriodicidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPeriodicidad.setText("Periodicidad");

        txtPeriodicidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblFechaPublicacion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblFechaPublicacion.setText("Fecha de publicación");

        txtFechaPublicidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

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
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnidadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnidadesDisponibles))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEditorial)
                            .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPeriodicidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFechaPublicacion)
                        .addGap(314, 314, 314))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPeriodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaPublicidad, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEditorial, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodicidad)
                    .addComponent(lblFechaPublicacion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeriodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaPublicidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(lblUnidadesDisponibles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUnidadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // Instance an object, filling his properties
        int availableUnits = 0;
        this.con.getConnection();
        if (this.checkFields()) {
            JOptionPane.showMessageDialog(null, "Se deben de llenar todos los campos antes de guardar la revista.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            availableUnits = Integer.parseInt(txtUnidadesDisponibles.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cantidad de unidades disponibles debe de ser un número.", "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
        }
        try {
            Revista megazine = new Revista("", txtTitulo.getText(), availableUnits, cmbEditorial.getSelectedItem().toString(), 1, txtPeriodicidad.getText(), txtFechaPublicidad.getText());
            megazine.insertRevista(con, cmbEditorial.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        this.con.getConnection();
        int availableUnits = 0;
        if (this.checkFields()) {
            JOptionPane.showMessageDialog(null, "Se deben de seleccionar todos los campos antes de editar y guardar la revista.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            availableUnits = Integer.parseInt(txtUnidadesDisponibles.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cantidad de unidades disponibles debe de ser un número.", "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
        }
        try {
            Revista megazine = new Revista("", txtTitulo.getText(), availableUnits, cmbEditorial.getSelectedItem().toString(), 1, txtPeriodicidad.getText(), txtFechaPublicidad.getText());
            megazine.updateRevista(con, cmbEditorial.getSelectedIndex());
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
    private javax.swing.JComboBox<String> cmbEditorial;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFechaPublicacion;
    private javax.swing.JLabel lblPeriodicidad;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidadesDisponibles;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCancelar;
    private javax.swing.JTextField txtFechaPublicidad;
    private javax.swing.JTextField txtPeriodicidad;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUnidadesDisponibles;
    // End of variables declaration//GEN-END:variables
}
