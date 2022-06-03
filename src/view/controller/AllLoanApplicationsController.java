package view.controller;

import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import constants.LoanApplicationStatus;
import domain.LoanApplication;
import view.constants.Constant;
import view.coordinator.MainCoordinator;
import view.form.AllLoanApplicationsForm;
import view.form.component.table.LoanApplicationTableModel;
import view.listeners.RefreshTableListener;


public class AllLoanApplicationsController implements RefreshTableListener {

    private final AllLoanApplicationsForm allLoanApplicationsForm;
    private final String CARD_NAME = "allLoanApplicationsForm";

    boolean statusSelected;

    public AllLoanApplicationsController(AllLoanApplicationsForm allLoanApplicationsForm) {
        this.allLoanApplicationsForm = allLoanApplicationsForm;
        addActionListeners();
    }

    public void openForm() {
        MainCoordinator.getInstance().getMainController().getMainForm().addCard(allLoanApplicationsForm, CARD_NAME);
        prepareView();
    }

    private void prepareView() {
        fillCbStatus();
        fillTblLoanApplications();

    }

    private void fillCbStatus() {
        allLoanApplicationsForm.getCbStatus().removeAllItems();
        allLoanApplicationsForm.getCbStatus().setEnabled(false);
        allLoanApplicationsForm.getCbStatus().insertItemAt(null, 0);
        for (LoanApplicationStatus s : LoanApplicationStatus.values()) {
            allLoanApplicationsForm.getCbStatus().addItem(s);
        }
    }

    private void fillTblLoanApplications() {
        try {
            List<LoanApplication> loanApplications = Communication.getInstance().getAllLoanApplications();
            LoanApplicationTableModel model = new LoanApplicationTableModel(loanApplications);
            allLoanApplicationsForm.getTblLoanApplications().setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(allLoanApplicationsForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addActionListeners() {

        allLoanApplicationsForm.addCBoxStatusActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton absB = (AbstractButton) e.getSource();
                if (absB.getModel().isSelected()) {
                    allLoanApplicationsForm.getCbStatus().setEnabled(true);
                    statusSelected = true;
                } else {
                    allLoanApplicationsForm.getCbStatus().setEnabled(false);
                    allLoanApplicationsForm.getCbStatus().setSelectedIndex(0);
                    statusSelected = false;
                }
            }
        });
        allLoanApplicationsForm.btnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoanApplication la = new LoanApplication();
                    validateSearch();

                    la.setStatus((LoanApplicationStatus) allLoanApplicationsForm.getCbStatus().getSelectedItem());
                    List<LoanApplication> wantedLoanApplications = Communication.getInstance().findLoanApplications(la);
                    LoanApplicationTableModel model = new LoanApplicationTableModel(wantedLoanApplications);
                    allLoanApplicationsForm.getTblLoanApplications().setModel(model);
                    if (wantedLoanApplications.isEmpty()) {
                        JOptionPane.showMessageDialog(allLoanApplicationsForm, "No loan application matches given criteria!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(allLoanApplicationsForm, "System has found loan applications by given criteria!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(allLoanApplicationsForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void validateSearch() throws Exception {
                String error = "";

                if (statusSelected) {
                    if (allLoanApplicationsForm.getCbStatus().getSelectedItem() == null) {
                        error += "Status must be selected!\n";
                    }
                }
                if (!error.isEmpty()) {
                    throw new Exception(error);
                }
            }
        });
        allLoanApplicationsForm.btnDetailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = allLoanApplicationsForm.getTblLoanApplications().getSelectedRow();
                if (rowIndex >= 0) {
                    LoanApplicationTableModel model = (LoanApplicationTableModel) allLoanApplicationsForm.getTblLoanApplications().getModel();
                    LoanApplication la = model.getLoanApplication(rowIndex);
                    MainCoordinator.getInstance().addParam(Constant.SELECTED_LOAN_APPLICATION, la);
                    MainCoordinator.getInstance().openLoanApplicationDetailsForm();
                    JOptionPane.showMessageDialog(allLoanApplicationsForm, "System has loaded the loan application!", "Message", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(allLoanApplicationsForm, "You must chose the loan application!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        allLoanApplicationsForm.addBtnExitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().getMainController().getMainForm().removeCard(allLoanApplicationsForm, CARD_NAME);
            }
        });
    }

    @Override
    public void refreshTable() {
        fillTblLoanApplications();
    }
}
