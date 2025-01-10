package com.pokeinv.View.admin.components;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteButton extends JButton {

    public DeleteButton() {
        setIcon(new FlatSVGIcon(getClass().getResource("/icons/trash.svg")));
        setBackground(new Color(100, 1, 1));
        setMaximumSize(new Dimension(25, 25));
        setPreferredSize(new Dimension(25, 25));
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }
}
