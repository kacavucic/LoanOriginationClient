package view.form;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.jdatepicker.JDatePicker;


public class ClientForm extends javax.swing.JPanel {


    public ClientForm() {
        initComponents();
        btnGroupBudget.add(rbYes);
        btnGroupBudget.add(rbNo);
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnGroupBudget = new ButtonGroup();
        jFormattedTextField1 = new JFormattedTextField();
        pnlStudent = new JPanel();
        lblAverageGrade = new JLabel();
        lblLengthOfStudy = new JLabel();
        lblBudget = new JLabel();
        lblNumberOfRemainingExams = new JLabel();
        lblUniversity = new JLabel();
        lblFaculty = new JLabel();
        lblCourse = new JLabel();
        txtLengthOfEmployment = new JTextField();
        rbYes = new JRadioButton();
        rbNo = new JRadioButton();
        txtNumberOfRemainingExams = new JTextField();
        txtUniversity = new JTextField();
        txtFaculty = new JTextField();
        txtCourse = new JTextField();
        txtAverageGrade = new JFormattedTextField();
        pnlEmployed = new JPanel();
        lblEmployerName = new JLabel();
        lblTaxIdentificationNumberOfEmployer = new JLabel();
        lblSalaryAmount = new JLabel();
        lblLengthOfEmployment = new JLabel();
        lblContractType = new JLabel();
        txtEmployerName = new JTextField();
        txtTaxIdentificationNumberOfEmployer = new JTextField();
        txtLengthOfEmployment = new JTextField();
        cbContractType = new JComboBox<>();
        txtSalaryAmount = new JFormattedTextField();
        jPanel1 = new JPanel();
        lblClientType = new JLabel();
        lblMaritalStatus = new JLabel();
        lblJMBG = new JLabel();
        lblLastName = new JLabel();
        lblFirstName = new JLabel();
        txtFirstName = new JTextField();
        txtJMBG = new JTextField();
        cbClientType = new JComboBox<>();
        lblContactPhone = new JLabel();
        lblAddress = new JLabel();
        lblEmail = new JLabel();
        txtLastName = new JTextField();
        lblID = new JLabel();
        txtID = new JTextField();
        lblBirthDate = new JLabel();
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1980);
        c.set(Calendar.MONTH, 4);
        c.set(Calendar.DATE, 1);
        pickerBirthDate = new JDatePicker(c);
        cbMaritalStatus = new JComboBox<>();
        txtContactPhone = new JTextField();
        txtAddress = new JTextField();
        txtEmail = new JTextField();
        jPanel2 = new JPanel();
        btnSaveChanges = new JButton();
        btnEdit = new JButton();
        btnRegistration = new JButton();
        btnExit = new JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        pnlStudent.setBorder(BorderFactory.createTitledBorder("Student information"));

        lblAverageGrade.setText("Average grade:");

        lblLengthOfStudy.setText("Length of study[MONTHS]:");

        lblBudget.setText("State budget financing:");

        lblNumberOfRemainingExams.setText("Number of remaining exams:");

        lblUniversity.setText("University:");

        lblFaculty.setText("Faculty:");

        lblCourse.setText("Course:");

        rbYes.setText("Yes");

        rbNo.setText("No");

