package com.pokeinv.View;

import javax.swing.*;

import com.pokeinv.View.login.LoginView;

import java.awt.*;
import java.io.IOException;

public class MainView extends JFrame {

    private LoginView interfacePrincipaleLogin;

    public MainView() throws IOException {
        setTitle("PokeINV");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconApp = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        setIconImage(iconApp.getImage());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        interfacePrincipaleLogin = new LoginView();

        mainPanel.add(interfacePrincipaleLogin, BorderLayout.CENTER);

        add(mainPanel);
        revalidate();
        repaint();

        setVisible(true);
    }

}
