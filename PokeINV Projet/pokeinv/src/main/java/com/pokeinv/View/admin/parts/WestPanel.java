package com.pokeinv.View.admin.parts;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.pokeinv.View.shared.Composants.BoutonAjouter;
import com.pokeinv.View.shared.Composants.BoutonFiltrer;
import com.pokeinv.View.shared.Composants.BoutonSubscription;

import java.awt.*;

public class WestPanel extends JPanel {

    public WestPanel() {
        setLayout(new BorderLayout());
        setSize(800, 800);
        setBackground(new Color(28, 28, 51));
        setBorder(new LineBorder(new Color(0xFFC107), 10));

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

        // Gif
        ImageIcon gifPika = new ImageIcon(getClass().getResource("/icons/PikaGif.gif"));
        gifPika.setImage(gifPika.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        JLabel gifLabel = new JLabel(gifPika);
        titlePanel.add(gifLabel, BorderLayout.NORTH);

        // Text Bienvenue
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(28, 28, 51));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel bienvenue = new JLabel("  Bienvenue, ", SwingConstants.CENTER);
        bienvenue.setForeground(Color.WHITE);
        bienvenue.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel pokeInv = new JLabel(" sur PokeInv! ", SwingConstants.CENTER);
        pokeInv.setForeground(Color.WHITE);
        pokeInv.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel linePanel = new JPanel();
        linePanel.setPreferredSize(new Dimension(10, 5));
        linePanel.setBackground(new Color(0xFFC107));

        // Boutons
        Dimension dimensionBouton = new Dimension(180, 50);

        BoutonSubscription boutonSubscription = new BoutonSubscription();
        boutonSubscription.setFont(new Font("Arial", Font.BOLD, 15));
        boutonSubscription.setPreferredSize(dimensionBouton);
        boutonSubscription.setBorderPainted(false);
        BoutonFiltrer boutonFiltrer = new BoutonFiltrer();
        boutonFiltrer.setPreferredSize(dimensionBouton);
        boutonFiltrer.setBorderPainted(false);
        boutonFiltrer.setFont(new Font("Arial", Font.BOLD, 15));
        BoutonAjouter boutonAjouter = new BoutonAjouter();
        boutonAjouter.setPreferredSize(dimensionBouton);
        boutonAjouter.setBorderPainted(false);
        boutonAjouter.setFont(new Font("Arial", Font.BOLD, 15));

        // Label bouton
        JLabel labelBouton = new JLabel();
        labelBouton.setForeground(new Color(28, 28, 51));
        labelBouton.setLayout(new GridBagLayout());

        GridBagConstraints gbcWEST = new GridBagConstraints();
        gbcWEST.gridx = 0;
        gbcWEST.gridy = 0;
        gbcWEST.insets = new java.awt.Insets(0, 0, 10, 0);
        labelBouton.add(boutonSubscription, gbcWEST);
        gbcWEST.gridy = 1;
        labelBouton.add(boutonFiltrer, gbcWEST);
        gbcWEST.gridy = 2;
        labelBouton.add(boutonAjouter, gbcWEST);
        gbcWEST.gridy = 3;

        mainPanelWest.add(labelBouton, BorderLayout.CENTER);

        // Panel copyright
        JPanel panelCopyright = new JPanel();
        panelCopyright.setLayout(new BoxLayout(panelCopyright, BoxLayout.Y_AXIS));
        panelCopyright.setBackground(new Color(28, 28, 51));

        // Label copyright
        JLabel copyright = new JLabel(
                "<html>© 2022 PokeInv. <br>Tous droits réservés.<br>Fait par: <br>Nait Sidena Djamel<br>Sionneau Terence<br>Espinoza Kevin </html>",
                SwingConstants.CENTER);
        copyright.setForeground(Color.WHITE);
        copyright.setFont(new Font("Arial", Font.BOLD, 15));

        // Añadir componentes al panelCopyright
        panelCopyright.add(copyright);
        panelCopyright.add(Box.createRigidArea(new Dimension(0, 5)));

        mainPanelWest.add(panelCopyright, BorderLayout.SOUTH);

        textPanel.add(bienvenue);
        textPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        textPanel.add(pokeInv);
        textPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        textPanel.add(linePanel);

        titlePanel.add(textPanel, BorderLayout.SOUTH);

        add(mainPanelWest);
    }

}
