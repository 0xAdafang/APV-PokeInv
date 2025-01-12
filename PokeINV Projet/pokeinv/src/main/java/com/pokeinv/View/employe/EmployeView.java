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
import com.pokeinv.View.employe.tables.CardsTableEmploye;
import com.pokeinv.View.shared.ColorManager;
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
        mainPanel.setBackground(ColorManager.BackgroundColor);

        // Panel du centre
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(ColorManager.BackgroundColor);


        CardsTableEmploye table = new CardsTableEmploye();

        centerPanel.add(table);

        // Panel du west
        WestPanel westPanel = new WestPanel(mainPanel);
        JPanel westPanelWrapper = new JPanel(new BorderLayout());
        westPanelWrapper.setBackground(ColorManager.BackgroundColor);
        westPanelWrapper.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        westPanelWrapper.add(westPanel, BorderLayout.CENTER);

        // Panel du nord
        NorthPanel northPanel = new NorthPanel();
        northPanel.setPreferredSize(new Dimension(80, 130));

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanelWrapper, BorderLayout.WEST);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

}
