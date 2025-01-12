package com.pokeinv.View.admin.components;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.View.shared.ColorManager;
import com.pokeinv.service.DataFixtures;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PieChartExemple extends JPanel {
    public PieChartExemple() {
        setLayout(new BorderLayout());
        Border cb = new MatteBorder(1, 1, 1, 1,
                ColorManager.customColorAlpha(0, 94, 183, 100));
        Border emtyBorder = new EmptyBorder(10, 10, 10, 10);
        Border border = new CompoundBorder(cb, emtyBorder);
        setBorder(border);
        List<Carte> cartes = DataFixtures.getCards();
        PieChart donutChart = createDonutChart(cartes);

        JPanel donutChartPanel = new XChartPanel<>(donutChart);
        add(donutChartPanel, BorderLayout.CENTER);
    }

    private PieChart createDonutChart(List<Carte> cartes) {
        Map<String, Double> collectionValue = cartes.stream()
                .collect(Collectors.groupingBy(carte -> carte.getCollection().getName(),
                        Collectors.summingDouble(Carte::getPrice)));

        PieChart chart = new PieChartBuilder().width(450).height(300).title("Valeurs par collection").build();
        chart.getStyler().setCircular(true);
        chart.getStyler().setDonutThickness(0.5); // Simule un graphique en anneau
        collectionValue.forEach(chart::addSeries);
        chart.getStyler().setChartBackgroundColor(ColorManager.customColor(3, 25, 44));
        chart.getStyler().setPlotBackgroundColor(ColorManager.customColorAlpha(0, 0, 0, 0));
        chart.getStyler().setPlotBorderVisible(false);

        chart.getStyler().setLegendBackgroundColor(ColorManager.customColorAlpha(0, 0, 0, 0));
        chart.getStyler().setChartFontColor(Color.WHITE);
        chart.getStyler().setChartTitleFont(new Font("Verdana", Font.BOLD, 14));
        chart.getStyler().setToolTipsEnabled(true);
        chart.getStyler().setToolTipBackgroundColor(ColorManager.customColor(3, 25, 44));
        chart.getStyler().setToolTipHighlightColor(ColorManager.customColor(2, 79, 126));
        return chart;
    }

}
