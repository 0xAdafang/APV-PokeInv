package com.pokeinv.View.admin.components;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditButton extends JButton {

    public EditButton() {
        setIcon(new FlatSVGIcon(getClass().getResource("/icons/pencil-square.svg")));
        setBackground(new Color(0, 94, 183));
        setMaximumSize(new Dimension(25, 25));
        setPreferredSize(new Dimension(25, 25));
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }
}