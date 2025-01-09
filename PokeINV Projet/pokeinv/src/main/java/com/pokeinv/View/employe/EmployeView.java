package com.pokeinv.View.employe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.View.admin.parts.tables.CardsTable;
import com.pokeinv.View.shared.Composants.parts.NorthPanel;
import com.pokeinv.View.shared.Composants.parts.WestPanel;

public class EmployeView extends JPanel {
    public EmployeView() throws IOException {
        initialiserComposantsEmploye();
        setVisible(true);
    }

    private void initialiserComposantsEmploye() throws IOException {
        setLayout(new BorderLayout());

        FlatLightLaf.setup();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        // Panel du centre
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));
        centerPanel.setBorder(new LineBorder(Color.WHITE, 2));

        CardsTable table = new CardsTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        centerPanel.add(scrollPane);

        // Panel du west
        WestPanel westPanel = new WestPanel();

        // Panel du nord
        NorthPanel northPanel = new NorthPanel();
        northPanel.setPreferredSize(new Dimension(80, 150));

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

}
