/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author Oliver-Dev
 */
public class BookComponent extends javax.swing.JPanel {

    /**
     * Creates new form BookComponent
     */
    public BookComponent(int type) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        txtTitulo = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox<>();
        txtNumPaginas = new javax.swing.JTextField();
        lblNumPaginas = new javax.swing.JLabel();
        cmbEditorial = new javax.swing.JComboBox<>();
        lblEditorial = new javax.swing.JLabel();
        lblISBN = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        txtAnioPublicacion = new javax.swing.JTextField();
        lblAñoPubliación = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        pnlAcciones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        pnlCancelar = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1024, 658));
        setPreferredSize(new java.awt.Dimension(1024, 658));

        txtTitulo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTitulo.setText("Titulo");

        lblAutor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAutor.setText("Autor");

        cmbAutor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNumPaginas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblNumPaginas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNumPaginas.setText("Número de páginas");

        cmbEditorial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEditorial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblEditorial.setText("Editorial");

        lblISBN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblISBN.setText("ISBN");

        txtISBN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtAnioPublicacion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblAñoPubliación.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAñoPubliación.setText("Año de publicación");

        pnlBotones.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotones.setLayout(new java.awt.GridBagLayout());

        pnlAcciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlAcciones.setLayout(new java.awt.GridBagLayout());

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setMaximumSize(new java.awt.Dimension(100, 35));
        btnAgregar.setMinimumSize(new java.awt.Dimension(100, 35));
        btnAgregar.setPreferredSize(new java.awt.Dimension(100, 35));
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
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo)
                            .addComponent(txtNumPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumPaginas)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblISBN))
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAñoPubliación)
                            .addComponent(txtAnioPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(lblEditorial)
                            .addComponent(cmbEditorial, 0, 350, Short.MAX_VALUE)
                            .addComponent(cmbAutor, 0, 350, Short.MAX_VALUE)
                            .addComponent(lblAutor))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cmbAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPaginas)
                    .addComponent(lblEditorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblISBN)
                    .addComponent(lblAñoPubliación))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnioPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JComboBox<String> cmbEditorial;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblAñoPubliación;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblNumPaginas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCancelar;
    private javax.swing.JTextField txtAnioPublicacion;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNumPaginas;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
