package com.pokeinv.View.admin;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.View.admin.parts.WestPanel;
import com.pokeinv.View.admin.parts.tables.CardsTable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AdminCardsView extends JPanel {

    public AdminCardsView() {
        initialiserComposantsAdmin();
        setVisible(true);

    }

    private void initialiserComposantsAdmin() {

        FlatLightLaf.setup();

        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));
        centerPanel.setBorder(new LineBorder(new Color(0xFFC107), 8));

        CardsTable table = new CardsTable();
        JScrollPane scrollPanel = new JScrollPane(table);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        centerPanel.add(scrollPanel);

        WestPanel menuPanel = new WestPanel(mainPanel);
        JPanel westPanelWrapper = new JPanel(new BorderLayout());
        westPanelWrapper.setBackground(new Color(28, 28, 51));
        westPanelWrapper.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        westPanelWrapper.add(menuPanel, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanelWrapper, BorderLayout.WEST);
        add(mainPanel);
    }

}
