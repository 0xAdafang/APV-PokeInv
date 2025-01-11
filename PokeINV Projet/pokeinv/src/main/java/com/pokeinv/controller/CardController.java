package com.pokeinv.controller;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.Model.entity.TypeCarte;
import com.pokeinv.Model.tables.CardsTableModel;
import com.pokeinv.View.admin.parts.forms.CardFormDialog;
import com.pokeinv.service.DataFixtures;

import java.util.List;

import javax.swing.*;

public class CardController {

    private final CardsTableModel model;

    public CardController() {
        this.model = CardsTableModel.getInstance();

    }

    public Carte getCard(int id) {
        return DataFixtures.getCard(id);
    }

    public Carte createCard(Carte card) {
        return card;
    }

    public void updateCardRequest(Carte card) {
        JDialog modal = new CardFormDialog(card);
        modal.setVisible(true);
    }

    public void updateCard(Long id, Carte card) {
        DataFixtures.updateCard(id, card);
        model.fireTableDataChanged();
    }

    public void deleteCard(Long id) {
        DataFixtures.deleteCard(id);
        model.fireTableDataChanged();
    }

    public void filtrerCardsParNom(String nom) {
        model.filtrerCardsParNom(nom);
    }

    public void filtrerCardsParType(TypeCarte type) {
        model.filtrerCardsParType(type);
    }

    public static List<Carte> getAllCards() {
        return DataFixtures.getCards();
    }

}
