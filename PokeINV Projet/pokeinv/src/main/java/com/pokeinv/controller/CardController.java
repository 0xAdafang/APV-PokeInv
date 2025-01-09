package com.pokeinv.controller;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.Model.tables.CardsTableModel;

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

    public void updateCard(Carte card) {
        System.out.println(card);
    }

    public void deleteCard(int row) {
        model.removeCardAt(row);
    }


}
