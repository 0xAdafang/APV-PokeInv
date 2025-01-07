package com.pokeinv.View.shared.Composants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pokeinv.View.login.LoginView;

public class LoginForm {
    private JPanel panelLogin;
    private JTextField userJTextField;
    private JPasswordField passJTextField;
    private JLabel notification;

    public LoginForm(LoginView mainFrame) {

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

        userJTextField = new JTextField(17);
        passJTextField = new JPasswordField(17);

        JButton buttonLogin = new JButton("Se connecter");
        buttonLogin.setOpaque(true);
        buttonLogin.setBackground(new Color(0, 94, 183));
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonLogin.setFocusPainted(false);

        JButton buttonInscription = new JButton("S'inscrire");
        buttonInscription.setOpaque(true);
        buttonInscription.setBackground(new Color(0, 94, 183));
        buttonInscription.setForeground(Color.WHITE);
        buttonInscription.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonInscription.setFocusPainted(false);

        // organisation des buttons
        JPanel labelButtons = new JPanel();
        labelButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelButtons.setBackground(new Color(28, 28, 51));
        labelButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelButtons.add(buttonLogin);
        labelButtons.add(buttonInscription);

        notification = new JLabel();

        // organisation des composants
        panelLogin = new JPanel(new GridLayout(6, 2));
        panelLogin.add(userJLabel, BorderLayout.CENTER);
        panelLogin.add(userJTextField, BorderLayout.CENTER);
        panelLogin.add(passJLabel, BorderLayout.CENTER);
        panelLogin.add(passJTextField, BorderLayout.CENTER);
        panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
        panelLogin.add(labelButtons, BorderLayout.SOUTH);
        panelLogin.add(notification);
        panelLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userJTextField.getText();
                String password = new String(passJTextField.getPassword());

                if (username.equals("admin") && password.equals("admin")) {
                    try {
                        mainFrame.afficherConnexionReussieAdmin(mainFrame);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                } else if (username.equals("employe") && password.equals("employe")) {
                    try {
                        mainFrame.afficherConnexionReussieEmploye(mainFrame);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                } else if (username.equals("") || password.equals("")) {
                    notification.setText("Veuillez remplir tous les champs.");
                    notification.setForeground(Color.RED);
                    notification.add(Box.createRigidArea(new Dimension(0, 10)));
                    notification.setAlignmentX(0.5f);
                    userJTextField.setText("");
                    userJTextField.setMaximumSize(userJTextField.getPreferredSize());
                    passJTextField.setText("");
                    passJTextField.setMaximumSize(userJTextField.getPreferredSize());
                    return;
                } else {
                    notification.setText("Nom d'utilisateur ou mot de passe incorrect.");
                    notification.setForeground(Color.RED);
                    notification.add(Box.createRigidArea(new Dimension(0, 10)));
                    notification.setAlignmentX(0.5f);
                    userJTextField.setText("");
                    userJTextField.setMaximumSize(userJTextField.getPreferredSize());
                    passJTextField.setText("");
                    passJTextField.setMaximumSize(userJTextField.getPreferredSize());
                }
            }
        });

        buttonInscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainFrame.afficherPanelInscription(mainFrame);
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
