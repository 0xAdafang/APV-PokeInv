package com.pokeinv.View.admin.parts;

import com.formdev.flatlaf.FlatDarkLaf;
import com.pokeinv.View.admin.components.BarChartExemple;
import com.pokeinv.View.admin.components.DashboardCard;
import com.pokeinv.View.admin.components.PieChartExemple;
import com.pokeinv.View.shared.ColorManager;

import javax.swing.*;
import java.awt.*;

public class MainDashboardPanel extends JPanel {

    public MainDashboardPanel() {
        FlatDarkLaf.setup();
        setLayout(new BorderLayout());
        setBackground(ColorManager.customColor(19, 19, 38));

        /*
         * NORTH PANEL
         * */
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel("DASHBOARD");
        northPanel.add(title);
        northPanel.setBackground(ColorManager.ColorMiniPanels);
        add(northPanel, BorderLayout.NORTH);

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(20);
        flowLayout.setVgap(20);

        Color statColorBackground = ColorManager.ColorStat;

        JPanel statPanel = new JPanel(flowLayout);
        statPanel.setBackground(statColorBackground);
        DashboardCard carte = new DashboardCard(
                "Nombre de cartes",
                "120",
                "Entre le 23 et le 30 Janvier");

        Color cardColor = ColorManager.customColor(3, 22, 38);
        Dimension cardDimension = new Dimension(200, 200);
        carte.setPreferredSize(cardDimension);
        carte.setBackground(cardColor);

        DashboardCard carte1 = new DashboardCard(
                "Nombre d'employés",
                "12",
                "Entre le 23 et le 30 Janvier");
        carte1.setPreferredSize(cardDimension);
        carte1.setBackground(cardColor);

        DashboardCard carte2 = new DashboardCard(
                "Ventes cette semaine ($)",
                "1 200",
                "Entre le 23 et le 30 Janvier");
        carte2.setPreferredSize(cardDimension);
        carte2.setBackground(cardColor);

        DashboardCard carte3 = new DashboardCard(
                "Vente du mois ($)",
                "5 420",
                "Entre le 1er et le 30 Janvier");
        carte3.setPreferredSize(cardDimension);
        carte3.setBackground(cardColor);

        statPanel.add(carte);
        statPanel.add(carte1);
        statPanel.add(carte2);
        statPanel.add(carte3);

        JPanel chartsPanel = new JPanel(flowLayout);
        chartsPanel.setBackground(statColorBackground);
        BarChartExemple chart1 = new BarChartExemple();
        chart1.setBackground(ColorManager.ColorCharts);
        PieChartExemple char2 = new PieChartExemple();
        char2.setBackground(ColorManager.ColorCharts);
        chartsPanel.add(chart1);
        chartsPanel.add(char2);
        JPanel container = new JPanel();
        container.setBackground(statColorBackground);
        container.add(statPanel);
        container.add(chartsPanel);
        add(container, BorderLayout.CENTER);

    }
}
