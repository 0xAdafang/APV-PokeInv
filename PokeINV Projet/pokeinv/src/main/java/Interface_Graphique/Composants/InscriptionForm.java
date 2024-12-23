package Interface_Graphique.Composants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Interface_Graphique.InterfacePrincipaleInscription;

public class InscriptionForm {
    private JPanel panelInscription;
    private JTextField userJTextField;
    private JPasswordField passJTextField;
    private JLabel notification;
    private ImageIcon Logo;

    public InscriptionForm(InterfacePrincipaleInscription mainFrame) {
    // Logo
        Logo = new ImageIcon("src/main/java/donnees/IconApp.png");
        Image LogoImage = Logo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(LogoImage));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoLabel.setBackground(new Color(28, 28, 51));
        logoLabel.setOpaque(true);
        logoLabel.setAlignmentX(0.5f);

        JLabel userJLabel = new JLabel("Nom d'utilisateur");
        userJLabel.setOpaque(true);
        userJLabel.setBackground(new Color(28, 28, 51));
        userJLabel.setForeground(Color.WHITE);
        userJLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        userJLabel.setAlignmentX(0.5f);

        JLabel passJLabel = new JLabel("Mot de passe");
        passJLabel.setOpaque(true);
        passJLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        passJLabel.setBackground(new Color(28, 28, 51));
        passJLabel.setForeground(Color.WHITE);
        passJLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        passJLabel.setAlignmentX(0.5f);

        userJTextField = new JTextField(15);
        passJTextField = new JPasswordField(15);

        JButton b1 = new JButton("Inscription");
        b1.setOpaque(true);
        b1.setBackground(new Color(0, 94, 183));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b1.setFocusPainted(false);

        JButton b2 = new JButton("Annuler");
        b2.setOpaque(true);
        b2.setBackground(new Color(0, 94, 183));
        b2.setForeground(Color.WHITE);
        b2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b2.setFocusPainted(false);

        // Organisation des boutons
        JPanel labelButtons = new JPanel();
        labelButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelButtons.setBackground(new Color(28, 28, 51));
        labelButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelButtons.add(b1);
        labelButtons.add(b2);

        notification = new JLabel();

        // Organisation des composants
        panelInscription = new JPanel(new GridLayout(6, 2));
        panelInscription.add(logoLabel, BorderLayout.NORTH);
        panelInscription.add(userJLabel, BorderLayout.CENTER);
        panelInscription.add(userJTextField, BorderLayout.CENTER);
        panelInscription.add(passJLabel, BorderLayout.CENTER);
        panelInscription.add(passJTextField, BorderLayout.CENTER);
        panelInscription.add(Box.createRigidArea(new Dimension(0, 10)));
        panelInscription.add(labelButtons, BorderLayout.SOUTH);
        panelInscription.add(notification);
        panelInscription.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userJTextField.getText();
                String pass = new String(passJTextField.getPassword());

                if (user.isEmpty() || pass.isEmpty()) {
                    notification.setText("Veuillez remplir tous les champs.");
                        notification.setForeground(Color.RED);
                        notification.add(Box.createRigidArea(new Dimension(0, 10)));
                        notification.setAlignmentX(0.5f);
                        userJTextField.setText("");
                        passJTextField.setText("");
                } else if (user.equals("admin") || user.equals("employe") || user.equals("user")) {
                    notification.setText("Nom d'utilisateur déjà utilisé.");
                    notification.setForeground(Color.RED);
                    notification.add(Box.createRigidArea(new Dimension(0, 10)));
                    notification.setAlignmentX(0.5f);
                    userJTextField.setText("");
                    passJTextField.setText("");
                } else if (user.equals("test1") || pass.equals("test1")) {
                    notification.setText("Inscription réussie.");
                    notification.setForeground(Color.GREEN);
                    notification.add(Box.createRigidArea(new Dimension(0, 10)));
                    notification.setAlignmentX(0.5f);
                    try {
                        mainFrame.afficherConnexionReussieAdmin();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    notification.setText("Inscription réussie.");
                    try {
                        mainFrame.afficherConnexionReussieUser();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainFrame.afficherPanelLogin();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel() {
        return panelInscription;
    }
}
