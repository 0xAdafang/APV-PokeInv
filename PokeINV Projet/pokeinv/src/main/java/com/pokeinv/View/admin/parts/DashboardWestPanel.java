package com.pokeinv.View.admin.parts;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.shared.ColorManager;

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
        setBackground(ColorManager.BackgroundColor);
        setPreferredSize(new Dimension(200, 200));

        JPanel mainPanelWest = new JPanel();
        mainPanelWest.setBackground(ColorManager.BackgroundColor);
        mainPanelWest.setLayout(new BorderLayout());
        mainPanelWest.setSize(1000, 1000);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(ColorManager.BackgroundColor);
        titlePanel.setLayout(new BorderLayout());

        mainPanelWest.add(titlePanel, BorderLayout.NORTH);

        Dimension dimensionBouton = new Dimension(180, 50);

        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.setPreferredSize(dimensionBouton);
        dashboardButton.setBackground(ColorManager.ColorMiniPanels);
        dashboardButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        dashboardButton.setForeground(ColorManager.customColor(150, 150, 150));
        dashboardButton.setBorder(new MatteBorder(0, 2, 0, 0, ColorManager.customColor(0, 145, 185)));
        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.showDashboard();
            }
        });

        JButton pokemonsButton = new JButton("Gestion Pokemons");
        pokemonsButton.setPreferredSize(dimensionBouton);
        pokemonsButton.setBackground(ColorManager.ColorMiniPanels);
        pokemonsButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/pokemon.svg")));
        pokemonsButton.setForeground(ColorManager.customColor(150, 150, 150));
        pokemonsButton.setBorder(new MatteBorder(1, 1, 1, 1, ColorManager.BackgroundColor));
        pokemonsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.showCards();
            }
        });

        JButton employeesButton = new JButton("Gestion Employés");
        employeesButton.setPreferredSize(dimensionBouton);
        employeesButton.setBackground(ColorManager.ColorMiniPanels);
        employeesButton.setIcon(new FlatSVGIcon(getClass().getResource("/icons/people.svg")));
        employeesButton.setForeground(ColorManager.customColor(150, 150, 150));
        employeesButton.setBorder(new MatteBorder(1, 1, 1, 1, ColorManager.ColorMiniPanels));

        // Label bouton
        JLabel labelBouton = new JLabel();
        labelBouton.setForeground(ColorManager.BackgroundColor);
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
        panelCopyright.setBackground(ColorManager.BackgroundColor);

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
