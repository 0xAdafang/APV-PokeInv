package poke;

import java.awt.Color;

import javax.swing.JFrame;

import com.formdev.flatlaf.FlatLightLaf;

import View.Interface_Graphique.InterfacePrincipaleLogin;

public class App {
    public static void main(String[] args) throws Exception {
        FlatLightLaf.setup();
        InterfacePrincipaleLogin interfacePrincipale = new InterfacePrincipaleLogin();

        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipale.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipale.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }
}
