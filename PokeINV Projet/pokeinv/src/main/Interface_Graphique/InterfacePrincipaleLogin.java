package Interface_Graphique;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import Interface_Graphique.Composants.LoginForm;

import java.awt.*;
import java.io.*;

public class InterfacePrincipaleLogin extends JFrame {

    public InterfacePrincipaleLogin() throws IOException {
        setTitle("PokeINV");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconApp = new ImageIcon("src/main/donnees/IconApp.png");
        setIconImage(iconApp.getImage());
        setLocationRelativeTo(null);
        initialiserComposantsLogin();
        setVisible(true);
    }

    private void initialiserComposantsLogin() throws IOException {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));

        LoginForm loginForm = new LoginForm(this);
        JPanel loginPanel = loginForm.getPanel();

        loginPanel.setBackground(new Color(28, 28, 51));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        centerPanel.add(loginPanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public void afficherConnexionReussieAdmin() throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion réussie");
        dispose();
        FlatLightLaf.setup();
        InterfacePrincipaleAdmin interfacePrincipaleAdmin = new InterfacePrincipaleAdmin();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleAdmin.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipaleAdmin.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

    public void afficherConnexionEchouee() throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion avec utilsateur regulier");
        dispose();
        FlatLightLaf.setup();
        InterfacePrincipaleUser interfacePrincipaleUser = new InterfacePrincipaleUser();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleUser.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipaleUser.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

}