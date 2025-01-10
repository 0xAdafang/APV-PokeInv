package com.pokeinv.View.admin;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.View.admin.parts.NorthPanel;
import com.pokeinv.View.admin.parts.WestPanel;
import com.pokeinv.View.admin.parts.tables.CardsTable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class AdminView extends JPanel {

    public AdminView() throws IOException {
        initialiserComposantsAdmin();
        setVisible(true);

    }

    private void initialiserComposantsAdmin() throws IOException {
        setLayout(new BorderLayout());

        FlatLightLaf.setup();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        // Panel du centre
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));
        centerPanel.setBorder(new LineBorder(new Color(0xFFC107), 8));

        CardsTable table = new CardsTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        centerPanel.add(scrollPane);

        // Panel du west
        WestPanel westPanel = new WestPanel(mainPanel);

        // Panel du nord
        NorthPanel northPanel = new NorthPanel();
        northPanel.setPreferredSize(new Dimension(80, 150));

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

}
