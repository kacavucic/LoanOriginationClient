package view.form;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class AllProductsForm extends javax.swing.JPanel {


    public AllProductsForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        cbCurrency = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        cBoxCurrency = new javax.swing.JCheckBox();
        cBoxStatus = new javax.swing.JCheckBox();
        jScrollPane = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnChooseProduct = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        btnSearch.setText("Search");

        cBoxCurrency.setText("Currency:");

        cBoxStatus.setText("Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cBoxCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cBoxCurrency))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cBoxStatus))
                                .addContainerGap(25, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch)
                                .addContainerGap())
        );

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane.setViewportView(tblProducts);

        btnChooseProduct.setText("Add to loan application");

        btnDetails.setText("Show details");

        btnExit.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 234, Short.MAX_VALUE)
                                                .addComponent(btnChooseProduct)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnExit)
                                        .addComponent(btnDetails)
                                        .addComponent(btnChooseProduct))
                                .addContainerGap())
        );
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnChooseProduct;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnDetails;
    private javax.swing.JComboBox<Object> cbStatus;
    private javax.swing.JComboBox<Object> cbCurrency;
    private javax.swing.JCheckBox cBoxStatus;
    private javax.swing.JCheckBox cBoxCurrency;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable tblProducts;
    // End of variables declaration

    public JTable getTblProducts() {
        return tblProducts;
    }

    public void setTblProducts(JTable tblProducts) {
        this.tblProducts = tblProducts;
    }

    public JComboBox<Object> getCbStatus() {
        return cbStatus;
    }

    public void setCbStatus(JComboBox<Object> cbStatus) {
        this.cbStatus = cbStatus;
    }

    public JComboBox<Object> getCbCurrency() {
        return cbCurrency;
    }

    public void setCbCurrency(JComboBox<Object> cbCurrency) {
        this.cbCurrency = cbCurrency;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnChooseProduct() {
        return btnChooseProduct;
    }

    public void setBtnChooseProduct(JButton btnChooseProduct) {
        this.btnChooseProduct = btnChooseProduct;
    }

    public JButton getBtnDetails() {
        return btnDetails;
    }

    public void setBtnDetails(JButton btnDetails) {
        this.btnDetails = btnDetails;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JCheckBox getCBoxStatus() {
        return cBoxStatus;
    }

    public void setCBoxStatus(JCheckBox cBoxStatus) {
        this.cBoxStatus = cBoxStatus;
    }

    public JCheckBox getCBoxCurrency() {
        return cBoxCurrency;
    }

    public void setCBoxCurrency(JCheckBox cBoxCurrency) {
        this.cBoxCurrency = cBoxCurrency;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }

    /////////////////////////////////////////////////////////////////////////
    public void btnSearchActionListener(ActionListener actionListener) {
        btnSearch.addActionListener(actionListener);
    }

    public void cBoxCurrencyActionListener(ActionListener actionListener) {
        cBoxCurrency.addActionListener(actionListener);
    }

    public void cBoxStatusActionListener(ActionListener actionListener) {
        cBoxStatus.addActionListener(actionListener);
    }

    public void btnDetailsActionListener(ActionListener actionListener) {
        btnDetails.addActionListener(actionListener);
    }

    public void btnChooseProductActionListener(ActionListener actionListener) {
        btnChooseProduct.addActionListener(actionListener);
    }

    public void addBtnExitActionListener(ActionListener actionListener) {
        btnExit.addActionListener(actionListener);
    }
}
