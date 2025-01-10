package com.pokeinv.View.shared.Composants.forms;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.Model.entity.Collection;
import com.pokeinv.Model.entity.Etat;
import com.pokeinv.Model.entity.GradePSA;
import com.pokeinv.Model.entity.Rarete;
import com.pokeinv.Model.entity.TypeCarte;

public class CardFiltreDialog extends JDialog {
    private JDialog dialog;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public CardFiltreDialog(ActionListener listener) {
        super();
        FlatLightLaf.setup();
        this.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        this.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
        this.setTitle("Filtrer");
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
        GridBagConstraints constraintsFiltrer = new GridBagConstraints();
        constraintsFiltrer.insets = new Insets(5, 10, 5, 10);
        constraintsFiltrer.gridx = 0;
        constraintsFiltrer.gridy = 0;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;
        constraintsFiltrer.fill = GridBagConstraints.BOTH;

        // dimension du champs
        Dimension dimension = new Dimension(200, 20);

        // Ajout des champs
        JLabel nomLabel = new JLabel("Filtrer par nom : ");
        nomLabel.setForeground(Color.WHITE);
        panel.add(nomLabel, constraintsFiltrer);
        constraintsFiltrer.gridx = 1;
        constraintsFiltrer.gridy = 0;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;

        JComboBox nomBox = new JComboBox();
        nomBox.addItem("");
        nomBox.addItem("ASC");
        nomBox.addItem("DESC");
        panel.add(nomBox, constraintsFiltrer);

        // Ajout des collections
        constraintsFiltrer.gridx = 0;
        constraintsFiltrer.gridy = 1;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;
        JLabel collectionLabel = new JLabel("Collection : ");
        collectionLabel.setForeground(Color.WHITE);
        panel.add(collectionLabel, constraintsFiltrer);
        constraintsFiltrer.gridx = 1;
        constraintsFiltrer.gridy = 1;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;

        // Ajout des collections Box
        JComboBox<Collection> collection = new JComboBox<>();
        collection.setPreferredSize(dimension);
        ((JComboBox<Collection>) collection).addItem(new Collection(1L, "Base Set"));
        ((JComboBox<Collection>) collection).addItem(new Collection(2L, "Fossil"));
        ((JComboBox<Collection>) collection).addItem(new Collection(3L, "Base Set 2"));
        ((JComboBox<Collection>) collection).addItem(new Collection(4L, "Jungle"));
        ((JComboBox<Collection>) collection).addItem(new Collection(5L, "Team Rocket"));
        panel.add(collection, constraintsFiltrer);

        constraintsFiltrer.gridx = 0;
        constraintsFiltrer.gridy = 2;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;

        JLabel typeLabel = new JLabel("Filtrer par type : ");
        typeLabel.setForeground(Color.WHITE);
        panel.add(typeLabel, constraintsFiltrer);
        constraintsFiltrer.gridx = 1;
        constraintsFiltrer.gridy = 2;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;

        JComboBox<TypeCarte> typeComboBox = new JComboBox<>(TypeCarte.values());
        panel.add(typeComboBox, constraintsFiltrer);
        constraintsFiltrer.gridx = 0;
        constraintsFiltrer.gridy = 3;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;

        JLabel rareteLabel = new JLabel("Filtrer par rarete : ");
        rareteLabel.setForeground(Color.WHITE);
        panel.add(rareteLabel, constraintsFiltrer);

        constraintsFiltrer.gridx = 1;
        constraintsFiltrer.gridy = 3;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;
        JComboBox<Rarete> rareteComboBox = new JComboBox<>(Rarete.values());
        panel.add(rareteComboBox, constraintsFiltrer);

        constraintsFiltrer.gridx = 0;
        constraintsFiltrer.gridy = 4;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;
        JLabel psaLabel = new JLabel("Filtrer par grade PSA : ");
        psaLabel.setForeground(Color.WHITE);
        panel.add(psaLabel, constraintsFiltrer);
        constraintsFiltrer.gridx = 1;
        constraintsFiltrer.gridy = 4;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;
        JComboBox<GradePSA> psaComboBox = new JComboBox<>(GradePSA.values());
        panel.add(psaComboBox, constraintsFiltrer);

        constraintsFiltrer.gridx = 0;
        constraintsFiltrer.gridy = 5;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;
        JLabel etatLabel = new JLabel("Filtrer par Etat : ");
        etatLabel.setForeground(Color.WHITE);
        panel.add(etatLabel, constraintsFiltrer);
        constraintsFiltrer.gridx = 1;
        constraintsFiltrer.gridy = 5;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;

        JComboBox<Etat> etatComboBox = new JComboBox<>(Etat.values());
        panel.add(etatComboBox, constraintsFiltrer);

        constraintsFiltrer.gridx = 0;
        constraintsFiltrer.gridy = 6;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;
        JLabel prixLabel = new JLabel("Filtrer par prix : ");
        prixLabel.setForeground(Color.WHITE);
        panel.add(prixLabel, constraintsFiltrer);
        constraintsFiltrer.gridx = 1;
        constraintsFiltrer.gridy = 6;
        constraintsFiltrer.anchor = GridBagConstraints.WEST;
        JTextField prixField = new JTextField(15);
        panel.add(prixField, constraintsFiltrer);

        JPanel panelBoutons = new JPanel(new GridBagLayout());
        panelBoutons.setBackground(new Color(28, 28, 51));
        GridBagConstraints constraintsBoutons = new GridBagConstraints();
        constraintsBoutons.gridx = 0;
        constraintsBoutons.gridy = 0;
        constraintsBoutons.anchor = GridBagConstraints.CENTER;
        constraintsBoutons.insets = new Insets(5, 10, 5, 10);

        JButton filtrer = new JButton("Filtrer");

        panelBoutons.add(filtrer, constraintsBoutons);

        constraintsBoutons.gridx = 1;
        constraintsBoutons.gridy = 0;
        constraintsBoutons.anchor = GridBagConstraints.CENTER;
        constraintsBoutons.insets = new Insets(5, 10, 5, 10);
        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(listener);
        panelBoutons.add(annuler, constraintsBoutons);

        this.add(panelBoutons, BorderLayout.SOUTH);

        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }

}
