package view.form.component.table;

import domain.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Name", "Description", "Currency",
            "Minimal amount", "Maximal amount", "Interest rate", "Status"};

    private final List<Product> products;

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        if (products == null) {
            return 0;
        }
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product p = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getName();
            case 2:
                return p.getDescription();
            case 3:
                return p.getCurrency();
            case 4:
                return p.getMinAmount();
            case 5:
                return p.getMaxAmount();
            case 6:
                return p.getInterestRate();
            case 7:
                return p.getStatus();
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

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Long.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Double.class;
            case 5:
                return Double.class;
            case 6:
                return Double.class;
            case 7:
                return String.class;
            default:
                return String.class;
        }
    }

    public Product getProduct(int rowIndex) {
        return products.get(rowIndex);
    }

}
