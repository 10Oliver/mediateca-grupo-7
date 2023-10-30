/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JOptionPane;
import classes.Cd;
import classes.ConnectionDb;
import classes.Dvd;
import classes.Libro;
import classes.Revista;
import javax.swing.JPanel;

/**
 *
 * @author Oliver
 */
public class DeleteMaterial extends javax.swing.JPanel {

    private int material;
    private JPanel mainPanel;

    /**
     * Creates new form DeleteMaterial
     */
    public DeleteMaterial(int materialOption, JPanel containerPanel) {
        this.material = materialOption;
        this.mainPanel = containerPanel;
        initComponents();

        switch (this.material) {
            case 1:
                lblMaterial.setText("Material seleccionado: Libro");
                lblCodigo.setText("Escriba el código del Libro que desea eliminar:");
                break;
            case 2:
                lblMaterial.setText("Material seleccionado: Revista");
                lblCodigo.setText("Escriba el código de la Revista que desea eliminar:");
                break;
            case 3:
                lblMaterial.setText("Material seleccionado: CD");
                lblCodigo.setText("Escriba el código del CD que desea eliminar:");
                break;
            case 4:
                lblMaterial.setText("Material seleccionado: DVD");
                lblCodigo.setText("Escriba el código del DVD que desea eliminar:");
                break;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblMaterial = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 230));
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setPreferredSize(new java.awt.Dimension(1024, 720));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Eliminar material");

        lblMaterial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMaterial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaterial.setText("Material seleccionado");

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigo.setText("Escriba el codigo del material que deseea eliminar:  ");

        btnRegresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setMaximumSize(new java.awt.Dimension(71, 25));
        btnRegresar.setMinimumSize(new java.awt.Dimension(71, 25));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(lblMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(336, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(375, 375, 375))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        String codigoIdentificacion = txtCodigo.getText().trim();

        if (codigoIdentificacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un código de identificación.");
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este material?");

        if (confirmacion == JOptionPane.YES_OPTION) {
            ConnectionDb conexion = new ConnectionDb(); // Reemplaza esto por la creación de tu instancia de ConnectionDb
            switch (material) {
                case 1: // Libro
                    try {
                        Libro libro = new Libro(codigoIdentificacion);
                        libro.borrarLibro(conexion);
                        JOptionPane.showMessageDialog(this, "El libro ha sido eliminado correctamente.");
                        txtCodigo.setText("");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error al eliminar el libro. Verifica el código de identificación.");
                    }

                    break;
                case 2: // Revista
                    try {
                        Revista revista = new Revista(codigoIdentificacion);
                        revista.deleteRevista(conexion);
                        JOptionPane.showMessageDialog(this, "La revista ha sido eliminada correctamente.");
                        txtCodigo.setText("");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error al eliminar la revista. Verifica el código de identificación.");
                    }
                    break;
                case 3: // CD
                    try {
                        Cd cd = new Cd(codigoIdentificacion);
                        cd.deleteCD(conexion);
                        JOptionPane.showMessageDialog(this, "El CD ha sido eliminado correctamente.");
                        txtCodigo.setText("");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error al eliminar el CD. Verifica el código de identificación.");
                    }

                    break;
                case 4: // DVD
                    try {
                        Dvd dvd = new Dvd(codigoIdentificacion);
                        dvd.deleteDVD(conexion);
                        JOptionPane.showMessageDialog(this, "El DVD ha sido eliminado correctamente.");
                        txtCodigo.setText("");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error al eliminar el DVD. Verifica el código de identificación.");
                    }
                    break;
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        MaterialOptions materialOptions = new MaterialOptions(3, mainPanel);
        materialOptions.setSize(1024, 720);
        mainPanel.add(materialOptions);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
