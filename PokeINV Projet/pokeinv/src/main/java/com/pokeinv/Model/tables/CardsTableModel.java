package com.pokeinv.Model.tables;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.Model.entity.TypeCarte;
import com.pokeinv.service.DataFixtures;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CardsTableModel extends AbstractTableModel {

    private static CardsTableModel instance;
    private final String[] nomsDesColonnes = {"", "ID", "Nom", "Prix ($)", "Type", "État", "PSA", "Collection", "Actions"};
    private List<Carte> cardsList;

    private CardsTableModel() {
        this.cardsList = DataFixtures.getCards();
    }

    public static CardsTableModel getInstance() {
        if (instance == null) {
            instance = new CardsTableModel();
        }
        return instance;
    }

    @Override
    public int getRowCount() {
        return cardsList.size();
    }

    @Override
    public int getColumnCount() {
        return nomsDesColonnes.length;
    }

    @Override
    public String getColumnName(int column) {
        return nomsDesColonnes[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carte carte = cardsList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> new ImageIcon(getClass().getResource("/pokemons/" + carte.getImage()));
            case 1 -> carte.getId();
            case 2 -> carte.getName();
            case 3 -> carte.getPrice();
            case 4 -> carte.getTypeCarte();
            case 5 -> carte.getEtat();
            case 6 -> carte.getGradePSA();
            case 7 -> carte.getCollection().getName();
            case 8 -> "Actions";
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 8;
    }

    public void updateData(List<Carte> nouvelleCarte) {
        this.cardsList = nouvelleCarte;
        fireTableDataChanged();
    }

    public Carte getCardAt(int row) {
        return cardsList.get(row);
    }

    public void addCard(Carte card) {
        cardsList.add(card);
    }

    public void removeCardAt(int row) {
        cardsList.remove(row);
        fireTableDataChanged();
    }

    public void filtrerCardsParNom(String nom) {
        if (nom.equals("ASC")) {
            cardsList = cardsList.stream().filter(card -> card.getName() != null).toList();
            fireTableDataChanged();
        }
    }

    public void filtrerCardsParType(TypeCarte type) {
        cardsList = cardsList.stream().filter(card -> card.getTypeCarte() == type).toList();
        fireTableDataChanged();
    }
}
