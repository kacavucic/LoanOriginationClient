package view.form.util;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;

import domain.Document;
import view.form.component.table.DocumentTableModel;

public class FileChooserCellEditor extends DefaultCellEditor implements TableCellEditor {

    /**
     * Number of clicks to start editing
     */
    private static final int CLICK_COUNT_TO_START = 2;
    /**
     * Editor component
     */
    private JButton button;
    /**
     * File chooser
     */
    private JFileChooser fileChooser;
    /**
     * Selected filePath
     */
    private JTable table;

    /**
     * Constructor.
     */
    public FileChooserCellEditor(JTable table) {
        super(new JTextField());
        this.table = table;
        setClickCountToStart(CLICK_COUNT_TO_START);

        // Using a JButton as the editor component
        button = new JButton();
        button.setBackground(Color.white);
        button.setFont(button.getFont().deriveFont(Font.PLAIN));

        // Dialog which will do the actual editing
        fileChooser = new JFileChooser();
    }

    @Override
    public Object getCellEditorValue() {
        Document d = ((DocumentTableModel) this.table.getModel()).getDocument(this.table.getSelectedRow());
        return d.getFileName();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Document d = ((DocumentTableModel) this.table.getModel()).getDocument(row);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String filePath = d.getFileName() == null ? System.getProperty("user.dir") : d.getFileName();
                fileChooser.setSelectedFile(new File(filePath));
                if (fileChooser.showOpenDialog(button) == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    d.setFileName(selectedFile.getName());
                    try {
                        d.setContent(Files.readAllBytes(selectedFile.toPath()));
                    } catch (IOException ex) {
                        // TODO Handle somehow
                        Logger.getLogger(FileChooserCellEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        return button;
    }
}
