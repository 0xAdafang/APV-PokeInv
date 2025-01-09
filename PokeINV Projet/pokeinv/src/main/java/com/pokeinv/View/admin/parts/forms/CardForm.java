package com.pokeinv.View.admin.parts.forms;

import com.pokeinv.Model.entity.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CardForm extends JDialog {
    private Carte card;

    public CardForm() {
        super();
        setTitle("Nouvelle carte");
        init();
    }

    public CardForm(Carte card) {
        super();
        this.card = card;
        setTitle("Modifier une carte " + this.card.getName());
        init();
    }

    private void init() {
        setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        setMinimumSize(new Dimension(600, 400));
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/icons/iconApp.png")))
                .getImage()
        );
        setLocationRelativeTo(getParentFrame());
        setVisible(false);
        initForm();
    }

    private void initForm() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Nom :");
        form.add(nameLabel, gbc);
        gbc.gridx = 1;
        JTextField name = new JTextField("", 15);
        form.add(name, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;

        JLabel collectionLabel = new JLabel("Collection :");
        form.add(collectionLabel, gbc);
        gbc.gridx = 1;
        JTextField collection = new JTextField("", 15);
        form.add(collection, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;

        JLabel typeLabel = new JLabel("Type de carte :");
        form.add(typeLabel, gbc);


        gbc.gridx = 1;
        JComboBox<TypeCarte> type = new JComboBox<>(TypeCarte.values());
        type.setPreferredSize(new Dimension(164, 22));
        form.add(type, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;

        JLabel etatLabel = new JLabel("État de la carte :");
        form.add(etatLabel, gbc);

        gbc.gridx = 1;
        JComboBox<Etat> etat = new JComboBox<>(Etat.values());
        etat.setPreferredSize(new Dimension(164, 22));
        form.add(etat, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;

        JLabel gradeLabel = new JLabel("Grade PSA de la carte:");
        form.add(gradeLabel, gbc);

        gbc.gridx = 1;
        JComboBox<GradePSA> grade = new JComboBox<>(GradePSA.values());
        grade.setPreferredSize(new Dimension(164, 22));
        form.add(grade, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;

        JLabel rareteLabel = new JLabel("Rareté de la carte:");
        form.add(rareteLabel, gbc);

        gbc.gridx = 1;
        JComboBox<Rarete> rarete = new JComboBox<>(Rarete.values());
        rarete.setPreferredSize(new Dimension(164, 22));
        form.add(rarete, gbc);

        add(form, BorderLayout.CENTER);
    }

    private JFrame getParentFrame() {
        Container parent = getParent();
        while (parent != null && !(parent instanceof JFrame)) {
            parent = parent.getParent();
        }
        return (JFrame) parent;
    }
}
