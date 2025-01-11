package com.pokeinv.View.admin.parts.forms;

import com.formdev.flatlaf.FlatDarkLaf;
import com.pokeinv.Model.entity.Carte;
import com.pokeinv.events.ProcessButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CardFormDialog extends JDialog {
    private final JButton processButton = new JButton();
    private Carte card;
    private CardForm form;

    public CardFormDialog() {
        processButton.setText("Ajouter");
        setTitle("Nouvelle carte");
        init();
    }

    public CardFormDialog(Carte card) {
        this.card = card;
        processButton.setText("Mettre à jour");
        setTitle("Modifier une carte " + this.card.getName());
        init();
    }

    private void init() {
        FlatDarkLaf.setup();
        setDefaultLookAndFeelDecorated(true);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);


        setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        setMinimumSize(new Dimension(600, 500));
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/icons/iconApp.png")))
                .getImage()
        );

        setLocationRelativeTo(getParentFrame());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(17, 17, 33));
        processButton.setBackground(new Color(0, 94, 183));
        processButton.setForeground(new Color(255, 255, 255));
        JButton effacer = new JButton("Effacer");
        bottomPanel.add(effacer);
        bottomPanel.add(processButton);


        form = new CardForm(card);
        add(form, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        processButton.addActionListener(new ProcessButtonListener(form, card));

        setVisible(false);

    }


    private JFrame getParentFrame() {
        Container parent = getParent();
        while (parent != null && !(parent instanceof JFrame)) {
            parent = parent.getParent();
        }
        return (JFrame) parent;
    }
}
