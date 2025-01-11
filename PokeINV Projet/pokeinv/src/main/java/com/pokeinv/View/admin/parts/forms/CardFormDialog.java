package com.pokeinv.View.admin.parts.forms;

import com.formdev.flatlaf.FlatDarkLaf;
import com.pokeinv.Model.entity.Carte;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CardFormDialog extends JDialog {
    private Carte card;


    public CardFormDialog() {

        setTitle("Nouvelle carte");
        init();
    }

    public CardFormDialog(Carte card) {
        this.card = card;
        setTitle("Modifier une carte " + this.card.getName());
        init();
    }

    private void init() {
        FlatDarkLaf.setup();
        setDefaultLookAndFeelDecorated(true);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(28, 28, 51));
        getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);

        JButton enregistrer = new JButton("Enregistrer");
        setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        setMinimumSize(new Dimension(600, 400));
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/icons/iconApp.png")))
                .getImage()
        );
        setLocationRelativeTo(getParentFrame());
        setVisible(false);
        add(enregistrer, BorderLayout.SOUTH);
        add(new CardForm(card), BorderLayout.CENTER);
    }


    private JFrame getParentFrame() {
        Container parent = getParent();
        while (parent != null && !(parent instanceof JFrame)) {
            parent = parent.getParent();
        }
        return (JFrame) parent;
    }
}
