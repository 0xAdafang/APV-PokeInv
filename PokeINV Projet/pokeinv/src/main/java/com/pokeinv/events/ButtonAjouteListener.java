package com.pokeinv.events;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.Model.entity.*;

public class ButtonAjouteListener implements ActionListener {

    private JTextField nom, prix;
    private JComboBox<Collection> collection;
    private JComboBox<TypeCarte> type;
    private JComboBox<Rarete> rarete;
    private JComboBox<GradePSA> gradePSA;
    private JComboBox<Etat> etat;
    private JDialog dialog;

    public ButtonAjouteListener() {
        FlatLightLaf.setup();

        // Panel dialog
        dialog = new JDialog();
        dialog.setTitle("Ajouter une carte");
        dialog.setSize(new Dimension(500, 500));
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.setBackground(new Color(28, 28, 51));
        dialog.setIconImage(new ImageIcon(getClass().getResource("/icons/iconApp.png")).getImage());
        dialog.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        dialog.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);

        // Panel central
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(28, 28, 51));

        // Constraints pour le panel
        GridBagConstraints constraintsAjoute = new GridBagConstraints();
        constraintsAjoute.insets = new Insets(5, 10, 5, 10);
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 0;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        constraintsAjoute.fill = GridBagConstraints.BOTH;

        // Dimension
        Dimension dimension = new Dimension(200, 20);

        // Ajout des labels et textfield
        JLabel nomLabel = new JLabel("Nom : ");
        nomLabel.setForeground(Color.WHITE);
        panel.add(nomLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        nom = new JTextField(15);
        nom.setPreferredSize(dimension);
        panel.add(nom, constraintsAjoute);

        // Ajout ComboBox de collection
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 1;
        JLabel collectionLabel = new JLabel("Collection : ");
        collectionLabel.setForeground(Color.WHITE);
        panel.add(collectionLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        collection = new JComboBox<>();
        collection.setPreferredSize(dimension);
        collection.addItem(new Collection(1L, "Base Set"));
        collection.addItem(new Collection(2L, "Fossil"));
        collection.addItem(new Collection(3L, "Base Set 2"));
        collection.addItem(new Collection(4L, "Jungle"));
        collection.addItem(new Collection(5L, "Team Rocket"));
        panel.add(collection, constraintsAjoute);

        // Ajout ComboBox de type
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 2;
        JLabel typeLabel = new JLabel("Type de carte : ");
        typeLabel.setForeground(Color.WHITE);
        panel.add(typeLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        type = new JComboBox<>(TypeCarte.values());
        type.setPreferredSize(dimension);
        panel.add(type, constraintsAjoute);

        // Ajout ComboBox de rarete
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 3;
        JLabel rareteLabel = new JLabel("Rarete : ");
        rareteLabel.setForeground(Color.WHITE);
        panel.add(rareteLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        rarete = new JComboBox<>(Rarete.values());
        rarete.setPreferredSize(dimension);
        panel.add(rarete, constraintsAjoute);

        // Ajout ComboBox de grade PSA
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 4;
        JLabel gradePSALabel = new JLabel("Grade PSA : ");
        gradePSALabel.setForeground(Color.WHITE);
        panel.add(gradePSALabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        gradePSA = new JComboBox<>(GradePSA.values());
        gradePSA.setPreferredSize(dimension);
        panel.add(gradePSA, constraintsAjoute);

        // Ajout ComboBox de etat
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 5;
        JLabel etatLabel = new JLabel("Etat : ");
        etatLabel.setForeground(Color.WHITE);
        panel.add(etatLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        etat = new JComboBox<>(Etat.values());
        etat.setPreferredSize(dimension);
        panel.add(etat, constraintsAjoute);

        // Ajout TextField de prix
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 6;
        JLabel prixLabel = new JLabel("Prix : ");
        prixLabel.setForeground(Color.WHITE);
        panel.add(prixLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        prix = new JTextField(15);
        prix.setPreferredSize(dimension);
        panel.add(prix, constraintsAjoute);

        // Ajout des boutons
        JPanel panelBoutons = new JPanel(new GridBagLayout());
        panelBoutons.setBackground(new Color(28, 28, 51));
        GridBagConstraints constraintsBoutons = new GridBagConstraints();
        constraintsBoutons.gridx = 0;
        constraintsBoutons.gridy = 0;
        constraintsBoutons.anchor = GridBagConstraints.CENTER;
        constraintsBoutons.insets = new Insets(5, 10, 5, 10);

        JButton valider = new JButton("Valider");
        valider.addActionListener(this);
        panelBoutons.add(valider, constraintsBoutons);

        constraintsBoutons.gridx = 1;
        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(e -> dialog.dispose());
        panelBoutons.add(annuler, constraintsBoutons);

        dialog.add(panelBoutons, BorderLayout.SOUTH);
        dialog.add(panel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Valider")) {
            System.out.println("Valider clicked");

        }
    }
}
