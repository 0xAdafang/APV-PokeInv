package com.pokeinv.View.shared.Composants;

import java.awt.Color;

import javax.swing.JButton;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.shared.ColorManager;

public class BoutonSubscription extends JButton {
    public BoutonSubscription() {
        try {
            FlatSVGIcon icon = new FlatSVGIcon(getClass().getResource("/icons/subIcon.svg"));
            setIcon(icon);
            setText("Subscription");
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
            setBackground(ColorManager.ColorButtons);
        } catch (Exception e) {
            System.out.println("Error loading icon: " + e.getMessage());
        }
    }

}
