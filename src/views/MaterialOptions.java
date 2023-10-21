/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JPanel;

/**
 *
 * @author Oliver
 */
public class MaterialOptions extends javax.swing.JPanel {
    private int viewOption;
    private JPanel mainPanel;

    /**
     * Creates new form MaterialOptions
     */
    public MaterialOptions(int view, JPanel containerPanel) {
        this.viewOption = view;
        mainPanel = containerPanel;
        initComponents();
    }
    
    private void showView(int materialChoose) {
        mainPanel.removeAll();
        System.out.println(this.viewOption);
        switch(this.viewOption){
            case 1:
                AddMaterial addMaterial = new AddMaterial();
                addMaterial.setSize(1024, 720);
                addMaterial.setVisible(true);
                mainPanel.add(addMaterial);
                break;
            // Modify material
            case 2:
                ModifyMaterial modifyMaterial = new ModifyMaterial();
                modifyMaterial.setSize(1024, 720);
                mainPanel.add(modifyMaterial);
                break;
            // Delete material
            case 3:
                DeleteMaterial deleteMaterial = new DeleteMaterial();
                deleteMaterial.setSize(1024, 720);
                mainPanel.add(deleteMaterial);
                break;
            // Search material
            case 4:
                SearchMaterial searchMaterial = new SearchMaterial();
                searchMaterial.setSize(1024, 720);
                mainPanel.add(searchMaterial);
                break;
            // List material
            case 5:
                ListMaterial listMaterial = new ListMaterial();
                listMaterial.setSize(1024, 720);
                mainPanel.add(listMaterial);
                break;
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTittle = new javax.swing.JLabel();
        btnMegazine = new javax.swing.JButton();
        btnCD = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btnDVD = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setPreferredSize(new java.awt.Dimension(1024, 720));

        lblTittle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTittle.setText("Elige el material que desea utilizar");

        btnMegazine.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMegazine.setText("Revista");
        btnMegazine.setMaximumSize(new java.awt.Dimension(90, 90));
        btnMegazine.setPreferredSize(new java.awt.Dimension(90, 90));
        btnMegazine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMegazineMouseClicked(evt);
            }
        });

        btnCD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCD.setText("CD");
        btnCD.setMaximumSize(new java.awt.Dimension(90, 90));
        btnCD.setPreferredSize(new java.awt.Dimension(90, 90));
        btnCD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCDMouseClicked(evt);
            }
        });

        btnBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBook.setLabel("Libro");
        btnBook.setMaximumSize(new java.awt.Dimension(90, 90));
        btnBook.setPreferredSize(new java.awt.Dimension(90, 90));
        btnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookMouseClicked(evt);
            }
        });

        btnDVD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDVD.setText("DVD");
        btnDVD.setMaximumSize(new java.awt.Dimension(90, 90));
        btnDVD.setPreferredSize(new java.awt.Dimension(90, 90));
        btnDVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDVDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(lblTittle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                        .addComponent(btnMegazine, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCD, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(229, 229, 229))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lblTittle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(btnCD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnMegazine, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(btnDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMegazineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMegazineMouseClicked
        this.showView(2);
    }//GEN-LAST:event_btnMegazineMouseClicked

    private void btnCDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCDMouseClicked
       this.showView(3);
    }//GEN-LAST:event_btnCDMouseClicked

    private void btnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseClicked
        this.showView(1);
    }//GEN-LAST:event_btnBookMouseClicked

    private void btnDVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDVDMouseClicked
        this.showView(4);
    }//GEN-LAST:event_btnDVDMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnCD;
    private javax.swing.JButton btnDVD;
    private javax.swing.JButton btnMegazine;
    private javax.swing.JLabel lblTittle;
    // End of variables declaration//GEN-END:variables
}
