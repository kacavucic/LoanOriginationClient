package view.controller;

import communication.Communication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import domain.Client;
import view.constants.Constant;
import view.coordinator.MainCoordinator;
import view.form.AllClientsForm;
import view.form.component.table.ClientTableModel;
import view.form.util.FormMode;
import view.listeners.ChooseClientListener;
import view.listeners.RefreshTableListener;

public class AllClientsController implements RefreshTableListener {

    private final AllClientsForm allClientsForm;
    private ChooseClientListener listener = null;
    private final String CARD_NAME = "allClientsForm";
    private FormMode formMode;

    boolean lastNameSelected;
    boolean JMBGSelected;

    public AllClientsController(AllClientsForm allClientsForm) {
        this.allClientsForm = allClientsForm;
        addActionListeners();
    }

    public AllClientsController(AllClientsForm allClientsForm, ChooseClientListener listener) {
        this.allClientsForm = allClientsForm;
        this.listener = listener;
        addActionListeners();
    }

    private void addActionListeners() {

        allClientsForm.cBoxLastNameActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton absB = (AbstractButton) e.getSource();
                if (absB.getModel().isSelected()) {
                    allClientsForm.getTxtLastName().setEnabled(true);
                    lastNameSelected = true;
                } else {
                    allClientsForm.getTxtLastName().setEnabled(false);
                    allClientsForm.getTxtLastName().setText("");
                    lastNameSelected = false;
                }
            }
        });

        allClientsForm.addCBoxJMBGActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton absB = (AbstractButton) e.getSource();
                if (absB.getModel().isSelected()) {
                    allClientsForm.getTxtJMBG().setEnabled(true);
                    JMBGSelected = true;
                } else {
                    allClientsForm.getTxtJMBG().setEnabled(false);
                    allClientsForm.getTxtJMBG().setText("");
                    JMBGSelected = false;
                }
            }
        });

        allClientsForm.btnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client c = new Client();
                    validateCriteria();
                    c.setLastName(allClientsForm.getTxtLastName().getText().trim());
                    c.setJMBG(allClientsForm.getTxtJMBG().getText().trim());
                    List<Client> clients = Communication.getInstance().findClients(c);
                    ClientTableModel model = new ClientTableModel(clients);
                    allClientsForm.getTblClients().setModel(model);

                    if (clients.isEmpty()) {
                        JOptionPane.showMessageDialog(allClientsForm, "No client matches given criteria!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(allClientsForm, "System has found clients by given criteria!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(allClientsForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void validateCriteria() throws Exception {
                String error = "";
                String lastName = allClientsForm.getTxtLastName().getText().trim();
                String jmbg = allClientsForm.getTxtJMBG().getText().trim();

                if (lastNameSelected) {
                    if (lastName.isEmpty()) {
                        error += "Last name must be entered!\n";
                    }
                }

                if (JMBGSelected) {
                    if (jmbg.isEmpty()) {
                        error += "JMBG must be entered!\n";
                    } else {
                        for (int i = 0; i < jmbg.length(); i++) {
                            if (Character.isDigit(jmbg.charAt(i))) {

                            } else {
                                error += "JMBG must contain only digits!\n";
                                break;
                            }
                        }
                        /*
                        if (jmbg.length() != 13) {
                            error += "JMBG must contain 13 digits!\n";
                        }
                         */
                    }
                }

                if (!error.isEmpty()) {
                    throw new Exception(error);
                }
            }

        });

        allClientsForm.btnDetailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = allClientsForm.getTblClients().getSelectedRow();
                if (rowIndex >= 0) {
                    try {
                        ClientTableModel model = (ClientTableModel) allClientsForm.getTblClients().getModel();
                        Client c = model.getClient(rowIndex);
                        MainCoordinator.getInstance().addParam(Constant.SELECTED_CLIENT, c);
                        MainCoordinator.getInstance().openClientDetailsForm();
                        JOptionPane.showMessageDialog(allClientsForm, "System has loaded the client!", "Message", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception ex) {
                        Logger.getLogger(AllClientsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(allClientsForm, "You must chose the client!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        allClientsForm.btnChooseClientActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = allClientsForm.getTblClients().getSelectedRow();
                if (rowIndex >= 0) {
                    try {
                        ClientTableModel model = (ClientTableModel) allClientsForm.getTblClients().getModel();
                        Client c = model.getClient(rowIndex);
                        if (listener != null) {
                            listener.clientChose(c);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    MainCoordinator.getInstance().getMainController().getMainForm().removeCard(allClientsForm, CARD_NAME + formMode);
                    JOptionPane.showMessageDialog(allClientsForm, "System had added the client to the loan application!", "Message", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(allClientsForm, "You must chose the client!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        allClientsForm.addBtnExitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().getMainController().getMainForm().removeCard(allClientsForm, CARD_NAME + formMode);
            }
        });
    }

    public void openForm(FormMode formMode) {
        this.formMode = formMode;
        MainCoordinator.getInstance().getMainController().getMainForm().addCard(allClientsForm, CARD_NAME + this.formMode);
        prepareView(formMode);
    }

    private void prepareView(FormMode formMode) {
        allClientsForm.getTxtLastName().setEnabled(false);
        allClientsForm.getTxtJMBG().setEnabled(false);
        fillTblClients();
        setupComponents(formMode);
    }

    private void fillTblClients() {
        List<Client> clients;
        try {
            clients = Communication.getInstance().getAllClients();
            for (Client c : clients) {
                c = (Client) c;
            }
            ClientTableModel model = new ClientTableModel(clients);
            allClientsForm.getTblClients().setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(allClientsForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setupComponents(FormMode formMode) {
        switch (formMode) {
            case FORM_VIEW:
                allClientsForm.getBtnDetails().setVisible(true);
                allClientsForm.getBtnChooseClient().setVisible(false);
                break;
            case FORM_CHOOSE:
                allClientsForm.getBtnDetails().setVisible(false);
                allClientsForm.getBtnChooseClient().setVisible(true);
                break;
        }
    }

    @Override
    public void refreshTable() {
        fillTblClients();
    }

}
