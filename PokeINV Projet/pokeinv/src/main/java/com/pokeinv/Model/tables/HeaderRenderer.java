package com.pokeinv.Model.tables;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class HeaderRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (c instanceof JComponent) {

            c.setBackground(new Color(19, 19, 38));
            c.setForeground(new Color(204, 204, 204));
            Border bottomBorder = new MatteBorder(0, 0, 1, 1, new Color(255, 255, 255, 10));
            Border paddingBorder = BorderFactory.createEmptyBorder(5, 20, 5, 5);
            ((JComponent) c).setBorder(new CompoundBorder(bottomBorder, paddingBorder));

        }

        return c;
    }
}