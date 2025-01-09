package com.pokeinv.Model.tables;

import com.pokeinv.Model.entity.Carte;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CardsTableModel extends AbstractTableModel {

    private final String[] nomsDesColonnes = {"ID", "Nom", "Type", "État", "Actions"};
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
            case 0 -> carte.getId();
            case 1 -> carte.getName();
            case 2 -> carte.getTypeCarte();
            case 3 -> carte.getEtat();
            case 4 -> "Actions";
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 4;
    }


    public void updateData(List<Carte> nouveauxVols) {
        this.cardsList = nouveauxVols;
        fireTableDataChanged();
    }

    public Carte getVolAt(int row) {
        return cardsList.get(row);
    }
}
