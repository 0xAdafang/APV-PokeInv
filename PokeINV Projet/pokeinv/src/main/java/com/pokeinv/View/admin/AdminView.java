package com.pokeinv.View.admin;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.View.admin.parts.dashboard.DashboardView;
import com.pokeinv.View.admin.parts.employees.AdminEmployeesView;
import com.pokeinv.View.admin.parts.pokemons.AdminCardsView;
import com.pokeinv.View.admin.parts.pokemons.NorthPanel;
import com.pokeinv.View.shared.ColorManager;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JPanel {

    public DashboardView dashboardView;
    public AdminCardsView adminCardsView;
    public AdminEmployeesView adminEmployeesView;
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
        mainPanel.setBackground(ColorManager.BackgroundColor);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        cardPanel.setBackground(ColorManager.BackgroundColor);


        dashboardView = new DashboardView(this);
        adminCardsView = new AdminCardsView(this);
        adminEmployeesView = new AdminEmployeesView(this);

        cardPanel.add(dashboardView, "DASHBOARD");
        cardPanel.add(adminCardsView, "CARDS");
        cardPanel.add(adminEmployeesView, "EMPLOYEES");

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

    public void showEmployees() {
        cardLayout.show(cardPanel, "EMPLOYEES");
    }
}
