package com.pokeinv.Model.tables;

import com.pokeinv.Model.entity.Carte;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CardsTableModel extends AbstractTableModel {

    private final String[] nomsDesColonnes = { "image", "ID", "Nom", "Type", "État", "PSA", "Collection", "Actions" };
    private List<Carte> cardsList;

    public CardsTableModel(List<Carte> cardsList) {
        this.cardsList = cardsList;
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
            case 3 -> carte.getTypeCarte();
            case 4 -> carte.getEtat();
            case 5 -> carte.getGradePSA();
            case 6 -> carte.getCollection();
            case 7 -> "Actions";
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 5;
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
}
