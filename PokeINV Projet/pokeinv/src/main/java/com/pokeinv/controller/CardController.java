package com.pokeinv.Controller;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.Model.tables.CardsTableModel;
import com.pokeinv.View.admin.parts.forms.CardForm;

import javax.swing.*;

public class CardController {

    private final CardsTableModel model;

    public CardController(CardsTableModel model) {
        this.model = model;
    }

    public Carte getCard(int row) {
        return model.getCardAt(row);
    }


    public Carte createCard(Carte card) {
        model.addCard(card);
        return card;
    }

    public void updateCardRequest(Carte card) {
        JDialog modal = new CardForm(card);
        modal.setVisible(true);
    }

    public void updateCard(Carte card) {
        System.out.println("card updated");
    }

    public void deleteCard(int row) {
        model.removeCardAt(row);
    }


}