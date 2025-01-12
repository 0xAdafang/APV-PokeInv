package com.pokeinv.View.shared.Composants;



import javax.swing.JButton;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.shared.ColorManager;

public class BoutonAjouter extends JButton {

    public BoutonAjouter() {
        try {
            FlatSVGIcon icon = new FlatSVGIcon(getClass().getResource("/icons/ajoute.svg"));
            setIcon(icon);
            setText("Ajouter");
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
            setBackground(ColorManager.ColorButtons);
            setBounds(100, 100, 100, 100);
            setSize(100, 100);
        } catch (Exception e) {
            System.out.println("Error loading icon: " + e.getMessage());
        }
    }

}
