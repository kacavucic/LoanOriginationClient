package view.controller;

import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

import constants.Currency;
import constants.DocumentType;
import constants.ProductStatus;
import domain.DocumentTemplate;
import domain.Product;
import view.constants.Constant;
import view.coordinator.MainCoordinator;
import view.form.ProductForm;
import view.form.component.table.DocumentTemplateTableModel;
import view.form.util.FormMode;
import view.listeners.RefreshTableListener;

public class ProductController {

    private final ProductForm productForm;
    private final String CARD_NAME = "productForm";
    private FormMode formMode;
    private RefreshTableListener refreshTableListener;

    public ProductController(ProductForm productForm) {
        this.productForm = productForm;
        addActionListeners();
    }

    public ProductController(ProductForm productForm, RefreshTableListener refreshTableListener) {
        this.productForm = productForm;
        this.refreshTableListener = refreshTableListener;
        addActionListeners();

    }

    private void addActionListeners() {
        productForm.btnAddDocumentTemplateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateDocumentTemplate();
                    DocumentTemplateTableModel model = (DocumentTemplateTableModel) productForm.getTblDocuments().getModel();
                    DocumentTemplate documentTemplate = makeDocumentTemplateFromForm();
                    int numberOfDocumentTemplatesCurrent = model.getAllDocumentTemplates().size();
                    documentTemplate.setId(numberOfDocumentTemplatesCurrent + 1);
                    model.addDocumentTemplate(documentTemplate);
                    clearDocumentTemplateInput();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(productForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        productForm.btnDeleteDocumentTemplateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = productForm.getTblDocuments().getSelectedRow();
                if (rowIndex >= 0) {
                    DocumentTemplateTableModel model = (DocumentTemplateTableModel) productForm.getTblDocuments().getModel();
                    List<DocumentTemplate> documentTemplates = model.getAllDocumentTemplates();
                    model.deleteDocumentTemplate(rowIndex);
                    updateID(documentTemplates, rowIndex);
                } else {
                    JOptionPane.showMessageDialog(productForm, "You must select document template for deleting!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void updateID(List<DocumentTemplate> documentTemplates, int rowIndex) {
                for (int i = rowIndex; i < documentTemplates.size(); i++) {
                    documentTemplates.get(i).setId(documentTemplates.get(i).getId() - 1);
                }
            }
        });

        productForm.btnSaveProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateProduct();
                    Product p = makeProductFromForm();
                    DocumentTemplateTableModel model = (DocumentTemplateTableModel) productForm.getTblDocuments().getModel();
                    List<DocumentTemplate> documentTemplates = model.getAllDocumentTemplates();
                    for (DocumentTemplate dt : documentTemplates) {
                        dt.setProduct(p);
                    }
                    p.setDocumentTemplates(documentTemplates);
                    Product savedProduct = Communication.getInstance().saveProduct(p);
                    JOptionPane.showMessageDialog(productForm, "System has saved product with ID: " + savedProduct.getId() + "!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    resetForm();
                    if (refreshTableListener != null) {
                        refreshTableListener.refreshTable();
                    }
                    MainCoordinator.getInstance().addParam(Constant.SELECTED_PRODUCT, savedProduct);
                    MainCoordinator.getInstance().openProductDetailsForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(productForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void resetForm() {
                productForm.getTxtID().setText("");
                productForm.getTxtProductName().setText("");
                productForm.getTxtDescription().setText("");
                productForm.getCbStatus().setSelectedItem(null);
                productForm.getCbCurrency().setSelectedItem(null);
                productForm.getTxtMinAmount().setValue(null);
                productForm.getTxtMaxAmount().setValue(null);
                productForm.getTxtInterestRate().setValue(null);

                DocumentTemplateTableModel model = new DocumentTemplateTableModel();
                productForm.getTblDocuments().setModel(model);
            }
        });

        productForm.btnEditProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupComponents(FormMode.FORM_EDIT);
            }
        });

        productForm.btnEditDocumentTemplateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productForm.getBtnEditDocumentTemplate().setEnabled(false);
                int rowIndex = productForm.getTblDocuments().getSelectedRow();
                if (rowIndex >= 0) {
                    DocumentTemplateTableModel model = (DocumentTemplateTableModel) productForm.getTblDocuments().getModel();
                    DocumentTemplate documentTemplate = model.getDocumentTemplate(rowIndex);
                    MainCoordinator.getInstance().addParam(Constant.SELECTED_DOCUMENT, documentTemplate);
                    setSelectedDocumentTemplate(documentTemplate);
                    enableChangesDocumentTemplate();
                    productForm.getBtnSaveChangesDocumentTemplate().setEnabled(true);
                } else {
                    productForm.getBtnEditDocumentTemplate().setEnabled(true);
                    JOptionPane.showMessageDialog(productForm, "You must select document template for editing!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        productForm.btnSaveChangesDocumentTemplateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DocumentTemplate dt = (DocumentTemplate) MainCoordinator.getInstance().getParam(Constant.SELECTED_DOCUMENT);
                    validateDocumentTemplate();
                    dt = makeDocumentTemplateFromForm(dt);
                    DocumentTemplateTableModel model = (DocumentTemplateTableModel) productForm.getTblDocuments().getModel();
                    model.refreshTable();
                    JOptionPane.showMessageDialog(productForm, "Document template successfully edited!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    resetPnlDocumentTemplate();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(productForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void resetPnlDocumentTemplate() {
                clearDocumentTemplateInput();
                disableChangesDocumentTemplate();
                productForm.getBtnSaveChangesDocumentTemplate().setEnabled(false);
                productForm.getBtnEditDocumentTemplate().setEnabled(true);
            }
        });

        productForm.btnSaveChangesProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Product p = (Product) MainCoordinator.getInstance().getParam(Constant.SELECTED_PRODUCT);
                    validateProduct();
                    p = makeProductFromForm(p);
                    int response = JOptionPane.showConfirmDialog(productForm,
                            "Are you sure you want to edit product with ID: "
                                    + p.getId() + "?");
                    if (response == JOptionPane.YES_OPTION) {
                        Communication.getInstance().editProduct(p);
                        if (refreshTableListener != null) {
                            refreshTableListener.refreshTable();
                        }
                        setupComponents(FormMode.FORM_VIEW);
                        JOptionPane.showMessageDialog(productForm, "Product successfully edited!", "Message", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(productForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        productForm.btnDeactivateProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Product p = (Product) MainCoordinator.getInstance().getParam(Constant.SELECTED_PRODUCT);
                    int response = JOptionPane.showConfirmDialog(productForm,
                            "Are you sure you want to activate product with ID: "
                                    + p.getId() + "?");
                    if (response == JOptionPane.YES_OPTION) {
                        p.setStatus(ProductStatus.INACTIVE);
                        Communication.getInstance().deactivateProduct(p);
                        JOptionPane.showMessageDialog(productForm, "Product successfully deactivated!", "Message", JOptionPane.INFORMATION_MESSAGE);
                        setupComponents(FormMode.FORM_VIEW);
                        if (refreshTableListener != null) {
                            refreshTableListener.refreshTable();
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(productForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        productForm.btnActivateProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Product p = (Product) MainCoordinator.getInstance().getParam(Constant.SELECTED_PRODUCT);
                    int response = JOptionPane.showConfirmDialog(productForm,
                            "Are you sure you want to activate product with ID: "
                                    + p.getId() + "?");
                    if (response == JOptionPane.YES_OPTION) {
                        p.setStatus(ProductStatus.ACTIVE);
                        Communication.getInstance().activateProduct(p);
                        JOptionPane.showMessageDialog(productForm, "Product successfully activated!", "Message", JOptionPane.INFORMATION_MESSAGE);
                        setupComponents(FormMode.FORM_VIEW);
                        if (refreshTableListener != null) {
                            refreshTableListener.refreshTable();
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(productForm, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        productForm.addBtnExitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().getMainController().getMainForm().removeCard(productForm, CARD_NAME + formMode);
            }
        });

    }

    public void openForm(FormMode formMode) {
        this.formMode = formMode;
        MainCoordinator.getInstance().getMainController().getMainForm().addCard(productForm, CARD_NAME + this.formMode);
        prepareView(formMode);
    }

    private void prepareView(FormMode formMode) {
        productForm.getTxtID().setEnabled(false);
        fillStatus();
        fillCbCurrency();
        fillCbType();
        fillTblDocuments();
        setupComponents(formMode);
    }

    private void fillStatus() {
        productForm.getCbStatus().removeAllItems();
        productForm.getCbStatus().insertItemAt(null, 0);
        for (ProductStatus ps : ProductStatus.values()) {
            productForm.getCbStatus().addItem(ps);
        }
    }

    private void fillCbCurrency() {
        productForm.getCbCurrency().removeAllItems();
        productForm.getCbCurrency().insertItemAt(null, 0);
        for (Currency c : Currency.values()) {
            productForm.getCbCurrency().addItem(c);
        }
    }

    private void fillCbType() {
        productForm.getCbDocumentType().removeAllItems();
        productForm.getCbDocumentType().insertItemAt(null, 0);
        for (DocumentType dt : DocumentType.values()) {
            productForm.getCbDocumentType().addItem(dt);
        }
    }

    private void fillTblDocuments() {
        DocumentTemplateTableModel model = new DocumentTemplateTableModel();
        productForm.getTblDocuments().setModel(model);
    }

    private void setupComponents(FormMode formMode) {
        switch (formMode) {
            case FORM_CREATE:
                productForm.getBtnSaveProduct().setEnabled(true);
                productForm.getBtnEditProduct().setEnabled(false);
                productForm.getBtnSaveChangesProduct().setEnabled(false);
                productForm.getBtnDeactivateProduct().setEnabled(false);
                productForm.getBtnActivateProduct().setEnabled(false);
                enableChangesProduct();

                productForm.getBtnAddDocumentTemplate().setEnabled(true);
                productForm.getBtnDeleteDocumentTemplate().setEnabled(true);
                productForm.getBtnEditDocumentTemplate().setEnabled(false);
                productForm.getBtnSaveChangesDocumentTemplate().setEnabled(false);
                enableChangesDocumentTemplate();
                break;
            case FORM_VIEW:
                productForm.getBtnSaveProduct().setEnabled(false);
                productForm.getBtnEditProduct().setEnabled(true);
                productForm.getBtnSaveChangesProduct().setEnabled(false);
                productForm.getBtnDeactivateProduct().setEnabled(false);
                productForm.getBtnActivateProduct().setEnabled(false);

                setSelectedProduct();
                disableChangesProduct();

                productForm.getBtnAddDocumentTemplate().setEnabled(false);
                productForm.getBtnDeleteDocumentTemplate().setEnabled(false);
                productForm.getBtnEditDocumentTemplate().setEnabled(false);
                productForm.getBtnSaveChangesDocumentTemplate().setEnabled(false);
                disableChangesDocumentTemplate();
                break;
            case FORM_EDIT:
                productForm.getBtnSaveProduct().setEnabled(false);
                productForm.getBtnEditProduct().setEnabled(false);
                productForm.getBtnSaveChangesProduct().setEnabled(true);

                Product p = (Product) MainCoordinator.getInstance().getParam(Constant.SELECTED_PRODUCT);
                if (p.getStatus().equals(ProductStatus.INACTIVE)) {
                    productForm.getBtnDeactivateProduct().setEnabled(false);
                    productForm.getBtnActivateProduct().setEnabled(true);
                } else {
                    productForm.getBtnDeactivateProduct().setEnabled(true);
                    productForm.getBtnActivateProduct().setEnabled(false);
                }

                setSelectedProduct();
                enableChangesProduct();

                productForm.getCbStatus().setEnabled(false);

                productForm.getBtnAddDocumentTemplate().setEnabled(false);
                productForm.getBtnDeleteDocumentTemplate().setEnabled(false);
                productForm.getBtnEditDocumentTemplate().setEnabled(true);
                productForm.getBtnSaveChangesDocumentTemplate().setEnabled(false);
                disableChangesDocumentTemplate();
                break;
        }
    }

    private void validateProduct() throws Exception {
        String name = productForm.getTxtProductName().getText().trim();
        double minAmount = 0;
        double maAmount = 0;
        boolean minOK = false;
        boolean maxOK = false;
        String error = "";

        if (name.isEmpty()) {
            error += "Name must be entered!\n";
        }

        if (productForm.getCbCurrency().getSelectedItem() == null) {
            error += "Currency must be selected!\n";
        }

        if (productForm.getCbStatus().getSelectedItem() == null) {
            error += "Status must be selected!\n";
        }

        if (String.valueOf(productForm.getTxtMinAmount().getText().trim()).isEmpty()) {
            error += "Minimal amount must be entered!\n";
        } else {
            minAmount = ((Number) productForm.getTxtMinAmount().getValue()).doubleValue();
            minOK = true;
            if (minAmount <= 0) {
                error += "Minimal amount can not be zero or negative!\n";
            }
        }

        if (String.valueOf(productForm.getTxtMaxAmount().getText().trim()).isEmpty()) {
            error += "Maximal amount must be entered!\n";
        } else {
            maAmount = ((Number) productForm.getTxtMaxAmount().getValue()).doubleValue();
            maxOK = true;
            if (maAmount <= 0) {
                error += "Maximal amount can not be zero or negative!\n";
            }
        }

        if (minOK && maxOK && (minAmount >= maAmount)) {
            error += "Maximal amount must be greater than minimal amount!\n";
        }

        if (String.valueOf(productForm.getTxtInterestRate().getText().trim()).isEmpty()) {
            error += "Interest rate must be entered!\n";
        } else {
            double interestRate = ((Number) productForm.getTxtInterestRate().getValue()).doubleValue();
            if (interestRate <= 0) {
                error += "Interest rate can not be zero or negative!\n";
            }
        }

        DocumentTemplateTableModel model = (DocumentTemplateTableModel) productForm.getTblDocuments().getModel();
        List<DocumentTemplate> documentTemplates = model.getAllDocumentTemplates();
        if (documentTemplates.isEmpty()) {
            error += "Product must contain at least one document template!\n";
        }

        if (!error.isEmpty()) {
            throw new Exception(error);
        }
    }

    private void validateDocumentTemplate() throws Exception {
        String error = "";

        if (productForm.getTxtDocumentTitle().getText().trim().isEmpty()) {
            error += "Document title must be entered!\n";
        }

        if (productForm.getBtnGroupRequired().getSelection() == null) {
            error += "Requirement of the document must be selected!\n";
        }

        if (productForm.getBtnGroupForSigning().getSelection() == null) {
            error += "Signing of the document must be selected!\n";
        }

        if (productForm.getCbDocumentType().getSelectedItem() == null) {
            error += "Document type must be selected!\n";
        }

        if (!error.isEmpty()) {
            throw new Exception(error);
        }
    }

    private Product makeProductFromForm() {
        return makeProductFromForm(new Product());
    }

    private Product makeProductFromForm(Product p) {
        p.setName(productForm.getTxtProductName().getText().trim());
        p.setDescription(productForm.getTxtDescription().getText().trim());
        p.setCurrency((Currency) productForm.getCbCurrency().getSelectedItem());
        p.setMinAmount((((Number) productForm.getTxtMinAmount().getValue()).doubleValue()));
        p.setMaxAmount((((Number) productForm.getTxtMaxAmount().getValue()).doubleValue()));
        p.setInterestRate((((Number) productForm.getTxtInterestRate().getValue()).doubleValue()));
        p.setStatus((ProductStatus) productForm.getCbStatus().getSelectedItem());
        return p;
    }

    private DocumentTemplate makeDocumentTemplateFromForm() {
        return makeDocumentTemplateFromForm(new DocumentTemplate());
    }

    private DocumentTemplate makeDocumentTemplateFromForm(DocumentTemplate dt) {
        dt.setTitle(productForm.getTxtDocumentTitle().getText().trim());
        dt.setType((DocumentType) productForm.getCbDocumentType().getSelectedItem());

        if (productForm.getRbYesRequired().isSelected()) {
            dt.setRequired(true);
        } else if (productForm.getRbNoRequired().isSelected()) {
            dt.setRequired(false);
        }

        if (productForm.getRbYesForSigning().isSelected()) {
            dt.setForSigning(true);
        } else if (productForm.getRbNoForSigning().isSelected()) {
            dt.setForSigning(false);
        }

        return dt;
    }

    private void setSelectedProduct() {
        Product p = (Product) MainCoordinator.getInstance().getParam(Constant.SELECTED_PRODUCT);
        productForm.getTxtID().setText(String.valueOf(p.getId()));
        productForm.getTxtProductName().setText(p.getName());
        productForm.getTxtDescription().setText(p.getDescription());
        productForm.getCbStatus().setSelectedItem(ProductStatus.getByName(p.getStatus().getName()));
        productForm.getCbCurrency().setSelectedItem(Currency.getByName(p.getCurrency().getName()));
        productForm.getTxtMinAmount().setValue(p.getMinAmount());
        productForm.getTxtMaxAmount().setValue(p.getMaxAmount());
        productForm.getTxtInterestRate().setValue(p.getInterestRate());

        List<DocumentTemplate> documentTemplates = p.getDocumentTemplates();
        DocumentTemplateTableModel model = new DocumentTemplateTableModel(documentTemplates);
        productForm.getTblDocuments().setModel(model);
    }

    private void setSelectedDocumentTemplate(DocumentTemplate documentTemplate) {
        productForm.getTxtDocumentTitle().setText(documentTemplate.getTitle());
        productForm.getCbDocumentType().setSelectedItem(DocumentType.getByName(documentTemplate.getType().getName()));

        if (documentTemplate.isRequired()) {
            productForm.getRbYesRequired().setSelected(true);
        } else {
            productForm.getRbNoRequired().setSelected(true);
        }

        if (documentTemplate.isForSigning()) {
            productForm.getRbYesForSigning().setSelected(true);
        } else {
            productForm.getRbNoForSigning().setSelected(true);
        }
    }

    private void disableChangesProduct() {
        productForm.getTxtProductName().setEnabled(false);
        productForm.getTxtDescription().setEnabled(false);
        productForm.getCbStatus().setEnabled(false);
        productForm.getCbCurrency().setEnabled(false);
        productForm.getTxtMinAmount().setEnabled(false);
        productForm.getTxtMaxAmount().setEnabled(false);
        productForm.getTxtInterestRate().setEnabled(false);
    }

    private void enableChangesProduct() {
        productForm.getTxtProductName().setEnabled(true);
        productForm.getTxtDescription().setEnabled(true);
        productForm.getCbStatus().setEnabled(true);
        productForm.getCbCurrency().setEnabled(true);
        productForm.getTxtMinAmount().setEnabled(true);
        productForm.getTxtMaxAmount().setEnabled(true);
        productForm.getTxtInterestRate().setEnabled(true);
    }

    private void disableChangesDocumentTemplate() {
        productForm.getTxtDocumentTitle().setEnabled(false);
        productForm.getCbDocumentType().setEnabled(false);
        productForm.getRbYesRequired().setEnabled(false);
        productForm.getRbNoRequired().setEnabled(false);
        productForm.getRbYesForSigning().setEnabled(false);
        productForm.getRbNoForSigning().setEnabled(false);
    }

    private void enableChangesDocumentTemplate() {
        productForm.getTxtDocumentTitle().setEnabled(true);
        productForm.getCbDocumentType().setEnabled(true);
        productForm.getRbYesRequired().setEnabled(true);
        productForm.getRbNoRequired().setEnabled(true);
        productForm.getRbYesForSigning().setEnabled(true);
        productForm.getRbNoForSigning().setEnabled(true);
    }

    private void clearDocumentTemplateInput() {
        productForm.getTxtDocumentTitle().setText("");
        productForm.getCbDocumentType().setSelectedIndex(0);
        productForm.getBtnGroupRequired().clearSelection();
        productForm.getBtnGroupForSigning().clearSelection();
    }

}
