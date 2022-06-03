package view.form.component.table;

import domain.Document;
import domain.DocumentTemplate;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DocumentTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Title", "Required", "Upload"};
    private final List<Document> documents;

    public DocumentTableModel(List<DocumentTemplate> documentTemplates) {
        documents = new ArrayList<>();
        for (DocumentTemplate dt : documentTemplates) {
            Document d = new Document();
            d.setId(dt.getId());
            d.setTitle(dt.getTitle());
            d.setRequired(dt.isRequired());
            d.setForSigning(dt.isForSigning());
            d.setType(dt.getType());
            documents.add(d);

        }
    }

    public DocumentTableModel() {
        documents = new ArrayList<>();
    }

    public DocumentTableModel(List<Document> documents, int something) {
        this.documents = documents;
    }

    @Override
    public int getRowCount() {
        if (documents == null) {
            return 0;
        }
        return documents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Document d = documents.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getTitle();
            case 2:
                return d.isRequired();
            case 3:
                return d.getFileName();
            default:
                return "n/a";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Long.class;
            case 1:
                return String.class;
            case 2:
                return Boolean.class;
            case 3:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    public void addDocument(Document d) {
        documents.add(d);
        fireTableRowsInserted(documents.size() - 1, documents.size() - 1);
    }

    public void deleteDocument(int rowIndex) {
        documents.remove(rowIndex);
        fireTableRowsDeleted(documents.size() - 1, documents.size() - 1);
    }

    public List<Document> getAllDocuments() {
        return documents;
    }

    public Document getDocument(int rowIndex) {
        return documents.get(rowIndex);
    }

    public void refreshTable() {
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }
}
