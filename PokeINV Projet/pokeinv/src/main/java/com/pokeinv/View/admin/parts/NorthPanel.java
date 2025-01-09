package com.pokeinv.View.admin.parts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;

import com.pokeinv.View.shared.Composants.BoutonMute;

public class NorthPanel extends JPanel {

    public NorthPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(28, 28, 51));
        setBorder(new LineBorder(new Color(28, 28, 51), 2));

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
        ImagePokeballLabel.setBackground(new Color(28, 28, 51));
        ImagePokeballLabel.setOpaque(true);

        // Text et Label pour info de lapplication
        JPanel logoPanel = new JPanel(
                new GridBagLayout());
        logoPanel.setBackground(new Color(28, 28, 51));
        logoPanel.add(ImagePokeballLabel, gbcWEST);
        gbcWEST.gridy = 1;
        gbcWEST.insets = new java.awt.Insets(10, 15, 20, 0);

        add(logoPanel, BorderLayout.WEST);

        // Text et Label pour info de lapplication
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(28, 28, 51));
        infoPanel.setLayout(new GridBagLayout());

        JLabel title = new JLabel(" PokeINV", javax.swing.SwingConstants.CENTER);
        title.setFont(new java.awt.Font("calibri", 1, 50));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setBorder(null);
        title.setBackground(new Color(28, 28, 51));

        JLabel subtitle = new JLabel(" Admin");
        subtitle.setFont(new java.awt.Font("calibri", 1, 20));
        subtitle.setForeground(Color.WHITE);
        subtitle.setOpaque(true);
        subtitle.setBorder(null);
        subtitle.setBackground(new Color(28, 28, 51));

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
        BoutonMute boutonMute = new BoutonMute();
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
        mutePanel.setBackground(new Color(28, 28, 51));
        mutePanel.setLayout(new FlowLayout());

        mutePanel.add(boutonMute);

        add(mutePanel, BorderLayout.EAST);
    }
}
