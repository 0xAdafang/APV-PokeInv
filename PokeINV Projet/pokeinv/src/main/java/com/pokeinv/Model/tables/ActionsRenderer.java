package com.pokeinv.Model.tables;

import com.pokeinv.View.admin.components.buttons.DeleteButton;
import com.pokeinv.View.admin.components.buttons.EditButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ActionsRenderer extends DefaultTableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JButton update = new EditButton();
        JButton delete = new DeleteButton();
        JPanel panel = new JPanel();
        Border matteBorder = new MatteBorder(0, 0, 2, 0, new Color(3, 22, 38));
        Border emptyBorder = new EmptyBorder(5, 20, 5, 5);
        Border compoundBorder = new CompoundBorder(matteBorder, emptyBorder);
        panel.setBorder(compoundBorder);
        if (isSelected || hasFocus) {
            panel.setBackground(table.getSelectionBackground());
        } else {
            panel.setBackground(table.getBackground());
        }
        panel.add(update);
        panel.add(delete);

        return panel;
    }
}
