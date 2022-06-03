package view.controller;

import communication.Communication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import domain.User;
import view.constants.Constant;
import view.coordinator.MainCoordinator;
import view.form.MainForm;

public class MainController {

    private final MainForm mainForm;

    public MainController(MainForm mainForm) {
        this.mainForm = mainForm;
        addActionListeners();
    }

    public void openForm() {
        mainForm.setTitle("Main menu");
        User user = (User) MainCoordinator.getInstance().getParam(Constant.LOGGED_IN_USER);
        mainForm.getLblLoggedInUser().setText("Logged in user: "
                + user.getFirstName() + " " + user.getLastName());
        mainForm.setLocationRelativeTo(null);
        mainForm.setVisible(true);
    }

    public MainForm getMainForm() {
        return mainForm;
    }

    private void addActionListeners() {
        mainForm.jmiAddNewProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openCreateProductForm();
            }
        });

        mainForm.jmiShowAllProductsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openAllProductsForm();
            }
        });

        mainForm.jmiRegisterNewClientActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openCreateClientForm();
            }
        });
        mainForm.jmiShowAllClientsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openAllClientsForm();

            }
        });
        mainForm.jmiCreateLoanApplicationActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openCreateLoanApplicationForm();
            }
        });

        mainForm.jmiShowAllLoanApplicationsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openAllLoanApplicationsForm();
            }
        });

        mainForm.btnLogoutActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int response = JOptionPane.showConfirmDialog(mainForm, "Are you sure you want to log out?");
                    if (response == JOptionPane.YES_OPTION) {
                        boolean ok = Communication.getInstance().logout((User) MainCoordinator.getInstance().getParam(Constant.LOGGED_IN_USER));
                        if (ok) {
                            JOptionPane.showMessageDialog(mainForm, "Logout successful!", "Message", JOptionPane.INFORMATION_MESSAGE);
                            mainForm.dispose();
                        }

                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainForm, "Logout unsuccessful!", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

}
