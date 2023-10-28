/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import components.*;
import javax.swing.JPanel;

/**
 *
 * @author Oliver
 */
public class ModifyMaterial extends javax.swing.JPanel {

    private int material;

    /**
     * Creates new form ModifyMaterial
     */
    public ModifyMaterial(int materialOption) {
        initComponents();
        switch (materialOption) {
            case 1:
                BookComponent book = new BookComponent(2);
                this.setLayout(book);
                break;
            case 2:
                MegazineComponent megazine = new MegazineComponent(2);
                this.setLayout(megazine);
                break;
            case 3:
                CdComponent cd = new CdComponent(2);
                this.setLayout(cd);
                break;
            case 4:
                DvdComponent dvd = new DvdComponent(2);
                this.setLayout(dvd);
                break;
        }
    }
    
    private void setLayout(JPanel layout) {
        layout.setSize(1024, 658);
        layout.setVisible(true);
        pnlContainer.removeAll();
        pnlContainer.add(layout);
        pnlContainer.revalidate();
        pnlContainer.repaint();
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
        lblTitile = new javax.swing.JLabel();
        pnlContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(230, 240, 240));
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setPreferredSize(new java.awt.Dimension(1024, 720));

        pnlTitle.setBackground(new java.awt.Color(140, 214, 255));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {1};
        jPanel1Layout.rowHeights = new int[] {1};
        pnlTitle.setLayout(jPanel1Layout);

        lblTitile.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitile.setText("Modificar material");
        pnlTitle.add(lblTitile, new java.awt.GridBagConstraints());

        pnlContainer.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitile;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
}
