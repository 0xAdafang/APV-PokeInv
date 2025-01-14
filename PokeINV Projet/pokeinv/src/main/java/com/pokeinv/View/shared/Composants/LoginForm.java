package com.pokeinv.View.shared.Composants;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginForm extends JPanel {
    private final JButton buttonLogin;
    private final JTextField userJTextField;
    private final JPasswordField passJTextField;

    public LoginForm() {
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

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

        userJTextField = buildUserTextField();
        passJTextField = buildPassTextField();

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(28, 28, 51));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        // LOGO
        JLabel logo = getLogo();
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

        // LOGIN BUTTON
        buttonLogin = getLoginButton();

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 5, 10);
        form.add(buttonLogin, gbc);

        // CLEAR BUTTON
        JButton clearButton = getClearButton();

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 5, 10);
        form.add(clearButton, gbc);

        centerPanel.add(form, BorderLayout.CENTER);

        // SLEEPING PIKACHU
        JPanel bottomPanel = getRightBottomIllustration();
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPasswordField buildPassTextField() {
        JPasswordField passField = new JPasswordField(17);
        passField.setBackground(new Color(21, 21, 21, 50));
        passField.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                new EmptyBorder(5, 5, 5, 5)
        ));
        passField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passField.setBorder(new CompoundBorder(
                        new MatteBorder(0, 0, 3, 0, new Color(0, 95, 120)),
                        new EmptyBorder(5, 5, 5, 5)
                ));
                passField.setBackground(new Color(35, 35, 70, 137));
            }

            @Override
            public void focusLost(FocusEvent e) {
                passField.setBorder(new CompoundBorder(
                        new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                        new EmptyBorder(5, 5, 5, 5)
                ));
                passField.setBackground(new Color(21, 21, 21, 50));
            }
        });

        return passField;
    }

    private JTextField buildUserTextField() {
        JTextField userField = new JTextField(17);
        userField.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                new EmptyBorder(5, 5, 5, 5)
        ));
        userField.setBackground(new Color(21, 21, 21, 50));
        userField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                userField.setBorder(new CompoundBorder(
                        new MatteBorder(0, 0, 3, 0, new Color(0, 95, 120)),
                        new EmptyBorder(5, 5, 5, 5)
                ));
                userField.setBackground(new Color(35, 35, 70, 137));
            }

            @Override
            public void focusLost(FocusEvent e) {
                userField.setBorder(new CompoundBorder(
                        new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                        new EmptyBorder(5, 5, 5, 5)
                ));
                userField.setBackground(new Color(21, 21, 21, 50));
            }
        });
        return userField;
    }

    private JLabel getLogo() {
        JLabel logo = new JLabel();
        ImageIcon ImagePokeball = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        Image ImagePokeballImage = ImagePokeball.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(ImagePokeballImage));
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 110));
        logo.setBackground(new Color(28, 28, 51));
        logo.setOpaque(true);
        return logo;
    }

    private JButton getLoginButton() {
        JButton buttonLogin = new JButton("Se connecter");
        buttonLogin.setOpaque(true);
        buttonLogin.setBackground(new Color(0, 95, 120));
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonLogin.setFocusPainted(false);
        buttonLogin.setIcon(new FlatSVGIcon("icons/login.svg", 20, 20));
        buttonLogin.setIconTextGap(15);
        return buttonLogin;
    }

    private JButton getClearButton() {
        JButton clearButton = new JButton("Effacer");
        clearButton.setOpaque(true);
        clearButton.setBackground(new Color(35, 35, 70));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        clearButton.setFocusPainted(false);
        clearButton.setIcon(new FlatSVGIcon("icons/trash.svg", 20, 20));
        return clearButton;
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

    private JPanel getRightBottomIllustration() {
        ImageIcon sleepingPikachu = new ImageIcon(getClass().getResource("/icons/Pikachu.png"));
        Image sleepingPikachuImage = sleepingPikachu.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        JLabel illustration = new JLabel();
        illustration.setIcon(new ImageIcon(sleepingPikachuImage));
        illustration.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 110));
        illustration.setBackground(new Color(28, 28, 51));
        illustration.setOpaque(true);
        illustration.setPreferredSize(new Dimension(140, 140));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel bottomEastPanel = new JPanel();
        bottomEastPanel.add(illustration);
        bottomEastPanel.setBackground(new Color(28, 28, 51));
        bottomEastPanel.setPreferredSize(new Dimension(140, 140));
        bottomPanel.add(bottomEastPanel, BorderLayout.EAST);
        bottomPanel.setBackground(new Color(28, 28, 51));
        return bottomPanel;
    }
}
