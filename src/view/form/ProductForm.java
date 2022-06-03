package view.form;

import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProductForm extends javax.swing.JPanel {


    public ProductForm() {
        initComponents();

        btnGroupRequired.add(rbYesRequired);
        btnGroupRequired.add(rbNoRequired);

        btnGroupForSigning.add(rbYesForSigning);
        btnGroupForSigning.add(rbNoForSigning);
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnGroupRequired = new javax.swing.ButtonGroup();
        btnGroupForSigning = new javax.swing.ButtonGroup();
        pnlProduct = new javax.swing.JPanel();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblCurrency = new javax.swing.JLabel();
        lblMinAmount = new javax.swing.JLabel();
        lblMaxAmount = new javax.swing.JLabel();
        lblInterestRate = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        cbCurrency = new javax.swing.JComboBox<>();
        txtMinAmount = new javax.swing.JFormattedTextField();
        txtMaxAmount = new javax.swing.JFormattedTextField();
        txtInterestRate = new javax.swing.JFormattedTextField();
        cbStatus = new javax.swing.JComboBox<>();
        pnlDocumentTemplate = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtDocumentTitle = new javax.swing.JTextField();
        lblDocumentType = new javax.swing.JLabel();
        cbDocumentType = new javax.swing.JComboBox<>();
        lblRequired = new javax.swing.JLabel();
        lblForSigning = new javax.swing.JLabel();
        btnAddDocumentTemplate = new javax.swing.JButton();
        btnDeleteDocumentTemplate = new javax.swing.JButton();
        btnEditDocumentTemplate = new javax.swing.JButton();
        btnSaveChangesDocumentTemplate = new javax.swing.JButton();
        rbYesRequired = new javax.swing.JRadioButton();
        rbNoRequired = new javax.swing.JRadioButton();
        rbYesForSigning = new javax.swing.JRadioButton();
        rbNoForSigning = new javax.swing.JRadioButton();
        pnlDocumentTemplates = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDocuments = new javax.swing.JTable();
        btnSaveProduct = new javax.swing.JButton();
        btnEditProduct = new javax.swing.JButton();
        btnSaveChangesProduct = new javax.swing.JButton();
        btnDeactivateProduct = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnActivateProduct = new javax.swing.JButton();

        pnlProduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Product information"));

        lblProductName.setText("Name:");

        lblDescription.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescription);

        lblID.setText("ID:");

        lblCurrency.setText("Currency:");

        lblMinAmount.setText("Minimal amount:");

        lblMaxAmount.setText("Maximal amount:");

        lblInterestRate.setText("Interest rate [%]:");

        lblStatus.setText("Status:");

        cbCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        txtMinAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));

        txtMaxAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));

        txtInterestRate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        javax.swing.GroupLayout pnlProductLayout = new javax.swing.GroupLayout(pnlProduct);
        pnlProduct.setLayout(pnlProductLayout);
        pnlProductLayout.setHorizontalGroup(
                pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlProductLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblProductName)
                                        .addGroup(pnlProductLayout.createSequentialGroup()
                                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(pnlProductLayout.createSequentialGroup()
                                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lblCurrency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(pnlProductLayout.createSequentialGroup()
                                                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblMinAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(lblInterestRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(lblMaxAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                                .addGap(18, 18, 18)
                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMaxAmount)
                                        .addComponent(txtInterestRate)
                                        .addComponent(cbStatus, 0, 157, Short.MAX_VALUE)
                                        .addComponent(txtMinAmount, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cbCurrency, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlProductLayout.setVerticalGroup(
                pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlProductLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblID)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCurrency)
                                        .addComponent(cbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblProductName)
                                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMinAmount)
                                        .addComponent(txtMinAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDescription)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlProductLayout.createSequentialGroup()
                                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblMaxAmount)
                                                        .addComponent(txtMaxAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblInterestRate)
                                                        .addComponent(txtInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblStatus)
                                                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDocumentTemplate.setBorder(javax.swing.BorderFactory.createTitledBorder("Document template information"));

        lblTitle.setText("Title:");

        lblDocumentType.setText("Document type:");

        cbDocumentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        lblRequired.setText("Required:");

        lblForSigning.setText("For signing:");

        btnAddDocumentTemplate.setText("Add");

        btnDeleteDocumentTemplate.setText("Delete");

        btnEditDocumentTemplate.setText("Edit");

        btnSaveChangesDocumentTemplate.setText("Save changes");

        rbYesRequired.setText("Yes");

        rbNoRequired.setText("No");

        rbYesForSigning.setText("Yes");

        rbNoForSigning.setText("No");

        javax.swing.GroupLayout pnlDocumentTemplateLayout = new javax.swing.GroupLayout(pnlDocumentTemplate);
        pnlDocumentTemplate.setLayout(pnlDocumentTemplateLayout);
        pnlDocumentTemplateLayout.setHorizontalGroup(
                pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDocumentTemplateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblDocumentType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDocumentTitle)
                                        .addComponent(cbDocumentType, 0, 215, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblForSigning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblRequired, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlDocumentTemplateLayout.createSequentialGroup()
                                                .addComponent(rbYesRequired)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbNoRequired))
                                        .addGroup(pnlDocumentTemplateLayout.createSequentialGroup()
                                                .addComponent(rbYesForSigning)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbNoForSigning)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnDeleteDocumentTemplate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEditDocumentTemplate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSaveChangesDocumentTemplate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddDocumentTemplate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDocumentTemplateLayout.setVerticalGroup(
                pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDocumentTemplateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlDocumentTemplateLayout.createSequentialGroup()
                                                .addComponent(btnAddDocumentTemplate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDeleteDocumentTemplate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSaveChangesDocumentTemplate))
                                        .addGroup(pnlDocumentTemplateLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblTitle)
                                                        .addComponent(txtDocumentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblRequired)
                                                        .addComponent(rbYesRequired)
                                                        .addComponent(rbNoRequired))
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlDocumentTemplateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblDocumentType)
                                                        .addComponent(cbDocumentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblForSigning)
                                                        .addComponent(rbYesForSigning)
                                                        .addComponent(rbNoForSigning))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditDocumentTemplate)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDocumentTemplates.setBorder(javax.swing.BorderFactory.createTitledBorder("Document templates"));

        tblDocuments.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(tblDocuments);

        javax.swing.GroupLayout pnlDocumentTemplatesLayout = new javax.swing.GroupLayout(pnlDocumentTemplates);
        pnlDocumentTemplates.setLayout(pnlDocumentTemplatesLayout);
        pnlDocumentTemplatesLayout.setHorizontalGroup(
                pnlDocumentTemplatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDocumentTemplatesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
        );
        pnlDocumentTemplatesLayout.setVerticalGroup(
                pnlDocumentTemplatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDocumentTemplatesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addContainerGap())
        );

        btnSaveProduct.setText("Save");

        btnEditProduct.setText("Edit");

        btnSaveChangesProduct.setText("Save changes");

        btnDeactivateProduct.setText("Deactivate");

        btnExit.setText("Back");

        btnActivateProduct.setText("Activate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(pnlProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(pnlDocumentTemplate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(pnlDocumentTemplates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(85, Short.MAX_VALUE)
                                                .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSaveChangesProduct)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnActivateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDeactivateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pnlDocumentTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pnlDocumentTemplates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(51, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnExit)
                                                        .addComponent(btnDeactivateProduct)
                                                        .addComponent(btnSaveChangesProduct)
                                                        .addComponent(btnEditProduct)
                                                        .addComponent(btnSaveProduct)
                                                        .addComponent(btnActivateProduct))
                                                .addContainerGap())))
        );
    }


    // Variables declaration - do not modify
    private javax.swing.ButtonGroup btnGroupRequired;
    private javax.swing.ButtonGroup btnGroupForSigning;

    private javax.swing.JButton btnActivateProduct;
    private javax.swing.JButton btnDeactivateProduct;
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnSaveChangesProduct;

    private javax.swing.JButton btnAddDocumentTemplate;
    private javax.swing.JButton btnEditDocumentTemplate;
    private javax.swing.JButton btnDeleteDocumentTemplate;
    private javax.swing.JButton btnSaveChangesDocumentTemplate;

    private javax.swing.JButton btnExit;

    private javax.swing.JComboBox<Object> cbStatus;
    private javax.swing.JComboBox<Object> cbDocumentType;
    private javax.swing.JComboBox<Object> cbCurrency;

    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblRequired;
    private javax.swing.JLabel lblForSigning;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblCurrency;
    private javax.swing.JLabel lblMinAmount;
    private javax.swing.JLabel lblMaxAmount;
    private javax.swing.JLabel lblInterestRate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblDocumentType;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;

    private javax.swing.JPanel pnlDocumentTemplate;
    private javax.swing.JPanel pnlDocumentTemplates;
    private javax.swing.JPanel pnlProduct;

    private javax.swing.JRadioButton rbYesRequired;
    private javax.swing.JRadioButton rbYesForSigning;
    private javax.swing.JRadioButton rbNoRequired;
    private javax.swing.JRadioButton rbNoForSigning;

    private javax.swing.JTable tblDocuments;

    private javax.swing.JTextField txtID;
    private javax.swing.JFormattedTextField txtInterestRate;
    private javax.swing.JFormattedTextField txtMaxAmount;
    private javax.swing.JFormattedTextField txtMinAmount;
    private javax.swing.JTextField txtDocumentTitle;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration

    public JButton getBtnAddDocumentTemplate() {
        return btnAddDocumentTemplate;
    }

    public void setBtnAddDocumentTemplate(JButton btnAddDocumentTemplate) {
        this.btnAddDocumentTemplate = btnAddDocumentTemplate;
    }

    public JPanel getPnlDocumentTemplate() {
        return pnlDocumentTemplate;
    }

    public JButton getBtnSaveChangesDocumentTemplate() {
        return btnSaveChangesDocumentTemplate;
    }

    public void setBtnSaveChangesDocumentTemplate(JButton btnSaveChangesDocumentTemplate) {
        this.btnSaveChangesDocumentTemplate = btnSaveChangesDocumentTemplate;
    }

    public void setPnlDocumentTemplate(JPanel pnlDocumentTemplate) {
        this.pnlDocumentTemplate = pnlDocumentTemplate;
    }

    public JPanel getPnlProduct() {
        return pnlProduct;
    }

    public void setPnlProduct(JPanel pnlProduct) {
        this.pnlProduct = pnlProduct;
    }

    public ButtonGroup getBtnGroupRequired() {
        return btnGroupRequired;
    }

    public void setBtnGroupRequired(ButtonGroup btnGroupRequired) {
        this.btnGroupRequired = btnGroupRequired;
    }

    public ButtonGroup getBtnGroupForSigning() {
        return btnGroupForSigning;
    }

    public void setBtnGroupForSigning(ButtonGroup btnGroupForSigning) {
        this.btnGroupForSigning = btnGroupForSigning;
    }

    public JButton getBtnDeleteDocumentTemplate() {
        return btnDeleteDocumentTemplate;
    }

    public void setBtnDeleteDocumentTemplate(JButton btnDeleteDocumentTemplate) {
        this.btnDeleteDocumentTemplate = btnDeleteDocumentTemplate;
    }

    public JButton getBtnSaveProduct() {
        return btnSaveProduct;
    }

    public void setBtnSaveProduct(JButton btnSaveProduct) {
        this.btnSaveProduct = btnSaveProduct;
    }

    public JComboBox<Object> getCbStatus() {
        return cbStatus;
    }

    public void setCbStatus(JComboBox<Object> cbStatus) {
        this.cbStatus = cbStatus;
    }

    public JComboBox<Object> getCbDocumentType() {
        return cbDocumentType;
    }

    public void setCbDocumentType(JComboBox<Object> cbDocumentType) {
        this.cbDocumentType = cbDocumentType;
    }

    public JComboBox<Object> getCbCurrency() {
        return cbCurrency;
    }

    public void setCbCurrency(JComboBox<Object> cbCurrency) {
        this.cbCurrency = cbCurrency;
    }

    public JRadioButton getRbYesRequired() {
        return rbYesRequired;
    }

    public void setRbYesRequired(JRadioButton rbYesRequired) {
        this.rbYesRequired = rbYesRequired;
    }

    public JRadioButton getRbYesForSigning() {
        return rbYesForSigning;
    }

    public void setRbYesForSigning(JRadioButton rbYesForSigning) {
        this.rbYesForSigning = rbYesForSigning;
    }

    public JRadioButton getRbNoRequired() {
        return rbNoRequired;
    }

    public void setRbNoRequired(JRadioButton rbNoRequired) {
        this.rbNoRequired = rbNoRequired;
    }

    public JRadioButton getRbNoForSigning() {
        return rbNoForSigning;
    }

    public void setRbNoForSigning(JRadioButton rbNoForSigning) {
        this.rbNoForSigning = rbNoForSigning;
    }

    public JTable getTblDocuments() {
        return tblDocuments;
    }

    public void setTblDocuments(JTable tblDocuments) {
        this.tblDocuments = tblDocuments;
    }

    public JFormattedTextField getTxtInterestRate() {
        return txtInterestRate;
    }

    public void setTxtInterestRate(JFormattedTextField txtInterestRate) {
        this.txtInterestRate = txtInterestRate;
    }

    public JFormattedTextField getTxtMaxAmount() {
        return txtMaxAmount;
    }

    public void setTxtMaxAmount(JFormattedTextField txtMaxAmount) {
        this.txtMaxAmount = txtMaxAmount;
    }

    public JFormattedTextField getTxtMinAmount() {
        return txtMinAmount;
    }

    public void setTxtMinAmount(JFormattedTextField txtMinAmount) {
        this.txtMinAmount = txtMinAmount;
    }

    public JTextField getTxtDocumentTitle() {
        return txtDocumentTitle;
    }

    public void setTxtDocumentTitle(JTextField txtDocumentTitle) {
        this.txtDocumentTitle = txtDocumentTitle;
    }

    public JTextField getTxtProductName() {
        return txtProductName;
    }

    public void setTxtProductName(JTextField txtProductName) {
        this.txtProductName = txtProductName;
    }

    public JTextArea getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(JTextArea txtDescription) {
        this.txtDescription = txtDescription;
    }

    public JButton getBtnDeactivateProduct() {
        return btnDeactivateProduct;
    }

    public void setBtnDeactivateProduct(JButton btnDeactivateProduct) {
        this.btnDeactivateProduct = btnDeactivateProduct;
    }

    public JButton getBtnEditProduct() {
        return btnEditProduct;
    }

    public void setBtnEditProduct(JButton btnEditProduct) {
        this.btnEditProduct = btnEditProduct;
    }

    public JButton getBtnSaveChangesProduct() {
        return btnSaveChangesProduct;
    }

    public void setBtnSaveChangesProduct(JButton btnSaveChangesProduct) {
        this.btnSaveChangesProduct = btnSaveChangesProduct;
    }

    public JPanel getPnlDocumentTemplates() {
        return pnlDocumentTemplates;
    }

    public void setPnlDocumentTemplates(JPanel pnlDocumentTemplates) {
        this.pnlDocumentTemplates = pnlDocumentTemplates;
    }

    public JButton getBtnEditDocumentTemplate() {
        return btnEditDocumentTemplate;
    }

    public void setBtnEditDocumentTemplate(JButton btnEditDocumentTemplate) {
        this.btnEditDocumentTemplate = btnEditDocumentTemplate;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }

    public JButton getBtnActivateProduct() {
        return btnActivateProduct;
    }

    public void setBtnActivateProduct(JButton btnActivateProduct) {
        this.btnActivateProduct = btnActivateProduct;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public void btnAddDocumentTemplateActionListener(ActionListener actionListener) {
        btnAddDocumentTemplate.addActionListener(actionListener);
    }

    public void btnDeleteDocumentTemplateActionListener(ActionListener actionListener) {
        btnDeleteDocumentTemplate.addActionListener(actionListener);
    }

    public void btnEditDocumentTemplateActionListener(ActionListener actionListener) {
        btnEditDocumentTemplate.addActionListener(actionListener);
    }

    public void btnSaveChangesDocumentTemplateActionListener(ActionListener actionListener) {
        btnSaveChangesDocumentTemplate.addActionListener(actionListener);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public void btnSaveProductActionListener(ActionListener actionListener) {
        btnSaveProduct.addActionListener(actionListener);
    }

    public void btnEditProductActionListener(ActionListener actionListener) {
        btnEditProduct.addActionListener(actionListener);
    }

    public void btnSaveChangesProductActionListener(ActionListener actionListener) {
        btnSaveChangesProduct.addActionListener(actionListener);
    }

    public void btnDeactivateProductActionListener(ActionListener actionListener) {
        btnDeactivateProduct.addActionListener(actionListener);
    }

    public void btnActivateProductActionListener(ActionListener actionListener) {
        btnActivateProduct.addActionListener(actionListener);
    }

    public void addBtnExitActionListener(ActionListener actionListener) {
        btnExit.addActionListener(actionListener);
    }
}
