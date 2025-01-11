package com.pokeinv.events;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.View.admin.parts.forms.CardForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardResetButtonListener implements ActionListener {
    private final CardForm form;
    private Carte card;

    public CardResetButtonListener(CardForm form, Carte card) {
        System.out.println(form);
        this.form = form;
        this.card = card;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (card != null) {
            form.getNameField().setText(card.getName());
            form.getCollectionField().setSelectedItem(card.getCollection());
            form.getPriceField().setText(String.valueOf(card.getPrice()));
            form.getEtatField().setSelectedItem(card.getEtat());
            form.getTypeField().setSelectedItem(card.getTypeCarte());
            form.getGradeField().setSelectedItem(card.getGradePSA());
            form.getRareteField().setSelectedItem(card.getRarete());
            form.getImageField().setText(card.getImage());
        } else {
            form.getNameField().setText(null);
            form.getCollectionField().setSelectedItem(null);
            form.getPriceField().setText(null);
            form.getEtatField().setSelectedItem(null);
            form.getTypeField().setSelectedItem(null);
            form.getGradeField().setSelectedItem(null);
            form.getRareteField().setSelectedItem(null);
            form.getImageField().setText(null);
        }
    }
}
