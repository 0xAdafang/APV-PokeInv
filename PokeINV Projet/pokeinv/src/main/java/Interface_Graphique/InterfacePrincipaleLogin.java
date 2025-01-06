package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import Interface_Graphique.Composants.LoginForm;

public class InterfacePrincipaleLogin extends JFrame {

    public InterfacePrincipaleLogin() throws IOException {
        setTitle("PokeINV");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconApp = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
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

        // Images decoratives
        ImageIcon ImagePika = new ImageIcon(getClass().getResource("/icons/Pikachu.png"));
        Image ImagePikaImage = ImagePika.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        JPanel bottomRightPanel = new JPanel(new BorderLayout());

        JLabel ImagePikaLabel = new JLabel(new ImageIcon(ImagePikaImage));
        ImagePikaLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ImagePikaLabel.setBackground(new Color(28, 28, 51));
        ImagePikaLabel.setOpaque(true);
        bottomRightPanel.add(ImagePikaLabel, BorderLayout.EAST);
        bottomRightPanel.setBackground(new Color(28, 28, 51));

        centerPanel.add(loginPanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomRightPanel, BorderLayout.SOUTH);

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

    public void afficherConnexionReussieEmploye() throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion avec employe");
        dispose();
        FlatLightLaf.setup();
        InterfacePrincipaleEmploye interfacePrincipaleEmploye = new InterfacePrincipaleEmploye();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleEmploye.getRootPane().putClientProperty("JRootPane.titleBarBackground",
                new Color(28, 28, 51));
        interfacePrincipaleEmploye.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

    public void afficherConnexionReussieUser() throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion avec utilsateur simple");
        dispose();
        FlatLightLaf.setup();
        InterfacePrincipaleUser interfacePrincipaleUser = new InterfacePrincipaleUser();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleUser.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipaleUser.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

    public void afficherPanelInscription() throws IOException {
        dispose();
        FlatLightLaf.setup();
        InterfacePrincipaleInscription interfacePrincipaleInscription = new InterfacePrincipaleInscription();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleInscription.getRootPane().putClientProperty("JRootPane.titleBarBackground",
                new Color(28, 28, 51));
        interfacePrincipaleInscription.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

}