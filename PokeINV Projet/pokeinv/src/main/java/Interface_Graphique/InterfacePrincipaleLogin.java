package Interface_Graphique;

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
        ImageIcon logo = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        Image logoImage = logo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

        JPanel bottomRightPanel = new JPanel(new BorderLayout());

        JLabel ImagePikaLabel = new JLabel(new ImageIcon(ImagePikaImage));
        ImagePikaLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ImagePikaLabel.setBackground(new Color(28, 28, 51));
        ImagePikaLabel.setOpaque(true);
        bottomRightPanel.add(ImagePikaLabel, BorderLayout.EAST);
        bottomRightPanel.setBackground(new Color(28, 28, 51));

        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoLabel.setBackground(new Color(28, 28, 51));
        logoLabel.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(logoLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(loginPanel, gbc);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomRightPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public void afficherConnexionReussieAdmin(JFrame mainFrame) throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion réussie");
        FlatLightLaf.setup();
        InterfacePrincipaleAdmin interfacePrincipaleAdmin = new InterfacePrincipaleAdmin();

        mainFrame.setTitle("PokeINV ADMIN");
        mainFrame.getContentPane().removeAll();
        mainFrame.setContentPane(interfacePrincipaleAdmin);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void afficherConnexionReussieEmploye(JFrame mainFrame) throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion avec employe");
        InterfacePrincipaleEmploye interfacePrincipaleEmploye = new InterfacePrincipaleEmploye();

        mainFrame.setTitle("PokeINV EMPLOYE");
        mainFrame.getContentPane().removeAll();
        mainFrame.setContentPane(interfacePrincipaleEmploye);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void afficherConnexionReussieUser(JFrame mainFrame) throws IOException {
        JOptionPane.showMessageDialog(null, "Connexion avec utilsateur simple");
        InterfacePrincipaleUser interfacePrincipaleUser = new InterfacePrincipaleUser();

        mainFrame.setTitle("PokeINV USER");
        mainFrame.getContentPane().removeAll();
        mainFrame.setContentPane(interfacePrincipaleUser);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void afficherPanelInscription(JFrame mainFrame) throws IOException {
        InterfacePrincipaleInscription interfacePrincipaleInscription = new InterfacePrincipaleInscription();

        mainFrame.setTitle("PokeINV INSCRIPTION");
        mainFrame.getContentPane().removeAll();
        mainFrame.setContentPane(interfacePrincipaleInscription);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

}