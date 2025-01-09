package com.pokeinv.Model.tables;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ActionsEditor extends AbstractCellEditor implements TableCellEditor {

    private final JButton update = new JButton("UPDATE");
    private final JButton delete = new JButton("DELETE");
    private final JPanel panel = new JPanel();
    //    private CardsTableModel model;
    private int rowIndex;

    public ActionsEditor() {

        panel.add(update);
        panel.add(delete);

        initActions();

    }

    private void initActions() {
        update.addActionListener(e -> {
            System.out.println("row to update : " + rowIndex);
        });
        delete.addActionListener(e -> {

            System.out.println("row to delete : " + rowIndex);
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//        this.model = (CardsTableModel) table.getModel();
        this.rowIndex = table.convertRowIndexToModel(row);
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
