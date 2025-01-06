package com.pokeinv.View.Interface_Graphique.Interface_Principale;

import javax.swing.*;

import com.pokeinv.View.Interface_Graphique.Interface_Login.InterfacePrincipaleLogin;

import java.awt.*;
import java.io.IOException;

public class InterfacePrincipale extends JFrame {

    private InterfacePrincipaleLogin interfacePrincipaleLogin;

    public InterfacePrincipale() throws IOException {
        setTitle("PokeINV");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconApp = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        setIconImage(iconApp.getImage());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        interfacePrincipaleLogin = new InterfacePrincipaleLogin();

        mainPanel.add(interfacePrincipaleLogin, BorderLayout.CENTER);

        add(mainPanel);
        revalidate();
        repaint();

        setVisible(true);
    }

}
