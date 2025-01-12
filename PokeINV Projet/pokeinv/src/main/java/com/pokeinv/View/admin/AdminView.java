package com.pokeinv.View.admin;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.View.admin.parts.DashboardView;
import com.pokeinv.View.admin.parts.NorthPanel;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JPanel {

    public DashboardView dashboardView;
    public AdminCardsView adminCardsView;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public AdminView() {
        initialiserComposantsAdmin();
        setVisible(true);
    }

    private void initialiserComposantsAdmin() {
        setLayout(new BorderLayout());

        FlatLightLaf.setup();
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        cardPanel.setBackground(new Color(28, 28, 51));
//        cardPanel.setBorder(new LineBorder(new Color(2, 19, 33), 1));


        dashboardView = new DashboardView(this);
        adminCardsView = new AdminCardsView(this);

        cardPanel.add(dashboardView, "DASHBOARD");
        cardPanel.add(adminCardsView, "CARDS");

        mainPanel.add(cardPanel, BorderLayout.CENTER);

        NorthPanel northPanel = new NorthPanel();
        northPanel.setPreferredSize(new Dimension(80, 130));

        mainPanel.add(northPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

    public void showDashboard() {
        cardLayout.show(cardPanel, "DASHBOARD");
    }

    public void showCards() {
        cardLayout.show(cardPanel, "CARDS");
    }
}
