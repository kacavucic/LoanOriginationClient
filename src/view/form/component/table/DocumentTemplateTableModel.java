package view.form.component.table;

import domain.DocumentTemplate;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DocumentTemplateTableModel extends AbstractTableModel {

    private final String[] columnNames = {"No.", "Title", "Type", "Required", "For signing"};
    private final List<DocumentTemplate> documentTemplates;

    public DocumentTemplateTableModel() {
        documentTemplates = new ArrayList<>();
    }

    public DocumentTemplateTableModel(List<DocumentTemplate> documentTemplates) {
        this.documentTemplates = documentTemplates;
    }

    @Override
    public int getRowCount() {
        if (documentTemplates == null) {
            return 0;
        }
        return documentTemplates.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DocumentTemplate dt = documentTemplates.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dt.getId();
            case 1:
                return dt.getTitle();
            case 2:
                return dt.getType();
            case 3:
                return dt.isRequired();
            case 4:
                return dt.isForSigning();
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
                return Boolean.class;
            case 4:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    public void addDocumentTemplate(DocumentTemplate dt) {
        documentTemplates.add(dt);
        fireTableRowsInserted(documentTemplates.size() - 1, documentTemplates.size() - 1);
    }

    public void deleteDocumentTemplate(int rowIndex) {
        documentTemplates.remove(rowIndex);
        fireTableRowsDeleted(documentTemplates.size() - 1, documentTemplates.size() - 1);
    }

    public List<DocumentTemplate> getAllDocumentTemplates() {
        return documentTemplates;
    }

    public DocumentTemplate getDocumentTemplate(int rowIndex) {
        return documentTemplates.get(rowIndex);
    }

    public void refreshTable() {
        fireTableDataChanged();
    }

}
