package communication;


import domain.*;

import java.net.Socket;
import java.util.List;

public class Communication {
    private final Sender sender;
    private final Receiver receiver;
    private static Communication instance;

    private Communication() throws Exception {
        Socket socket = new Socket("localhost", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Communication getInstance() throws Exception {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    // LOGIN
    public User login(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Request request = new Request(Operation.LOGIN, user);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (User) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // LOGOUT
    public boolean logout(User user) throws Exception {
        Request request = new Request(Operation.LOGOUT, user);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (boolean) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // SAVE PRODUCT
    public Product saveProduct(Product product) throws Exception {
        Request request = new Request(Operation.SAVE_PRODUCT, product);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Long index = (Long) response.getResult();
            product.setId(index);
            return product;
        } else {
            throw response.getException();
        }
    }

    // GET ALL PRODUCTS
    public List<Product> getAllProducts() throws Exception {
        Request request = new Request(Operation.GET_ALL_PRODUCTS, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Product>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // FIND PRODUCTS
    public List<Product> findProducts(Product product) throws Exception {
        Request request = new Request(Operation.FIND_PRODUCTS, product);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Product>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // EDIT PRODUCT
    public void editProduct(Product product) throws Exception {
        Request request = new Request(Operation.EDIT_PRODUCT, product);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    // DEACTIVATE PRODUCT
    public void deactivateProduct(Product product) throws Exception {
        Request request = new Request(Operation.DEACTIVATE_PRODUCT, product);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    // ACTIVATE PRODUCT
    public void activateProduct(Product product) throws Exception {
        Request request = new Request(Operation.ACTIVATE_PRODUCT, product);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    // REGISTER CLIENT
    public Client registerClient(Client client) throws Exception {
        Request request = new Request(Operation.REGISTER_CLIENT, client);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Long index = (Long) response.getResult();
            client.setId(index);
            return client;
        } else {
            throw response.getException();
        }
    }

    // GET ALL CLIENTS
    public List<Client> getAllClients() throws Exception {
        Request request = new Request(Operation.GET_ALL_CLIENTS, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Client>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // FIND CLIENTS
    public List<Client> findClients(Client client) throws Exception {
        Request request = new Request(Operation.FIND_CLIENTS, client);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Client>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // EDIT CLIENT
    public void editClient(Client client) throws Exception {
        Request request = new Request(Operation.EDIT_CLIENT, client);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    // CREATE LOAN APPLICATION
    public LoanApplication createLoanApplication(LoanApplication loanApplication) throws Exception {
        Request request = new Request(Operation.CREATE_LOAN_APPLICATION, loanApplication);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Long index = (Long) response.getResult();
            loanApplication.setId(index);
            return loanApplication;
        } else {
            throw response.getException();
        }
    }

    // GET ALL LOAN APPLICATIONS
    public List<LoanApplication> getAllLoanApplications() throws Exception {
        Request request = new Request(Operation.GET_ALL_LOAN_APPLICATIONS, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<LoanApplication>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // GET CREDIT BUREAU REPORT
    public CreditBureauReport getCreditBureauReport(CreditBureauReport creditBureauReport) throws Exception {
        Request request = new Request(Operation.GET_CREDIT_BUREAU_REPORT, creditBureauReport);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (CreditBureauReport) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // GET FRAUD REPORT
    public FraudReport getFraudReport(FraudReport fraudReport) throws Exception {
        Request request = new Request(Operation.GET_FRAUD_REPORT, fraudReport);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (FraudReport) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // PROCESS LOAN APPLICATION
    public void processLoanApplication(LoanApplication loanApplication) throws Exception {
        Request request = new Request(Operation.PROCESS_LOAN_APPLICATION, loanApplication);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    // FIND LOAN APPLICATIONS
    public List<LoanApplication> findLoanApplications(LoanApplication loanApplication) throws Exception {
        Request request = new Request(Operation.FIND_LOAN_APPLICATIONS, loanApplication);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<LoanApplication>) response.getResult();
        } else {
            throw response.getException();
        }
    }
}
