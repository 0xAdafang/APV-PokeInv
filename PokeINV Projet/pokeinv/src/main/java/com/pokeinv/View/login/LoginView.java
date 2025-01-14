package com.pokeinv.View.login;

import com.pokeinv.View.MainView;
import com.pokeinv.View.shared.Composants.LoginForm;
import com.pokeinv.View.shared.Composants.Notification;
import com.pokeinv.events.login.LoginSuccessEvent;
import com.pokeinv.events.login.LoginSuccessListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LoginView extends JPanel {
    private final List<LoginSuccessListener> listeners = new ArrayList<>();
    private final LoginForm form = new LoginForm();
    MainView mainView;

    public LoginView(MainView mainView) {
        this.mainView = mainView;
        initialiserComposantsLogin();

        setVisible(true);
    }

    private void initialiserComposantsLogin() {
        setLayout(new BorderLayout());
        setBackground(new Color(28, 28, 51));

        JButton loginButton = form.getButtonLogin();
        add(form);
        loginButton.addActionListener(e -> {
            String login = form.getUserJTextField().getText();
            String pass = new String(form.getPassJTextField().getPassword());
            if (login.equals("admin") && pass.equals("admin")) {
                fireLoginSuccessEvent("ADMIN");
            } else if (login.equals("employe") && pass.equals("employe")) {
                fireLoginSuccessEvent("EMPLOYEE");
            } else {
                Notification.showNotification("Veuillez bien renseigner les champs SVP", Notification.ERROR);
            }
        });

        add(form, BorderLayout.CENTER);
        addLoginSuccessListener(mainView);
//        JPanel centerPanel = new JPanel(new GridBagLayout());
//        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
//        centerPanel.setBackground(new Color(28, 28, 51));
//
//        LoginForm loginForm = new LoginForm(this);
//        JPanel loginPanel = loginForm.getPanel();
//
//        loginPanel.setBackground(new Color(28, 28, 51));
//        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
//
//        // Images decoratives
//        ImageIcon ImagePika = new ImageIcon(getClass().getResource("/icons/Pikachu.png"));
//        Image ImagePikaImage = ImagePika.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        ImageIcon logo = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
//        Image logoImage = logo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
//
//        JPanel bottomRightPanel = new JPanel(new BorderLayout());
//
//        JLabel ImagePikaLabel = new JLabel(new ImageIcon(ImagePikaImage));
//        ImagePikaLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        ImagePikaLabel.setBackground(new Color(28, 28, 51));
//        ImagePikaLabel.setOpaque(true);
//        bottomRightPanel.add(ImagePikaLabel, BorderLayout.EAST);
//        bottomRightPanel.setBackground(new Color(28, 28, 51));
//
//        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
//        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        logoLabel.setBackground(new Color(28, 28, 51));
//        logoLabel.setOpaque(true);
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 1;
//        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
//        gbc.anchor = GridBagConstraints.CENTER;
//        centerPanel.add(logoLabel, gbc);
//
//        gbc.gridy = 1;
//        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
//        gbc.anchor = GridBagConstraints.CENTER;
//        centerPanel.add(loginPanel, gbc);
//
//        mainPanel.add(centerPanel, BorderLayout.CENTER);
//        mainPanel.add(bottomRightPanel, BorderLayout.SOUTH);
//
//        setLayout(new BorderLayout());
//        add(mainPanel);
    }


    public void addLoginSuccessListener(LoginSuccessListener listener) {
        listeners.add(listener);
    }

    public void removeLoginSuccessListener(LoginSuccessListener listener) {
        listeners.remove(listener);
    }

    private void fireLoginSuccessEvent(String role) {
        LoginSuccessEvent event = new LoginSuccessEvent(this, role);
        for (LoginSuccessListener listener : listeners) {
            listener.loginSuccess(event);
        }
    }

}