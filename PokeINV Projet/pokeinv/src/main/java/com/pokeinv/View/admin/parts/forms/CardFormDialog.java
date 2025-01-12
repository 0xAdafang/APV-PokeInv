package com.pokeinv.View.admin.parts.forms;

import com.formdev.flatlaf.FlatDarkLaf;
import com.pokeinv.Model.entity.Carte;
import com.pokeinv.View.shared.ColorManager;
import com.pokeinv.events.CardProcessButtonListener;
import com.pokeinv.events.CardResetButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CardFormDialog extends JDialog {
    private final JButton processButton = new JButton();
    private final JButton resetButton = new JButton();
    private Carte card;
    private CardForm form;

    public CardFormDialog() {
        processButton.setText("Ajouter");
        resetButton.setText("Effacer");
        setTitle("Nouvelle carte");
        init();
    }

    public CardFormDialog(Carte card) {
        this.card = card;
        processButton.setText("Mettre à jour");
        resetButton.setText("Réinitialiser");
        setTitle("Modifier une carte " + this.card.getName());
        init();
    }

    private void init() {
        FlatDarkLaf.setup();
        setDefaultLookAndFeelDecorated(true);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", ColorManager.TitleBarBackground);
        getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);


        setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        setMinimumSize(new Dimension(600, 500));
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/icons/iconApp.png")))
                .getImage()
        );

        setLocationRelativeTo(getParentFrame());

        form = new CardForm(card);
        add(form, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(ColorManager.ColorMiniPanels);
        processButton.setBackground(ColorManager.customColor(0, 94, 183));
        processButton.setForeground(ColorManager.customColor(255, 255, 255));
        processButton.addActionListener(new CardProcessButtonListener(form, card));
        resetButton.addActionListener(new CardResetButtonListener(form, card));

        bottomPanel.add(resetButton);
        bottomPanel.add(processButton);
        add(bottomPanel, BorderLayout.SOUTH);

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
