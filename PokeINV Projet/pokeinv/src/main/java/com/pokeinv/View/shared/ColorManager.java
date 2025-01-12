package com.pokeinv.View.shared;

import java.awt.Color;

public class ColorManager {

    public static final Color TitleBarBackground = new Color(28, 28, 51);
    public static final Color BackgroundColor = new Color(28, 28, 51);
    public static final Color ScrollPaneColor = new Color(50, 50, 50);
    public static final Color ChampTexteColor = new Color(252, 252, 252);
    public static final Color ColorMiniPanels = new Color(12, 13, 30);
    public static final Color ColorButtons = new Color(255, 193, 7);
    public static final Color ColorError = new Color(255, 0, 0);

    public static Color customColor(int r, int g, int b) {
        return new Color(r, g, b);
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

            case "colorbuttons":
                return ColorButtons;

            case "colorerror":
                return ColorError;
            default:
                throw new IllegalArgumentException("Nom de couleur inconnu: " + nom);
        }
    }
}
