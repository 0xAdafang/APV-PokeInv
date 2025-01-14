package com.pokeinv.View.shared.Composants;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.shared.ColorManager;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class LoginForm extends JPanel {
    private final JButton buttonLogin;
    private final JTextField userJTextField;
    private final JPasswordField passJTextField;

    public LoginForm() {
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel errorLabel = new JLabel("Pour afficher les erreurs");
        errorLabel.setOpaque(true);
        errorLabel.setBorder(new CompoundBorder(
                new MatteBorder(0, 5, 0, 0, new Color(80, 1, 1)),
                new EmptyBorder(5, 5, 5, 5)));
        errorLabel.setForeground(new Color(80, 0, 0));
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setBackground(new Color(31, 1, 1));
        errorLabel.setVisible(false);

        JLabel userJLabel = new JLabel("Nom d'utilisateur");
        JLabel passJLabel = new JLabel("Mot de passe");

        userJTextField = new JTextField(17);
        passJTextField = new JPasswordField(17);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(28, 28, 51));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        // Logo
        ImageIcon ImagePokeball = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        Image ImagePokeballImage = ImagePokeball.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(ImagePokeballImage));
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 110));
        logo.setBackground(new Color(28, 28, 51));
        logo.setOpaque(true);
        gbc.gridx = 1;
        gbc.gridy = 0;
        form.add(logo, gbc);

        // ERREUR
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        form.add(errorLabel, gbc);

        // USERNAME
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        form.add(userJLabel, gbc);
        gbc.gridx = 1;
        form.add(userJTextField, gbc);

        // PASSWORD
        gbc.gridy = 3;
        gbc.gridx = 0;

        form.add(passJLabel, gbc);
        gbc.gridx = 1;
        form.add(passJTextField, gbc);

        buttonLogin = new JButton("Se connecter");
        buttonLogin.setOpaque(true);
        buttonLogin.setBackground(ColorManager.ColorButtonsBlue);
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonLogin.setFocusPainted(false);
        buttonLogin.setIcon(new FlatSVGIcon("icons/login.svg"));
        buttonLogin.setIconTextGap(15);

        gbc.gridx = 0;
        gbc.gridy = 4; // Décalé d'une ligne vers le bas
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 10, 5, 10);

        form.add(buttonLogin, gbc);
        add(form, BorderLayout.CENTER);
    }

    public JButton getButtonLogin() {
        return buttonLogin;
    }

    public JTextField getUserJTextField() {
        return userJTextField;
    }

    public JPasswordField getPassJTextField() {
        return passJTextField;
    }
}
