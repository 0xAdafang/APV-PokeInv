package com.pokeinv.View.admin.parts;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class WestPanel extends JPanel {

    public WestPanel() {
        setLayout(new BorderLayout());
        setSize(800, 800);
        setBackground(new Color(28, 28, 51));
        setBorder(new LineBorder(Color.WHITE, 10));

        // Panel
        JPanel mainPanelWest = new JPanel();
        mainPanelWest.setBackground(new Color(28, 28, 51));
        mainPanelWest.setLayout(new BorderLayout());
        mainPanelWest.setSize(1000, 1000);

        // Panel pour le title et image
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(28, 28, 51));
        titlePanel.setLayout(new BorderLayout());

        // Ajoute du titlePanel au mainPanel dans le north
        mainPanelWest.add(titlePanel, BorderLayout.NORTH);

        // Image
        ImageIcon ImagePokeball = new ImageIcon(getClass().getResource("/icons/PokeballTrans.png"));
        Image ImagePokeballImage = ImagePokeball.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel ImagePokeballLabel = new JLabel(new ImageIcon(ImagePokeballImage));
        ImagePokeballLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ImagePokeballLabel.setBackground(new Color(28, 28, 51));
        ImagePokeballLabel.setOpaque(true);
        titlePanel.add(ImagePokeballLabel, BorderLayout.NORTH);
        titlePanel.add(Box.createRigidArea(new Dimension(0, 30)), BorderLayout.CENTER);

        // Text Bienvenue
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(28, 28, 51));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel bienvenue = new JLabel(" Bienvenue, ", SwingConstants.CENTER);
        bienvenue.setForeground(Color.WHITE);
        bienvenue.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel pokeInv = new JLabel("sur PokeInv! ", SwingConstants.CENTER);
        pokeInv.setForeground(Color.WHITE);
        pokeInv.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel linePanel = new JPanel();
        linePanel.setPreferredSize(new Dimension(10, 5));
        linePanel.setBackground(Color.WHITE);

        textPanel.add(bienvenue);
        textPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        textPanel.add(pokeInv);
        textPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        textPanel.add(linePanel);

        titlePanel.add(textPanel, BorderLayout.SOUTH);

        add(mainPanelWest);
    }

}
