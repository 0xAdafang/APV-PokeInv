package com.pokeinv.View.admin.parts;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.admin.parts.forms.CardFormDialog;
import com.pokeinv.View.shared.Composants.BoutonAjouter;
import com.pokeinv.View.shared.Composants.BoutonFiltrer;
import com.pokeinv.View.shared.Composants.BoutonSubscription;
import com.pokeinv.events.ButtonFiltrerListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class DashboardWestPanel extends JPanel {

    public DashboardWestPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(28, 28, 51));
        setPreferredSize(new Dimension(200, 200));
        // Panel
        JPanel mainPanelWest = new JPanel();
        mainPanelWest.setBackground(new Color(28, 28, 51));
        mainPanelWest.setLayout(new BorderLayout());
        mainPanelWest.setSize(1000, 1000);

        // Panel pour le title et image
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(28, 28, 51));
        titlePanel.setLayout(new BorderLayout());

        // Ajoute du titlePanel au mainPanel dans le north
        mainPanelWest.add(titlePanel, BorderLayout.NORTH);


        // Boutons
        Dimension dimensionBouton = new Dimension(180, 50);

        BoutonSubscription boutonSubscription = new BoutonSubscription();
//        boutonSubscription.addActionListener(e -> new subscriptionEvent().subscriptionEvent(mainPanel));
        boutonSubscription.setFont(new Font("Arial", Font.BOLD, 15));
        boutonSubscription.setPreferredSize(dimensionBouton);
        boutonSubscription.setBorderPainted(false);
        BoutonFiltrer boutonFiltrer = new BoutonFiltrer();
        boutonFiltrer.addActionListener(e -> {
            try {
                new ButtonFiltrerListener();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        boutonFiltrer.setPreferredSize(dimensionBouton);
        boutonFiltrer.setBorderPainted(false);
        boutonFiltrer.setFont(new Font("Arial", Font.BOLD, 15));
        BoutonAjouter boutonAjouter = new BoutonAjouter();
        boutonAjouter.addActionListener(e -> {
            CardFormDialog cardFormDialog = new CardFormDialog();
            cardFormDialog.setVisible(true);
        });
        boutonAjouter.setPreferredSize(dimensionBouton);
        boutonAjouter.setBorderPainted(false);
        boutonAjouter.setFont(new Font("Arial", Font.BOLD, 15));

        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.setPreferredSize(dimensionBouton);
        dashboardButton.setBackground(new Color(13, 13, 30));
        dashboardButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        dashboardButton.setForeground(new Color(150, 150, 150));
        dashboardButton.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0, 145, 185)));

        JButton pokemonsButton = new JButton("Gestion Pokemons");
        pokemonsButton.setPreferredSize(dimensionBouton);
        pokemonsButton.setBackground(new Color(13, 13, 30));
        pokemonsButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        pokemonsButton.setForeground(new Color(150, 150, 150));
        pokemonsButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(13, 13, 30)));

        JButton employeesButton = new JButton("Gestion Employés");
        employeesButton.setPreferredSize(dimensionBouton);
        employeesButton.setBackground(new Color(13, 13, 30));
        employeesButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/people.svg")));
        employeesButton.setForeground(new Color(150, 150, 150));
        employeesButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(13, 13, 30)));
        // Label bouton
        JLabel labelBouton = new JLabel();
        labelBouton.setForeground(new Color(28, 28, 51));
        labelBouton.setLayout(new GridBagLayout());

        GridBagConstraints gbcWEST = new GridBagConstraints();
        gbcWEST.gridx = 0;
        gbcWEST.gridy = 0;
        gbcWEST.insets = new Insets(0, 0, 10, 0);


        labelBouton.add(dashboardButton, gbcWEST);
        gbcWEST.gridy = 1;
        labelBouton.add(pokemonsButton, gbcWEST);
        gbcWEST.gridy = 2;
        labelBouton.add(employeesButton, gbcWEST);
        gbcWEST.gridy = 3;

        mainPanelWest.add(labelBouton, BorderLayout.CENTER);

        // Panel copyright
        JPanel panelCopyright = new JPanel();
        panelCopyright.setLayout(new BoxLayout(panelCopyright, BoxLayout.Y_AXIS));
        panelCopyright.setBackground(new Color(28, 28, 51));

        // Label copyright
        JLabel copyright = new JLabel(
                "<html>© 2025 PokeInv. <br>Tous droits réservés.<br>Fait par: <br>Nait Sidena Djamel<br>Sionneau Terence<br>Espinoza Kevin </html>",
                SwingConstants.CENTER);
        copyright.setForeground(Color.WHITE);
        copyright.setFont(new Font("Arial", Font.BOLD, 12));

        panelCopyright.add(copyright);
        panelCopyright.add(Box.createRigidArea(new Dimension(0, 5)));

        mainPanelWest.add(panelCopyright, BorderLayout.SOUTH);

        add(mainPanelWest);
        setVisible(true);
    }

}
