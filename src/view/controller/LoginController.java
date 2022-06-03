package view.controller;

import communication.Communication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import javax.swing.JOptionPane;

import domain.User;
import view.constants.Constant;
import view.coordinator.MainCoordinator;
import view.form.LoginForm;

public class LoginController {

    private final LoginForm loginForm;

    public LoginController(LoginForm loginForm) {
        this.loginForm = loginForm;
        addActionListeners();
    }

    public void openForm() {
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
    }

    private void addActionListeners() {
        loginForm.btnLoginActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
                try {
                    String username = loginForm.getTxtUsername().getText().trim();
                    String password = String.copyValueOf(loginForm.getTxtPassword().getPassword());

                    validateForm(username, password);

                    User user = Communication.getInstance().login(username, password);
                    JOptionPane.showMessageDialog(loginForm, "User " + user.getFirstName() + " " + user.getLastName() + " logged in!",
                            "Login", JOptionPane.INFORMATION_MESSAGE);
                    loginForm.dispose();
                    MainCoordinator.getInstance().addParam(Constant.LOGGED_IN_USER, user);
                    MainCoordinator.getInstance().openMainForm();
                } catch (ConnectException ex1) {
                    JOptionPane.showMessageDialog(loginForm, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex1.printStackTrace();
                    clearInput();
                } catch (Exception ex2) {
                    JOptionPane.showMessageDialog(loginForm, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex2.printStackTrace();
                }

            }

            private void resetForm() {
                loginForm.getLblUsernameError().setText("");
                loginForm.getLblPasswordError().setText("");
            }

            private void validateForm(String username, String password) throws Exception {
                String errorMessage = "";
                if (username.isEmpty()) {
                    loginForm.getLblUsernameError().setText("Username must be entered!");
                    errorMessage += "Username must be entered!\n";
                }
                if (password.isEmpty()) {
                    loginForm.getLblPasswordError().setText("Password must be entered!");
                    errorMessage += "Password must be entered!\n";
                }

                if (!errorMessage.isEmpty()) {
                    throw new Exception(errorMessage);
                }

            }

            private void clearInput() {
                loginForm.getTxtUsername().setText("");
                loginForm.getTxtPassword().setText("");
            }
        });
    }
}
