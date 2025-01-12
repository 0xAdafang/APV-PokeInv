
package com.pokeinv.View.inscription;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.login.LoginView;
import com.pokeinv.View.shared.ColorManager;
import com.pokeinv.View.shared.Composants.InscriptionForm;

public class InscriptionView extends JPanel {

    public InscriptionView() throws IOException {

        initialiserComposantsLogin();
        setVisible(true);
    }

    private void initialiserComposantsLogin() throws IOException {
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(ColorManager.BackgroundColor);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(ColorManager.BackgroundColor);

        InscriptionForm inscriptionForm = new InscriptionForm(this);
        JPanel inscriptionPanel = inscriptionForm.getPanel();

        inscriptionPanel.setBackground(ColorManager.BackgroundColor);
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
        ImagePikaLabel.setBackground(ColorManager.BackgroundColor);
        ImagePikaLabel.setOpaque(true);
        bottomRightPanel.add(ImagePikaLabel, BorderLayout.EAST);
        bottomRightPanel.setBackground(ColorManager.BackgroundColor);

        JLabel logoImageLabel = new JLabel(new ImageIcon(logoImage));
        logoImageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoImageLabel.setBackground(ColorManager.BackgroundColor);
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

    public void afficherPanelAdmin(InscriptionView mainFrame) throws IOException {

        AdminView interfacePrincipaleAdmin = new AdminView();

        mainFrame.removeAll();
        mainFrame.add(interfacePrincipaleAdmin);
        mainFrame.revalidate();
        mainFrame.repaint();

    }
}