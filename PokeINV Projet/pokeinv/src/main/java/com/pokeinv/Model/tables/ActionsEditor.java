package com.pokeinv.Model.tables;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.controller.CardController;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ActionsEditor extends AbstractCellEditor implements TableCellEditor {

    private final JButton update = new JButton("UPDATE");
    private final JButton delete = new JButton("DELETE");
    private final JPanel panel = new JPanel();
    private final CardController cardController;
    private CardsTableModel model;
    private int rowIndex;

    public ActionsEditor(CardController cardController) {
        this.cardController = cardController;
        panel.add(update);
        panel.add(delete);

        initActions();

    }

    private void initActions() {
        update.addActionListener(e -> {
            Carte card = model.getCardAt(rowIndex);
            cardController.updateCardRequest(card);
        });
        delete.addActionListener(e -> {
            cardController.deleteCard(rowIndex);
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.model = (CardsTableModel) table.getModel();
        this.rowIndex = table.convertRowIndexToModel(row);
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
