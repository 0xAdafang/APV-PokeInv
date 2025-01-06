package com.pokeinv;

import java.awt.Color;
import javax.swing.JFrame;
import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.View.Interface_Graphique.Interface_Principale.InterfacePrincipale;

public class App {
    public static void main(String[] args) throws Exception {
        FlatLightLaf.setup();
        InterfacePrincipale interfacePrincipale = new InterfacePrincipale();

        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipale.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipale.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }
}
