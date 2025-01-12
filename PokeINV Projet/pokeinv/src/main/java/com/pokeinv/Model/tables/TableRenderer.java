package com.pokeinv.Model.tables;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (c instanceof JComponent) {
            Border matteBorder = new MatteBorder(0, 0, 2, 0, new Color(3, 22, 38));
            Border emptyBorder = new EmptyBorder(5, 20, 5, 5);
            Border compoundBorder = new CompoundBorder(matteBorder, emptyBorder);
            ((JComponent) c).setBorder(compoundBorder);
        }

        return c;
    }
}