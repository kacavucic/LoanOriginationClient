package view.coordinator;

import java.util.HashMap;
import java.util.Map;

import view.controller.*;
import view.form.*;
import view.form.util.FormMode;

public class MainCoordinator {

    private static MainCoordinator instance;
    private final MainController mainController;

    private AllProductsController allProductsListener;
    private AllClientsController allClientsListener;
    private AllLoanApplicationsController allLoanApplicationsListener;

    private LoanApplicationController loanApplicationListener;

    // this can be in some other Singleton class
    private final Map<String, Object> params;

    private MainCoordinator() {
        mainController = new MainController(new MainForm());
        params = new HashMap<>();
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }

    public void addParam(String name, Object key) {
        params.put(name, key);
    }

    public Object getParam(String name) {
        return params.get(name);
    }

    // LOGIN FORM
    public void openLoginForm() {
        LoginController loginController = new LoginController(new LoginForm());
        loginController.openForm();
    }

    // MAIN FORM
    public void openMainForm() {
        mainController.openForm();
    }

    public MainController getMainController() {
        return mainController;
    }

    // CREATE
    public void openCreateProductForm() {
        ProductController productController = new ProductController(new ProductForm(), allProductsListener);
        productController.openForm(FormMode.FORM_CREATE);
    }

    public void openCreateClientForm() {
        ClientController clientController = new ClientController(new ClientForm(), allClientsListener);
        clientController.openForm(FormMode.FORM_CREATE);
    }

    public void openCreateLoanApplicationForm() {
        LoanApplicationController loanApplicationController = new LoanApplicationController(new LoanApplicationForm(), allLoanApplicationsListener);
        loanApplicationListener = loanApplicationController;
        loanApplicationController.openForm(FormMode.FORM_CREATE);
    }

    // VIEW
    public void openAllProductsForm() {
        AllProductsController allProductsController
                = new AllProductsController(new AllProductsForm());
        allProductsListener = allProductsController;
        allProductsController.openForm(FormMode.FORM_VIEW);
    }

    public void openAllClientsForm() {
        AllClientsController allClientsController
                = new AllClientsController(new AllClientsForm());
        allClientsListener = allClientsController;
        allClientsController.openForm(FormMode.FORM_VIEW);
    }

    public void openAllLoanApplicationsForm() {
        AllLoanApplicationsController allLoanApplicationsController
                = new AllLoanApplicationsController(new AllLoanApplicationsForm());
        allLoanApplicationsListener = allLoanApplicationsController;
        allLoanApplicationsController.openForm();
    }

    // CHOOSE
    public void openChooseProductForm() {
        AllProductsController allProductsController
                = new AllProductsController(new AllProductsForm(), loanApplicationListener);
        allProductsController.openForm(FormMode.FORM_CHOOSE);
    }

    public void openChooseClientForm() {
        AllClientsController allClientsController
                = new AllClientsController(new AllClientsForm(), loanApplicationListener);
        allClientsController.openForm(FormMode.FORM_CHOOSE);
    }

    // PROCESS LOAN APPLICATION
    public void openProcessLoanApplicationForm() {
        LoanApplicationController loanApplicationController = new LoanApplicationController(new LoanApplicationForm(), allLoanApplicationsListener);
        loanApplicationController.openForm(FormMode.FORM_PROCESS);
    }

    // DETAILS
    public void openProductDetailsForm() {
        ProductForm productDetails = new ProductForm();
        ProductController productController = new ProductController(productDetails, allProductsListener);
        productController.openForm(FormMode.FORM_VIEW);
    }

    public void openClientDetailsForm() {
        ClientForm clientDetails = new ClientForm();
        ClientController clientController = new ClientController(clientDetails, allClientsListener);
        clientController.openForm(FormMode.FORM_VIEW);
    }

    public void openLoanApplicationDetailsForm() {
        LoanApplicationForm loanApplicationForm = new LoanApplicationForm();
        LoanApplicationController loanApplicationController = new LoanApplicationController(loanApplicationForm, allLoanApplicationsListener);
        loanApplicationController.openForm(FormMode.FORM_VIEW);
    }
}
