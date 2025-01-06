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

import Interface_Graphique.InterfacePrincipaleLogin;

public class LoginForm {
    private JPanel panelLogin;
    private JTextField userJTextField;
    private JPasswordField passJTextField;
    private JLabel notification;
    private ImageIcon Logo;

    public LoginForm(InterfacePrincipaleLogin mainFrame) {
        // Logo
        Logo = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
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

        JButton b1 = new JButton("Connexion");
        b1.setOpaque(true);
        b1.setBackground(new Color(0, 94, 183));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b1.setFocusPainted(false);

        JButton b2 = new JButton("Inscription");
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
        panelLogin = new JPanel(new GridLayout(6, 2));
        panelLogin.add(logoLabel, BorderLayout.NORTH);
        panelLogin.add(userJLabel, BorderLayout.CENTER);
        panelLogin.add(userJTextField, BorderLayout.CENTER);
        panelLogin.add(passJLabel, BorderLayout.CENTER);
        panelLogin.add(passJTextField, BorderLayout.CENTER);
        panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
        panelLogin.add(labelButtons, BorderLayout.SOUTH);
        panelLogin.add(notification);
        panelLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userJTextField.getText();
                String password = new String(passJTextField.getPassword());

                try {
                    if (username.equals("admin") && password.equals("admin")) {
                        mainFrame.afficherConnexionReussieAdmin();
                    } else if (username.equals("employe") && password.equals("employe")) {
                        mainFrame.afficherConnexionReussieEmploye();
                    } else if (username.equals("user") && password.equals("user")) {
                        mainFrame.afficherConnexionReussieUser();
                    } else if (username.equals("") || password.equals("")) {
                        notification.setText("Veuillez remplir tous les champs.");
                        notification.setForeground(Color.RED);
                        notification.add(Box.createRigidArea(new Dimension(0, 10)));
                        notification.setAlignmentX(0.5f);
                        userJTextField.setText("");
                        passJTextField.setText("");
                        return;
                    } else {
                        notification.setText("Nom d'utilisateur ou mot de passe incorrect.");
                        notification.setForeground(Color.RED);
                        notification.add(Box.createRigidArea(new Dimension(0, 10)));
                        notification.setAlignmentX(0.5f);
                        userJTextField.setText("");
                        passJTextField.setText("");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainFrame.afficherPanelInscription();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

        public JPanel getPanel() {
            return panelLogin;
        }
    }
    


