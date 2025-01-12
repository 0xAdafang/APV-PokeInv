package com.pokeinv.View.admin.components;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.Model.entity.Collection;
import com.pokeinv.service.DataFixtures;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BarChartExemple extends JPanel {
    public BarChartExemple() {
        setLayout(new BorderLayout());
        Border cb =
                new MatteBorder(1, 1, 1, 1,
                        new Color(0, 94, 183, 100)
                );
        Border emtyBorder = new EmptyBorder(10, 10, 10, 10);
        Border border = new CompoundBorder(cb, emtyBorder);
        setBorder(border);
        List<Carte> cartes = DataFixtures.getCards();
        List<Collection> collections = DataFixtures.getCollections();

        CategoryChart barChart = createBarChart(cartes);
        JPanel barChartPanel = new XChartPanel<>(barChart);
        add(barChartPanel, BorderLayout.CENTER);
    }

    private CategoryChart createBarChart(List<Carte> cartes) {
        Map<String, Long> collectionCount = cartes.stream()
                .collect(Collectors.groupingBy(carte -> carte.getCollection().getName(), Collectors.counting()));

        CategoryChart chart = new CategoryChartBuilder().width(550).height(300).title("Nombre de cartes par collection")
                .xAxisTitle("Collection").yAxisTitle("Nombre de carte").build();
        chart.addSeries("Cartes", new ArrayList<>(collectionCount.keySet()), new ArrayList<>(collectionCount.values()));
        chart.getStyler().setChartBackgroundColor(new Color(3, 25, 44));
        chart.getStyler().setPlotBackgroundColor(new Color(0, 0, 0, 0));
        chart.getStyler().setPlotBorderVisible(false);

        chart.getStyler().setAxisTickLabelsColor(Color.WHITE);
        chart.getStyler().setLegendBackgroundColor(new Color(0, 0, 0, 0));
        chart.getStyler().setChartFontColor(Color.WHITE);
        chart.getStyler().setChartTitleFont(new Font("Verdana", Font.BOLD, 14));
        chart.getStyler().setPlotGridHorizontalLinesVisible(false);
        chart.getStyler().setPlotGridVerticalLinesVisible(false);
        chart.getStyler().setPlotBorderVisible(false);
        chart.getStyler().setToolTipsEnabled(true);
        chart.getStyler().setToolTipBackgroundColor(new Color(3, 25, 44));
        chart.getStyler().setToolTipHighlightColor(new Color(2, 79, 126));


        return chart;
    }

}
