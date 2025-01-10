package com.pokeinv.events;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.Model.entity.Collection;
import com.pokeinv.Model.entity.Etat;
import com.pokeinv.Model.entity.GradePSA;
import com.pokeinv.Model.entity.Rarete;
import com.pokeinv.Model.entity.TypeCarte;

public class ajouteEvent extends JDialog {

    public ajouteEvent() {
        super();
        FlatLightLaf.setup();
        this.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        this.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
        this.setTitle("Ajouter une carte");
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        this.setIconImage(
                new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/iconApp.png"))).getImage());
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(28, 28, 51));

        // Panel du centre
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(28, 28, 51));

        // Constraints pour le panel
        GridBagConstraints constraintsAjoute = new GridBagConstraints();
        constraintsAjoute.insets = new Insets(5, 10, 5, 10);
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 0;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        constraintsAjoute.fill = GridBagConstraints.BOTH;

        // dimension du champs
        Dimension dimension = new Dimension(200, 20);

        // Ajout des champs
        JLabel nomLabel = new JLabel("Nom : ");
        nomLabel.setForeground(Color.WHITE);
        panel.add(nomLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        constraintsAjoute.gridy = 0;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JTextField nom = new JTextField(15);
        nom.setPreferredSize(dimension);
        panel.add(nom, constraintsAjoute);

        // Ajout des collections
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 1;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JLabel collectionLabel = new JLabel("Collection : ");
        collectionLabel.setForeground(Color.WHITE);
        panel.add(collectionLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        constraintsAjoute.gridy = 1;
        constraintsAjoute.anchor = GridBagConstraints.WEST;

        // Ajout des collections Box
        JComboBox<Collection> collection = new JComboBox<>();
        collection.setPreferredSize(dimension);
        ((JComboBox<Collection>) collection).addItem(new Collection(1L, "Base Set"));
        ((JComboBox<Collection>) collection).addItem(new Collection(2L, "Fossil"));
        ((JComboBox<Collection>) collection).addItem(new Collection(3L, "Base Set 2"));
        ((JComboBox<Collection>) collection).addItem(new Collection(4L, "Jungle"));
        ((JComboBox<Collection>) collection).addItem(new Collection(5L, "Team Rocket"));
        panel.add(collection, constraintsAjoute);

        // Ajout des types de cartes
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 2;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JLabel typeLabel = new JLabel("Type de carte : ");
        typeLabel.setForeground(Color.WHITE);
        panel.add(typeLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        constraintsAjoute.gridy = 2;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JComboBox<TypeCarte> type = new JComboBox<>(TypeCarte.values());
        type.setPreferredSize(dimension);
        panel.add(type, constraintsAjoute);

        // AJoute des raretes
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 3;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JLabel rareteLabel = new JLabel("Rarete : ");
        rareteLabel.setForeground(Color.WHITE);
        panel.add(rareteLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        constraintsAjoute.gridy = 3;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JComboBox<Rarete> rarete = new JComboBox<>(Rarete.values());
        rarete.setPreferredSize(dimension);
        panel.add(rarete, constraintsAjoute);

        // Ajoute des grades
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 4;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JLabel gradePSALabel = new JLabel("Grade PSA : ");
        gradePSALabel.setForeground(Color.WHITE);
        panel.add(gradePSALabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        constraintsAjoute.gridy = 4;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JComboBox<GradePSA> gradePSA = new JComboBox<>(GradePSA.values());
        gradePSA.setPreferredSize(dimension);
        panel.add(gradePSA, constraintsAjoute);

        // Ajoute des etats
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 5;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JLabel etatLabel = new JLabel("Etat : ");
        etatLabel.setForeground(Color.WHITE);
        panel.add(etatLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        constraintsAjoute.gridy = 5;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JComboBox<Etat> etat = new JComboBox<>(Etat.values());
        etat.setPreferredSize(dimension);
        panel.add(etat, constraintsAjoute);

        // Ajoute des prix
        constraintsAjoute.gridx = 0;
        constraintsAjoute.gridy = 6;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JLabel prixLabel = new JLabel("Prix : ");
        prixLabel.setForeground(Color.WHITE);
        panel.add(prixLabel, constraintsAjoute);
        constraintsAjoute.gridx = 1;
        constraintsAjoute.gridy = 6;
        constraintsAjoute.anchor = GridBagConstraints.WEST;
        JTextField prix = new JTextField(15);
        prix.setPreferredSize(dimension);
        panel.add(prix, constraintsAjoute);

        // Boutons de validation et annulation

        JPanel panelBoutons = new JPanel(new GridBagLayout());
        panelBoutons.setBackground(new Color(28, 28, 51));
        GridBagConstraints constraintsBoutons = new GridBagConstraints();
        constraintsBoutons.gridx = 0;
        constraintsBoutons.gridy = 0;
        constraintsBoutons.anchor = GridBagConstraints.CENTER;
        constraintsBoutons.insets = new Insets(5, 10, 5, 10);
        JButton valider = new JButton("Valider");
        panelBoutons.add(valider, constraintsBoutons);

        constraintsBoutons.gridx = 1;
        constraintsBoutons.gridy = 0;
        constraintsBoutons.anchor = GridBagConstraints.CENTER;
        constraintsBoutons.insets = new Insets(5, 10, 5, 10);
        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(e -> this.dispose());
        panelBoutons.add(annuler, constraintsBoutons);

        this.add(panelBoutons, BorderLayout.SOUTH);

        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }

}
