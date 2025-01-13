package com.pokeinv.View.admin.components;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.admin.components.buttons.LeftMenuButton;
import com.pokeinv.View.shared.ColorManager;

import javax.swing.*;
import java.awt.*;

public class DashboardLeftMenu extends JPanel {

    public DashboardLeftMenu(AdminView adminView) {

        LeftMenuButton dashboardButton = new LeftMenuButton("Dashboard", true);
        dashboardButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        dashboardButton.addActionListener(e -> adminView.showDashboard());

        JButton pokemonsButton = new LeftMenuButton("Gestion Pokemons");
        pokemonsButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        pokemonsButton.addActionListener(e -> adminView.showCards());

        JButton employeesButton = new LeftMenuButton("Gestion Employés");
        employeesButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/people.svg")));


        setBackground(ColorManager.BackgroundColor);
        setLayout(new GridBagLayout());

        GridBagConstraints gbcWEST = new GridBagConstraints();
        gbcWEST.gridx = 0;
        gbcWEST.gridy = 0;
        gbcWEST.insets = new Insets(0, 0, 3, 0);
        gbcWEST.anchor = GridBagConstraints.EAST;

        add(dashboardButton, gbcWEST);
        gbcWEST.gridy = 1;
        add(pokemonsButton, gbcWEST);
        gbcWEST.gridy = 2;
        add(employeesButton, gbcWEST);
        gbcWEST.gridy = 3;

    }
}
