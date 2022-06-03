package view.form.component.table;

import domain.LoanApplication;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LoanApplicationTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Client", "Product", "Creation date",
            "Amount", "Repayment period", "Annuity", "Status"};

    private final List<LoanApplication> loanApplications;

    public LoanApplicationTableModel(List<LoanApplication> loanApplications) {
        this.loanApplications = loanApplications;
    }

    @Override
    public int getRowCount() {
        if (loanApplications == null) {
            return 0;
        }
        return loanApplications.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LoanApplication la = loanApplications.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return la.getId();
            case 1:
                return la.getClient().getFirstName() + " " + la.getClient().getLastName()
                        + " (" + la.getClient().getJMBG() + ")";
            case 2:
                return la.getProduct();
            case 3:
                return la.getCreationDate();
            case 4:
                return la.getAmount();
            case 5:
                return la.getRepaymentPeriod();
            case 6:
                return la.getAnnuity();
            case 7:
                return la.getStatus();
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

    public LoanApplication getAllLoanApplications(int rowIndex) {
        return loanApplications.get(rowIndex);
    }

    public LoanApplication getLoanApplication(int rowIndex) {
        return loanApplications.get(rowIndex);
    }
}
