package com.pokeinv.View.shared.Composants;

import java.awt.Color;

import javax.sound.sampled.Clip;
import javax.swing.JButton;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.MainView;

public class BoutonMute extends JButton {

    private Clip clip;

    public BoutonMute(Clip clip) {
        this.clip = clip;
        try {
            FlatSVGIcon icon = new FlatSVGIcon(getClass().getResource("/icons/MusiqueIcon.svg"));
            setIcon(icon);
            setBackground(new Color(0xFFC107));
            setBounds(100, 100, 100, 100);
            setSize(100, 100);

            addActionListener(e -> {
                if (clip.isActive()) {
                    clip.stop();
                } else {
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            });
        } catch (Exception e) {
            System.out.println("Error loading icon: " + e.getMessage());
        }
    }

}
