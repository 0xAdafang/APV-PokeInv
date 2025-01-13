package com.pokeinv.View.admin.parts.pokemons;

import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.admin.parts.tables.CardsTable;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class AdminCardsView extends JPanel {

    private AdminView adminView;

    public AdminCardsView(AdminView adminView) {
        this.adminView = adminView;
        initialiserComposantsAdmin();
        setVisible(true);

    }

    private void initialiserComposantsAdmin() {

        setLayout(new BorderLayout());
        WestPanel westPanel = new WestPanel(adminView);
        CardsTable table = new CardsTable();
        JScrollPane main = new JScrollPane(table);
        main.setBorder(new MatteBorder(1, 1, 1, 1, new Color(28, 28, 51)));
        add(main, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);

//        setLayout(new BorderLayout());
//
//        JPanel mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setBackground(ColorManager.BackgroundColor);
//
//        JPanel centerPanel = new JPanel(new BorderLayout());
//        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
//        centerPanel.setBackground(ColorManager.BackgroundColor);
//
//        CardsTable table = new CardsTable();
//        JScrollPane scrollPanel = new JScrollPane(table);
//        scrollPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
//
//        centerPanel.add(scrollPanel);
//        WestPanel menuPanel = new WestPanel(adminView);
//        JPanel westPanelWrapper = new JPanel(new BorderLayout());
//        westPanelWrapper.setMaximumSize(new Dimension(200, getHeight()));
//        westPanelWrapper.setBackground(ColorManager.BackgroundColor);
//        westPanelWrapper.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
//        westPanelWrapper.add(menuPanel, BorderLayout.CENTER);
//
//        mainPanel.add(centerPanel, BorderLayout.CENTER);
//        mainPanel.add(westPanelWrapper, BorderLayout.WEST);
//        add(mainPanel);
    }

}
