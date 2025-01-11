package com.pokeinv.Model.form;

import com.pokeinv.Model.entity.Collection;

import javax.swing.*;
import java.awt.*;

public class CollectionCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Collection collection) {
            setText(collection.getName());
        }
        return this;
    }
}
