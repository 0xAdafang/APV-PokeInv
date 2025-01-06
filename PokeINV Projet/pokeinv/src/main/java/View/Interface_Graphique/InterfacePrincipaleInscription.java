
package View.Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
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

import View.Interface_Graphique.Composants.InscriptionForm;

public class InterfacePrincipaleInscription extends JPanel {

    public InterfacePrincipaleInscription() throws IOException {

        initialiserComposantsLogin();
        setVisible(true);
    }

    private void initialiserComposantsLogin() throws IOException {
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));

        InscriptionForm inscriptionForm = new InscriptionForm(this);
        JPanel inscriptionPanel = inscriptionForm.getPanel();

        inscriptionPanel.setBackground(new Color(28, 28, 51));
        inscriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inscriptionPanel.setLayout(new BoxLayout(inscriptionPanel, BoxLayout.Y_AXIS));

        // Images decoratives
        ImageIcon ImagePika = new ImageIcon(getClass().getResource("/icons/Pikachu.png"));
        Image ImagePikaImage = ImagePika.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        Image logoImage = logo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

        JPanel bottomRightPanel = new JPanel(new BorderLayout());

        JLabel ImagePikaLabel = new JLabel(new ImageIcon(ImagePikaImage));
        ImagePikaLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ImagePikaLabel.setBackground(new Color(28, 28, 51));
        ImagePikaLabel.setOpaque(true);
        bottomRightPanel.add(ImagePikaLabel, BorderLayout.EAST);
        bottomRightPanel.setBackground(new Color(28, 28, 51));

        JLabel logoImageLabel = new JLabel(new ImageIcon(logoImage));
        logoImageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoImageLabel.setBackground(new Color(28, 28, 51));
        logoImageLabel.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(logoImageLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(inscriptionPanel, gbc);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomRightPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public void afficherConnexionReussieAdmin() throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion réussie");
        FlatLightLaf.setup();
        InterfacePrincipaleAdmin interfacePrincipaleAdmin = new InterfacePrincipaleAdmin();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleAdmin.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipaleAdmin.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

    public void afficherConnexionReussieEmploye() throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion avec utilsateur regulier");
        FlatLightLaf.setup();
        InterfacePrincipaleEmploye interfacePrincipaleEmploye = new InterfacePrincipaleEmploye();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleEmploye.getRootPane().putClientProperty("JRootPane.titleBarBackground",
                new Color(28, 28, 51));
        interfacePrincipaleEmploye.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

    public void afficherConnexionReussieUser() throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion avec utilsateur simple");
        FlatLightLaf.setup();
        InterfacePrincipaleUser interfacePrincipaleUser = new InterfacePrincipaleUser();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleUser.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipaleUser.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

    public void afficherPanelLogin() throws IOException {
        InterfacePrincipaleLogin interfacePrincipaleLogin = new InterfacePrincipaleLogin();
        JFrame.setDefaultLookAndFeelDecorated(true);
        interfacePrincipaleLogin.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        interfacePrincipaleLogin.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);

    }

}