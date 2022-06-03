package view.form;

import java.awt.event.ActionListener;
import javax.swing.*;

public class AllClientsForm extends javax.swing.JPanel {

    public AllClientsForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlSearch = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        cBoxLastName = new javax.swing.JCheckBox();
        cBoxJMBG = new javax.swing.JCheckBox();
        txtLastName = new javax.swing.JTextField();
        txtJMBG = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();
        btnChooseClient = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        btnSearch.setText("Search");

        cBoxLastName.setText("Last name:");

        cBoxJMBG.setText("JMBG:");

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
                pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSearchLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlSearchLayout.createSequentialGroup()
                                                .addComponent(cBoxJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtJMBG))
                                        .addGroup(pnlSearchLayout.createSequentialGroup()
                                                .addComponent(cBoxLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
                pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSearchLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cBoxLastName)
                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cBoxJMBG)
                                        .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(25, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch)
                                .addContainerGap())
        );

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane.setViewportView(tblClients);

        btnDetails.setText("Show details");

        btnChooseClient.setText("Add to loan application");

        btnExit.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnChooseClient)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnExit)
                                        .addComponent(btnDetails)
                                        .addComponent(btnChooseClient))
                                .addContainerGap())
        );
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnChooseClient;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox cBoxJMBG;
    private javax.swing.JCheckBox cBoxLastName;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTable tblClients;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration


    public JCheckBox getCBoxJMBG() {
        return cBoxJMBG;
    }

    public void setCBoxJMBG(JCheckBox cBoxJMBG) {
        this.cBoxJMBG = cBoxJMBG;
    }

    public JCheckBox getCBoxLastName() {
        return cBoxLastName;
    }

    public void setCBoxLastName(JCheckBox cBoxLastName) {
        this.cBoxLastName = cBoxLastName;
    }

    public JPanel getPnlSearch() {
        return pnlSearch;
    }

    public void setPnlSearch(JPanel pnlSearch) {
        this.pnlSearch = pnlSearch;
    }

    public JTable getTblClients() {
        return tblClients;
    }

    public void setTblClients(JTable tblClients) {
        this.tblClients = tblClients;
    }

    public JTextField getTxtJMBG() {
        return txtJMBG;
    }

    public void setTxtJMBG(JTextField txtJMBG) {
        this.txtJMBG = txtJMBG;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public void setTxtLastName(JTextField txtLastName) {
        this.txtLastName = txtLastName;
    }

    public JButton getBtnDetails() {
        return btnDetails;
    }

    public void setBtnDetails(JButton btnDetails) {
        this.btnDetails = btnDetails;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }

    public JButton getBtnChooseClient() {
        return btnChooseClient;
    }

    public void setBtnChooseClient(JButton btnChooseClient) {
        this.btnChooseClient = btnChooseClient;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    ///////////////////////////////////////////////////////////////
    public void btnSearchActionListener(ActionListener actionListener) {
        btnSearch.addActionListener(actionListener);
    }

    public void btnDetailsActionListener(ActionListener actionListener) {
        btnDetails.addActionListener(actionListener);
    }

    public void addCBoxJMBGActionListener(ActionListener actionListener) {
        cBoxJMBG.addActionListener(actionListener);
    }

    public void cBoxLastNameActionListener(ActionListener actionListener) {
        cBoxLastName.addActionListener(actionListener);
    }

    public void btnChooseClientActionListener(ActionListener actionListener) {
        btnChooseClient.addActionListener(actionListener);
    }

    public void addBtnExitActionListener(ActionListener actionListener) {
        btnExit.addActionListener(actionListener);
    }
}
