package com.pokeinv.events;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.View.admin.parts.forms.CardForm;
import com.pokeinv.controller.CardController;
import com.pokeinv.service.FormValidator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardProcessButtonListener implements ActionListener {

    private final CardForm form;
    CardController controller;
    private Carte card;

    public CardProcessButtonListener(CardForm form, Carte card) {
        this.form = form;
        this.card = card;
        controller = new CardController();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("ajouter")) {
            System.out.println("ajouter");
        }
        if (e.getActionCommand().equalsIgnoreCase("mettre à jour")) {
            FormValidator validator = new FormValidator(form);
            try {
                Carte newCard = validator.getValidatedCard();
                controller.updateCard(card.getId(), newCard);
                JDialog dialog = (JDialog) form.getTopLevelAncestor();
                dialog.dispose();
            } catch (IllegalArgumentException ex) {
                form.error.setText(ex.getMessage());
            }

        }
    }
}
