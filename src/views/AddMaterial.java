/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Oliver
 */
public class AddMaterial extends javax.swing.JPanel {

    private int material;

    /**
     * Creates new form AddMaterial
     */
    public AddMaterial(int materialOption) {
        this.material = materialOption;
        initComponents();
        // Delete this when you start working
        switch (this.material) {
            case 1:
                lblMaterial.setText("Material seleccionado: Libro");
                break;
            case 2:
                lblMaterial.setText("Material seleccionado: Revista");
                break;
            case 3:
                lblMaterial.setText("Material seleccionado: CD");
                break;
            case 4:
                lblMaterial.setText("Material seleccionado: DVD");
                break;
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

        lblTitle = new javax.swing.JLabel();
        lblMaterial = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 245, 255));
        setPreferredSize(new java.awt.Dimension(1024, 720));

        lblTitle.setText("Agregar material");

        lblMaterial.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(lblMaterial)))
                .addContainerGap(510, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(lblTitle)
                .addGap(83, 83, 83)
                .addComponent(lblMaterial)
                .addContainerGap(468, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
