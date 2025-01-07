package com.pokeinv.View.admin.parts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import com.pokeinv.View.shared.Composants.BoutonUpdate;

public class NorthPanel extends JPanel {

    public NorthPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(28, 28, 51));
        setBorder(new LineBorder(Color.WHITE, 2));

        // Gif
        ImageIcon gifPika = new ImageIcon(getClass().getResource("/icons/PikaGif.gif"));
        gifPika.setImage(gifPika.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        JLabel gifLabel = new JLabel(gifPika);

        // GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        // Boutons
        BoutonFiltrer boutonFiltrer = new BoutonFiltrer();
        boutonFiltrer.setSize(20, 20);
        BoutonAjouter boutonAjouter = new BoutonAjouter();
        BoutonUpdate boutonUpdate = new BoutonUpdate();
        boutonUpdate.setSize(20, 20);

        // Text pour info de lapplication
        JPanel infoPanel = new JPanel(
                new GridBagLayout());
        infoPanel.setBackground(new Color(28, 28, 51));
        JTextArea textArea = new JTextArea(
                "Bienvenues!! \n ");
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new java.awt.Font("courier new", 1, 25));
        infoPanel.add(gifLabel, gbc);
        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(10, 20, 0, 0);

        infoPanel.add(textArea, gbc);

        add(infoPanel, BorderLayout.WEST);

        boutonAjouter.setSize(20, 20);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(28, 28, 51));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        buttonPanel.add(boutonFiltrer);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(boutonAjouter);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(boutonUpdate);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
