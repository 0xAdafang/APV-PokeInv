package Interface_Graphique.Composants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Interface_Graphique.InterfacePrincipaleLogin;

public class LoginForm {
    private JPanel panelLogin;
    private JTextField userJTextField;
    private JPasswordField passJTextField;
    private JLabel notification;
    private ImageIcon Logo;

    public LoginForm(InterfacePrincipaleLogin mainFrame) {

        // Logo
        Logo = new ImageIcon("src/main/donnees/IconApp.png");
        Image LogoImage = Logo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(LogoImage));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoLabel.setBackground(new Color(28, 28, 51));
        logoLabel.setOpaque(true);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel userJLabel = new JLabel("Nom d'utilisateur");
        userJLabel.setOpaque(true);
        userJLabel.setBackground(new Color(28, 28, 51));
        userJLabel.setForeground(Color.WHITE);
        userJLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel passJLabel = new JLabel("Mot de passe");
        passJLabel.setOpaque(true);
        passJLabel.setBackground(new Color(28, 28, 51));
        passJLabel.setForeground(Color.WHITE);
        passJLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        userJTextField = new JTextField(15);
        passJTextField = new JPasswordField(15);

        JButton b1 = new JButton("Connexion");
        b1.setOpaque(true);
        b1.setBackground(new Color(0, 94, 183));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b1.setFocusPainted(false);

        notification = new JLabel();

        // Organisation des composants
        panelLogin = new JPanel(new GridLayout(6, 2));
        panelLogin.add(logoLabel);
        panelLogin.add(userJLabel);
        panelLogin.add(userJTextField);
        panelLogin.add(passJLabel);
        panelLogin.add(passJTextField);
        panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
        panelLogin.add(b1);
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
                    } else {
                        mainFrame.afficherConnexionEchouee();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel() {
        return panelLogin;
    }
}
