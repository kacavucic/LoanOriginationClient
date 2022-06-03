package view.controller;

import communication.Communication;

import constants.ClientType;
import constants.ContractType;
import constants.MaritalStatus;
import domain.Client;
import domain.Employed;
import domain.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

import view.constants.Constant;
import view.coordinator.MainCoordinator;
import view.form.ClientForm;
import view.form.util.EmailValidator;
import view.form.util.FormMode;
import view.listeners.RefreshTableListener;


public class ClientController {

    private final ClientForm clientForm;
    private RefreshTableListener refreshTableListener;
    private final String CARD_NAME = "clientForm";
    private FormMode formMode;

    public ClientController(ClientForm clientForm) {
        this.clientForm = clientForm;
        addActionListeners();
    }

    public ClientController(ClientForm clientForm, RefreshTableListener refreshTableListener) {
        this.clientForm = clientForm;
        this.refreshTableListener = refreshTableListener;
        addActionListeners();

    }

    private void addActionListeners() {

        clientForm.btnRegistrationActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateClient();
                    ClientType ct = (ClientType) clientForm.getCbClientType().getSelectedItem();
                    Client c;
                    switch (ct) {
                        case STUDENT:
                            validateStudent();
                            c = makeStudentFromForm();
                            break;
                        case EMPLOYED:
                            validateEmployed();
                            c = makeEmployedFromForm();
                            break;
                        default:
                            throw new Exception("You have to choose client type!");
                    }
                    Client savedClient = Communication.getInstance().registerClient(c);
                    JOptionPane.showMessageDialog(clientForm, "System has registered client with ID: " + savedClient.getId() + "!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    resetForm(savedClient);
                    if (refreshTableListener != null) {
                        refreshTableListener.refreshTable();
                    }
                    MainCoordinator.getInstance().addParam(Constant.SELECTED_CLIENT, savedClient);
                    MainCoordinator.getInstance().openClientDetailsForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(clientForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void resetForm(Client savedClient) {
                clientForm.getTxtID().setText("");
                clientForm.getTxtFirstName().setText("");
                clientForm.getTxtLastName().setText("");
                clientForm.getTxtJMBG().setText("");

                GregorianCalendar birthDate = new GregorianCalendar();
                birthDate.setTime(new Date(325983600000L));

                clientForm.getPickerBirthDate().getModel().setDate(birthDate.get(GregorianCalendar.YEAR),
                        birthDate.get(GregorianCalendar.MONTH),
                        birthDate.get(GregorianCalendar.DAY_OF_MONTH));

                clientForm.getTxtContactPhone().setText("");
                clientForm.getTxtAddress().setText("");
                clientForm.getTxtEmail().setText("");
                clientForm.getCbMaritalStatus().setSelectedItem(null);
                clientForm.getCbClientType().setSelectedItem(null);

                if (savedClient instanceof Student) {
                    // reset Student fields
                    clientForm.getTxtAverageGrade().setValue(null);
                    clientForm.getTxtLengthOfStudy().setText("");
                    clientForm.getBtnGroupBudget().clearSelection();
                    clientForm.getTxtNumberOfRemainingExams().setText("");
                    clientForm.getTxtUniversity().setText("");
                    clientForm.getTxtFaculty().setText("");
                    clientForm.getTxtCourse().setText("");
                }

                if (savedClient instanceof Employed) {
                    // reset Employed fields
                    clientForm.getTxtEmployerName().setText("");
                    clientForm.getTxtTaxIdentificationNumberOfEmployer().setText("");
                    clientForm.getTxtSalaryAmount().setValue(null);
                    clientForm.getTxtLengthOfEmployment().setText("");
                    clientForm.getCbContractType().setSelectedItem(null);
                }
            }
        });

        clientForm.cbClientTypeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientForm.getCbClientType().getSelectedItem() == null) {
                    clientForm.getPnlStudent().setVisible(false);
                    clientForm.getPnlEmployed().setVisible(false);
                    return;
                }

