package com.pokeinv.events;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.View.admin.parts.forms.CardForm;
import com.pokeinv.controller.CardController;
import com.pokeinv.service.FormValidator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessButtonListener implements ActionListener {

    private final CardForm form;
    Carte card;
    CardController controller;

    public ProcessButtonListener(CardForm form, Carte card) {
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
            System.out.println("Mise a jour ...");
            FormValidator validator = new FormValidator(form);
            try {
                Carte newCard = validator.getValidatedCard();
                controller.updateCard(card.getId(), newCard);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

        }
    }
}
