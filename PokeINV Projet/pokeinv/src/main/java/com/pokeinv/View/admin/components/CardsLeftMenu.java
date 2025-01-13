package com.pokeinv.View.admin.components;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.admin.components.buttons.LeftMenuButton;
import com.pokeinv.View.admin.parts.forms.CardFormDialog;
import com.pokeinv.View.shared.ColorManager;
import com.pokeinv.events.ButtonFiltrerListener;

import javax.swing.*;
import java.awt.*;

public class CardsLeftMenu extends JPanel {

    public CardsLeftMenu(AdminView adminView) {

        setBackground(ColorManager.BackgroundColor);

        JButton dashboardButton = new LeftMenuButton("Dashboard");
        dashboardButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        dashboardButton.addActionListener(e -> adminView.showDashboard());

        JButton pokemonsButton = new LeftMenuButton("Gestion Pokemons", true);
        pokemonsButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        pokemonsButton.addActionListener(e -> adminView.showCards());
        JButton addButton = new LeftMenuButton("Ajouter", false, true);
        addButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/plus-square.svg")));
        addButton.addActionListener(e -> {
            CardFormDialog cardFormDialog = new CardFormDialog();
            cardFormDialog.setVisible(true);
        });

        JButton filterButton = new LeftMenuButton("Filtrer", false, true);
        filterButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/filter-square.svg")));
        filterButton.addActionListener(e -> new ButtonFiltrerListener());

        JButton employeeButton = new LeftMenuButton("Gestion Employés");
        employeeButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/people.svg")));
        employeeButton.addActionListener(e -> adminView.showEmployees());

        setForeground(ColorManager.customColor(150, 150, 150));
        setBackground(ColorManager.BackgroundColor);
        setLayout(new GridBagLayout());
        setMaximumSize(new Dimension(200, getHeight()));
        GridBagConstraints gbcWEST = new GridBagConstraints();
        gbcWEST.gridx = 0;
        gbcWEST.gridy = 0;
        gbcWEST.insets = new Insets(0, 0, 3, 0);
        gbcWEST.anchor = GridBagConstraints.EAST;

        add(dashboardButton, gbcWEST);
        gbcWEST.gridy = 1;
        add(pokemonsButton, gbcWEST);
        gbcWEST.gridy = 2;
        add(addButton, gbcWEST);
        gbcWEST.gridy = 3;
        add(filterButton, gbcWEST);
        gbcWEST.gridy = 4;
        add(employeeButton, gbcWEST);
        gbcWEST.gridy = 5;

    }
}
