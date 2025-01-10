package com.pokeinv.View.admin.parts.forms;

import com.pokeinv.Model.entity.*;

import javax.swing.*;
import java.awt.*;

public class CardForm extends JPanel {

    private Carte card;
    private String name;
    private double price;
    private String collection;
    private TypeCarte type;
    private GradePSA grade;
    private Etat etat;
    private Rarete rarete;

    public CardForm(Carte card) {
        this.card = card;
        initForm();
    }

    public CardForm() {
        initForm();
    }

    private void initForm() {
        initFields();
        JPanel form = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        // champs NOM
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Nom :");
        form.add(nameLabel, gbc);
        gbc.gridx = 1;
        JTextField nameField = new JTextField(name, 15);
        form.add(nameField, gbc);

        // champs COLLECTION
        gbc.gridy = 1;
        gbc.gridx = 0;

        JLabel collectionLabel = new JLabel("Collection :");
        form.add(collectionLabel, gbc);
        gbc.gridx = 1;
        JTextField collectionField = new JTextField(collection, 15);
        form.add(collectionField, gbc);


        // champs PRIX
        gbc.gridy = 2;
        gbc.gridx = 0;

        JLabel priceLabel = new JLabel("Prix :");
        form.add(priceLabel, gbc);
        gbc.gridx = 1;
        JTextField priceField = new JTextField(String.valueOf(price), 15);
        form.add(priceField, gbc);


        // champs TYPE_DE_CARTE
        gbc.gridy = 3;
        gbc.gridx = 0;

        JLabel typeLabel = new JLabel("Type de carte :");
        form.add(typeLabel, gbc);

        gbc.gridx = 1;
        JComboBox<TypeCarte> typeField = new JComboBox<>(TypeCarte.values());
        typeField.setPreferredSize(new Dimension(164, 22));
        typeField.setSelectedItem(type);
        form.add(typeField, gbc);

        // champs ÉTAT
        gbc.gridy = 4;
        gbc.gridx = 0;

        JLabel etatLabel = new JLabel("État de la carte :");
        form.add(etatLabel, gbc);

        gbc.gridx = 1;
        JComboBox<Etat> etatField = new JComboBox<>(Etat.values());
        etatField.setPreferredSize(new Dimension(164, 22));
        etatField.setSelectedItem(etat);
        form.add(etatField, gbc);

        // champs GRADE
        gbc.gridy = 5;
        gbc.gridx = 0;

        JLabel gradeLabel = new JLabel("Grade PSA de la carte:");
        form.add(gradeLabel, gbc);

        gbc.gridx = 1;
        JComboBox<GradePSA> gradeField = new JComboBox<>(GradePSA.values());
        gradeField.setPreferredSize(new Dimension(164, 22));
        gradeField.setSelectedItem(grade);
        form.add(gradeField, gbc);

        // champs RARETÉ
        gbc.gridy = 6;
        gbc.gridx = 0;

        JLabel rareteLabel = new JLabel("Rareté de la carte:");
        form.add(rareteLabel, gbc);

        gbc.gridx = 1;
        JComboBox<Rarete> rareteField = new JComboBox<>(Rarete.values());
        rareteField.setPreferredSize(new Dimension(164, 22));
        rareteField.setSelectedItem(rarete);
        form.add(rareteField, gbc);

        add(form, BorderLayout.CENTER);
    }

    private void initFields() {
        if (card != null) {
            name = card.getName();
            collection = card.getCollection().getName();
            price = card.getPrice();
            type = card.getTypeCarte();
            grade = card.getGradePSA();
            etat = card.getEtat();
            rarete = card.getRarete();
        }
    }
}
