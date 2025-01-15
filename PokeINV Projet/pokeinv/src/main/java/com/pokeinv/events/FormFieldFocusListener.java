package com.pokeinv.events;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FormFieldFocusListener implements FocusListener {

    private final JComponent component;

    public FormFieldFocusListener(JComponent component) {
        this.component = component;
    }

    @Override
    public void focusGained(FocusEvent e) {
        component.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 3, 0, new Color(0, 95, 120)),
                new EmptyBorder(5, 5, 5, 5)
        ));
        component.setBackground(new Color(35, 35, 70, 137));
    }

    @Override
    public void focusLost(FocusEvent e) {
        component.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                new EmptyBorder(5, 5, 5, 5)
        ));
        component.setBackground(new Color(21, 21, 21, 50));
    }
}