                ClientType choice = (ClientType) clientForm.getCbClientType().getSelectedItem();
                if (choice.equals(ClientType.getByName("Student"))) {
                    clientForm.getPnlStudent().setVisible(true);
                    clientForm.getPnlEmployed().setVisible(false);
                } else if (choice.equals(ClientType.getByName("Employed"))) {
                    clientForm.getPnlStudent().setVisible(false);
                    clientForm.getPnlEmployed().setVisible(true);
                }
            }
        });

        clientForm.btnEditActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupComponents(FormMode.FORM_EDIT);
            }
        });

        clientForm.btnSaveChangesActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client c = (Client) MainCoordinator.getInstance().getParam(Constant.SELECTED_CLIENT);
                    validateClient();

                    if (c instanceof Student) {
                        validateStudent();
                        c = makeStudentFromForm((Student) c);
                    } else if (c instanceof Employed) {
                        validateEmployed();
                        c = makeEmployedFromForm((Employed) c);
                    }

                    int response = JOptionPane.showConfirmDialog(clientForm,
                            "Are you sure you want to edit client with ID: "
                                    + c.getId() + "?");
                    if (response == JOptionPane.YES_OPTION) {
                        Communication.getInstance().editClient(c);
                        setupComponents(FormMode.FORM_VIEW);
                        JOptionPane.showMessageDialog(clientForm, "Client successfully edited!", "Message", JOptionPane.INFORMATION_MESSAGE);

                        if (refreshTableListener != null) {
                            refreshTableListener.refreshTable();
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(clientForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clientForm.addBtnExitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().getMainController().getMainForm().removeCard(clientForm, CARD_NAME + formMode);
            }
        });
    }

    public void openForm(FormMode formMode) {
        this.formMode = formMode;
        MainCoordinator.getInstance().getMainController().getMainForm().addCard(clientForm, CARD_NAME + this.formMode);
        prepareView(formMode);
    }

    private void prepareView(FormMode formMode) {
        clientForm.getPnlStudent().setVisible(false);
        clientForm.getPnlEmployed().setVisible(false);
        clientForm.getTxtID().setEnabled(false);
        fillCbContractType();
        fillCbMaritalStatus();
        fillCbClientType();
        setupComponents(formMode);
    }

    private void fillCbContractType() {
        clientForm.getCbContractType().removeAllItems();
        clientForm.getCbContractType().insertItemAt(null, 0);
        for (ContractType ct : ContractType.values()) {
            clientForm.getCbContractType().addItem(ct);
        }
    }

    private void fillCbMaritalStatus() {
        clientForm.getCbMaritalStatus().removeAllItems();
        clientForm.getCbMaritalStatus().insertItemAt(null, 0);
        for (MaritalStatus ms : MaritalStatus.values()) {
            clientForm.getCbMaritalStatus().addItem(ms);
        }
    }

    private void fillCbClientType() {
        clientForm.getCbClientType().removeAllItems();
        clientForm.getCbClientType().insertItemAt(null, 0);
        for (ClientType ct : ClientType.values()) {
            clientForm.getCbClientType().addItem(ct);
        }
    }

    private void setupComponents(FormMode formMode) {
        switch (formMode) {
            case FORM_CREATE:
                clientForm.getBtnRegistration().setEnabled(true);
                clientForm.getBtnSaveChanges().setEnabled(false);
                clientForm.getBtnEdit().setEnabled(false);
                break;
            case FORM_VIEW:
                clientForm.getBtnRegistration().setEnabled(false);
                clientForm.getBtnEdit().setEnabled(true);
                clientForm.getBtnSaveChanges().setEnabled(false);
                setSelectedClient();
                disableChanges();
                break;
            case FORM_EDIT:
                clientForm.getBtnRegistration().setEnabled(false);
                clientForm.getBtnEdit().setEnabled(false);
                clientForm.getBtnSaveChanges().setEnabled(true);
                setSelectedClient();
                enableChanges();
                break;
        }
    }

    private void enableChanges() {
        clientForm.getTxtAddress().setEnabled(true);
        clientForm.getTxtEmail().setEnabled(true);
        clientForm.getTxtFirstName().setEnabled(true);
        clientForm.getTxtJMBG().setEnabled(true);
        clientForm.getTxtContactPhone().setEnabled(true);
        clientForm.getTxtLastName().setEnabled(true);
        clientForm.getPickerBirthDate().setEnabled(true);
        clientForm.getCbMaritalStatus().setEnabled(true);
        clientForm.getCbClientType().setEnabled(true);
        /////////////////////////////////////
        clientForm.getTxtAverageGrade().setEnabled(true);
        clientForm.getTxtLengthOfStudy().setEnabled(true);
        clientForm.getRbYes().setEnabled(true);
        clientForm.getRbNo().setEnabled(true);
        clientForm.getTxtNumberOfRemainingExams().setEnabled(true);
        clientForm.getTxtUniversity().setEnabled(true);
        clientForm.getTxtFaculty().setEnabled(true);
        clientForm.getTxtCourse().setEnabled(true);
        /////////////////////////////////////
        clientForm.getTxtEmployerName().setEnabled(true);
        clientForm.getTxtTaxIdentificationNumberOfEmployer().setEnabled(true);
        clientForm.getTxtSalaryAmount().setEnabled(true);
        clientForm.getTxtLengthOfEmployment().setEnabled(true);
        clientForm.getCbContractType().setEnabled(true);
    }

    private void disableChanges() {
        clientForm.getTxtAddress().setEnabled(false);
        clientForm.getTxtEmail().setEnabled(false);
        clientForm.getTxtFirstName().setEnabled(false);
        clientForm.getTxtJMBG().setEnabled(false);
        clientForm.getTxtContactPhone().setEnabled(false);
        clientForm.getTxtLastName().setEnabled(false);
        clientForm.getPickerBirthDate().setEnabled(false);
        clientForm.getCbMaritalStatus().setEnabled(false);
        clientForm.getCbClientType().setEnabled(false);
        /////////////////////////////////////
        clientForm.getTxtAverageGrade().setEnabled(false);
        clientForm.getTxtLengthOfStudy().setEnabled(false);
        clientForm.getRbYes().setEnabled(false);
        clientForm.getRbNo().setEnabled(false);
        clientForm.getTxtNumberOfRemainingExams().setEnabled(false);
        clientForm.getTxtUniversity().setEnabled(false);
        clientForm.getTxtFaculty().setEnabled(false);
        clientForm.getTxtCourse().setEnabled(false);
        /////////////////////////////////////
        clientForm.getTxtEmployerName().setEnabled(false);
        clientForm.getTxtTaxIdentificationNumberOfEmployer().setEnabled(false);
        clientForm.getTxtSalaryAmount().setEnabled(false);
        clientForm.getTxtLengthOfEmployment().setEnabled(false);
        clientForm.getCbContractType().setEnabled(false);
    }

    private void setSelectedClient() {
        Client c = (Client) MainCoordinator.getInstance().getParam(Constant.SELECTED_CLIENT);
        clientForm.getTxtID().setText(String.valueOf(c.getId()));
        clientForm.getTxtFirstName().setText(c.getFirstName());
        clientForm.getTxtLastName().setText(c.getLastName());
        clientForm.getTxtJMBG().setText(c.getJMBG());

        GregorianCalendar birthDate = new GregorianCalendar();
        birthDate.setTime(c.getBirthDate());

        clientForm.getPickerBirthDate().getModel().setDate(birthDate.get(GregorianCalendar.YEAR),
                birthDate.get(GregorianCalendar.MONTH),
                birthDate.get(GregorianCalendar.DAY_OF_MONTH));

        clientForm.getTxtContactPhone().setText(c.getContactPhone());
        clientForm.getTxtAddress().setText(c.getAddress());
        clientForm.getTxtEmail().setText(c.getEmail());
        clientForm.getCbMaritalStatus().setSelectedItem(MaritalStatus.getByName(c.getMaritalStatus().getName()));
        clientForm.getCbClientType().setSelectedItem(ClientType.getByName(c.getType().getName()));

        if (c instanceof Student) {
            Student s = (Student) c;
            // set Student fields
            clientForm.getTxtAverageGrade().setValue(s.getAverageGrade());
            clientForm.getTxtLengthOfStudy().setText(String.valueOf(s.getLengthOfStudy()));

            if (s.isStateBudgetFinancing()) {
                clientForm.getRbYes().setSelected(true);
            } else if (!s.isStateBudgetFinancing()) {
                clientForm.getRbNo().setSelected(true);
            }

            clientForm.getTxtNumberOfRemainingExams().setText(String.valueOf(s.getNumberOfRemainingExams()));
            clientForm.getTxtUniversity().setText(s.getUniversity());
            clientForm.getTxtFaculty().setText(s.getFaculty());
            clientForm.getTxtCourse().setText(s.getCourse());
        }

        if (c instanceof Employed) {
            Employed e = (Employed) c;
            // set Employed fields
            clientForm.getTxtEmployerName().setText(e.getEmployerName());
            clientForm.getTxtTaxIdentificationNumberOfEmployer().setText(e.getTaxIdentificationNumberOfEmployer());
            clientForm.getTxtSalaryAmount().setValue(e.getSalaryAmount());
            clientForm.getTxtLengthOfEmployment().setText(String.valueOf(e.getLengthOfEmployment()));
            clientForm.getCbContractType().setSelectedItem(e.getContractType());
        }
    }

    private Client makeClientFromForm(Client c) {
        c.setJMBG(clientForm.getTxtJMBG().getText().trim());
        c.setFirstName(clientForm.getTxtFirstName().getText().trim());
        c.setLastName(clientForm.getTxtLastName().getText().trim());
        GregorianCalendar birthDate = (GregorianCalendar) clientForm.getPickerBirthDate().getModel().getValue();
        c.setBirthDate(birthDate.getTime());
        c.setContactPhone(clientForm.getTxtContactPhone().getText().trim());
        c.setAddress(clientForm.getTxtAddress().getText().trim());
        c.setEmail(clientForm.getTxtEmail().getText().trim());
        c.setMaritalStatus((MaritalStatus) clientForm.getCbMaritalStatus().getSelectedItem());
        c.setType((ClientType) clientForm.getCbClientType().getSelectedItem());
        return c;
    }

    private Client makeClientFormForm() {
        Client c = new Client();
        return makeClientFromForm(c);
    }

    private Student makeStudentFromForm() {
        return makeStudentFromForm(new Student());
    }

    private Student makeStudentFromForm(Student s) {
        s.setJMBG(clientForm.getTxtJMBG().getText().trim());
        s.setFirstName(clientForm.getTxtFirstName().getText().trim());
        s.setLastName(clientForm.getTxtLastName().getText().trim());
        GregorianCalendar birthDate = (GregorianCalendar) clientForm.getPickerBirthDate().getModel().getValue();
        s.setBirthDate(birthDate.getTime());
        s.setContactPhone(clientForm.getTxtContactPhone().getText().trim());
        s.setAddress(clientForm.getTxtAddress().getText().trim());
        s.setEmail(clientForm.getTxtEmail().getText().trim());
        s.setMaritalStatus((MaritalStatus) clientForm.getCbMaritalStatus().getSelectedItem());
        s.setType((ClientType) clientForm.getCbClientType().getSelectedItem());
        ////////////////////////////////////////////////////
        s.setAverageGrade((((Number) clientForm.getTxtAverageGrade().getValue()).doubleValue()));
        s.setLengthOfStudy(Integer.parseInt(clientForm.getTxtLengthOfStudy().getText().trim()));

        if (clientForm.getRbYes().isSelected()) {
            s.setStateBudgetFinancing(true);
        } else if (clientForm.getRbNo().isSelected()) {
            s.setStateBudgetFinancing(false);
        }

        s.setNumberOfRemainingExams(Integer.parseInt(clientForm.getTxtNumberOfRemainingExams().getText().trim()));
        s.setUniversity(clientForm.getTxtUniversity().getText().trim());
        s.setFaculty(clientForm.getTxtFaculty().getText().trim());
        s.setCourse(clientForm.getTxtCourse().getText().trim());
        return s;
    }

    private Employed makeEmployedFromForm() {
        return makeEmployedFromForm(new Employed());
    }

    private Employed makeEmployedFromForm(Employed e) {
        e.setJMBG(clientForm.getTxtJMBG().getText().trim());
        e.setFirstName(clientForm.getTxtFirstName().getText().trim());
        e.setLastName(clientForm.getTxtLastName().getText().trim());
        GregorianCalendar birthDate = (GregorianCalendar) clientForm.getPickerBirthDate().getModel().getValue();
        e.setBirthDate(birthDate.getTime());
        e.setContactPhone(clientForm.getTxtContactPhone().getText().trim());
        e.setAddress(clientForm.getTxtAddress().getText().trim());
        e.setEmail(clientForm.getTxtEmail().getText().trim());
        e.setMaritalStatus((MaritalStatus) clientForm.getCbMaritalStatus().getSelectedItem());
        e.setType((ClientType) clientForm.getCbClientType().getSelectedItem());
        ////////////////////////////////////////////////////
        e.setEmployerName(clientForm.getTxtEmployerName().getText().trim());
        e.setTaxIdentificationNumberOfEmployer(clientForm.getTxtTaxIdentificationNumberOfEmployer().getText().trim());
        e.setSalaryAmount((((Number) clientForm.getTxtSalaryAmount().getValue()).doubleValue()));
        e.setLengthOfEmployment(Integer.parseInt(clientForm.getTxtLengthOfEmployment().getText().trim()));
        e.setContractType((ContractType) clientForm.getCbContractType().getSelectedItem());
        return e;
    }

    private void validateClient() throws Exception {
        String error = "";
        int day = clientForm.getPickerBirthDate().getModel().getDay();
        int month = clientForm.getPickerBirthDate().getModel().getMonth();
        month += 1;
        int year = clientForm.getPickerBirthDate().getModel().getYear();
        String jmbg = clientForm.getTxtJMBG().getText().trim();
        String contactPhone = clientForm.getTxtContactPhone().getText().trim();

        String firstName = clientForm.getTxtFirstName().getText().trim();
        String lastName = clientForm.getTxtLastName().getText().trim();

        if (firstName.isEmpty()) {
            error += "First name must be entered!\n";
        } else {
            if (!isAlpha(firstName)) {
                error += "First name must contain only characters!\n";
            }
        }

        if (lastName.isEmpty()) {
            error += "Last name must be entered!\n";
        } else {
            if (!isAlpha(lastName)) {
                error += "Last name must contain only characters!\n";
            }
        }

        if (jmbg.isEmpty()) {
            error += "JMBG must be entered!\n";
        } else {
            if (!isDigit(jmbg)) {
                error += "JMBG must contain only digits!\n";
            }

            if (jmbg.length() != 13) {
                error += "JMBG must contain 13 digits!\n";
            } else {
                try {
                    int dayINT = Integer.parseInt(jmbg.substring(0,
                            jmbg.length() - 11));
                    int monthINT = Integer.parseInt(jmbg.substring(2,
                            jmbg.length() - 9));
                    int yearINT = Integer.parseInt(jmbg.substring(4,
                            jmbg.length() - 6));

                    if (dayINT != day) {
                        error += "JMBG invalid: Day of birth from JMBG doesn't match birth date!\n";
                    }

                    if (monthINT != month) {
                        error += "JMBG invalid: Month of birth from JMBG doesn't match birth date!\n";
                    }

                    if (yearINT > 21 && yearINT < 1000) {
                        yearINT += 1000;
                    } else if (yearINT <= 21) {
                        yearINT += 2000;
                    }

                    if (yearINT != year) {
                        error += "JMBG invalid: Year of birth from JMBG doesn't match birth date!\n";
                    }
                } catch (Exception ex) {

                }
            }
        }

        if (clientForm.getCbMaritalStatus().getSelectedItem() == null) {
            error += "Marital status must be selected!\n";
        }

        if (clientForm.getCbClientType().getSelectedItem() == null) {
            error += "Client type must be selected!\n";
        }

        if (contactPhone.isEmpty()) {
            error += "Contact phone must be entered!\n";
        } else {
            if (!isDigit(contactPhone)) {
                error += "Contact phone must contain only digits!\n";
            }

        }

        if (clientForm.getTxtAddress().getText().trim().isEmpty()) {
            error += "Address must be entered!\n";
        }

        if (clientForm.getTxtEmail().getText().trim().isEmpty()) {
            error += "Email address must be entered!\n";
        } else {
            EmailValidator emailValidator = new EmailValidator();
            if (!emailValidator.validate(clientForm.getTxtEmail().getText().trim())) {
                error += "Invalid format of email address!\n";
            }
        }

        if (!error.isEmpty()) {
            throw new Exception(error);
        }
    }

    private void validateStudent() throws Exception {
        String error = "";
        double averageGrade = 0;
        String university = clientForm.getTxtUniversity().getText().trim();
        String faculty = clientForm.getTxtFaculty().getText().trim();
        String course = clientForm.getTxtCourse().getText().trim();

        if (String.valueOf(clientForm.getTxtAverageGrade().getText().trim()).isEmpty()) {
            error += "Average grade must be entered!\n";
        } else {
            averageGrade = ((Number) clientForm.getTxtAverageGrade().getValue()).doubleValue();
            if (averageGrade < 6 || averageGrade > 10) {
                error += "Average grade must be in range [6.00-10.00]!\n";
            }
        }

        if (clientForm.getTxtLengthOfStudy().getText().trim().isEmpty()) {
            error += "Length of study must be entered!\n";
        } else {
            int lengthOfStudy = Integer.parseInt(clientForm.getTxtLengthOfStudy().getText().trim());
            if (lengthOfStudy <= 0) {
                error += "Length of study can not be zero or negative!\n";
            } else {
                if (lengthOfStudy > 120) {
                    error += "Length of study can not be more than 120 months(10 years)!\n";
                }
            }
        }

        if (clientForm.getTxtNumberOfRemainingExams().getText().trim().isEmpty()) {
            error += "Number of remaining exams must be entered!\n";
        } else {
            int numberOfRemainingExams = Integer.parseInt(clientForm.getTxtNumberOfRemainingExams().getText().trim());
            if (numberOfRemainingExams <= 0) {
                error += "Number of remaining exams can not be zero or negative!\n";
            } else {
                if (numberOfRemainingExams > 90) {
                    error += "Number of remaining exams can not be greater than 90!\n";
                }
            }
        }

        if (university.isEmpty()) {
            error += "University must be entered!\n";
        } else {
            if (!isAlpha(university)) {
                error += "University must contain only characters!\n";
            }
        }

        if (faculty.isEmpty()) {
            error += "Faculty must be entered!\n";
        } else {
            if (!isAlpha(faculty)) {
                error += "Faculty must contain only characters!\n";
            }
        }

        if (course.isEmpty()) {
            error += "Course must be entered!\n";
        } else {
            if (!isAlpha(course)) {
                error += "Course must contain only characters!\n";
            }
        }

        if (clientForm.getBtnGroupBudget().getSelection() == null) {
            error += "State budget financing status must be selected!\n";
        }

        if (!error.isEmpty()) {
            throw new Exception(error);
        }
    }

    private void validateEmployed() throws Exception {
        String error = "";
        String TIN = clientForm.getTxtTaxIdentificationNumberOfEmployer().getText().trim();
        double salaryAmount = 0;

        if (clientForm.getTxtEmployerName().getText().trim().isEmpty()) {
            error += "Employer name must be entered!\n";
        }

        if (TIN.isEmpty()) {
            error += "Tax identification number of employer must be entered!\n";
        } else {
            if (!isDigit(TIN)) {
                error += "Tax identification number of employer must contain only digits!\n";
            }

            if (TIN.length() != 9) {
                error += "Tax identification number of employer must contain 9 digits!\n";
            }
        }

        if (String.valueOf(clientForm.getTxtSalaryAmount().getText().trim()).isEmpty()) {
            error += "Salary amount must be entered!\n";
        } else {
            salaryAmount = ((Number) clientForm.getTxtSalaryAmount().getValue()).doubleValue();
            if (salaryAmount <= 0) {
                error += "Salary amount can not be zero or negative!\n";
            }
        }

        if (clientForm.getTxtLengthOfEmployment().getText().trim().isEmpty()) {
            error += "Length of employment must be entered!\n";
        } else {
            int lengthOfEmployment = Integer.parseInt(clientForm.getTxtLengthOfEmployment().getText().trim());
            if (lengthOfEmployment <= 0) {
                error += "Length of employment can not be zero or negative!\n";
            } else {
                if (lengthOfEmployment < 6) {
                    error += "Length of employment must be at least 6 months!\n";
                }
            }
        }

        if (clientForm.getCbContractType().getSelectedItem() == null) {
            error += "Contract type must be chosen!\n";
        }

        if (!error.isEmpty()) {
            throw new Exception(error);
        }
    }

    public boolean isAlpha(String name) {
        name = name.replaceAll("\\s+", "");
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDigit(String name) {
        name = name.replaceAll("\\s+", "");
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}

