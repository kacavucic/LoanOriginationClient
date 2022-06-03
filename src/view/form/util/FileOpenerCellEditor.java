package view.form.util;

import domain.Document;
import view.form.component.table.DocumentTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;

public class FileOpenerCellEditor extends DefaultCellEditor implements TableCellEditor {

    private static final int CLICK_COUNT_TO_START = 2;
    private JButton button;
    private JTable table;

    public FileOpenerCellEditor(JTable table) {
        super(new JTextField());
        this.table = table;
        setClickCountToStart(CLICK_COUNT_TO_START);

        // Using a JButton as the editor component
        button = new JButton();
        button.setBackground(Color.white);
        button.setFont(button.getFont().deriveFont(Font.PLAIN));
        button.setForeground(Color.black);
        button.setBorderPainted(true);
        button.setContentAreaFilled(true);
        button.setDefaultCapable(true);
        button.setFocusPainted(true);
        button.setVisible(true);
        button.setEnabled(true);

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
                String filePath = System.getProperty("java.io.tmpdir");
                filePath += d.getFileName();
                byte[] content = d.getContent();
                try (FileOutputStream stream = new FileOutputStream(filePath)) {
                    stream.write(content);
                    File fileToDisplay = new File(filePath);
                    if (!Desktop.isDesktopSupported()) {
                        System.out.println("not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(fileToDisplay);
                } catch (Exception ex) {
                    Logger.getLogger(FileOpenerCellEditor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        return button;
    }

}
