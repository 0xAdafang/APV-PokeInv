package com.pokeinv.View.admin.parts;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.admin.components.Copyright;
import com.pokeinv.View.admin.parts.forms.CardFormDialog;
import com.pokeinv.View.shared.ColorManager;
import com.pokeinv.events.ButtonFiltrerListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class WestPanel extends JPanel {

    private AdminView adminView;

    public WestPanel(AdminView adminView) {
        this.adminView = adminView;
        setLayout(new BorderLayout());
        setBackground(ColorManager.BackgroundColor);
        setPreferredSize(new Dimension(200, 200));

        JPanel mainPanelWest = new JPanel();
        mainPanelWest.setBackground(ColorManager.BackgroundColor);
        mainPanelWest.setLayout(new BorderLayout());
        mainPanelWest.setBackground(ColorManager.BackgroundColor);
//        mainPanelWest.setSize(1000, 1000);

//        JPanel titlePanel = new JPanel();
//        titlePanel.setBackground(new Color(28, 28, 51));
//        titlePanel.setLayout(new BorderLayout());
//
//        mainPanelWest.add(titlePanel, BorderLayout.NORTH);
//
        Dimension dimensionBouton = new Dimension(180, 50);


        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.setPreferredSize(dimensionBouton);
        dashboardButton.setBackground(ColorManager.BackgroundColor);
        dashboardButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        dashboardButton.setForeground(ColorManager.customColor(150, 150, 150));
        dashboardButton.setBorder(new MatteBorder(1, 1, 1, 1, ColorManager.ColorMiniPanels));
        dashboardButton.addActionListener(e -> adminView.showDashboard());

        JButton pokemonsButton = new JButton("Gestion Pokemons");
        pokemonsButton.setPreferredSize(dimensionBouton);
        pokemonsButton.setBackground(ColorManager.ColorMiniPanels);
        pokemonsButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        pokemonsButton.setForeground(ColorManager.customColor(150, 150, 150));
        pokemonsButton.setBorder(new MatteBorder(0, 2, 0, 0, ColorManager.customColor(0, 145, 185)));

        JButton addButton = new JButton("Ajouter");
        addButton.setPreferredSize(dimensionBouton);
        addButton.setBackground(ColorManager.ColorMiniPanels);
        addButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/plus-square.svg")));
        addButton.setBorder(new MatteBorder(0, 2, 0, 0, ColorManager.customColor(234, 185, 24)));
        addButton.setForeground(ColorManager.customColor(150, 150, 150));

        addButton.addActionListener(e -> {
            CardFormDialog cardFormDialog = new CardFormDialog();
            cardFormDialog.setVisible(true);
        });

        JButton filterButton = new JButton("Filtrer");
        filterButton.setPreferredSize(dimensionBouton);
        filterButton.setBackground(ColorManager.ColorMiniPanels);
        filterButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/filter-square.svg")));
        filterButton.setBorder(new MatteBorder(0, 2, 0, 0, ColorManager.customColor(234, 185, 24)));
        filterButton.setForeground(ColorManager.customColor(150, 150, 150));

        filterButton.addActionListener(e -> {
            try {
                new ButtonFiltrerListener();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        JPanel labelBouton = new JPanel();
        labelBouton.setForeground(ColorManager.customColor(150, 150, 150));
        labelBouton.setBackground(ColorManager.ColorMiniPanels);
        labelBouton.setLayout(new GridBagLayout());

        GridBagConstraints gbcWEST = new GridBagConstraints();
        gbcWEST.gridx = 0;
        gbcWEST.gridy = 0;
        gbcWEST.insets = new Insets(0, 0, 10, 0);


        labelBouton.add(dashboardButton, gbcWEST);
        gbcWEST.gridy = 1;
        labelBouton.add(pokemonsButton, gbcWEST);
        gbcWEST.gridy = 2;
        labelBouton.add(addButton, gbcWEST);
        gbcWEST.gridy = 3;
        labelBouton.add(filterButton, gbcWEST);
        gbcWEST.gridy = 4;

        mainPanelWest.add(labelBouton, BorderLayout.CENTER);

        JPanel panelCopyright = new Copyright();
        mainPanelWest.add(panelCopyright, BorderLayout.SOUTH);

        add(mainPanelWest);
        setVisible(true);
    }

}
