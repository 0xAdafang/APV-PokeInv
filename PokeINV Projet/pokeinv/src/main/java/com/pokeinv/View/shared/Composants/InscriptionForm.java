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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pokeinv.View.inscription.InscriptionView;

public class InscriptionForm {
    private JPanel panelInscription;
    private JTextField userJTextField;
    private JPasswordField passJTextField;
    private JLabel notification;

    public InscriptionForm(InscriptionView mainFrame) {

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

        JButton buttonInscription = new JButton("Inscription");
        buttonInscription.setOpaque(true);
        buttonInscription.setBackground(new Color(0, 94, 183));
        buttonInscription.setForeground(Color.WHITE);
        buttonInscription.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonInscription.setFocusPainted(false);

        JButton buttonAnnuler = new JButton("Annuler");
        buttonAnnuler.setOpaque(true);
        buttonAnnuler.setBackground(new Color(0, 94, 183));
        buttonAnnuler.setForeground(Color.WHITE);
        buttonAnnuler.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonAnnuler.setFocusPainted(false);

        // Organisation des boutons
        JPanel labelButtons = new JPanel();
        labelButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelButtons.setBackground(new Color(28, 28, 51));
        labelButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelButtons.add(buttonInscription);
        labelButtons.add(buttonAnnuler);

        notification = new JLabel();

        // Organisation des composants
        panelInscription = new JPanel(new GridLayout(6, 2));
        panelInscription.add(userJLabel, BorderLayout.CENTER);
        panelInscription.add(userJTextField, BorderLayout.CENTER);
        panelInscription.add(passJLabel, BorderLayout.CENTER);
        panelInscription.add(passJTextField, BorderLayout.CENTER);
        panelInscription.add(Box.createRigidArea(new Dimension(0, 10)));
        panelInscription.add(labelButtons, BorderLayout.SOUTH);
        panelInscription.add(notification);
        panelInscription.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttonInscription.addActionListener(new ActionListener() {
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
                    userJTextField.setMaximumSize(userJTextField.getPreferredSize());
                    passJTextField.setText("");
                    passJTextField.setMaximumSize(passJTextField.getPreferredSize());
                } else if (user.equals("admin") || user.equals("employe") || user.equals("user")) {
                    notification.setText("Nom d'utilisateur déjà utilisé.");
                    notification.setForeground(Color.RED);
                    notification.add(Box.createRigidArea(new Dimension(0, 10)));
                    notification.setAlignmentX(0.5f);
                    userJTextField.setText("");
                    userJTextField.setMaximumSize(userJTextField.getPreferredSize());
                    passJTextField.setText("");
                    passJTextField.setMaximumSize(passJTextField.getPreferredSize());
                } else if (user.equals("test1") || pass.equals("test1")) {
                    JOptionPane.showMessageDialog(null, "Inscription réussie.");
                    notification.setForeground(Color.GREEN);
                    notification.add(Box.createRigidArea(new Dimension(0, 10)));
                    notification.setAlignmentX(0.5f);
                    try {
                        mainFrame.afficherPanelAdmin(mainFrame);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    notification.setText("Inscription réussie.");
                }
            }
        });

        buttonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainFrame.afficherPanelAdmin(mainFrame);
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
