package view.controller;

import communication.Communication;
import constants.LoanApplicationStatus;
import domain.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import view.constants.Constant;
import view.coordinator.MainCoordinator;
import view.form.LoanApplicationForm;
import view.form.component.table.DocumentTableModel;
import view.form.util.FileChooserCellEditor;
import view.form.util.FileOpenerCellEditor;
import view.form.util.FormMode;
import view.listeners.ChooseClientListener;
import view.listeners.ChooseProductListener;
import view.listeners.RefreshTableListener;

public class LoanApplicationController implements ChooseClientListener, ChooseProductListener {

    private final LoanApplicationForm loanApplicationForm;
    private LoanApplication loanApplication;
    private final String CARD_NAME = "loanApplicationForm";
    private FormMode formMode;
    private RefreshTableListener refreshTableListener;

    public LoanApplicationController(LoanApplicationForm loanApplicationForm) {
        this.loanApplicationForm = loanApplicationForm;
        loanApplication = new LoanApplication();
        addActionListeners();
    }

    public LoanApplicationController(LoanApplicationForm loanApplicationForm, RefreshTableListener refreshTableListener) {
        this.loanApplicationForm = loanApplicationForm;
        this.refreshTableListener = refreshTableListener;
        loanApplication = new LoanApplication();
        addActionListeners();
    }

