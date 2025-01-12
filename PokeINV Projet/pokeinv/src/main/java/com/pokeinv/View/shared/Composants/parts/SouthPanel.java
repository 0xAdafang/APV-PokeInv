package com.pokeinv.View.shared.Composants.parts;

import javax.swing.*;

import com.pokeinv.View.shared.ColorManager;

import java.awt.*;

public class SouthPanel extends JPanel {

    public SouthPanel() {
        setLayout(new GridLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(ColorManager.BackgroundColor);
    }
}
