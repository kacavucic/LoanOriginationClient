package view.form.component.table;


import domain.Client;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ClientTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "First name", "Last name", "JMBG",
            "Birth date", "Contact phone", "Address", "E-mail address", "Marital status", "Client type"};

    private final List<Client> clients;

    public ClientTableModel(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int getRowCount() {
        if (clients == null) {
            return 0;
        }
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client c = clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getFirstName();
            case 2:
                return c.getLastName();
            case 3:
                return c.getJMBG();
            case 4:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                return sdf.format(c.getBirthDate());
            case 5:
                return c.getContactPhone();
            case 6:
                return c.getAddress();
            case 7:
                return c.getEmail();
            case 8:
                return c.getMaritalStatus();
            case 9:
                return c.getType();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    public Client getClient(int rowIndex) {
        return clients.get(rowIndex);
    }

}
