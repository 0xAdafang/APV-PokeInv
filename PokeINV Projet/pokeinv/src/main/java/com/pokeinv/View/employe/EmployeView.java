package com.pokeinv.View.employe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.pokeinv.View.shared.Composants.parts.NorthPanel;
import com.pokeinv.View.shared.Composants.parts.WestPanel;

public class EmployeView extends JPanel {
    public EmployeView() throws IOException {
        initialiserComposantsEmploye();
        setVisible(true);
    }

    private void initialiserComposantsEmploye() throws IOException {
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));

        // Panel du Nord
        NorthPanel northPanel = new NorthPanel();
        northPanel.setPreferredSize(new Dimension(80, 100));

        // Panel du West
        WestPanel westPanel = new WestPanel();

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

}
