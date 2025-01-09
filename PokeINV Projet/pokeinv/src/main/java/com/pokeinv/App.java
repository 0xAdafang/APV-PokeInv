package com.pokeinv;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.View.MainView;

import javax.swing.*;
import java.awt.*;


public class App {
    public static void main(String[] args) throws Exception {
        FlatLightLaf.setup();
        MainView interfacePrincipale = new MainView();

        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipale.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipale.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }
}
