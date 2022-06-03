package view.controller;

import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import constants.Currency;
import constants.ProductStatus;
import domain.Product;
import view.constants.Constant;
import view.coordinator.MainCoordinator;
import view.form.AllProductsForm;
import view.form.component.table.ProductTableModel;
import view.form.util.FormMode;
import view.listeners.ChooseProductListener;
import view.listeners.RefreshTableListener;

public class AllProductsController implements RefreshTableListener {

    private final AllProductsForm allProductsForm;
    private ChooseProductListener listener = null;
    private final String CARD_NAME = "allProductsForm";
    private FormMode formMode;
    private List<Product> products;

    boolean currencySelected;
    boolean statusSelected;

    public AllProductsController(AllProductsForm allProductsForm) {
        this.allProductsForm = allProductsForm;
        addActionListeners();
    }

    public AllProductsController(AllProductsForm allProductsForm, ChooseProductListener listener) {
        this.allProductsForm = allProductsForm;
        this.listener = listener;
        addActionListeners();
    }

    private void addActionListeners() {

        allProductsForm.cBoxCurrencyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton absB = (AbstractButton) e.getSource();
                if (absB.getModel().isSelected()) {
                    allProductsForm.getCbCurrency().setEnabled(true);
                    currencySelected = true;
                } else {
                    allProductsForm.getCbCurrency().setEnabled(false);
                    allProductsForm.getCbCurrency().setSelectedIndex(0);
                    currencySelected = false;
                }
            }
        });

        allProductsForm.cBoxStatusActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton absB = (AbstractButton) e.getSource();
                if (absB.getModel().isSelected()) {
                    allProductsForm.getCbStatus().setEnabled(true);
                    statusSelected = true;
                } else {
                    allProductsForm.getCbStatus().setEnabled(false);
                    allProductsForm.getCbStatus().setSelectedIndex(0);
                    statusSelected = false;
                }
            }
        });

        allProductsForm.btnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Product p = new Product();
                    validateSearch();

                    p.setCurrency((Currency) allProductsForm.getCbCurrency().getSelectedItem());
                    p.setStatus((ProductStatus) allProductsForm.getCbStatus().getSelectedItem());
                    if (formMode.equals(FormMode.FORM_CHOOSE)) {
                        p.setStatus(ProductStatus.ACTIVE);
                    }
                    List<Product> wantedProducts = Communication.getInstance().findProducts(p);
                    ProductTableModel model = new ProductTableModel(wantedProducts);
                    allProductsForm.getTblProducts().setModel(model);
                    if (wantedProducts.isEmpty()) {
                        JOptionPane.showMessageDialog(allProductsForm, "No product matches given criteria!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(allProductsForm, "System has found products by given criteria!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(allProductsForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void validateSearch() throws Exception {
                String error = "";
                if (currencySelected) {
                    if (allProductsForm.getCbCurrency().getSelectedItem() == null) {
                        error += "Currency must be selected!\n";
                    }
                }
                if (statusSelected) {
                    if (allProductsForm.getCbStatus().getSelectedItem() == null) {
                        error += "Status must be selected!\n";
                    }
                }
                if (!error.isEmpty()) {
                    throw new Exception(error);
                }
            }
        });

        allProductsForm.btnDetailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = allProductsForm.getTblProducts().getSelectedRow();
                if (rowIndex >= 0) {
                    try {
                        Long id = (Long) allProductsForm.getTblProducts().getValueAt(rowIndex, 0);
                        for (Product p : products) {
                            if (p.getId() == id) {
                                MainCoordinator.getInstance().addParam(Constant.SELECTED_PRODUCT, p);
                                MainCoordinator.getInstance().openProductDetailsForm();
                                JOptionPane.showMessageDialog(allProductsForm, "System has loaded the product!", "Message", JOptionPane.INFORMATION_MESSAGE);

                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(AllProductsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(allProductsForm, "You must chose the product!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        allProductsForm.btnChooseProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = allProductsForm.getTblProducts().getSelectedRow();
                if (rowIndex >= 0) {
                    ProductTableModel model = (ProductTableModel) allProductsForm.getTblProducts().getModel();
                    Product p = model.getProduct(rowIndex);
                    if (listener != null) {
                        listener.productChose(p);
                    }
                    MainCoordinator.getInstance().getMainController().getMainForm().removeCard(allProductsForm, CARD_NAME + formMode);
                    JOptionPane.showMessageDialog(allProductsForm, "System had added the product to the loan application!", "Message", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(allProductsForm, "You must chose the product!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        allProductsForm.addBtnExitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().getMainController().getMainForm().removeCard(allProductsForm, CARD_NAME + formMode);
            }
        });
    }

    public void openForm(FormMode formMode) {
        this.formMode = formMode;
        MainCoordinator.getInstance().getMainController().getMainForm().addCard(allProductsForm, CARD_NAME + this.formMode);
        prepareView(formMode);
    }

    private void prepareView(FormMode formMode) {
        fillCbCurrency();
        fillCbStatus();
        setupComponents(formMode);
    }

    private void fillCbCurrency() {
        allProductsForm.getCbCurrency().removeAllItems();
        allProductsForm.getCbCurrency().setEnabled(false);
        allProductsForm.getCbCurrency().insertItemAt(null, 0);
        for (Currency c : Currency.values()) {
            allProductsForm.getCbCurrency().addItem(c);
        }
    }

    private void fillCbStatus() {
        allProductsForm.getCbStatus().removeAllItems();
        allProductsForm.getCbStatus().setEnabled(false);
        allProductsForm.getCbStatus().insertItemAt(null, 0);
        for (ProductStatus ps : ProductStatus.values()) {
            allProductsForm.getCbStatus().addItem(ps);
        }
    }

    private void setupComponents(FormMode formMode) {
        switch (formMode) {
            case FORM_VIEW:
                allProductsForm.getBtnDetails().setEnabled(true);
                allProductsForm.getBtnChooseProduct().setEnabled(false);
                fillTblProducts();
                break;
            case FORM_CHOOSE:
                allProductsForm.getCBoxStatus().setEnabled(false);
                allProductsForm.getBtnDetails().setEnabled(false);
                allProductsForm.getBtnChooseProduct().setEnabled(true);
                fillTblProductsActive();
                break;
        }
    }

    private void fillTblProducts() {
        try {
            products = Communication.getInstance().getAllProducts();
            ProductTableModel model = new ProductTableModel(products);
            allProductsForm.getTblProducts().setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(allProductsForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillTblProductsActive() {
        try {
            products = Communication.getInstance().getAllProducts();
            List<Product> activeProducts = new ArrayList<>();
            for (Product p : products) {
                if (p.getStatus().equals(ProductStatus.ACTIVE)) {
                    activeProducts.add(p);
                }
            }
            ProductTableModel model = new ProductTableModel(activeProducts);
            allProductsForm.getTblProducts().setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(allProductsForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void refreshTable() {
        fillTblProducts();
    }

}
