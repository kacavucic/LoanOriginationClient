package view.form;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class LoanApplicationForm extends javax.swing.JPanel {

    public LoanApplicationForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnChooseClient = new javax.swing.JButton();
        btnChooseProduct = new javax.swing.JButton();
        pnlLoanApplication = new javax.swing.JPanel();
        lblClient = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        lblCreationDate = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        lblAnnuity = new javax.swing.JLabel();
        lblRepaymentPeriod = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        txtCreationDate = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        txtRepaymentPeriod = new javax.swing.JTextField();
        txtAmount = new javax.swing.JFormattedTextField();
        txtProduct = new javax.swing.JTextField();
        txtClient = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtAnnuity = new javax.swing.JFormattedTextField();
        pnlDocument = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblDocument = new javax.swing.JTable();
        pnlCreditBureauReport = new javax.swing.JPanel();
        lblCreationDateCBR = new javax.swing.JLabel();
        lblTotalDebt = new javax.swing.JLabel();
        lblTotalAnnuity = new javax.swing.JLabel();
        lblNumberOfDaysInDelay = new javax.swing.JLabel();
        txtNumberOfDaysInDelay = new javax.swing.JTextField();
        txtCreationDateCBR = new javax.swing.JTextField();
        txtTotalDebt = new javax.swing.JFormattedTextField();
        txtTotalAnnuity = new javax.swing.JFormattedTextField();
        pnlFraudReport = new javax.swing.JPanel();
        lblCreationDateFR = new javax.swing.JLabel();
        lblBlackListRate = new javax.swing.JLabel();
        lblAMLRate = new javax.swing.JLabel();
        txtBlackListRate = new javax.swing.JTextField();
        txtAMLRate = new javax.swing.JTextField();
        txtCreationDateFR = new javax.swing.JTextField();
        jPanel = new javax.swing.JPanel();
        btnProcess = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnSaveProcess = new javax.swing.JButton();

        btnChooseClient.setText("Choose client");

        btnChooseProduct.setText("Choose product");

        pnlLoanApplication.setBorder(javax.swing.BorderFactory.createTitledBorder("Loan application information"));

        lblClient.setText("Client:");

        lblProduct.setText("Product:");

        lblCreationDate.setText("Creation date:");

        lblAmount.setText("Amount:");

        lblAnnuity.setText("Annuity:");

        lblRepaymentPeriod.setText("Repayment period:");

        lblID.setText("ID:");

        lblStatus.setText("Status:");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        txtAnnuity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        javax.swing.GroupLayout pnlLoanApplicationLayout = new javax.swing.GroupLayout(pnlLoanApplication);
        pnlLoanApplication.setLayout(pnlLoanApplicationLayout);
        pnlLoanApplicationLayout.setHorizontalGroup(
                pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLoanApplicationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCreationDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblAnnuity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblRepaymentPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCreationDate)
                                        .addComponent(cbStatus, 0, 170, Short.MAX_VALUE)
                                        .addComponent(txtRepaymentPeriod)
                                        .addComponent(txtAmount)
                                        .addComponent(txtProduct)
                                        .addComponent(txtClient)
                                        .addComponent(txtID)
                                        .addComponent(txtAnnuity))
                                .addContainerGap())
        );
        pnlLoanApplicationLayout.setVerticalGroup(
                pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLoanApplicationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblID)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblClient)
                                        .addComponent(txtClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblProduct)
                                        .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAmount)
                                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblRepaymentPeriod)
                                        .addComponent(txtRepaymentPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAnnuity)
                                        .addComponent(txtAnnuity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblStatus)
                                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLoanApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCreationDate)
                                        .addComponent(txtCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDocument.setBorder(javax.swing.BorderFactory.createTitledBorder("Documents"));

        tblDocument.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "Title", "Required", "Upload"
                }
        ));
        jScrollPane.setViewportView(tblDocument);

        javax.swing.GroupLayout pnlDocumentLayout = new javax.swing.GroupLayout(pnlDocument);
        pnlDocument.setLayout(pnlDocumentLayout);
        pnlDocumentLayout.setHorizontalGroup(
                pnlDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDocumentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pnlDocumentLayout.setVerticalGroup(
                pnlDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDocumentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pnlCreditBureauReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Credit bureau report"));

        lblCreationDateCBR.setText("Creation date:");

        lblTotalDebt.setText("Total debt:");

        lblTotalAnnuity.setText("Total annuity:");

        lblNumberOfDaysInDelay.setText("Number of days in delay:");

        txtTotalDebt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        txtTotalAnnuity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        javax.swing.GroupLayout pnlCreditBureauReportLayout = new javax.swing.GroupLayout(pnlCreditBureauReport);
        pnlCreditBureauReport.setLayout(pnlCreditBureauReportLayout);
        pnlCreditBureauReportLayout.setHorizontalGroup(
                pnlCreditBureauReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlCreditBureauReportLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlCreditBureauReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNumberOfDaysInDelay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTotalAnnuity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTotalDebt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCreationDateCBR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlCreditBureauReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNumberOfDaysInDelay, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(txtCreationDateCBR, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTotalDebt)
                                        .addComponent(txtTotalAnnuity))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCreditBureauReportLayout.setVerticalGroup(
                pnlCreditBureauReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlCreditBureauReportLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(pnlCreditBureauReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCreationDateCBR)
                                        .addComponent(txtCreationDateCBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCreditBureauReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTotalDebt)
                                        .addComponent(txtTotalDebt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCreditBureauReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTotalAnnuity)
                                        .addComponent(txtTotalAnnuity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCreditBureauReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNumberOfDaysInDelay)
                                        .addComponent(txtNumberOfDaysInDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFraudReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Fraud report"));

        lblCreationDateFR.setText("Creation date:");

        lblBlackListRate.setText("Black list rate:");

        lblAMLRate.setText("AML rate:");

        txtBlackListRate.setText(" ");

        javax.swing.GroupLayout pnlFraudReportLayout = new javax.swing.GroupLayout(pnlFraudReport);
        pnlFraudReport.setLayout(pnlFraudReportLayout);
        pnlFraudReportLayout.setHorizontalGroup(
                pnlFraudReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlFraudReportLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlFraudReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCreationDateFR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblBlackListRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblAMLRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlFraudReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtBlackListRate, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(txtCreationDateFR)
                                        .addComponent(txtAMLRate))
                                .addContainerGap())
        );
        pnlFraudReportLayout.setVerticalGroup(
                pnlFraudReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlFraudReportLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(pnlFraudReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCreationDateFR)
                                        .addComponent(txtCreationDateFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFraudReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblBlackListRate)
                                        .addComponent(txtBlackListRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFraudReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAMLRate)
                                        .addComponent(txtAMLRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnProcess.setText("Process");

        btnCreate.setText("Create");

        btnExit.setText("Back");

        btnSaveProcess.setText("Save process");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSaveProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProcess)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnExit)
                                        .addComponent(btnCreate)
                                        .addComponent(btnProcess)
                                        .addComponent(btnSaveProcess))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnChooseClient)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnChooseProduct))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pnlFraudReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pnlLoanApplication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pnlDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pnlCreditBureauReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(81, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnChooseClient)
                                        .addComponent(btnChooseProduct))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pnlDocument, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pnlLoanApplication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pnlFraudReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pnlCreditBureauReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnChooseProduct;
    private javax.swing.JButton btnChooseClient;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnSaveProcess;

    private javax.swing.JComboBox<Object> cbStatus;

    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblCreationDateCBR;
    private javax.swing.JLabel lblTotalDebt;
    private javax.swing.JLabel lblTotalAnnuity;
    private javax.swing.JLabel lblNumberOfDaysInDelay;
    private javax.swing.JLabel lblCreationDateFR;
    private javax.swing.JLabel lblBlackListRate;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblCreationDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblAnnuity;
    private javax.swing.JLabel lblRepaymentPeriod;
    private javax.swing.JLabel lblAMLRate;

    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel pnlDocument;
    private javax.swing.JPanel pnlFraudReport;
    private javax.swing.JPanel pnlCreditBureauReport;
    private javax.swing.JPanel pnlLoanApplication;

    private javax.swing.JScrollPane jScrollPane;

    private javax.swing.JTable tblDocument;

    private javax.swing.JTextField txtAMLRate;
    private javax.swing.JFormattedTextField txtAnnuity;
    private javax.swing.JTextField txtBlackListRate;
    private javax.swing.JTextField txtNumberOfDaysInDelay;
    private javax.swing.JTextField txtCreationDateFR;
    private javax.swing.JTextField txtCreationDateCBR;
    private javax.swing.JTextField txtCreationDate;
    private javax.swing.JTextField txtID;
    private javax.swing.JFormattedTextField txtAmount;
    private javax.swing.JTextField txtClient;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtRepaymentPeriod;
    private javax.swing.JFormattedTextField txtTotalAnnuity;
    private javax.swing.JFormattedTextField txtTotalDebt;
    // End of variables declaration

    public JButton getBtnChooseProduct() {
        return btnChooseProduct;
    }

    public void setBtnChooseProduct(JButton btnChooseProduct) {
        this.btnChooseProduct = btnChooseProduct;
    }

    public JButton getBtnChooseClient() {
        return btnChooseClient;
    }

    public void setBtnChooseClient(JButton btnChooseClient) {
        this.btnChooseClient = btnChooseClient;
    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public void setBtnCreate(JButton btnCreate) {
        this.btnCreate = btnCreate;
    }

    public JButton getBtnProcess() {
        return btnProcess;
    }

    public void setBtnProcess(JButton btnProcess) {
        this.btnProcess = btnProcess;
    }

    public JTextField getTxtClient() {
        return txtClient;
    }

    public void setTxtClient(JTextField txtClient) {
        this.txtClient = txtClient;
    }

    public JTextField getTxtProduct() {
        return txtProduct;
    }

    public void setTxtProduct(JTextField txtProduct) {
        this.txtProduct = txtProduct;
    }

    public JTextField getTxtCreationDateFR() {
        return txtCreationDateFR;
    }

    public void setTxtCreationDateFR(JTextField txtCreationDateFR) {
        this.txtCreationDateFR = txtCreationDateFR;
    }

    public JTextField getTxtCreationDateCBR() {
        return txtCreationDateCBR;
    }

    public void setTxtCreationDateCBR(JTextField txtCreationDateCBR) {
        this.txtCreationDateCBR = txtCreationDateCBR;
    }

    public JTextField getTxtCreationDate() {
        return txtCreationDate;
    }

    public void setTxtCreationDate(JTextField txtCreationDate) {
        this.txtCreationDate = txtCreationDate;
    }

    public JPanel getPnlFraudReport() {
        return pnlFraudReport;
    }

    public void setPnlFraudReport(JPanel pnlFraudReport) {
        this.pnlFraudReport = pnlFraudReport;
    }

    public JPanel getPnlCreditBureauReport() {
        return pnlCreditBureauReport;
    }

    public void setPnlCreditBureauReport(JPanel pnlCreditBureauReport) {
        this.pnlCreditBureauReport = pnlCreditBureauReport;
    }

    public JPanel getPnlLoanApplication() {
        return pnlLoanApplication;
    }

    public void setPnlLoanApplication(JPanel pnlLoanApplication) {
        this.pnlLoanApplication = pnlLoanApplication;
    }

    public JTextField getTxtAMLRate() {
        return txtAMLRate;
    }

    public void setTxtAMLRate(JTextField txtAMLRate) {
        this.txtAMLRate = txtAMLRate;
    }

    public JPanel getPnlDocument() {
        return pnlDocument;
    }

    public void setPnlDocument(JPanel pnlDocument) {
        this.pnlDocument = pnlDocument;
    }

    public JFormattedTextField getTxtAnnuity() {
        return txtAnnuity;
    }

    public void setTxtAnnuity(JFormattedTextField txtAnnuity) {
        this.txtAnnuity = txtAnnuity;
    }

    public JTextField getTxtBlackListRate() {
        return txtBlackListRate;
    }

    public void setTxtBlackListRate(JTextField txtBlackListRate) {
        this.txtBlackListRate = txtBlackListRate;
    }

    public JTextField getTxtNumberOfDaysInDelay() {
        return txtNumberOfDaysInDelay;
    }

    public void setTxtNumberOfDaysInDelay(JTextField txtNumberOfDaysInDelay) {
        this.txtNumberOfDaysInDelay = txtNumberOfDaysInDelay;
    }

    public JFormattedTextField getTxtAmount() {
        return txtAmount;
    }

    public void setTxtAmount(JFormattedTextField txtAmount) {
        this.txtAmount = txtAmount;
    }

    public JTextField getTxtRepaymentPeriod() {
        return txtRepaymentPeriod;
    }

    public void setTxtRepaymentPeriod(JTextField txtRepaymentPeriod) {
        this.txtRepaymentPeriod = txtRepaymentPeriod;
    }

    public JFormattedTextField getTxtTotalAnnuity() {
        return txtTotalAnnuity;
    }

    public void setTxtTotalAnnuity(JFormattedTextField txtTotalAnnuity) {
        this.txtTotalAnnuity = txtTotalAnnuity;
    }

    public JFormattedTextField getTxtTotalDebt() {
        return txtTotalDebt;
    }

    public void setTxtTotalDebt(JFormattedTextField txtTotalDebt) {
        this.txtTotalDebt = txtTotalDebt;
    }

    public JComboBox<Object> getCbStatus() {
        return cbStatus;
    }

    public void setCbStatus(JComboBox<Object> cbStatus) {
        this.cbStatus = cbStatus;
    }

    public JTable getTblDocument() {
        return tblDocument;
    }

    public void setTblDocument(JTable tblDocument) {
        this.tblDocument = tblDocument;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JButton getBtnSaveProcess() {
        return btnSaveProcess;
    }

    public void setBtnSaveProcess(JButton btnSaveProcess) {
        this.btnSaveProcess = btnSaveProcess;
    }

    ///////////////////////////////////////////////////////////////////////////
    public void btnChooseClientActionListener(ActionListener actionListener) {
        btnChooseClient.addActionListener(actionListener);
    }

    public void btnChooseProductActionListener(ActionListener actionListener) {
        btnChooseProduct.addActionListener(actionListener);
    }

    public void btnCreateActionListener(ActionListener actionListener) {
        btnCreate.addActionListener(actionListener);
    }

    public void btnProcessActionListener(ActionListener actionListener) {
        btnProcess.addActionListener(actionListener);
    }

    public void btnSaveProcessActionListener(ActionListener actionListener) {
        btnSaveProcess.addActionListener(actionListener);
    }

    public void addBtnExitActionListener(ActionListener actionListener) {
        btnExit.addActionListener(actionListener);
    }
}
