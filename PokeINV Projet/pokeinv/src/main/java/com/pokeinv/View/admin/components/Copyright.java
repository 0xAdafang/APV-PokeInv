package com.pokeinv.View.admin.components;

import javax.swing.*;

import com.pokeinv.View.shared.ColorManager;

import java.awt.*;

public class Copyright extends JPanel {
    public Copyright() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(ColorManager.BackgroundColor);

        JLabel copyright = new JLabel(
                "<html>© 2025 PokeInv. <br>Tous droits réservés.<br> Fait par: <br>Nait Sidena Djamel<br> Sionneau Terence<br>Espinoza Kevin </html> ",
                SwingConstants.CENTER);
        copyright.setForeground(Color.WHITE);
        copyright.setFont(new Font("Arial", Font.BOLD, 12));

        add(copyright);
        add(Box.createRigidArea(new Dimension(0, 5)));

    }
}
