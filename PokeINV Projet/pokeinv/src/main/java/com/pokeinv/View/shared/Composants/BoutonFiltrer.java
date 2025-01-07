package com.pokeinv.View.shared.Composants;

import java.awt.Color;
import javax.swing.JButton;

import com.formdev.flatlaf.extras.FlatSVGIcon;



public class BoutonFiltrer extends JButton {

    public BoutonFiltrer() {
        try {
            FlatSVGIcon icon = new FlatSVGIcon(getClass().getResource("/icons/filtreIcon.svg"));
            setIcon(icon);
            setBackground(new Color(0xFFC107));
            setBounds(100, 100, 100, 100);
            setSize(100, 100);
        } catch (Exception e) {
            System.out.println("Error loading icon: " + e.getMessage());
        }
    }

}
