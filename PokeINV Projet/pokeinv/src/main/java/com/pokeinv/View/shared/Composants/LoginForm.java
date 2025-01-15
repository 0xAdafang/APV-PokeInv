package com.pokeinv.View.shared.Composants;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.events.FormFieldFocusListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.Objects;

public class LoginForm extends JPanel {
    private final JButton buttonLogin;
    private final JTextField userJTextField;
    private final JPasswordField passJTextField;

    private final JLabel errorLabel;
    private String userRole;

    public LoginForm() {
        userJTextField = buildUserTextField();
        passJTextField = buildPassTextField();
        buttonLogin = getLoginButton();
        errorLabel = getErrorLabel();


        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JPanel form = buildForm();

        centerPanel.add(form, BorderLayout.CENTER);

        // SLEEPING PIKACHU
        JPanel bottomPanel = getRightBottomIllustration();
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    private JPanel buildForm() {
        JLabel userJLabel = new JLabel("Nom d'utilisateur");
        JLabel passJLabel = new JLabel("Mot de passe");
        JButton clearButton = getClearButton();

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
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 5, 10);
        form.add(buttonLogin, gbc);

        // CLEAR BUTTON

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 5, 10);
        form.add(clearButton, gbc);
        return form;
    }

    private JLabel getErrorLabel() {
        JLabel error = new JLabel("");
        error.setOpaque(true);
        error.setBorder(new CompoundBorder(
                new MatteBorder(0, 5, 0, 0, new Color(80, 1, 1)),
                new EmptyBorder(5, 5, 5, 5)));
        error.setForeground(new Color(157, 2, 2));
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setBackground(new Color(31, 1, 1));
        error.setVisible(false);
        return error;
    }

    private JPasswordField buildPassTextField() {
        JPasswordField passField = new JPasswordField("", 17);
        passField.setBackground(new Color(21, 21, 21, 50));
        passField.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                new EmptyBorder(5, 5, 5, 5)
        ));
        passField.addFocusListener(new FormFieldFocusListener(passField));
        return passField;
    }

    private JTextField buildUserTextField() {
        JTextField userField = new JTextField("", 17);
        userField.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                new EmptyBorder(5, 5, 5, 5)
        ));
        userField.setBackground(new Color(21, 21, 21, 50));
        userField.addFocusListener(new FormFieldFocusListener(userField));
        return userField;
    }

    private JLabel getLogo() {
        JLabel logo = new JLabel();
        ImageIcon ImagePokeball = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/IconApp.png")));
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

        clearButton.addActionListener(e -> reset());
        return clearButton;
    }

    public JButton getButtonLogin() {
        return buttonLogin;
    }


    private JPanel getRightBottomIllustration() {
        ImageIcon sleepingPikachu = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/Pikachu.png")));
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

    public void showFromError(String error) {
        errorLabel.setText(error);
        errorLabel.setVisible(true);
    }

    public void reset() {
        userJTextField.setText("");
        userJTextField.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                new EmptyBorder(5, 5, 5, 5)
        ));
        passJTextField.setText("");
        passJTextField.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, new Color(0, 95, 120)),
                new EmptyBorder(5, 5, 5, 5)
        ));
        errorLabel.setText("");
        errorLabel.setVisible(false);
    }

    public boolean isValidated() {
        String login = userJTextField.getText();
        String pass = new String(passJTextField.getPassword());
        if (login.isBlank()) {
            showFromError("Veuillez saisir votre nom utilisateur s'il vous plait.");
            userJTextField.setBorder(new CompoundBorder(
                    new MatteBorder(1, 1, 1, 1, new Color(105, 0, 0)),
                    new EmptyBorder(5, 5, 5, 5)
            ));
            return false;
        }
        if (pass.isBlank()) {
            showFromError("Veuillez saisir votre mot de passe s'il vous plait.");
            passJTextField.setBorder(new CompoundBorder(
                    new MatteBorder(1, 1, 1, 1, new Color(105, 0, 0)),
                    new EmptyBorder(5, 5, 5, 5)
            ));
            return false;
        }

        if (login.equals("admin") && pass.equals("admin")) {
            reset();
            userRole = "ADMIN";
            return true;
        } else if (login.equals("employe") && pass.equals("employe")) {
            reset();
            userRole = "EMPLOYEE";
            return true;
        } else {
            showFromError("Nom utilisateur ou mot de passe incorrect !");
            return false;
        }
    }

    public String getUserRole() {
        return userRole;
    }
}
