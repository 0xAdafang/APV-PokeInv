package com.pokeinv.View.admin.parts.forms;

import com.formdev.flatlaf.FlatLightLaf;
import com.pokeinv.Model.entity.*;
import com.pokeinv.Model.form.CollectionCellRenderer;
import com.pokeinv.View.shared.ColorManager;
import com.pokeinv.events.ChooseImageListener;
import com.pokeinv.service.DataFixtures;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class CardForm extends JPanel {

    private final JPanel form;
    private final JTextField imageField = new JTextField();
    private final JLabel imageLabel = new JLabel();
    public JLabel error;
    private Carte card;
    private JTextField nameField;
    private JTextField priceField;
    private JComboBox<Collection> collectionField;
    private JComboBox<TypeCarte> typeField;
    private JComboBox<Rarete> rareteField;
    private JComboBox<GradePSA> gradeField;
    private JComboBox<Etat> etatField;
    private JFileChooser fileChooser;
    private String name;
    private double price;
    private Collection collection;
    private TypeCarte type;
    private GradePSA grade;
    private Etat etat;
    private Rarete rarete;
    private String imageName;

    public CardForm(Carte card) {
        form = new JPanel(new GridBagLayout());
        this.card = card;
        initForm();
    }

    public CardForm() {
        form = new JPanel(new GridBagLayout());
        initForm();
    }

    private void initForm() {
        FlatLightLaf.setup();
        setLayout(new BorderLayout());
        JPanel errorPanel = new JPanel();
        error = new JLabel();
        error.setForeground(ColorManager.customColor(100, 1, 1));
        errorPanel.add(error);
        errorPanel.setBackground(ColorManager.BackgroundColor);
        errorPanel.setPreferredSize(new Dimension(errorPanel.getWidth(), 40));
        add(errorPanel, BorderLayout.NORTH);
        form.setBackground(ColorManager.BackgroundColor);
        form.setForeground(Color.WHITE);

        initFields();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        Dimension dimensionChamps = new Dimension(200, 25);

        // champs NAME
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Nom :");
        nameLabel.setForeground(Color.WHITE);
        form.add(nameLabel, gbc);
        gbc.gridx = 1;
        nameField = new JTextField(name, 17);
        nameField.setPreferredSize(dimensionChamps);
        nameField.setBackground(Color.WHITE);
        nameField.setForeground(Color.BLACK);
        form.add(nameField, gbc);

        // champs COLLECTION
        gbc.gridy = 1;
        gbc.gridx = 0;

        JLabel collectionLabel = new JLabel("Collection :");
        collectionLabel.setForeground(Color.WHITE);
        form.add(collectionLabel, gbc);
        gbc.gridx = 1;
        JComboBox<String> collectionField = new JComboBox<>();
        for (Collection collection : DataFixtures.getCollections()) {
            collectionField.addItem(collection.getName());
        }
        collectionField.setBackground(Color.WHITE);
        collectionField.setForeground(Color.BLACK);
        collectionField.setRenderer(new CollectionCellRenderer());
        collectionField.setPreferredSize(dimensionChamps);

        form.add(collectionField, gbc);

        // champs PRIX
        gbc.gridy = 2;
        gbc.gridx = 0;

        JLabel priceLabel = new JLabel("Prix :");
        priceLabel.setForeground(Color.WHITE);
        form.add(priceLabel, gbc);
        gbc.gridx = 1;
        priceField = new JTextField(String.valueOf(price), 17);
        priceField.setPreferredSize(dimensionChamps);
        priceField.setBackground(Color.WHITE);
        priceField.setForeground(Color.BLACK);
        form.add(priceField, gbc);

        // champs TYPE_DE_CARTE
        gbc.gridy = 3;
        gbc.gridx = 0;

        JLabel typeLabel = new JLabel("Type de carte :");
        typeLabel.setForeground(Color.WHITE);
        form.add(typeLabel, gbc);

        gbc.gridx = 1;
        typeField = new JComboBox<>(TypeCarte.values());
        typeField.setPreferredSize(dimensionChamps);
        typeField.setBackground(Color.WHITE);
        typeField.setForeground(Color.BLACK);
        form.add(typeField, gbc);

        // champs ÉTAT
        gbc.gridy = 4;
        gbc.gridx = 0;

        JLabel etatLabel = new JLabel("État de la carte :");
        etatLabel.setForeground(Color.WHITE);
        form.add(etatLabel, gbc);

        gbc.gridx = 1;
        etatField = new JComboBox<>(Etat.values());
        etatField.setPreferredSize(dimensionChamps);
        etatField.setBackground(Color.WHITE);
        etatField.setForeground(Color.BLACK);
        etatField.setSelectedItem(etat);
        form.add(etatField, gbc);

        // champs GRADE
        gbc.gridy = 5;
        gbc.gridx = 0;

        JLabel gradeLabel = new JLabel("Grade PSA de la carte:");
        gradeLabel.setForeground(Color.WHITE);
        form.add(gradeLabel, gbc);

        gbc.gridx = 1;
        gradeField = new JComboBox<>(GradePSA.values());
        gradeField.setPreferredSize(dimensionChamps);
        gradeField.setBackground(Color.WHITE);
        gradeField.setForeground(Color.BLACK);
        gradeField.setSelectedItem(grade);
        form.add(gradeField, gbc);

        // champs RARETÉ
        gbc.gridy = 6;
        gbc.gridx = 0;

        JLabel rareteLabel = new JLabel("Rareté de la carte:");
        rareteLabel.setForeground(Color.WHITE);
        form.add(rareteLabel, gbc);

        gbc.gridx = 1;
        rareteField = new JComboBox<>(Rarete.values());
        rareteField.setPreferredSize(dimensionChamps);
        rareteField.setBackground(Color.WHITE);
        rareteField.setForeground(Color.BLACK);
        rareteField.setSelectedItem(rarete);
        form.add(rareteField, gbc);

        // champs IMAGE
        gbc.gridy = 7;
        gbc.gridx = 0;

        form.add(imageLabel, gbc);
        if (card != null) {
            Image image = new ImageIcon(getClass().getResource("/pokemons/" + card.getImage())).getImage();
            Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledImage = new ImageIcon(newImage);
            imageLabel.setIcon(scaledImage);
        }
        gbc.gridx = 1;
        JPanel imageFieldPanel = getImagePanel();
        imageFieldPanel.setBackground(Color.WHITE);
        form.add(imageFieldPanel, gbc);

        add(form, BorderLayout.CENTER);
    }

    private void initFields() {
        if (card != null) {
            name = card.getName();
            collection = card.getCollection();
            price = card.getPrice();
            type = card.getTypeCarte();
            grade = card.getGradePSA();
            etat = card.getEtat();
            rarete = card.getRarete();
            imageName = card.getImage();
            imageField.setText(imageName);
        }
    }

    private JPanel getImagePanel() {
        JButton chooseImage = new JButton("Image");

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter(
                "Images (PNG, JPG, JPEG)", "png", "jpg", "jpeg"));
        chooseImage.addActionListener(new ChooseImageListener(this));
        imageField.setEnabled(false);

        JPanel imageFieldPanel = new JPanel();
        imageFieldPanel.add(chooseImage);
        imageFieldPanel.add(imageField);
        return imageFieldPanel;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public JTextField getImageField() {
        return imageField;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JComboBox<Collection> getCollectionField() {
        return collectionField;
    }

    public JComboBox<TypeCarte> getTypeField() {
        return typeField;
    }

    public JComboBox<Rarete> getRareteField() {
        return rareteField;
    }

    public JComboBox<GradePSA> getGradeField() {
        return gradeField;
    }

    public JComboBox<Etat> getEtatField() {
        return etatField;
    }
}