    private void addActionListeners() {

        loanApplicationForm.btnChooseClientActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openChooseClientForm();
            }
        });

        loanApplicationForm.btnChooseProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openChooseProductForm();
            }
        });

        loanApplicationForm.btnCreateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateLoanApplication();
                    makeLoanApplicationFromForm();
                    LoanApplication createdLoanApplication = Communication.getInstance().createLoanApplication(loanApplication);
                    JOptionPane.showMessageDialog(loanApplicationForm, "Loan application with ID: " + createdLoanApplication.getId() + " successfully created!", "Message", JOptionPane.INFORMATION_MESSAGE);

                    MainCoordinator.getInstance().addParam(Constant.SELECTED_LOAN_APPLICATION, createdLoanApplication);
                    MainCoordinator.getInstance().openLoanApplicationDetailsForm();
                    resetForm();
                    if (refreshTableListener != null) {
                        refreshTableListener.refreshTable();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(loanApplicationForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void validateLoanApplication() throws Exception {
                String error = "";

                if (loanApplication.getClient() == null) {
                    error += "Client must be chosen!\n";
                }

                if (loanApplication.getProduct() == null) {
                    error += "Product must be chosen!\n";
                } else {
                    if (String.valueOf(loanApplicationForm.getTxtAmount().getText().trim()).isEmpty()) {
                        error += "Amount must be entered!\n";
                    } else {
                        double amount = (((Number) loanApplicationForm.getTxtAmount().getValue()).doubleValue());
                        if (amount <= 0) {
                            error += "Amount can not be zero or negative!\n";
                        } else {
                            double minAmount = loanApplication.getProduct().getMinAmount();
                            double maxAmount = loanApplication.getProduct().getMaxAmount();
                            String currency = loanApplication.getProduct().getCurrency().getName();
                            if (amount < minAmount || amount > maxAmount) {
                                error += "Amount for the product \"" + loanApplication.getProduct() + "\" must be in range ["
                                        + minAmount + " " + currency + " - " + maxAmount + " " + currency + "]!\n";
                            }
                        }

                    }
                    String repaymentPeriodString = loanApplicationForm.getTxtRepaymentPeriod().getText().trim();
                    if (repaymentPeriodString.isEmpty()) {
                        error += "Repayment period must be entered!\n";
                    } else {
                        for (int i = 0; i < repaymentPeriodString.length(); i++) {
                            if (Character.isDigit(repaymentPeriodString.charAt(i))) {

                            } else {
                                error += "Repayment period must contain only digits!\n";
                                break;
                            }
                        }
                        try {
                            int repaymentPeriodInt = Integer.parseInt(repaymentPeriodString);
                            if (repaymentPeriodInt <= 0) {
                                error += "Repayment period can not be zero or negative!\n";
                            }
                        } catch (Exception ex) {

                        }

                    }

                    DocumentTableModel model = (DocumentTableModel) loanApplicationForm.getTblDocument().getModel();
                    List<Document> documents = model.getAllDocuments();
                    for (Document d : documents) {
                        if (d.isRequired()) {
                            if (d.getContent() == null) {
                                error += "Document \"" + d.getTitle() + "\" is required!\n";
                            }
                        }

                    }

                }

                if (!error.isEmpty()) {
                    throw new Exception(error);
                }

            }

            private void makeLoanApplicationFromForm() {
                loanApplication.setCreationDate(new Date());

                double amount = (((Number) loanApplicationForm.getTxtAmount().getValue()).doubleValue());
                int repaymentPeriodMonths = Integer.parseInt(loanApplicationForm.getTxtRepaymentPeriod().getText().trim());
                loanApplication.setAmount(amount);
                loanApplication.setRepaymentPeriod(repaymentPeriodMonths);

                double repaymentPeriodYears = (double) repaymentPeriodMonths / 12;
                double interestRate = loanApplication.getProduct().getInterestRate();
                double interest = (amount * interestRate * repaymentPeriodYears) / 100;
                // System.out.println(interest);
                double annuity = (amount + interest) / repaymentPeriodMonths;

                BigDecimal bd = new BigDecimal(Double.toString(annuity));
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                annuity = bd.doubleValue();

                loanApplicationForm.getTxtAnnuity().setValue(annuity);

                loanApplication.setAnnuity((((Number) annuity).doubleValue()));
                loanApplication.setStatus(LoanApplicationStatus.ON_HOLD);

                DocumentTableModel model = (DocumentTableModel) loanApplicationForm.getTblDocument().getModel();
                List<Document> documents = model.getAllDocuments();
                for (Document d : documents) {
                    d.setLoanApplication(loanApplication);
                }
                loanApplication.setDocuments(documents);
            }

            private void resetForm() {

                loanApplicationForm.getTxtID().setText("");
                loanApplicationForm.getTxtClient().setText("");
                loanApplicationForm.getTxtProduct().setText("");
                loanApplicationForm.getTxtAmount().setValue(null);
                loanApplicationForm.getTxtRepaymentPeriod().setText("");
                loanApplicationForm.getTxtAnnuity().setValue(null);

                DocumentTableModel model = new DocumentTableModel();
                loanApplicationForm.getTblDocument().setModel(model);
            }
        });

        loanApplicationForm.btnProcessActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                if (loanApplication.getCreditBureauReport() == null || loanApplication.getFraudReport() == null) {
                    if (loanApplication.getCreditBureauReport() == null) {
                        message += "Loan application with ID: "
                                + loanApplication.getId()
                                + " can not be processed because credit bureau report for the client " + loanApplication.getClient()
                                + " hasn't been delivered yet!\n";

                    }
                    if (loanApplication.getFraudReport() == null) {
                        message += "Loan application with ID: "
                                + loanApplication.getId()
                                + " can not be processed because fraud report for the client " + loanApplication.getClient()
                                + " hasn't been delivered yet!\n";
                    }
                    JOptionPane.showMessageDialog(loanApplicationForm, message,
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                } else if (!loanApplication.getStatus().equals(LoanApplicationStatus.ON_HOLD)) {
                    JOptionPane.showMessageDialog(loanApplicationForm, "Loan application with ID: "
                                    + loanApplication.getId()
                                    + " has already been processed!",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    setupComponents(FormMode.FORM_PROCESS);
                }
            }
        });

        loanApplicationForm.btnSaveProcessActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // LoanApplication la = (LoanApplication) MainCoordinator.getInstance().getParam(Constant.SELECTED_LOAN_APPLICATION);
                    loanApplication = (LoanApplication) MainCoordinator.getInstance().getParam(Constant.SELECTED_LOAN_APPLICATION);
                    validateLoanApplicationProcess();
                    loanApplication.setStatus((LoanApplicationStatus) loanApplicationForm.getCbStatus().getSelectedItem());
                    int response = JOptionPane.showConfirmDialog(loanApplicationForm,
                            "Are you sure you want to process loan application with ID: "
                                    + loanApplication.getId() + "?");
                    if (response == JOptionPane.YES_OPTION) {
                        Communication.getInstance().processLoanApplication(loanApplication);
                        JOptionPane.showMessageDialog(loanApplicationForm, "Loan application successfully processed!", "Message", JOptionPane.INFORMATION_MESSAGE);
                        if (refreshTableListener != null) {
                            refreshTableListener.refreshTable();
                        }
                        setupComponents(FormMode.FORM_VIEW);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(loanApplicationForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void validateLoanApplicationProcess() throws Exception {
                String error = "";
                if (loanApplicationForm.getCbStatus().getSelectedItem() == null) {
                    error += "Status must be selected!\n";
                }
                if (!error.isEmpty()) {
                    throw new Exception(error);
                }
            }
        });

        loanApplicationForm.addBtnExitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().getMainController().getMainForm().removeCard(loanApplicationForm, CARD_NAME + formMode);
            }
        });
    }

    public void openForm(FormMode formMode) {
        this.formMode = formMode;
        MainCoordinator.getInstance().getMainController().getMainForm().addCard(loanApplicationForm, CARD_NAME + this.formMode);
        prepareView(formMode);
    }

    private void prepareView(FormMode formMode) {
        fillCreationDateLoanApplication();
        fillCbStatus();
        loanApplicationForm.getTxtID().setEnabled(false);
        loanApplicationForm.getTxtClient().setEnabled(false);
        loanApplicationForm.getTxtProduct().setEnabled(false);
        loanApplicationForm.getTxtAnnuity().setEnabled(false);
        loanApplicationForm.getTxtCreationDate().setEnabled(false);
        setupComponents(formMode);
    }

    private void fillCreationDateLoanApplication() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        loanApplicationForm.getTxtCreationDate().setText(sdf.format(new Date()));
    }

    private void fillCbStatus() {
        loanApplicationForm.getCbStatus().removeAllItems();
        loanApplicationForm.getCbStatus().insertItemAt(null, 0);
        for (LoanApplicationStatus s : LoanApplicationStatus.values()) {
            loanApplicationForm.getCbStatus().addItem(s);
        }
    }

    private void setupComponents(FormMode formMode) {
        switch (formMode) {
            case FORM_CREATE:
                loanApplicationForm.getBtnChooseClient().setEnabled(true);
                loanApplicationForm.getBtnChooseProduct().setEnabled(true);
                loanApplicationForm.getBtnCreate().setEnabled(true);
                loanApplicationForm.getBtnProcess().setEnabled(false);
                loanApplicationForm.getBtnSaveProcess().setEnabled(false);

                loanApplicationForm.getTxtAmount().setEnabled(true);
                loanApplicationForm.getTxtRepaymentPeriod().setEnabled(true);
                loanApplicationForm.getCbStatus().setSelectedItem(LoanApplicationStatus.ON_HOLD);
                loanApplicationForm.getCbStatus().setEnabled(false);

                loanApplicationForm.getPnlCreditBureauReport().setVisible(false);
                loanApplicationForm.getPnlFraudReport().setVisible(false);
                break;
            case FORM_VIEW:
                loanApplicationForm.getBtnChooseClient().setEnabled(false);
                loanApplicationForm.getBtnChooseProduct().setEnabled(false);
                loanApplicationForm.getBtnCreate().setEnabled(false);
                loanApplicationForm.getBtnProcess().setEnabled(true);
                loanApplicationForm.getBtnSaveProcess().setEnabled(false);

                disableChanges();
                loanApplicationForm.getCbStatus().setEnabled(false);

                loanApplicationForm.getPnlCreditBureauReport().setVisible(true);
                loanApplicationForm.getPnlFraudReport().setVisible(true);

                setSelectedLoanApplication();
                break;
            case FORM_PROCESS:
                loanApplicationForm.getBtnChooseClient().setEnabled(false);
                loanApplicationForm.getBtnChooseProduct().setEnabled(false);
                loanApplicationForm.getBtnCreate().setEnabled(false);
                loanApplicationForm.getBtnProcess().setEnabled(false);
                loanApplicationForm.getBtnSaveProcess().setEnabled(true);

                disableChanges();
                loanApplicationForm.getCbStatus().setEnabled(true);

                setSelectedLoanApplication();
                break;
        }
    }

    private void disableChanges() {
        loanApplicationForm.getTxtAmount().setEnabled(false);
        loanApplicationForm.getTxtRepaymentPeriod().setEnabled(false);

        loanApplicationForm.getTxtCreationDateCBR().setEnabled(false);
        loanApplicationForm.getTxtTotalAnnuity().setEnabled(false);
        loanApplicationForm.getTxtTotalDebt().setEnabled(false);
        loanApplicationForm.getTxtNumberOfDaysInDelay().setEnabled(false);

        loanApplicationForm.getTxtCreationDateFR().setEnabled(false);
        loanApplicationForm.getTxtBlackListRate().setEnabled(false);
        loanApplicationForm.getTxtAMLRate().setEnabled(false);
    }

    private void setSelectedLoanApplication() {
        loanApplication = (LoanApplication) MainCoordinator.getInstance().getParam(Constant.SELECTED_LOAN_APPLICATION);
        fillPnlLoanApplication(loanApplication);
        fillPnlDocuments(loanApplication);
        fillPnlCreditBureauReport(loanApplication);
        fillPnlFraudReport(loanApplication);
    }

    private void fillPnlLoanApplication(LoanApplication la) {
        loanApplicationForm.getTxtID().setText(String.valueOf(la.getId()));
        loanApplicationForm.getTxtClient().setText(la.getClient().toString());
        loanApplicationForm.getTxtProduct().setText(la.getProduct().toString());
        loanApplicationForm.getTxtAmount().setValue(la.getAmount());
        loanApplicationForm.getTxtRepaymentPeriod().setText(String.valueOf(la.getRepaymentPeriod()));
        loanApplicationForm.getTxtAnnuity().setValue(la.getAnnuity());
        loanApplicationForm.getCbStatus().setSelectedItem(la.getStatus());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        loanApplicationForm.getTxtCreationDate().setText(sdf.format(la.getCreationDate()));

    }

    private void fillPnlDocuments(LoanApplication la) {
        List<Document> documents = la.getDocuments();
        DocumentTableModel model = new DocumentTableModel(la.getDocuments(), 99);
        loanApplicationForm.getTblDocument().setModel(model);
        loanApplicationForm.getTblDocument().getColumnModel().getColumn(3).setCellEditor(new FileOpenerCellEditor(loanApplicationForm.getTblDocument()));
    }

    private void fillPnlCreditBureauReport(LoanApplication la) {
        try {
            CreditBureauReport creditBureauReport = new CreditBureauReport();
            creditBureauReport.setClient(la.getClient());
            creditBureauReport = Communication.getInstance().getCreditBureauReport(creditBureauReport);
            if (creditBureauReport != null) {
                loanApplication.setCreditBureauReport(creditBureauReport);
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                loanApplicationForm.getTxtCreationDateCBR().setText(sdf.format(creditBureauReport.getCreationDate()));
                loanApplicationForm.getTxtTotalDebt().setValue(creditBureauReport.getTotalDebt());
                loanApplicationForm.getTxtTotalAnnuity().setValue(creditBureauReport.getTotalAnnuity());
                loanApplicationForm.getTxtNumberOfDaysInDelay().setText(String.valueOf(creditBureauReport.getNumberOfDaysInDelay()));
            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fillPnlFraudReport(LoanApplication la) {
        try {
            FraudReport fraudReport = new FraudReport();
            fraudReport.setClient(la.getClient());
            fraudReport = Communication.getInstance().getFraudReport(fraudReport);
            if (fraudReport != null) {
                loanApplication.setFraudReport(fraudReport);
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                loanApplicationForm.getTxtCreationDateFR().setText(sdf.format(fraudReport.getCreationDate()));
                loanApplicationForm.getTxtBlackListRate().setText(String.valueOf(fraudReport.getBlackListRate()));
                loanApplicationForm.getTxtAMLRate().setText(String.valueOf(fraudReport.getAMLRate()));
            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void clientChose(Client c) {
        loanApplication.setClient(c);
        loanApplicationForm.getTxtClient().setText(c.toString());
        System.out.println(loanApplicationForm.getTxtClient().getText());
    }

    @Override
    public void productChose(Product p) {
        loanApplication.setProduct(p);
        loanApplicationForm.getTxtProduct().setText(p.toString());
        fillTblDocuments();
        loanApplicationForm.repaint();

    }

    private void fillTblDocuments() {
        Product p = loanApplication.getProduct();
        List<DocumentTemplate> documentTemplates = p.getDocumentTemplates();
        DocumentTableModel model = new DocumentTableModel(documentTemplates);
        loanApplicationForm.getTblDocument().setModel(model);
        loanApplicationForm.getTblDocument().getColumnModel().getColumn(3).setCellEditor(new FileChooserCellEditor(loanApplicationForm.getTblDocument()));
    }

}
