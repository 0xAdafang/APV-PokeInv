package com.pokeinv.View.admin.parts.pokemons;

import com.pokeinv.View.MainView;
import com.pokeinv.View.shared.ColorManager;
import com.pokeinv.View.shared.Composants.BoutonMute;

import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NorthPanel extends JPanel {

    public NorthPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(28, 28, 51));
        setBorder(new LineBorder(ColorManager.BackgroundColor, 2));

        // GridBagConstraints
        GridBagConstraints gbcWEST = new GridBagConstraints();
        gbcWEST.gridx = 0;
        gbcWEST.gridy = 0;
        gbcWEST.insets = new java.awt.Insets(0, 25, 10, 0);
        gbcWEST.anchor = GridBagConstraints.CENTER;

        // image pokeball
        ImageIcon ImagePokeball = new ImageIcon(getClass().getResource("/icons/PokeballTrans.png"));
        Image ImagePokeballImage = ImagePokeball.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        JLabel ImagePokeballLabel = new JLabel(new ImageIcon(ImagePokeballImage));
        ImagePokeballLabel.setBackground(ColorManager.BackgroundColor);
        ImagePokeballLabel.setOpaque(true);

        // Text et Label pour info de lapplication
        JPanel logoPanel = new JPanel(
                new GridBagLayout());
        logoPanel.setBackground(ColorManager.BackgroundColor);
        logoPanel.add(ImagePokeballLabel, gbcWEST);
        gbcWEST.gridy = 1;
        gbcWEST.insets = new java.awt.Insets(10, 15, 20, 0);

        add(logoPanel, BorderLayout.WEST);

        // Text et Label pour info de lapplication
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(ColorManager.BackgroundColor);
        infoPanel.setLayout(new GridBagLayout());

        JLabel title = new JLabel(" PokeINV", javax.swing.SwingConstants.CENTER);
        title.setFont(new java.awt.Font("calibri", 1, 50));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setBorder(null);
        title.setBackground(ColorManager.BackgroundColor);

        JLabel subtitle = new JLabel(" Admin");
        subtitle.setFont(new java.awt.Font("calibri", 1, 20));
        subtitle.setForeground(Color.WHITE);
        subtitle.setOpaque(true);
        subtitle.setBorder(null);
        subtitle.setBackground(ColorManager.BackgroundColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0);

        infoPanel.add(title, gbc);
        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
        infoPanel.add(subtitle, gbc);

        add(infoPanel, BorderLayout.CENTER);

        // Bouton Mute
        Clip clip = MainView.getClip();
        BoutonMute boutonMute = new BoutonMute(clip);
        boutonMute.setSize(20, 20);
        boutonMute.setBorderPainted(false);


        // gbc configuration nord buttons
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.gridx = 1;
        gbcButtons.gridy = 0;
        gbcButtons.anchor = GridBagConstraints.EAST;
        gbcButtons.insets = new java.awt.Insets(0, 0, 0, 0);

        // Label Titre de l'application
        JPanel mutePanel = new JPanel();
        mutePanel.setBackground(ColorManager.BackgroundColor);
        mutePanel.setLayout(new FlowLayout());

        mutePanel.add(boutonMute);

        add(mutePanel, BorderLayout.EAST);
    }
}
