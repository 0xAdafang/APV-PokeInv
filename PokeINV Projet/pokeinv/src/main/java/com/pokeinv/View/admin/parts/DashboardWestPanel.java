package com.pokeinv.View.admin.parts;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.admin.AdminView;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardWestPanel extends JPanel {

    private AdminView adminView;

    public DashboardWestPanel(AdminView adminView) {
        this.adminView = adminView;
        setLayout(new BorderLayout());
        setBackground(new Color(28, 28, 51));
        setPreferredSize(new Dimension(200, 200));

        JPanel mainPanelWest = new JPanel();
        mainPanelWest.setBackground(new Color(28, 28, 51));
        mainPanelWest.setLayout(new BorderLayout());
        mainPanelWest.setSize(1000, 1000);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(28, 28, 51));
        titlePanel.setLayout(new BorderLayout());

        mainPanelWest.add(titlePanel, BorderLayout.NORTH);

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

        JButton pokemonsButton = new JButton("Gestion Pokemons");
        pokemonsButton.setPreferredSize(dimensionBouton);
        pokemonsButton.setBackground(new Color(13, 13, 30));
        pokemonsButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        pokemonsButton.setForeground(new Color(150, 150, 150));
        pokemonsButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(13, 13, 30)));
        pokemonsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.showCards();
            }
        });

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
