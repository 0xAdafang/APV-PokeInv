package com.pokeinv.View.shared.Composants.forms;

import java.awt.*;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.crypto.Data;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.Model.entity.Collection;
import com.pokeinv.Model.entity.Etat;
import com.pokeinv.Model.entity.GradePSA;
import com.pokeinv.Model.entity.Rarete;
import com.pokeinv.Model.entity.TypeCarte;
import com.pokeinv.events.ChooseImageListener;
import com.pokeinv.service.DataFixtures;

public class CardAjouteDialog extends JDialog {
    private JTextField nom, prix;
    private JComboBox<Collection> collection;
    private JComboBox<TypeCarte> type;
    private JComboBox<Rarete> rarete;
    private JComboBox<GradePSA> gradePSA;
    private JComboBox<Etat> etat;
    private JDialog dialog;

    public CardAjouteDialog(ActionListener listener) {
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
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 10, 5, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.BOTH;

        // Dimension
        Dimension dimension = new Dimension(200, 20);

        // Ajout des labels et textfield
        JLabel nomLabel = new JLabel("Nom : ");
        nomLabel.setForeground(Color.WHITE);
        panel.add(nomLabel, constraints);
        constraints.gridx = 1;
        nom = new JTextField(15);
        nom.setPreferredSize(dimension);
        panel.add(nom, constraints);

        // Ajout ComboBox de collection
        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel collectionLabel = new JLabel("Collection : ");
        collectionLabel.setForeground(Color.WHITE);
        panel.add(collectionLabel, constraints);
        constraints.gridx = 1;
        JComboBox<String> collection = new JComboBox<>();
        for (Collection c : DataFixtures.collections) {
            collection.addItem(c.getName());
        }
        collection.setPreferredSize(dimension);
        panel.add(collection, constraints);

        // Ajout ComboBox de type
        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel typeLabel = new JLabel("Type de carte : ");
        typeLabel.setForeground(Color.WHITE);
        panel.add(typeLabel, constraints);
        constraints.gridx = 1;
        type = new JComboBox<>(TypeCarte.values());
        type.setPreferredSize(dimension);
        panel.add(type, constraints);

        // Ajout ComboBox de rarete
        constraints.gridx = 0;
        constraints.gridy = 3;
        JLabel rareteLabel = new JLabel("Rarete : ");
        rareteLabel.setForeground(Color.WHITE);
        panel.add(rareteLabel, constraints);
        constraints.gridx = 1;
        rarete = new JComboBox<>(Rarete.values());
        rarete.setPreferredSize(dimension);
        panel.add(rarete, constraints);

        // Ajout ComboBox de grade PSA
        constraints.gridx = 0;
        constraints.gridy = 4;
        JLabel gradePSALabel = new JLabel("Grade PSA : ");
        gradePSALabel.setForeground(Color.WHITE);
        panel.add(gradePSALabel, constraints);
        constraints.gridx = 1;
        gradePSA = new JComboBox<>(GradePSA.values());
        gradePSA.setPreferredSize(dimension);
        panel.add(gradePSA, constraints);

        // Ajout ComboBox de etat
        constraints.gridx = 0;
        constraints.gridy = 5;
        JLabel etatLabel = new JLabel("Etat : ");
        etatLabel.setForeground(Color.WHITE);
        panel.add(etatLabel, constraints);
        constraints.gridx = 1;
        etat = new JComboBox<>(Etat.values());
        etat.setPreferredSize(dimension);
        panel.add(etat, constraints);

        // Ajout TextField de prix
        constraints.gridx = 0;
        constraints.gridy = 6;
        JLabel prixLabel = new JLabel("Prix : ");
        prixLabel.setForeground(Color.WHITE);
        panel.add(prixLabel, constraints);
        constraints.gridx = 1;
        prix = new JTextField(15);
        prix.setPreferredSize(dimension);
        panel.add(prix, constraints);

        // Ajout de l'image
        constraints.gridx = 0;
        constraints.gridy = 7;
        JLabel imageLabel = new JLabel("Image : ");
        imageLabel.setForeground(Color.WHITE);
        panel.add(imageLabel, constraints);
        constraints.gridx = 1;
        JButton imageButton = new JButton("Ajouter une image");
        JTextField imageField = new JTextField(15);
        imageField.setEditable(false);

        // Choix de l'image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter(
                "Images (PNG, JPG, JPEG)", "png", "jpg", "jpeg"));
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(dialog);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    imageField.setText(file.getAbsolutePath());
                }
            }
        });

        JPanel imageFieldPanel = new JPanel();
        imageFieldPanel.add(imageButton);
        imageFieldPanel.add(imageField);

        constraints.gridx = 1;
        panel.add(imageFieldPanel, constraints);

        // Ajout des boutons
        JPanel panelBoutons = new JPanel(new GridBagLayout());
        panelBoutons.setBackground(new Color(28, 28, 51));
        GridBagConstraints constraintsBoutons = new GridBagConstraints();
        constraintsBoutons.gridx = 0;
        constraintsBoutons.gridy = 0;
        constraintsBoutons.anchor = GridBagConstraints.CENTER;
        constraintsBoutons.insets = new Insets(5, 10, 5, 10);

        JButton valider = new JButton("Valider");
        valider.setActionCommand("Valider");
        valider.addActionListener(listener);

        panelBoutons.add(valider, constraintsBoutons);

        constraintsBoutons.gridx = 1;
        JButton annuler = new JButton("Annuler");
        annuler.setActionCommand("Annuler");
        annuler.addActionListener(listener);
        panelBoutons.add(annuler, constraintsBoutons);

        dialog.add(panelBoutons, BorderLayout.SOUTH);
        dialog.add(panel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    public JDialog getDialog() {
        return dialog;
    }
}