        txtAverageGrade.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));

        GroupLayout pnlStudentLayout = new GroupLayout(pnlStudent);
        pnlStudent.setLayout(pnlStudentLayout);
        pnlStudentLayout.setHorizontalGroup(
                pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlStudentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNumberOfRemainingExams)
                                        .addComponent(lblLengthOfStudy)
                                        .addComponent(lblAverageGrade, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblUniversity)
                                        .addComponent(lblFaculty)
                                        .addComponent(lblCourse)
                                        .addComponent(lblBudget))
                                .addGap(18, 18, 18)
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlStudentLayout.createSequentialGroup()
                                                .addComponent(rbYes)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbNo))
                                        .addComponent(txtNumberOfRemainingExams)
                                        .addComponent(txtUniversity)
                                        .addComponent(txtFaculty)
                                        .addComponent(txtCourse, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(txtLengthOfStudy)
                                        .addComponent(txtAverageGrade))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStudentLayout.setVerticalGroup(
                pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlStudentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAverageGrade)
                                        .addComponent(txtAverageGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblLengthOfStudy)
                                        .addComponent(txtLengthOfStudy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNumberOfRemainingExams)
                                        .addComponent(txtNumberOfRemainingExams, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUniversity)
                                        .addComponent(txtUniversity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFaculty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFaculty))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCourse)
                                        .addComponent(txtCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlStudentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblBudget)
                                        .addComponent(rbYes)
                                        .addComponent(rbNo))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEmployed.setBorder(BorderFactory.createTitledBorder("Employed information"));
        pnlEmployed.setPreferredSize(new Dimension(305, 247));

        lblEmployerName.setText("Employer name:");

        lblTaxIdentificationNumberOfEmployer.setText("Tax identification number of employer:");

        lblSalaryAmount.setText("Salary amount[RSD]:");

        lblLengthOfEmployment.setText("Length of employment[MONTHS]:");

        lblContractType.setText("Contract type:");

        cbContractType.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtSalaryAmount.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));

        GroupLayout pnlEmployedLayout = new GroupLayout(pnlEmployed);
        pnlEmployed.setLayout(pnlEmployedLayout);
        pnlEmployedLayout.setHorizontalGroup(
                pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlEmployedLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblContractType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSalaryAmount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblLengthOfEmployment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTaxIdentificationNumberOfEmployer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEmployerName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLengthOfEmployment)
                                        .addComponent(cbContractType, 0, 183, Short.MAX_VALUE)
                                        .addComponent(txtTaxIdentificationNumberOfEmployer)
                                        .addComponent(txtEmployerName)
                                        .addComponent(txtSalaryAmount))
                                .addGap(20, 20, 20))
        );
        pnlEmployedLayout.setVerticalGroup(
                pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlEmployedLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEmployerName)
                                        .addComponent(txtEmployerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTaxIdentificationNumberOfEmployer)
                                        .addComponent(txtTaxIdentificationNumberOfEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSalaryAmount)
                                        .addComponent(txtSalaryAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLengthOfEmployment)
                                        .addComponent(txtLengthOfEmployment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEmployedLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblContractType)
                                        .addComponent(cbContractType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.setBorder(BorderFactory.createTitledBorder("Client information"));

        lblClientType.setText("Client Type:");

        lblMaritalStatus.setText("Marital status:");

        lblJMBG.setText("JMBG:");

        lblLastName.setText("Last name:");

        lblFirstName.setText("First name:");

        cbClientType.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblContactPhone.setText("Contact phone:");

        lblAddress.setText("Address:");

        lblEmail.setText("E-mail address:");

        lblID.setText("ID:");

        lblBirthDate.setText("Birth date:");

        cbMaritalStatus.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblLastName, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                        .addComponent(lblJMBG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtJMBG, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblContactPhone)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtContactPhone, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblBirthDate)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pickerBirthDate, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(lblFirstName, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                                        .addComponent(lblID, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txtFirstName, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                                                        .addComponent(txtID))))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblClientType, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cbClientType, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtEmail))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblMaritalStatus, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cbMaritalStatus, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblClientType)
                                        .addComponent(cbClientType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblID)
                                        .addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFirstName)
                                        .addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMaritalStatus)
                                        .addComponent(cbMaritalStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblContactPhone)
                                        .addComponent(lblLastName)
                                        .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtContactPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAddress)
                                        .addComponent(lblJMBG)
                                        .addComponent(txtJMBG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblEmail)
                                                .addComponent(lblBirthDate)
                                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(pickerBirthDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSaveChanges.setText("Save changes");

        btnEdit.setText("Edit");

        btnRegistration.setText("Registration");

        btnExit.setText("Back");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSaveChanges)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistration, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnExit)
                                        .addComponent(btnRegistration)
                                        .addComponent(btnEdit)
                                        .addComponent(btnSaveChanges))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pnlEmployed, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(pnlStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(119, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pnlEmployed, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup btnGroupBudget;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRegistration;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<Object> cbMaritalStatus;
    private javax.swing.JComboBox<Object> cbClientType;
    private javax.swing.JComboBox<Object> cbContractType;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblAverageGrade;
    private javax.swing.JLabel lblLengthOfStudy;
    private javax.swing.JLabel lblBudget;
    private javax.swing.JLabel lblNumberOfRemainingExams;
    private javax.swing.JLabel lblUniversity;
    private javax.swing.JLabel lblFaculty;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblEmployerName;
    private javax.swing.JLabel lblTaxIdentificationNumberOfEmployer;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblSalaryAmount;
    private javax.swing.JLabel lblLengthOfEmployment;
    private javax.swing.JLabel lblContractType;
    private javax.swing.JLabel lblJMBG;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblContactPhone;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMaritalStatus;
    private javax.swing.JLabel lblClientType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.jdatepicker.JDatePicker pickerBirthDate;
    private javax.swing.JPanel pnlStudent;
    private javax.swing.JPanel pnlEmployed;
    private javax.swing.JRadioButton rbYes;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtNumberOfRemainingExams;
    private javax.swing.JTextField txtLengthOfStudy;
    private javax.swing.JTextField txtLengthOfEmployment;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFaculty;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtContactPhone;
    private javax.swing.JTextField txtEmployerName;
    private javax.swing.JTextField txtTaxIdentificationNumberOfEmployer;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JFormattedTextField txtAverageGrade;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtUniversity;
    private javax.swing.JFormattedTextField txtSalaryAmount;
    // End of variables declaration


    public JComboBox<Object> getCbMaritalStatus() {
        return cbMaritalStatus;
    }

    public void setCbMaritalStatus(JComboBox<Object> cbMaritalStatus) {
        this.cbMaritalStatus = cbMaritalStatus;
    }

    public JComboBox<Object> getCbClientType() {
        return cbClientType;
    }

    public void setCbClientType(JComboBox<Object> cbClientType) {
        this.cbClientType = cbClientType;
    }

    public JComboBox<Object> getCbContractType() {
        return cbContractType;
    }

    public void setCbContractType(JComboBox<Object> cbContractType) {
        this.cbContractType = cbContractType;
    }

    public JDatePicker getPickerBirthDate() {
        return pickerBirthDate;
    }

    public void setPickerBirthDate(JDatePicker pickerBirthDate) {
        this.pickerBirthDate = pickerBirthDate;
    }

    public JRadioButton getRbYes() {
        return rbYes;
    }

    public void setRbYes(JRadioButton rbYes) {
        this.rbYes = rbYes;
    }

    public JRadioButton getRbNo() {
        return rbNo;
    }

    public void setRbNo(JRadioButton rbNo) {
        this.rbNo = rbNo;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(JTextField txtAddress) {
        this.txtAddress = txtAddress;
    }

    public JTextField getTxtNumberOfRemainingExams() {
        return txtNumberOfRemainingExams;
    }

    public void setTxtNumberOfRemainingExams(JTextField txtNumberOfRemainingExams) {
        this.txtNumberOfRemainingExams = txtNumberOfRemainingExams;
    }

    public JTextField getTxtLengthOfStudy() {
        return txtLengthOfStudy;
    }

    public void setTxtLengthOfStudy(JTextField txtLengthOfStudy) {
        this.txtLengthOfStudy = txtLengthOfStudy;
    }

    public JTextField getTxtLengthOfEmployment() {
        return txtLengthOfEmployment;
    }

    public void setTxtLengthOfEmployment(JTextField txtLengthOfEmployment) {
        this.txtLengthOfEmployment = txtLengthOfEmployment;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtFaculty() {
        return txtFaculty;
    }

    public void setTxtFaculty(JTextField txtFaculty) {
        this.txtFaculty = txtFaculty;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtFirstName() {
        return txtFirstName;
    }

    public void setTxtFirstName(JTextField txtFirstName) {
        this.txtFirstName = txtFirstName;
    }

    public JTextField getTxtJMBG() {
        return txtJMBG;
    }

    public void setTxtJMBG(JTextField txtJMBG) {
        this.txtJMBG = txtJMBG;
    }

    public JTextField getTxtContactPhone() {
        return txtContactPhone;
    }

    public void setTxtContactPhone(JTextField txtContactPhone) {
        this.txtContactPhone = txtContactPhone;
    }

    public JTextField getTxtEmployerName() {
        return txtEmployerName;
    }

    public void setTxtEmployerName(JTextField txtEmployerName) {
        this.txtEmployerName = txtEmployerName;
    }

    public JTextField getTxtTaxIdentificationNumberOfEmployer() {
        return txtTaxIdentificationNumberOfEmployer;
    }

    public void setTxtTaxIdentificationNumberOfEmployer(JTextField txtTaxIdentificationNumberOfEmployer) {
        this.txtTaxIdentificationNumberOfEmployer = txtTaxIdentificationNumberOfEmployer;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public void setTxtLastName(JTextField txtLastName) {
        this.txtLastName = txtLastName;
    }

    public JFormattedTextField getTxtAverageGrade() {
        return txtAverageGrade;
    }

    public void setTxtAverageGrade(JFormattedTextField txtAverageGrade) {
        this.txtAverageGrade = txtAverageGrade;
    }

    public JTextField getTxtCourse() {
        return txtCourse;
    }

    public void setTxtCourse(JTextField txtCourse) {
        this.txtCourse = txtCourse;
    }

    public JTextField getTxtUniversity() {
        return txtUniversity;
    }

    public void setTxtUniversity(JTextField txtUniversity) {
        this.txtUniversity = txtUniversity;
    }

    public JFormattedTextField getTxtSalaryAmount() {
        return txtSalaryAmount;
    }

    public void setTxtSalaryAmount(JFormattedTextField txtSalaryAmount) {
        this.txtSalaryAmount = txtSalaryAmount;
    }

    public ButtonGroup getBtnGroupBudget() {
        return btnGroupBudget;
    }

    public void setBtnGroupBudget(ButtonGroup btnGroupBudget) {
        this.btnGroupBudget = btnGroupBudget;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }

    public JPanel getPnlStudent() {
        return pnlStudent;
    }

    public void setPnlStudent(JPanel pnlStudent) {
        this.pnlStudent = pnlStudent;
    }

    public JPanel getPnlEmployed() {
        return pnlEmployed;
    }

    public void setPnlEmployed(JPanel pnlEmployed) {
        this.pnlEmployed = pnlEmployed;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JButton getBtnRegistration() {
        return btnRegistration;
    }

    public void setBtnRegistration(JButton btnRegistration) {
        this.btnRegistration = btnRegistration;
    }

    public JButton getBtnSaveChanges() {
        return btnSaveChanges;
    }

    public void setBtnSaveChanges(JButton btnSaveChanges) {
        this.btnSaveChanges = btnSaveChanges;
    }

    //////////////////////////////////////////////////
    public void btnRegistrationActionListener(ActionListener actionListener) {
        btnRegistration.addActionListener(actionListener);
    }

    public void btnEditActionListener(ActionListener actionListener) {
        btnEdit.addActionListener(actionListener);
    }

    public void btnSaveChangesActionListener(ActionListener actionListener) {
        btnSaveChanges.addActionListener(actionListener);
    }

    public void cbClientTypeActionListener(ActionListener actionListener) {
        cbClientType.addActionListener(actionListener);
    }

    public void addBtnExitActionListener(ActionListener actionListener) {
        btnExit.addActionListener(actionListener);
    }
}
