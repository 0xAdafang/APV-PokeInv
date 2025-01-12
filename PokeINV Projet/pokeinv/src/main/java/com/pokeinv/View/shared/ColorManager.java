package com.pokeinv.View.shared;

import java.awt.Color;

public class ColorManager {

    public static final Color TitleBarBackground = new Color(28, 28, 51);
    public static final Color BackgroundColor = new Color(28, 28, 51);
    public static final Color ScrollPaneColor = new Color(50, 50, 50);
    public static final Color ChampTexteColor = new Color(252, 252, 252);
    public static final Color ColorMiniPanels = new Color(13, 13, 30);
    public static final Color ColorButtons = new Color(255, 193, 7);
    public static final Color ColorButtonsBlue = new Color(0, 94, 183);
    public static final Color ColorError = new Color(255, 0, 0);
    public static final Color ColorStat = new Color(0, 26, 47);
    public static final Color ColorCharts = new Color(3, 22, 38);

    public static Color customColor(int r, int g, int b) {
        return new Color(r, g, b);
    }

    public static Color customColorAlpha(int r, int g, int b, int a) {
        return new Color(r, g, b, a);
    }

    public static Color getColorParNom(String nom) {
        switch (nom.toLowerCase()) {
            case "titlebarbackground":
                return TitleBarBackground;

            case "backgroundcolor":
                return BackgroundColor;

            case "scrollpane":
                return ScrollPaneColor;

            case "champtexte":
                return ChampTexteColor;

            case "colorminipanels":
                return ColorMiniPanels;

            case "colorbuttonsblue":
                return ColorButtonsBlue;

            case "colorbuttons":
                return ColorButtons;

            case "colorstat":
                return ColorStat;

            case "colorcharts":
                return ColorCharts;

            case "colorerror":
                return ColorError;
            default:
                throw new IllegalArgumentException("Nom de couleur inconnu: " + nom);
        }
    }
}
