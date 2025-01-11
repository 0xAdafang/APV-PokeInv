package com.pokeinv.View.admin.parts.forms;

import com.pokeinv.Model.entity.*;
import com.pokeinv.Model.form.CollectionCellRenderer;
import com.pokeinv.events.ChooseImageListener;
import com.pokeinv.service.DataFixtures;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class CardForm extends JPanel {

    JPanel form;
    private Carte card;
    private java.util.List<Collection> collections;
    private JTextField nameField;
    private JTextField priceField;
    private JComboBox<Collection> collectionField;
    private JComboBox<TypeCarte> typeField;
    private JComboBox<Rarete> rareteField;
    private JComboBox<GradePSA> gradeField;
    private JComboBox<Etat> etatField;
    private JTextField imageField = new JTextField();
    private JLabel imageLabel = new JLabel();
    private JFileChooser fileChooser;

    private String name;
    private double price;
    private String collection;
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
        collections = DataFixtures.getCollections();
        form.setBackground(new Color(28, 28, 51));
        form.setForeground(new Color(255, 255, 255));

        setLayout(new BorderLayout());
        initFields();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        // champs NAME
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Nom :");
        form.add(nameLabel, gbc);
        gbc.gridx = 1;
        nameField = new JTextField(name, 15);
        form.add(nameField, gbc);

        // champs COLLECTION
        gbc.gridy = 1;
        gbc.gridx = 0;

        JLabel collectionLabel = new JLabel("Collection :");
        form.add(collectionLabel, gbc);
        gbc.gridx = 1;
        collectionField = new JComboBox<>(new DefaultComboBoxModel<>(collections.toArray(new Collection[0])));
        collectionField.setRenderer(new CollectionCellRenderer());
        collectionField.setPreferredSize(new Dimension(164, 22));
        form.add(collectionField, gbc);


        // champs PRIX
        gbc.gridy = 2;
        gbc.gridx = 0;

        JLabel priceLabel = new JLabel("Prix :");
        form.add(priceLabel, gbc);
        gbc.gridx = 1;
        priceField = new JTextField(String.valueOf(price), 15);
        form.add(priceField, gbc);


        // champs TYPE_DE_CARTE
        gbc.gridy = 3;
        gbc.gridx = 0;

        JLabel typeLabel = new JLabel("Type de carte :");
        form.add(typeLabel, gbc);

        gbc.gridx = 1;
        typeField = new JComboBox<>(TypeCarte.values());
        typeField.setPreferredSize(new Dimension(164, 22));
        typeField.setSelectedItem(type);
        form.add(typeField, gbc);

        // champs ÉTAT
        gbc.gridy = 4;
        gbc.gridx = 0;

        JLabel etatLabel = new JLabel("État de la carte :");
        form.add(etatLabel, gbc);

        gbc.gridx = 1;
        etatField = new JComboBox<>(Etat.values());
        etatField.setPreferredSize(new Dimension(164, 22));
        etatField.setSelectedItem(etat);
        form.add(etatField, gbc);

        // champs GRADE
        gbc.gridy = 5;
        gbc.gridx = 0;

        JLabel gradeLabel = new JLabel("Grade PSA de la carte:");
        form.add(gradeLabel, gbc);

        gbc.gridx = 1;
        gradeField = new JComboBox<>(GradePSA.values());
        gradeField.setPreferredSize(new Dimension(164, 22));
        gradeField.setSelectedItem(grade);
        form.add(gradeField, gbc);

        // champs RARETÉ
        gbc.gridy = 6;
        gbc.gridx = 0;

        JLabel rareteLabel = new JLabel("Rareté de la carte:");
        form.add(rareteLabel, gbc);

        gbc.gridx = 1;
        rareteField = new JComboBox<>(Rarete.values());
        rareteField.setPreferredSize(new Dimension(164, 22));
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
        form.add(imageFieldPanel, gbc);

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
