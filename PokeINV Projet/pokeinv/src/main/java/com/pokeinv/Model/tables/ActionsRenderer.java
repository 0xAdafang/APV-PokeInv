package com.pokeinv.Model.tables;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ActionsRenderer extends DefaultTableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JButton update = new JButton("UPDATE");
        JButton delete = new JButton("DELETE");
        JPanel panel = new JPanel();
        panel.add(update);
        panel.add(delete);
        return panel;
    }
}
