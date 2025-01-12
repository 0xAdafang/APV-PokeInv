package com.pokeinv.View.admin.parts;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.admin.components.Copyright;
import com.pokeinv.View.admin.parts.forms.CardFormDialog;
import com.pokeinv.events.ButtonFiltrerListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WestPanel extends JPanel {

    private AdminView adminView;

    public WestPanel(AdminView adminView) {
        this.adminView = adminView;
        setLayout(new BorderLayout());
        setBackground(new Color(28, 28, 51));
        setPreferredSize(new Dimension(200, 200));

        JPanel mainPanelWest = new JPanel();
        mainPanelWest.setBackground(new Color(28, 28, 51));
        mainPanelWest.setLayout(new BorderLayout());
        mainPanelWest.setBackground(new Color(28, 28, 51));
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
        dashboardButton.setBackground(new Color(13, 13, 30));
        dashboardButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        dashboardButton.setForeground(new Color(150, 150, 150));
        dashboardButton.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0, 145, 185)));
        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.showDashboard();
            }
        });

        JButton addButton = new JButton("Ajouter");
        addButton.setPreferredSize(dimensionBouton);
        addButton.setBackground(new Color(13, 13, 30));
        addButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/plus-square.svg")));
        addButton.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0, 145, 185)));
        addButton.setForeground(new Color(150, 150, 150));

        addButton.addActionListener(e -> {
            CardFormDialog cardFormDialog = new CardFormDialog();
            cardFormDialog.setVisible(true);
        });

        JButton filterButton = new JButton("Filtrer");
        filterButton.setPreferredSize(dimensionBouton);
        filterButton.setBackground(new Color(13, 13, 30));
        filterButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/filter-square.svg")));
        filterButton.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0, 145, 185)));
        filterButton.setForeground(new Color(150, 150, 150));

        filterButton.addActionListener(e -> {
            try {
                new ButtonFiltrerListener();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        JPanel labelBouton = new JPanel();
        labelBouton.setForeground(new Color(150, 150, 150));
        labelBouton.setBackground(new Color(28, 28, 51));
        labelBouton.setLayout(new GridBagLayout());

        GridBagConstraints gbcWEST = new GridBagConstraints();
        gbcWEST.gridx = 0;
        gbcWEST.gridy = 0;
        gbcWEST.insets = new Insets(0, 0, 10, 0);


        labelBouton.add(dashboardButton, gbcWEST);
        gbcWEST.gridy = 1;
        labelBouton.add(addButton, gbcWEST);
        gbcWEST.gridy = 2;
        labelBouton.add(filterButton, gbcWEST);
        gbcWEST.gridy = 3;

        mainPanelWest.add(labelBouton, BorderLayout.CENTER);

        JPanel panelCopyright = new Copyright();
        mainPanelWest.add(panelCopyright, BorderLayout.SOUTH);

        add(mainPanelWest);
        setVisible(true);
    }

}
