package view.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class MainForm extends javax.swing.JFrame {


    private HashMap<String, JPanel> cardNames;

    public MainForm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPanel.setVisible(true);
        cardNames = new HashMap<>();
        /*
        BufferedImage pic;
        try {
            pic = ImageIO.read(new File("./loan.jpg"));
            JLabel icon = new JLabel(new ImageIcon(pic));
            mainPanel.add(icon);
        } catch (IOException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblLoggedInUser = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuProduct = new javax.swing.JMenu();
        jmiAddNewProduct = new javax.swing.JMenuItem();
        jmiShowAllProducts = new javax.swing.JMenuItem();
        jMenuClient = new javax.swing.JMenu();
        jmiRegisterNewClient = new javax.swing.JMenuItem();
        jmiShowAllClients = new javax.swing.JMenuItem();
        jMenuLoanApplication = new javax.swing.JMenu();
        jmiCreateLoanApplication = new javax.swing.JMenuItem();
        jmiShowAllLoanApplications = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLoggedInUser.setText("");

        btnLogout.setText("Log out");

        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 4, true));
        mainPanel.setLayout(new java.awt.CardLayout());
        jScrollPane.setViewportView(mainPanel);

        jMenuProduct.setText("Product");

        jmiAddNewProduct.setText("Add new");
        jMenuProduct.add(jmiAddNewProduct);

        jmiShowAllProducts.setText("Show all");
        jMenuProduct.add(jmiShowAllProducts);

        jMenuBarMain.add(jMenuProduct);

        jMenuClient.setText("Client");

        jmiRegisterNewClient.setText("Register new");
        jMenuClient.add(jmiRegisterNewClient);

        jmiShowAllClients.setText("Show all");
        jMenuClient.add(jmiShowAllClients);

        jMenuBarMain.add(jMenuClient);

        jMenuLoanApplication.setText("Kreditni zahtev");

        jmiCreateLoanApplication.setText("Create");
        jMenuLoanApplication.add(jmiCreateLoanApplication);

        jmiShowAllLoanApplications.setText("Show all");
        jMenuLoanApplication.add(jmiShowAllLoanApplications);

        jMenuBarMain.add(jMenuLoanApplication);

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblLoggedInUser)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 664, Short.MAX_VALUE)
                                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLoggedInUser)
                                        .addComponent(btnLogout))
                                .addContainerGap())
        );

        pack();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JButton btnLogout;
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenu jMenuClient;
    private javax.swing.JMenu jMenuLoanApplication;
    private javax.swing.JMenu jMenuProduct;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JMenuItem jmiAddNewProduct;
    private javax.swing.JMenuItem jmiCreateLoanApplication;
    private javax.swing.JMenuItem jmiShowAllClients;
    private javax.swing.JMenuItem jmiShowAllLoanApplications;
    private javax.swing.JMenuItem jmiShowAllProducts;
    private javax.swing.JMenuItem jmiRegisterNewClient;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public JLabel getLblLoggedInUser() {
        return lblLoggedInUser;
    }

    public void setLblLoggedInUser(JLabel lblLoggedInUser) {
        this.lblLoggedInUser = lblLoggedInUser;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public void setBtnLogout(JButton btnLogout) {
        this.btnLogout = btnLogout;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public void jmiAddNewProductActionListener(ActionListener actionListener) {
        jmiAddNewProduct.addActionListener(actionListener);
    }

    public void jmiShowAllProductsActionListener(ActionListener actionListener) {
        jmiShowAllProducts.addActionListener(actionListener);
    }

    public void jmiRegisterNewClientActionListener(ActionListener actionListener) {
        jmiRegisterNewClient.addActionListener(actionListener);
    }

    public void jmiShowAllClientsActionListener(ActionListener actionListener) {
        jmiShowAllClients.addActionListener(actionListener);
    }

    public void jmiCreateLoanApplicationActionListener(ActionListener actionListener) {
        jmiCreateLoanApplication.addActionListener(actionListener);
    }

    public void jmiShowAllLoanApplicationsActionListener(ActionListener actionListener) {
        jmiShowAllLoanApplications.addActionListener(actionListener);
    }


    public void btnLogoutActionListener(ActionListener actionListener) {
        btnLogout.addActionListener(actionListener);
    }

    // Main panel handlers
    public void addCard(JPanel card, String cardName) {
        removeCard(card, cardName);
        cardNames.put(cardName, card);
        mainPanel.add(card, cardName);
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, cardName);
        mainPanel.revalidate();
        mainPanel.repaint();

        jScrollPane.getViewport().setViewPosition(new Point(0, 0));
    }

    public void removeCard(JPanel card, String cardName) {
        if (cardNames.containsKey(cardName)) {
            cardNames.remove(cardName);
            mainPanel.remove(card);
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.last(mainPanel);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
        if (cardNames.isEmpty()) {
            mainPanel.removeAll();
            mainPanel.revalidate();
            mainPanel.repaint();
        }
        jScrollPane.getViewport().setViewPosition(new Point(0, 0));

    }

}
