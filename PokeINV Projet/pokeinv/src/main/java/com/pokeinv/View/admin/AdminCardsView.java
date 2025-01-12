package com.pokeinv.View.admin;

import com.pokeinv.View.admin.parts.WestPanel;
import com.pokeinv.View.admin.parts.tables.CardsTable;
import com.pokeinv.View.shared.ColorManager;

import javax.swing.*;
import java.awt.*;

public class AdminCardsView extends JPanel {

    private AdminView adminView;

    public AdminCardsView(AdminView adminView) {
        this.adminView = adminView;
        initialiserComposantsAdmin();
        setVisible(true);

    }

    private void initialiserComposantsAdmin() {

//        FlatLightLaf.setup();

        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(ColorManager.BackgroundColor);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(ColorManager.BackgroundColor);
//        centerPanel.setBorder(new LineBorder(new Color(0xFFC107), 2));

        CardsTable table = new CardsTable();
        JScrollPane scrollPanel = new JScrollPane(table);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        centerPanel.add(scrollPanel);
//
        WestPanel menuPanel = new WestPanel(adminView);
        JPanel westPanelWrapper = new JPanel(new BorderLayout());
        westPanelWrapper.setBackground(ColorManager.BackgroundColor);
        westPanelWrapper.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        westPanelWrapper.add(menuPanel, BorderLayout.CENTER);
//
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanelWrapper, BorderLayout.WEST);
        add(mainPanel);
    }

}
