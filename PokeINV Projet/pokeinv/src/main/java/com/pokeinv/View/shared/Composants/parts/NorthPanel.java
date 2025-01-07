package com.pokeinv.View.shared.Composants.parts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.pokeinv.View.shared.Composants.BoutonAjouter;
import com.pokeinv.View.shared.Composants.BoutonFiltrer;
import com.pokeinv.View.shared.Composants.BoutonMute;
import com.pokeinv.View.shared.Composants.BoutonUpdate;

public class NorthPanel extends JPanel {

    public NorthPanel() {
        setDoubleBuffered(true);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(28, 28, 51));
        setBorder(new LineBorder(new Color(28, 28, 51), 2));

        // Gif
        ImageIcon gifPika = new ImageIcon(getClass().getResource("/icons/PikaGif.gif"));
        gifPika.setImage(gifPika.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));
        JLabel gifLabel = new JLabel(gifPika);

        // Boutons
        BoutonFiltrer boutonFiltrer = new BoutonFiltrer();
        boutonFiltrer.setSize(20, 20);
        boutonFiltrer.setBorder(new LineBorder(Color.WHITE, 2));
        boutonFiltrer.setBackground(new Color(28, 28, 51));
        BoutonAjouter boutonAjouter = new BoutonAjouter();
        boutonAjouter.setSize(20, 20);
        BoutonUpdate boutonUpdate = new BoutonUpdate();
        boutonUpdate.setSize(20, 20);
        BoutonMute boutonMute = new BoutonMute();
        boutonMute.setSize(20, 20);
        boutonMute.setBorderPainted(false);

        // GridBagConstraints
        GridBagConstraints gbcWEST = new GridBagConstraints();
        gbcWEST.gridx = 0;
        gbcWEST.gridy = 0;
        gbcWEST.insets = new java.awt.Insets(0, 0, 0, 0);
        gbcWEST.anchor = GridBagConstraints.CENTER;

        // Text pour info de lapplication
        JPanel infoPanel = new JPanel(
                new GridBagLayout());
        infoPanel.setBackground(new Color(28, 28, 51));
        JTextArea textArea = new JTextArea(
                "Bienvenues!! \n ");
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new java.awt.Font("courier new", 1, 20));
        infoPanel.add(gifLabel, gbcWEST);
        gbcWEST.gridy = 1;
        gbcWEST.insets = new java.awt.Insets(10, 20, 0, 0);

        infoPanel.add(textArea, gbcWEST);

        add(infoPanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(28, 28, 51));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        buttonPanel.add(Box.createVerticalStrut(0));
        buttonPanel.add(boutonFiltrer);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(boutonAjouter);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(boutonUpdate);

        // gbc configuration nord
        GridBagConstraints gbcNORTH = new GridBagConstraints();
        gbcNORTH.gridx = 0;
        gbcNORTH.gridy = 0;
        gbcNORTH.insets = new java.awt.Insets(0, 1213, 0, 0);
        gbcNORTH.anchor = GridBagConstraints.CENTER;
        gbcNORTH.fill = GridBagConstraints.HORIZONTAL;

        // Label Titre de l'application
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(28, 28, 51));
        titlePanel.setLayout(new GridBagLayout());
        JLabel title = new JLabel("    PokeINV");
        title.setFont(new java.awt.Font("Arial", 1, 20));
        title.setForeground(Color.WHITE);

        titlePanel.add(boutonMute, gbcNORTH);
        titlePanel.add(title);

        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
