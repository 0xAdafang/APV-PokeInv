package com.pokeinv;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.View.MainView;
import com.pokeinv.View.shared.ColorManager;

import javax.swing.*;
import java.awt.*;


public class App {
    public static void main(String[] args) throws Exception {
        FlatLightLaf.setup();
        MainView interfacePrincipale = new MainView();

        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipale.getRootPane().putClientProperty("JRootPane.titleBarBackground", ColorManager.TitleBarBackground);
        interfacePrincipale.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }
}
