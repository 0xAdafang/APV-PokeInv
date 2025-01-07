package com.pokeinv.View.shared.Composants.parts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
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

        // Boutons
        BoutonFiltrer boutonFiltrer = new BoutonFiltrer();
        boutonFiltrer.setSize(20, 20);
        BoutonAjouter boutonAjouter = new BoutonAjouter();
        BoutonUpdate boutonUpdate = new BoutonUpdate();
        boutonUpdate.setSize(20, 20);

        // Text pour info de lapplication
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBackground(new Color(28, 28, 51));
        JTextArea textArea = new JTextArea("\n Bienvenues!! \n ");
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new java.awt.Font("courier new", 1, 25));
        infoPanel.add(textArea, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.WEST);

        boutonAjouter.setSize(20, 20);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(28, 28, 51));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        buttonPanel.add(Box.createVerticalStrut(0));
        buttonPanel.add(boutonFiltrer);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(boutonAjouter);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(boutonUpdate);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
